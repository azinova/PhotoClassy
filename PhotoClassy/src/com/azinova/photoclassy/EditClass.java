package com.azinova.photoclassy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.azinova.photoclassy.globals.GlobalsClass;
import com.azinova.splash.R;

public class EditClass extends Activity
{
	SeekBar barHue;
	ImageView imageView;
	GlobalsClass globals;
	int seekBarDetector;
	PopupWindow popUp;
	
    int i, j;
	private final int[] mColors =
	{Color.BLUE, Color.GREEN, Color.RED};

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_class);
		
		 
		globals = GlobalsClass.getInstance();
		imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setImageBitmap(globals.getBitmap());
		
		barHue = (SeekBar)findViewById(R.id.seekbar1);
		barHue.setVisibility(View.INVISIBLE);
		
		barHue.setOnSeekBarChangeListener(seekBarChangeListener); 
		
		
		
		Button btnBrightness = (Button)findViewById(R.id.btnBrightness);
		btnBrightness.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				barHue.setProgress(0);
				barHue.setVisibility(View.VISIBLE); 
				seekBarDetector = 1;
			}
		});
	
		Button btnHue = (Button)findViewById(R.id.btnHue);
		btnHue.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)  
			{
				barHue.setProgress(0);
				barHue.setVisibility(View.VISIBLE); 
				seekBarDetector = 2;
				
			}
		});

		Button btnSaturated = (Button)findViewById(R.id.btnSaturated); 
		btnSaturated.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				barHue.setProgress(0);
				barHue.setVisibility(View.VISIBLE); 
				seekBarDetector = 3;
				
			}
		});

		Button btnBlackWhite = (Button)findViewById(R.id.btnBlackWhite);
		btnBlackWhite.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				barHue.setProgress(0);
				barHue.setVisibility(View.VISIBLE); 
				seekBarDetector = 4;
				
			}
		});
	
		Button btnRGB = (Button)findViewById(R.id.btnRBG);
		btnRGB.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				
				int mColor = (int) Math.floor(Math.random() * mColors.length);
                imageView.setColorFilter(mColors[mColor], PorterDuff.Mode.MULTIPLY); 
                imageView.invalidate(); 
			}  
		});
		
		Button btnSharpness  = (Button)findViewById(R.id.btnSharpness);
		btnSharpness.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
            	barHue.setProgress(0);
				barHue.setVisibility(View.VISIBLE);  
				seekBarDetector = 5;
            	
            }
        });

		Button btnBlurred = (Button)findViewById(R.id.btnBlurred);
		btnBlurred.setOnClickListener(new View.OnClickListener() 
        {
                    @Override
                    public void onClick(View v) 
                    {
                            imageView.setImageBitmap(blurBitmap(globals.getBitmap()));
                    }
        });
		
	    final LayoutInflater linflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    Button btnReservation = (Button)findViewById(R.id.btnColor);
	    btnReservation.setOnClickListener(new View.OnClickListener()
	    {
	            
	            public void onClick(View v) 
	            {
	                    View myView = linflater1.inflate(R.layout.popup_layout, null);
	                    popUp = new PopupWindow(myView, 300, 300, true);
	                    
	                    popUp.showAtLocation(myView, Gravity.CENTER, 0, 0);
	                
	                    ImageView imageView_close = (ImageView)myView.findViewById(R.id.iv_close1);
	                    imageView_close.setOnClickListener(new View.OnClickListener()
	                    {
	                            public void onClick(View v)
	                            {
	                                    popUp.dismiss();  
	                            } 
	                    }); 
	                    ImageView iv2_cyan = (ImageView)myView.findViewById(R.id.imageView2_cyan);
	                    iv2_cyan.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.CYAN,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView imageView3_lgtGrey = (ImageView)myView.findViewById(R.id.imageView3_lgtGrey);
	                    imageView3_lgtGrey.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.LTGRAY,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView iv4_green = (ImageView)myView.findViewById(R.id.iv4_green);
	                    iv4_green.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.GREEN,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView iv5_dkGrey = (ImageView)myView.findViewById(R.id.iv5_dkGrey);
	                    iv5_dkGrey.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.DKGRAY,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView iv6_magenta = (ImageView)myView.findViewById(R.id.iv6_magenta);
	                    iv6_magenta.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.MAGENTA,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView iv7_yello = (ImageView)myView.findViewById(R.id.iv7_yello);
	                    iv7_yello.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.YELLOW,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    ImageView iv8_red = (ImageView)myView.findViewById(R.id.iv8_red);
	                    iv8_red.setOnClickListener(new View.OnClickListener()
	                    {
							
							@Override
							public void onClick(View v)
							{
								imageView.setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY); 
								popUp.dismiss();
							}
						});
	                    
	                
	                    /*linearlayout = (LinearLayout) myView.findViewById(R.id.linearlayout1);
	                    linflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                    for ( i = 0; i < SessionManager.getManager().getDates().size(); i++) 
	                    {
	                            View childView = linflater.inflate(R.layout.popup_layout_details, null);
	                            txtDate = (TextView)childView.findViewById(R.id.txtDate);
	                            txtDate.setTextColor(Color.BLACK);
	                            txtDate.setTextSize(16);
	                            txtDate.setTypeface(null, Typeface.BOLD);
	                            txtDate.setText(SessionManager.getManager().getDates().get(i));
	                            childView.setTag(SessionManager.getManager().getDates().get(i));
	                            childView.setOnClickListener(new View.OnClickListener()
	                            {
	                                    public void onClick(View arg0)
	                                    {
	                                           
	                                    }
	                            });
	                            linearlayout.addView(childView);
	                    }*/
	                    
	            }
	    });
		
	}  
	OnSeekBarChangeListener seekBarChangeListener = new OnSeekBarChangeListener()
	{

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) 
			{
				//adjusting brightness
				if (seekBarDetector == 1)
				{
					imageView.setImageBitmap(EditClass.doBrightness(globals.getBitmap(), arg1));
				}
				//adjusting hue
				else if(seekBarDetector == 2)
				{
					imageView.setColorFilter(EditClass.adjustHue(arg1));
				
				}
				//adjusting saturation 
				else if (seekBarDetector == 3)
				{
					imageView.setImageBitmap(EditClass.applySaturationFilter(globals.getBitmap(), arg1));
				}
				//contrast
				else if (seekBarDetector == 4) 
				{
					imageView.setImageBitmap(EditClass.createContrast(globals.getBitmap(), arg1));
				}
				else if(seekBarDetector == 5)
				{
					
	                imageView.setImageBitmap(EditClass.sharpen(globals.getBitmap(), arg1));
				}
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)    
			{
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				
	}}; 

	  
	public static ColorFilter adjustHue( float value ) 
	{
	    ColorMatrix cm = new ColorMatrix();

	    adjustHue(cm, value);

	    return new ColorMatrixColorFilter(cm); 
	}

	public static void adjustHue(ColorMatrix cm, float value)
	{
	    value = cleanValue(value, 180f) / 180f * (float) Math.PI;
	    if (value == 0)
	    {
	        return;
	    }
	    float cosVal = (float) Math.cos(value);
	    float sinVal = (float) Math.sin(value);
	    float lumR = 0.213f;
	    float lumG = 0.715f;
	    float lumB = 0.072f;
	    float[] mat = new float[]
	    { 
	            lumR + cosVal * (1 - lumR) + sinVal * (-lumR), lumG + cosVal * (-lumG) + sinVal * (-lumG), lumB + cosVal * (-lumB) + sinVal * (1 - lumB), 0, 0, 
	            lumR + cosVal * (-lumR) + sinVal * (0.143f), lumG + cosVal * (1 - lumG) + sinVal * (0.140f), lumB + cosVal * (-lumB) + sinVal * (-0.283f), 0, 0,
	            lumR + cosVal * (-lumR) + sinVal * (-(1 - lumR)), lumG + cosVal * (-lumG) + sinVal * (lumG), lumB + cosVal * (1 - lumB) + sinVal * (lumB), 0, 0, 
	            0f, 0f, 0f, 1f, 0f, 
	            0f, 0f, 0f, 0f, 1f };
	    cm.postConcat(new ColorMatrix(mat));
	}

	protected static float cleanValue(float p_val, float p_limit)
	{
	    return Math.min(p_limit, Math.max(-p_limit, p_val));
	}

	public static Bitmap applySaturationFilter(Bitmap source, int level) {
		// get image size
		int width = source.getWidth();
		int height = source.getHeight();
		int[] pixels = new int[width * height];
		float[] HSV = new float[3];
		// get pixel array from source
		source.getPixels(pixels, 0, width, 0, 0, width, height);

		int index = 0;
		// iteration through pixels
		for(int y = 0; y < height; ++y) {
			for(int x = 0; x < width; ++x) {
				// get current index in 2D-matrix
				index = y * width + x;
				// convert to HSV
				Color.colorToHSV(pixels[index], HSV);
				// increase Saturation level
				HSV[1] *= level;
				HSV[1] = (float) Math.max(0.0, Math.min(HSV[1], 1.0));
				// take color back
				pixels[index] |= Color.HSVToColor(HSV);
			}
		}
		// output bitmap
		Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
		return bmOut;
	}

	public static Bitmap applyShadingFilter(Bitmap source, int shadingColor) {
		// get image size
		int width = source.getWidth();
		int height = source.getHeight();
		int[] pixels = new int[width * height];
		// get pixel array from source
		source.getPixels(pixels, 0, width, 0, 0, width, height);

		int index = 0;
		// iteration through pixels
		for(int y = 0; y < height; ++y) {
			for(int x = 0; x < width; ++x) {
				// get current index in 2D-matrix
				index = y * width + x;
				// AND
				pixels[index] &= shadingColor;
			}
		}
		// output bitmap
		Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
		return bmOut;
	}
	
	public static Bitmap createContrast(Bitmap src, double value) {
		// image size
		int width = src.getWidth();
		int height = src.getHeight();
		// create output bitmap
		Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
		// color information
		int A, R, G, B;
		int pixel;
		// get contrast value
		double contrast = Math.pow((100 + value) / 100, 2);

		// scan through all pixels
		for(int x = 0; x < width; ++x) {
		    for(int y = 0; y < height; ++y) {
		        // get pixel color
		        pixel = src.getPixel(x, y);
		        A = Color.alpha(pixel);
		        // apply filter contrast for every channel R, G, B
		        R = Color.red(pixel);
		        R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
		        if(R < 0) { R = 0; }
		        else if(R > 255) { R = 255; }

		        G = Color.red(pixel);
		        G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
		        if(G < 0) { G = 0; }
		        else if(G > 255) { G = 255; }

		        B = Color.red(pixel);
		        B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
		        if(B < 0) { B = 0; }
		        else if(B > 255) { B = 255; }

		        // set new pixel color to output bitmap
		        bmOut.setPixel(x, y, Color.argb(A, R, G, B));
		    }
		}

		return bmOut;
		 }

	public static Bitmap doBrightness(Bitmap src, int value)
     {
                 int width = src.getWidth();
                 int height = src.getHeight();
                 // create output bitmap
                 Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
                 // color information
                 int A, R, G, B;
                 int pixel;
              
                 // scan through all pixels
                 for(int x = 0; x < width; ++x) 
                 {
                     for(int y = 0; y < height; ++y)
                     {
                         // get pixel color
                         pixel = src.getPixel(x, y);
                         A = Color.alpha(pixel);
                         R = Color.red(pixel);
                         G = Color.green(pixel);
                         B = Color.blue(pixel);
              
                         // increase/decrease each channel
                         R += value;
                         if(R > 255) { R = 255; }
                         else if(R < 0) { R = 0; }
              
                         G += value;
                         if(G > 255) { G = 255; }
                         else if(G < 0) { G = 0; }
                         B += value;
                         if(B > 255) { B = 255; }
                         else if(B < 0) { B = 0; }
              
                         // apply new pixel color to output bitmap
                         bmOut.setPixel(x, y, Color.argb(A, R, G, B));
                     }
                 }
              
                 // return final image
                 return bmOut;
             }

	public Bitmap RuiHuaBitmap(Bitmap bitmap) 

	{
         int width, height;
         height = bitmap.getHeight();
         width = bitmap.getWidth();
         int red, green, blue;
         int a1, a2, a3, a4, a5, a6, a7, a8, a9;
         Bitmap bmpBlurred = Bitmap.createBitmap(width, height,bitmap.getConfig());

         Canvas canvas = new Canvas(bmpBlurred);

         canvas.drawBitmap(bitmap, 0, 0, null);
         for (int i = 1; i < width - 1; i++)
         {
             for (int j = 1; j < height - 1; j++) 
             {

                 a1 = bitmap.getPixel(i - 1, j - 1);
                 a2 = bitmap.getPixel(i - 1, j);
                 a3 = bitmap.getPixel(i - 1, j + 1);
                 a4 = bitmap.getPixel(i, j - 1);
                 a5 = bitmap.getPixel(i, j);
                 a6 = bitmap.getPixel(i, j + 1);
                 a7 = bitmap.getPixel(i + 1, j - 1);
                 a8 = bitmap.getPixel(i + 1, j);
                 a9 = bitmap.getPixel(i + 1, j + 1);

                 red = (Color.red(a1) + Color.red(a2) + Color.red(a3) + Color.red(a4) + Color.red(a6) + Color.red(a7) + Color.red(a8) + Color.red(a9)) *(-1)   + Color.red(a5)*9 ;
                 green = (Color.green(a1) + Color.green(a2) + Color.green(a3) + Color.green(a4) + Color.green(a6) + Color.green(a7) + Color.green(a8) + Color.green(a9)) *(-1)  + Color.green(a5)*9 ;
                 blue = (Color.blue(a1) + Color.blue(a2) + Color.blue(a3) + Color.blue(a4) + Color.blue(a6) + Color.blue(a7) + Color.blue(a8) + Color.blue(a9)) *(-1)   + Color.blue(a5)*9 ;

                 bmpBlurred.setPixel(i, j, Color.rgb(red, green, blue));
             }
         }
         return bmpBlurred;
     }

	public static Bitmap sharpen(Bitmap src, double weight)
    {
                 double[][] SharpConfig = new double[][] 
                 {
                     { 0 , -2    , 0  },
                     { -2, weight, -2 },
                     { 0 , -2    , 0  }
                 };
                 ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
                 convMatrix.applyConfig(SharpConfig);
                 convMatrix.Factor = weight - 8;
                 return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
     }

	public Bitmap blurBitmap(Bitmap bmpOriginal)
    {        
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();    

        Bitmap bmpBlurred = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int color = (int) getAverageOfPixel(bmpOriginal, i, j);
                bmpBlurred.setPixel(i, j, Color.argb(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color)));
            }
        }
        return bmpBlurred;
    }

    private double getAverageOfPixel(Bitmap bitmap, int i, int j)
    {
         return (
        bitmap.getPixel(i-1, j-1) + bitmap.getPixel(i-1, j) + bitmap.getPixel(i-1, j+1) +
        bitmap.getPixel(i, j-1) + bitmap.getPixel(i, j) + bitmap.getPixel(i, j+1) + 
        bitmap.getPixel(i+1, j-1) + bitmap.getPixel(i+1, j) + bitmap.getPixel(i+1, j+1)) / 9;
    }

    
}