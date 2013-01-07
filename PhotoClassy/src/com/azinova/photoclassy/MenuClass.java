package com.azinova.photoclassy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

public class MenuClass extends Activity
{
	Button btnEdit;
	Button  btnRotate, btnZoom;
	ImageView imageView, ivLeft, ivRight;
	int iMenuStatus ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.menu_class);
		
		final GlobalsClass globals = GlobalsClass.getInstance();
		ivLeft = (ImageView)findViewById(R.id.imageViewLeft);
		ivRight = (ImageView)findViewById(R.id.imageViewRight);
				
		imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setImageBitmap(globals.getBitmap());
				 
				
		btnEdit = (Button)findViewById(R.id.btnEdit);
		btnEdit.setOnClickListener(new View.OnClickListener()  
		{
				@Override
				public void onClick(View v)
				{
						Intent intent = new Intent(getApplicationContext(), EditClass.class);
						startActivity(intent);
				}
		});
		
		btnRotate = (Button)findViewById(R.id.btnRotate);
		btnRotate.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
					iMenuStatus = 1;
					ivLeft.setVisibility(View.VISIBLE);
					ivRight.setVisibility(View.VISIBLE);
					ivLeft.setBackgroundResource(R.drawable.leftarrow);
					ivRight.setBackgroundResource(R.drawable.arrow);
				}
		});	
		
		btnZoom = (Button)findViewById(R.id.btnZoom);
		btnZoom.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
					iMenuStatus = 2;
					ivLeft.setVisibility(View.VISIBLE);
					ivRight.setVisibility(View.VISIBLE);
					ivLeft.setBackgroundResource(R.drawable.zoominicon);
					ivRight.setBackgroundResource(R.drawable.zoomouticon);
				}
		});	
		
		ivLeft.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
					if(iMenuStatus == 1)
					{
						Drawable drawable = imageView.getDrawable() ;
						BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
						Bitmap bitmap = bitmapDrawable .getBitmap();
						
						Bitmap bitmapRotate = rotate(bitmap, -90) ;
						imageView.setImageBitmap(bitmapRotate);
						
						globals.setBitmap(bitmapRotate);
					}
					else if(iMenuStatus == 2)
					{
						Toast.makeText(MenuClass.this, "Zoom In", Toast.LENGTH_LONG).show();
					}
				}
		});	
		 
		ivRight.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
					if(iMenuStatus == 1)
					{
						Drawable drawable = imageView.getDrawable() ;
						BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
						Bitmap bitmap = bitmapDrawable.getBitmap();
						
						Bitmap bitmapRotate = rotate(bitmap, 90) ;
						imageView.setImageBitmap(bitmapRotate);
						globals.setBitmap(bitmapRotate);
					}
					
					else if(iMenuStatus == 2)
					{
						Toast.makeText(MenuClass.this, "Zoom Out", Toast.LENGTH_LONG).show();
					}
				}
		});	
		
		
		
		
	} 

	
	@Override
	protected void onStart() 
	{
		super.onStart();
		ivLeft.setVisibility(View.GONE);
		ivRight.setVisibility(View.GONE);
	}

	public static Bitmap rotate(Bitmap b, int degrees)
	{
	    if (degrees != 0 && b != null)
	    {
	        Matrix m = new Matrix();

	        m.setRotate(degrees, (float) b.getWidth() / 2, (float) b.getHeight() / 2);
	        try 
	        {
	            Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
	            if (b != b2)
	            {
	                b.recycle();
	                b = b2;
	            }
	        } 
	        catch (OutOfMemoryError ex)
	        {
	           throw ex;
	        }
	    }
	    return b;
	}


}