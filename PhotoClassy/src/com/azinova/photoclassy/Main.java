package com.azinova.photoclassy;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

public class Main extends Activity
{
	File file;
	Uri outputFileUri;
	ImageView mIv;
	
	private static final int CAMERA_REQUEST = 1888; 
	private static int RESULT_LOAD_IMAGE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mIv = (ImageView)findViewById(R.id.imageView1);
                
		Button btGallery = (Button)findViewById(R.id.button1_gallery);
		btGallery.setOnClickListener(new View.OnClickListener()
		{
			  
			@Override
			public void onClick(View v)
			{
				
				 Intent i = new Intent(Intent.ACTION_PICK,
	                       android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	             startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		Button btCamera = (Button)findViewById(R.id.button2_camera);
		btCamera.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
                System.out.println("after intent inside click");
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
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	 {  
	        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
	        {  
	             Bitmap photo = (Bitmap)data.getExtras().get("data"); 
	             mIv.setImageBitmap(photo);
	             System.out.println("req "+requestCode+"result "+resultCode);
	            
	             Intent intent = new Intent(getApplicationContext(), EditClass.class);
	             GlobalsClass globals = GlobalsClass.getInstance();
	             globals.setBitmap(photo);
	             startActivity(intent); 
	             
	        }       
	        
	        
	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
            {
                   Uri selectedImage = data.getData();
                   String[] filePathColumn = { MediaStore.Images.Media.DATA };
           
                   Cursor cursor = getContentResolver().query(selectedImage,
                           filePathColumn, null, null, null);
                   cursor.moveToFirst();
           
                   int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                   String picturePath = cursor.getString(columnIndex);
                   cursor.close();
                   
                   mIv.setImageBitmap(BitmapFactory.decodeFile(picturePath)); 
            } 

	 } 
	 
	/*@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
	  if (requestCode == 1) { 
	    switch( resultCode ) { 
	      case 0: 
	        break; 
	 
	      case -1: 
	    	  
	        mIv.setImageBitmap(setupImage(data)); 
	        
	        
	        break;  
	    } 
	  } 
	} 
	public Bitmap setupImage(Intent data) 
	{ 
		  BitmapFactory.Options options = new BitmapFactory.Options(); 
		  options.inSampleSize = SAMPLE_SIZE;     // SAMPLE_SIZE = 2 
		 
		  Bitmap tempBitmap = null; 
		  Bitmap bm = null; 
		  try
		  { 
		    tempBitmap = (Bitmap) data.getExtras().get("data"); 
		    bm = tempBitmap; 
		 
		    Log.v("ManageImage-hero", "the data.getData seems to be valid"); 
		    
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
		 
		  try 
		  { 
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
		} */


}
