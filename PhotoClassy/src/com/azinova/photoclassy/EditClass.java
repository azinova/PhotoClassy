package com.azinova.photoclassy;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class EditClass extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_class);
		
		GlobalsClass globals = GlobalsClass.getInstance();
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setImageBitmap(globals.getBitmap());
		 
		 
	} 
 
}
