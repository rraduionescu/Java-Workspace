package ro.ionescu.radu.tagscanner;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
	private Button bScan;
	private RecyclerView rvScanned;
	private ArrayList<Scan> products;
	private List<String> productsString;
	private MyRecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bScan     = findViewById(R.id.bScan);
		rvScanned = findViewById(R.id.rvScanned);
		products  = new ArrayList<>();
		productsString = new ArrayList<>();

		rvScanned.setLayoutManager(new LinearLayoutManager(this));
		adapter = new MyRecyclerViewAdapter(this, productsString);
		rvScanned.setAdapter(adapter);

		bScan.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				try
				{
					startActivityForResult(takePictureIntent, 1);
				}
				catch(ActivityNotFoundException e)
				{
					e.printStackTrace();
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
			Bundle extras      = data.getExtras();
			Bitmap imageBitmap = (Bitmap)extras.get("data");

			FirebaseVisionImage        firebaseVisionImage        = FirebaseVisionImage.fromBitmap(imageBitmap);
			FirebaseVisionTextDetector firebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector();
			firebaseVisionTextDetector.detectInImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>()
			{
				@Override
				public void onSuccess(FirebaseVisionText firebaseVisionText)
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
							text += block.getText() + " ";
						}

						Scan scan = new Scan();

						Pattern pattern = Pattern.compile("[JDZ]{1}[0-9A-Z]{5}");
						Matcher matcher = pattern.matcher(text);
						if(matcher.find())
						{
							scan.setSKU(text.substring(matcher.start(), matcher.end()));
						}

						text = text.replaceAll(scan.getSKU(), "");

						pattern = Pattern.compile("/");
						matcher = pattern.matcher(text);
						if(matcher.find())
						{
							scan.setColorCode(text.substring(matcher.start() + 1, matcher.start() + 4));
						}

						text = text.replaceAll("/" + scan.getColorCode(), "");

						pattern = Pattern.compile("[0-9]{2}[AYM]");
						matcher = pattern.matcher(text);
						if(matcher.find())
						{
							scan.setSize(text.substring(matcher.start(), matcher.end()));
						}

						text = text.replaceAll(scan.getSize(), "");

						scan.setBarCode(text.replaceAll(" +", ""));

						products.add(scan);
						productsString.add(scan.toString());

						adapter = new MyRecyclerViewAdapter(MainActivity.this, productsString);
						rvScanned.setAdapter(adapter);
					}
				}
			}).addOnFailureListener(new OnFailureListener()
			{
				@Override
				public void onFailure(@NonNull Exception e)
				{
					Toast.makeText(MainActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}