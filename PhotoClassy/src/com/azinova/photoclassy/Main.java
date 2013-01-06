package com.azinova.photoclassy;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
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
	GlobalsClass globals;
	  
	private static final int CAMERA_REQUEST = 1888; 
	private static int RESULT_LOAD_IMAGE = 1;
	int targetHeight = 250, targetWidth = 250;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);  
		setContentView(R.layout.main);
		
		globals = GlobalsClass.getInstance();
                
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
	            
	             Intent intent = new Intent(getApplicationContext(), MenuClass.class);
	            
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
	                   
	                  Bitmap bmGallery = custom_SizedImage(picturePath) ;
	                      
	                 Intent intent = new Intent(getApplicationContext(), MenuClass.class);
	                       globals.setBitmap(bmGallery);  
	                 startActivity(intent); 
	         }
	 

	 } 
	 public Bitmap custom_SizedImage(String intent_data2)  
     {
             Bitmap scaledBitmap = null;
             Options options = new Options();
             options.inJustDecodeBounds = true;
             BitmapFactory.decodeFile(intent_data2, options);
             double sampleSize = 0; 
             
                     Boolean scaleByHeight = Math.abs(options.outHeight - targetHeight) >= Math
                     .abs(options.outWidth - targetWidth);

             if (options.outHeight * options.outWidth * 2 >= 1638) 
             {
                 sampleSize = scaleByHeight ? options.outHeight / targetHeight
                         : options.outWidth / targetWidth;
                 sampleSize = (int) Math.pow(2d,
                         Math.floor(Math.log(sampleSize) / Math.log(2d)));
             }
             options.inJustDecodeBounds = false;
             options.inTempStorage = new byte[128];
             while (true)
             {
                 try 
                 {
                     options.inSampleSize = (int) sampleSize;
                     scaledBitmap = BitmapFactory.decodeFile(intent_data2, options);
                     break;
                 } 
                 catch (Exception ex)
                 {
                     try
                     {
                         sampleSize = sampleSize * 2;
                     } 
                     catch (Exception ex1) 
                     {
                     }
                 }
             }
             return scaledBitmap;
      }
}