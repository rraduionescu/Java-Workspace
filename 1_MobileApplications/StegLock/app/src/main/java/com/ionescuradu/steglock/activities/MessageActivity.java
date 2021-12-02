package com.ionescuradu.steglock.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.ionescuradu.steglock.classes.Message;
import com.ionescuradu.steglock.adapters.MessageAdapter;
import com.ionescuradu.steglock.R;
import com.ionescuradu.steglock.classes.User;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

//  Created by Ionescu Radu Stefan  //

public class MessageActivity extends AppCompatActivity
{
	CircleImageView   profilePicture;
	TextView          nickname;
	FirebaseUser      firebaseUser;
	DatabaseReference databaseReference;
	ImageButton       bSend;
	ImageButton       bSendImage;
	ImageButton       bSendPhoto;
	ImageButton       bSendRecording;
	EditText          etMessage;
	Intent            intent;
	MessageAdapter    messageAdapter;
	List<Message>     messages;
	RecyclerView      recyclerViewMessages;
	String            userId;
	String            currentPhotoPath;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		Window window = this.getWindow();
		window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));

		Toolbar toolbar = findViewById(R.id.chatToolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		toolbar.setNavigationOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), ChatTabActivity.class);
				startActivity(intent);
			}
		});

		intent = getIntent();
		userId = intent.getStringExtra("userId");
		profilePicture = findViewById(R.id.profilePictureChat);
		nickname = findViewById(R.id.nicknameChat);
		bSend = findViewById(R.id.bSend);
		bSendImage = findViewById(R.id.bSendImage);
		bSendPhoto = findViewById(R.id.bSendPhoto);
		bSendRecording = findViewById(R.id.bSendRecording);
		etMessage = findViewById(R.id.etMessage);
		firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
		databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);


		bSend.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String message = etMessage.getText().toString();
				if (!message.equals(""))
				{
					sendMessage(firebaseUser.getUid(), userId, message);
				}
				else
				{
					Toast.makeText(MessageActivity.this, R.string.msgError, Toast.LENGTH_SHORT).show();
				}
				etMessage.setText("");
			}
		});

		bSendImage.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, 2);
			}
		});

		bSendPhoto.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent    = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File   photoFile = null;
				try
				{
					photoFile = createImageFile();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				if (photoFile != null)
				{
					Uri photoURI = FileProvider.getUriForFile(getApplicationContext(),
															  "com.example.android.fileprovider",
															  photoFile);
					intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
					startActivityForResult(intent, 3);
				}
			}
		});

		bSendRecording.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Intent    intent    = new Intent(getApplicationContext(), StegoRecordingActivity.class);
				intent.putExtra("userId", userId);
				intent.putExtra("timestamp", timestamp.toString());
				startActivity(intent);
			}
		});

		databaseReference.addValueEventListener(new ValueEventListener()
		{
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot)
			{
				User user = dataSnapshot.getValue(User.class);

				nickname.setText(user.getNickname());

				FirebaseStorage  storage   = FirebaseStorage.getInstance("gs://steglockmapp.appspot.com");
				StorageReference reference = null;
				reference = storage.getReference().child("ProfilePictures/" + user.getId());
				if (reference != null)
				{
					reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
					{
						@Override
						public void onSuccess(byte[] bytes)
						{
							Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
							profilePicture.setImageBitmap(bitmap);
						}
					});
				}

				readMessages(firebaseUser.getUid(), userId);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError)
			{

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 2 && resultCode == RESULT_OK)
		{
			Uri image = data.getData();

			Intent intent = new Intent(getApplicationContext(), StegoImageActivity.class);
			intent.putExtra("userId", userId);
			intent.putExtra("imageURI", image.toString());
			startActivity(intent);
		}
		else if (requestCode == 3 && resultCode == RESULT_OK)
		{
			File file  = new File(currentPhotoPath);
			Uri  image = Uri.fromFile(file);

			Intent intent = new Intent(getApplicationContext(), StegoImageActivity.class);
			intent.putExtra("userId", userId);
			intent.putExtra("imageURI", image.toString());
			startActivity(intent);

		}
	}

	private void sendMessage(String sender, String receiver, String message)
	{
		DatabaseReference       reference = FirebaseDatabase.getInstance().getReference();
		HashMap<String, Object> hashMap   = new HashMap<>();
		hashMap.put("sender", sender);
		hashMap.put("receiver", receiver);
		hashMap.put("message", message);

		reference.child("Chats").push().setValue(hashMap);
	}

	private void readMessages(final String myId, final String userId)
	{
		messages = new ArrayList<>();
		databaseReference = FirebaseDatabase.getInstance().getReference("Chats");
		databaseReference.addValueEventListener(new ValueEventListener()
		{
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot)
			{
				messages.clear();
				for (DataSnapshot snapshot : dataSnapshot.getChildren())
				{
					Message databaseMessage = snapshot.getValue(Message.class);
					if (databaseMessage.getReceiver().equals(myId) && databaseMessage.getSender().equals(userId) || databaseMessage.getReceiver().equals(userId) && databaseMessage.getSender().equals(myId))
					{
						messages.add(databaseMessage);
					}
					messageAdapter = new MessageAdapter(MessageActivity.this, messages);
					recyclerViewMessages = findViewById(R.id.recyclerMessages);
					recyclerViewMessages.setHasFixedSize(true);
					LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
					linearLayoutManager.setStackFromEnd(true);
					recyclerViewMessages.setLayoutManager(linearLayoutManager);
					recyclerViewMessages.setHasFixedSize(true);
					recyclerViewMessages.setAdapter(messageAdapter);
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError)
			{

			}
		});
	}

	private File createImageFile() throws IOException
	{
		String timeStamp     = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = "JPEG_" + timeStamp + "_";
		File   storageDir    = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		File image = File.createTempFile(
				imageFileName,  /* prefix */
				".png",         /* suffix */
				storageDir      /* directory */
										);

		currentPhotoPath = image.getAbsolutePath();
		return image;
	}
}