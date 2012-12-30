package com.azinova.splash;

import com.azinova.photoclassy.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PhotoClassyActivity extends Activity
{
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
    
        Thread splashTread = new Thread()
        {
	        @Override
	        public void run() 
	        {
	            try
	            {
	            	synchronized(this)
	            	{

	            		//wait 5 sec
	            		wait(3000);
	            	}

	            } catch(InterruptedException e)
	            {
	            	
	            }
	            finally
	            {
	                finish(); 
	
	                Intent i = new Intent();
	                i.setClass(PhotoClassyActivity.this, Main.class);
	        		startActivity(i);

	                //stop();
	            }
	        }
	    };

	    splashTread.start();
 
        
    }
}