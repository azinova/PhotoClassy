package com.azinova.photoclassy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

public class MenuClass extends Activity
{
	Button btnEdit;
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.menu_class);
		
		final GlobalsClass globals = GlobalsClass.getInstance();
				
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
				 
				
	} 
		

}