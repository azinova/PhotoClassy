package com.azinova.photoclassy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.azinova.splash.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main extends Activity
{
	File file;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		Button btGallery = (Button)findViewById(R.id.button1_gallery);
		btGallery.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivity(intent);
				//startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
			}
		});
		Button btCamera = (Button)findViewById(R.id.button2_camera);
		btCamera.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
				file = new File(Environment.getExternalStorageDirectory(),
						ReceiptData.PICTURE_PATH + String.valueOf(System.currentTimeMillis()) + ".jpg"); 
				 
				outputFileUri = Uri.fromFile(file); 
				intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri); 
				 
				startActivityForResult(intent, 1); 

				
			}
		});
		Button btSavedImg = (Button)findViewById(R.id.button3_savedImg);
		btSavedImg.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
			}
		});
		Button btHelp = (Button)findViewById(R.id.button4_help);
		btHelp.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
			}
		});
	}
	 
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
	  if (requestCode == 1) { 
	    switch( resultCode ) { 
	      case 0: 
	        break; 
	 
	      case -1: 
	                   
	        mIv.setImageBitmap(mi.setupImage(data)); 
	        break; 
	    } 
	  } 
	} 
	public Bitmap setupImage(Intent data) { 
		  BitmapFactory.Options options = new BitmapFactory.Options(); 
		  options.inSampleSize = SAMPLE_SIZE;     // SAMPLE_SIZE = 2 
		 
		  Bitmap tempBitmap = null; 
		  Bitmap bm = null; 
		  try { 
		    tempBitmap = (Bitmap) data.getExtras().get("data"); 
		    bm = tempBitmap; 
		 
		    Log.v("ManageImage-hero", "the data.getData seems to be valid"); 
		    
		    file
		    FileOutputStream out = new FileOutputStream(outputFileUri.getPath()); 
		    tempBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out); 
		  } catch (NullPointerException ex) { 
		    Log.v("ManageImage-other", "another phone type"); 
		    bm = otherImageProcessing(options); 
		  } catch(Exception e) { 
		    Log.e("ManageImage-setupImage", "problem setting up the image", e); 
		  } 
		 
		  return bm; 
		} 
		private Bitmap otherImageProcessing(BitmapFactory.Options options)
		{ 
		  Bitmap bm = null; 
		 
		  try { 
		    FileInputStream fis = new FileInputStream(outputFileUri.getPath()); 
		    BufferedInputStream bis = new BufferedInputStream(fis); 
		    bm = BitmapFactory.decodeStream(bis, null, options); 
		 
		    // cleaning up 
		    fis.close(); 
		    bis.close(); 
		  } catch(Exception e) { 
		    Log.e("ManageImage-otherImageProcessing", "Cannot load image", e); 
		  } 
		 
		  return bm; 
		} 


}
