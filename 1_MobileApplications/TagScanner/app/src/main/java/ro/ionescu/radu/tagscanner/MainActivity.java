package ro.ionescu.radu.tagscanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
	private RecyclerView rvScanned;
	private ArrayList<Scan> products;
	private List<String> productsString;
	private MyRecyclerViewAdapter adapter;
	private String currentPhotoPath;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bScan = findViewById(R.id.bScan);
		rvScanned      = findViewById(R.id.rvScanned);
		products       = new ArrayList<>();
		productsString = new ArrayList<>();

		rvScanned.setLayoutManager(new LinearLayoutManager(this));
		adapter = new MyRecyclerViewAdapter(this, productsString);
		rvScanned.setAdapter(adapter);

		bScan.setOnClickListener(view->
		{
			Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			// Ensure that there's a camera activity to handle the intent
			if(takePictureIntent.resolveActivity(getPackageManager()) != null)
			{
				// Create the File where the photo should go
				File photoFile = null;
				try
				{
					photoFile = createImageFile();
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
				// Continue only if the File was successfully created
				if(photoFile != null)
				{
					Uri photoURI = FileProvider.getUriForFile(this,
							"com.example.android.fileprovider",
							photoFile);
					takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
					startActivityForResult(takePictureIntent, 1);
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == 1 && resultCode == RESULT_OK)
		{
			BitmapFactory.Options bmOptions   = new BitmapFactory.Options();
			Bitmap                imageBitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
			Log.e("SIZE", imageBitmap.getHeight() + " " + imageBitmap.getWidth());

			FirebaseVisionImage        firebaseVisionImage        = FirebaseVisionImage.fromBitmap(imageBitmap);
			FirebaseVisionTextDetector firebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector();
			firebaseVisionTextDetector.detectInImage(firebaseVisionImage).addOnSuccessListener(firebaseVisionText->
			{
				List<FirebaseVisionText.Block> blockList = firebaseVisionText.getBlocks();
				if(blockList.size() == 0)
				{
					Toast.makeText(MainActivity.this, "No text in image!", Toast.LENGTH_SHORT).show();
				}
				else
				{
					String text = "";
					for(FirebaseVisionText.Block block : firebaseVisionText.getBlocks())
					{
						text += block.getText();
					}

//					Scan scan = new Scan();
//
//					Pattern pattern = Pattern.compile("[JDZ][0-9A-Z]{5}");
//					Matcher matcher = pattern.matcher(text.toString());
//					if(matcher.find())
//					{
//						scan.setSKU(text.substring(matcher.start(), matcher.end()));
//					}
//
//					text = new StringBuilder(text.toString().replaceAll(scan.getSKU(), ""));
//
//					pattern = Pattern.compile("/");
//					matcher = pattern.matcher(text.toString());
//					if(matcher.find())
//					{
//						scan.setColorCode(text.substring(matcher.start() + 1, matcher.start() + 4));
//					}
//
//					text = new StringBuilder(text.toString().replaceAll("/" + scan.getColorCode(), ""));
//
//					pattern = Pattern.compile("[0-9]{1,2}[AYM]");
//					matcher = pattern.matcher(text.toString());
//					if(matcher.find())
//					{
//						scan.setSize(text.substring(matcher.start(), matcher.end()));
//					}
//
//					text = new StringBuilder(text.toString().replaceAll(scan.getSize(), ""));
//
//					scan.setBarCode(text.toString().replaceAll(" +", ""));

//					products.add(scan);
//					productsString.add(scan.toString());
					productsString.add(text);

					adapter = new MyRecyclerViewAdapter(MainActivity.this, productsString);
					rvScanned.setAdapter(adapter);
				}
			}).addOnFailureListener(e->Toast.makeText(MainActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show());
		}
	}

	private File createImageFile() throws IOException
	{
		// Create an image file name
		String timeStamp     = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = "JPEG_" + timeStamp + "_";
		File   storageDir    = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		File image = File.createTempFile(
				imageFileName,  /* prefix */
				".jpg",         /* suffix */
				storageDir      /* directory */
		);

		// Save a file: path for use with ACTION_VIEW intents
		currentPhotoPath = image.getAbsolutePath();
		return image;
	}
}