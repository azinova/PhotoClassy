package com.azinova.photoclassy.globals;

import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.Bitmap;

public class GlobalsClass 
{
	private static GlobalsClass instance;
	   
	   int TabCount, jArrLength, answer;
	   String iddd, idd,lattitude, longitude, offer0, id, description, jsonVar, minutess, secondss, brName, brAdd, brImgUr, brHeading;
	   ArrayList<HashMap<String, String>> arList;
	   Bitmap bitmap;

	   private GlobalsClass()
	   {
		   
	   }
	   public void setBitmap(Bitmap bitma) 
	   {
			this.bitmap = bitma;
	   }
	  
	   public Bitmap getBitmap()
	   {
	       return this.bitmap;	    
	   }	  

	   public static synchronized GlobalsClass getInstance()
	   {
	       if(instance==null)
	       {
	    	   instance=new GlobalsClass();
	       }
	       return instance;
	   
	   }
}
