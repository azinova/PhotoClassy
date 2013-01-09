package com.azinova.photoclassy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

public class MenuClass extends Activity
{
	Button btnEdit;
	Button  btnRotate, btnZoom, btnText, btnTextRight, btnTextLeft, btnTextTop, btnTextBottom, btnTextCenter, btnColor ;
	ImageView imageView, ivLeft, ivRight;
	TextView txtRight, txtLeft,txtTop, txtBottom, txtCenter ;
	View myView, popupView ;
	String sText = "";
	PopupWindow popUp, popUpColor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.menu_class);
		
		final GlobalsClass globals = GlobalsClass.getInstance();
		ivLeft = (ImageView)findViewById(R.id.imageViewLeft);
		ivRight = (ImageView)findViewById(R.id.imageViewRight);
				
		imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setImageBitmap(globals.getBitmap());
		btnTextRight = (Button)findViewById(R.id.btnTextRight);
		btnTextLeft = (Button)findViewById(R.id.btnTextLeft);
		btnTextTop = (Button)findViewById(R.id.btnTextTop);
		btnTextBottom = (Button)findViewById(R.id.btnTextBottom);
		btnTextCenter = (Button)findViewById(R.id.btnTextCenter);
		txtRight = (TextView)findViewById(R.id.txtRight);
		txtLeft = (TextView)findViewById(R.id.txtLeft);
		txtTop = (TextView)findViewById(R.id.txtTop);
		txtBottom = (TextView)findViewById(R.id.txtBottom);
		txtCenter = (TextView)findViewById(R.id.txtCenter);
		 			
		Display display = getWindowManager().getDefaultDisplay(); 
		final int width = display.getWidth();
		final int height = display.getHeight();
				
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
					ivLeft.setVisibility(View.VISIBLE); 
					ivRight.setVisibility(View.VISIBLE);
					ivLeft.setBackgroundResource(R.drawable.leftarrow);
					ivRight.setBackgroundResource(R.drawable.arrow);
				}
		});	
		
		final LayoutInflater linflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		btnText = (Button)findViewById(R.id.btnText);
		btnText.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v) 
				{
				    myView = linflater1.inflate(R.layout.popup_layout1, null);
					popUp = new PopupWindow(myView, width, height, true); 
				    popUp.showAtLocation(myView, Gravity.CENTER, 0, 0);
					
				    btnColor = (Button)findViewById(R.id.btnColor);
				    
				    Button btnOK = (Button)myView.findViewById(R.id.btnOK);
				    btnOK.setOnClickListener(new View.OnClickListener()
				    {
						public void onClick(View v)
						{
							EditText etxtText = (EditText)myView.findViewById(R.id.txt_Text);
							sText = etxtText.getText().toString();
							 if(!sText.equals(""))
							    {  
							    	txtCenter.setText(sText);
							    	btnTextRight.setVisibility(View.VISIBLE);
									btnTextLeft.setVisibility(View.VISIBLE);
									btnTextTop.setVisibility(View.VISIBLE);
									btnTextBottom.setVisibility(View.VISIBLE);
									btnColor.setVisibility(View.VISIBLE);
							    	
							    }
							popUp.dismiss();
						}
					});
				    
				    Button btnCancel = (Button)myView.findViewById(R.id.btnCancel);
				    btnCancel.setOnClickListener(new View.OnClickListener()
				    {
						public void onClick(View v)
						{
							popUp.dismiss();
						}
					});
				    
				    txtCenter.setVisibility(View.VISIBLE);
				   					
					btnTextRight.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								txtRight.setVisibility(View.VISIBLE);
								txtRight.setText(sText);
								btnTextLeft.setVisibility(View.VISIBLE);
								btnTextTop.setVisibility(View.VISIBLE);
								btnTextCenter.setVisibility(View.VISIBLE);
								btnTextBottom.setVisibility(View.VISIBLE);
								btnTextRight.setVisibility(View.GONE);
								btnTextCenter.setVisibility(View.VISIBLE);
								txtCenter.setVisibility(View.GONE);
								txtLeft.setVisibility(View.GONE);
								txtTop.setVisibility(View.GONE);
								txtBottom.setVisibility(View.GONE);
							}
					});	
					
					btnTextLeft.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								txtLeft.setVisibility(View.VISIBLE);
								txtLeft.setText(sText);
								btnTextRight.setVisibility(View.VISIBLE);
								btnTextTop.setVisibility(View.VISIBLE);
								btnTextCenter.setVisibility(View.VISIBLE);
								btnTextBottom.setVisibility(View.VISIBLE);
								btnTextLeft.setVisibility(View.GONE);
								txtCenter.setVisibility(View.GONE);
								txtRight.setVisibility(View.GONE);
								txtTop.setVisibility(View.GONE);
								txtBottom.setVisibility(View.GONE);
							}
					});	
					
					btnTextTop.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								txtTop.setVisibility(View.VISIBLE);
								txtTop.setText(sText);
								btnTextRight.setVisibility(View.VISIBLE);
								btnTextLeft.setVisibility(View.VISIBLE);
								btnTextCenter.setVisibility(View.VISIBLE);
								btnTextBottom.setVisibility(View.VISIBLE);
								btnTextTop.setVisibility(View.GONE);
								txtCenter.setVisibility(View.GONE);
								txtRight.setVisibility(View.GONE);
								txtLeft.setVisibility(View.GONE);
								txtBottom.setVisibility(View.GONE);
							}
					});	
					
					btnTextBottom.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								txtBottom.setVisibility(View.VISIBLE);
								txtBottom.setText(sText);
								btnTextRight.setVisibility(View.VISIBLE);
								btnTextTop.setVisibility(View.VISIBLE);
								btnTextLeft.setVisibility(View.VISIBLE);
								btnTextCenter.setVisibility(View.VISIBLE);
								btnTextBottom.setVisibility(View.GONE);
								txtCenter.setVisibility(View.GONE);
								txtRight.setVisibility(View.GONE);
								txtLeft.setVisibility(View.GONE);
								txtTop.setVisibility(View.GONE);
							}
					});	
					
					btnTextCenter.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								txtCenter.setVisibility(View.VISIBLE);
								txtCenter.setText(sText);
								btnTextRight.setVisibility(View.VISIBLE);
								btnTextTop.setVisibility(View.VISIBLE);
								btnTextLeft.setVisibility(View.VISIBLE);
								btnTextBottom.setVisibility(View.VISIBLE);
								btnTextCenter.setVisibility(View.GONE);
								txtBottom.setVisibility(View.GONE);
								txtRight.setVisibility(View.GONE);
								txtLeft.setVisibility(View.GONE);
								txtTop.setVisibility(View.GONE);
							}
					});	
					
					btnColor.setOnClickListener(new View.OnClickListener() 
					{
							@Override
							public void onClick(View v)
							{
								popupView = linflater1.inflate(R.layout.popup_layout, null);
								popUpColor = new PopupWindow(popupView, width, height, true); 
								popUpColor.showAtLocation(popupView, Gravity.CENTER, 0, 0);
							
								ImageView imageView_close = (ImageView)popupView.findViewById(R.id.iv_close1);
			                    imageView_close.setOnClickListener(new View.OnClickListener()
			                    {
			                            public void onClick(View v)
			                            {
			                            	popUpColor.dismiss();  
			                            } 
			                    }); 
			                    ImageView iv2_cyan = (ImageView)popupView.findViewById(R.id.imageView2_cyan);
			                    iv2_cyan.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.CYAN); 
										txtRight.setTextColor(Color.CYAN); 
										txtLeft.setTextColor(Color.CYAN); 
										txtTop.setTextColor(Color.CYAN); 
										txtBottom.setTextColor(Color.CYAN); 
										popUpColor.dismiss();
									}
								});
			                    ImageView imageView3_lgtGrey = (ImageView)popupView.findViewById(R.id.imageView3_lgtGrey);
			                    imageView3_lgtGrey.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.LTGRAY); 
										txtRight.setTextColor(Color.LTGRAY); 
										txtLeft.setTextColor(Color.LTGRAY); 
										txtTop.setTextColor(Color.LTGRAY); 
										txtBottom.setTextColor(Color.LTGRAY); 
										popUpColor.dismiss();
									}
								});
			                    ImageView iv4_green = (ImageView)popupView.findViewById(R.id.iv4_green);
			                    iv4_green.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.GREEN); 
										txtRight.setTextColor(Color.GREEN); 
										txtLeft.setTextColor(Color.GREEN); 
										txtTop.setTextColor(Color.GREEN); 
										txtBottom.setTextColor(Color.GREEN); 
										popUpColor.dismiss();
									}
								});
			                    ImageView iv5_dkGrey = (ImageView)popupView.findViewById(R.id.iv5_dkGrey);
			                    iv5_dkGrey.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.DKGRAY); 
										txtRight.setTextColor(Color.DKGRAY); 
										txtLeft.setTextColor(Color.DKGRAY); 
										txtTop.setTextColor(Color.DKGRAY); 
										txtBottom.setTextColor(Color.DKGRAY); 
										popUpColor.dismiss();
									}
								});
			                    ImageView iv6_magenta = (ImageView)popupView.findViewById(R.id.iv6_magenta);
			                    iv6_magenta.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.MAGENTA); 
										txtRight.setTextColor(Color.MAGENTA); 
										txtLeft.setTextColor(Color.MAGENTA); 
										txtTop.setTextColor(Color.MAGENTA); 
										txtBottom.setTextColor(Color.MAGENTA); 
										popUpColor.dismiss();
									}
								});
			                    ImageView iv7_yello = (ImageView)popupView.findViewById(R.id.iv7_yello);
			                    iv7_yello.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.YELLOW); 
										txtRight.setTextColor(Color.YELLOW); 
										txtLeft.setTextColor(Color.YELLOW); 
										txtTop.setTextColor(Color.YELLOW); 
										txtBottom.setTextColor(Color.YELLOW); 
										popUpColor.dismiss();
									}
								});
			                    ImageView iv8_red = (ImageView)popupView.findViewById(R.id.iv8_red);
			                    iv8_red.setOnClickListener(new View.OnClickListener()
			                    {
									@Override
									public void onClick(View v)
									{
										txtCenter.setTextColor(Color.RED); 
										txtRight.setTextColor(Color.RED); 
										txtLeft.setTextColor(Color.RED); 
										txtTop.setTextColor(Color.RED); 
										txtBottom.setTextColor(Color.RED); 
										popUpColor.dismiss();
									}
								});
							}
					});	
				}
		});	
		
		btnZoom = (Button)findViewById(R.id.btnZoom);
		btnZoom.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
					//WebView webView = (WebView)findViewById(R.id.webView1); 
					//webView.zoomIn();
					/*iMenuStatus = 2;
					ivLeft.setVisibility(View.VISIBLE);
					ivRight.setVisibility(View.VISIBLE);
					ivLeft.setBackgroundResource(R.drawable.zoominicon);
					ivRight.setBackgroundResource(R.drawable.zoomouticon);*/
				}   
		});	
		
		ivLeft.setOnClickListener(new View.OnClickListener() 
		{
				@Override
				public void onClick(View v)
				{
						Drawable drawable = imageView.getDrawable() ;
						BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
						Bitmap bitmap = bitmapDrawable .getBitmap();
						
						Bitmap bitmapRotate = rotate(bitmap, -90) ;
						imageView.setImageBitmap(bitmapRotate);
						
						globals.setBitmap(bitmapRotate);
				}
		});	
		 
		ivRight.setOnClickListener(new View.OnClickListener()  
		{
				@Override
				public void onClick(View v)
				{
						Drawable drawable = imageView.getDrawable() ;
						BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
						Bitmap bitmap = bitmapDrawable.getBitmap();
						
						Bitmap bitmapRotate = rotate(bitmap, 90) ;
						imageView.setImageBitmap(bitmapRotate);
						globals.setBitmap(bitmapRotate);
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