package com.rakhi577.works;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Flames extends Activity 
{
	private EditText boy;
	private EditText girl;
	private Button test;
	private Button clear;
	private boolean flag;
	
	private int i;
	private int z=0;
	private int x;
	private int[] f={1,7,13,19,25,31};
			int[] l={2,8,14,20,26,32};
			int[] a={3,9,15,21,27,33};
			int[] m={4,10,16,22,28,34};
			int[] e={5,11,17,23,29,35};
			int[] s={6,12,18,24,30,36};
			
	private String Boyname;
	private String Girlname;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    try{    
        boy	=	(EditText)findViewById(R.id.txtBoy);
        girl=	(EditText)findViewById(R.id.txtGirl);
        test=	(Button)findViewById(R.id.buttonsubmit);
        clear=	(Button)findViewById(R.id.buttonclear);
        
        test.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				Boyname = boy.getText().toString().trim().replaceAll(" ", "");
				Girlname= girl.getText().toString().trim().replaceAll(" ", "");
				Validate();
				//CheckFlames();
			}
		});
        
        clear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				boy.setText("");
				girl.setText("");
			}
		});
    }catch (Exception e) {
		e.printStackTrace();
	}
        
    }
    private String findDifference() {
        String difference = "";
        String temName = this.Girlname;
        for (int i = 0; i < Boyname.length(); i++) {
          String a = Boyname.charAt(i) + "";
          if (Girlname.indexOf(a) != -1) {
            Girlname = Girlname.replaceFirst(a, "");
          }
          else {
            difference += a;
          }
        }
        difference += Girlname;
        this.Girlname = temName;
        return difference;
      }
    
    public String getFLAMES() {
        String flamesResult = "";
        int difference = findDifference().length();
        if (difference == 0) {
          if (Boyname.equals(Girlname)) {
            return "You have Given Same Names, So Can't find FLAMES";
          }
          else {
            return "Can't find FLAMES for the Given Names";
          }
        }
        String fResult[] = {
            "FRIENDS", "LOVERS", "AFFAIR", "MARRIAGE", "ENEMIES",
            "SISTERS/BROTHERS"};
        int k = 0;
        for (int i = 5; i > 0; i--) {
          int j = 1;
          while (j < difference) {
            k++;
            if (k == fResult.length) {
              k = 0;
            }
            j++;
          }
          String fResult1[] = new String[i];
          int m = 0;
          for (int kk = 0; kk < fResult.length; kk++) {
            if (kk != k) {
              fResult1[m++] = fResult[kk];
            }
          }
          fResult = fResult1;
          if (k == fResult.length) {
            k = 0;
          }
          flamesResult = fResult[0];
        }
        return flamesResult;
      }
    
    public void CheckFlames()
    {
    	z=0;
    	
    	char[] boyD = Boyname.toCharArray();
    	char[] girlD = Girlname.toCharArray();
    	int glen = girlD.length;
    	int blen = boyD.length;

    	for(x=0;x<blen;x++)
    	{
	    	for(i=0;i<glen;i++)
	    	{
		    	if(boyD[x]==girlD[i])
		    	{
		    		z=z+1;
		    	}
	    	}
    	}

    	for(i=0;i<z;i++)
		{
    		if(z==f[i])
			{
    			DisplayToast("Friends");
			}
    		if(z==l[i])
    		{
    			DisplayToast("Lovers");
			}
    		if(z==a[i])
			{
    			DisplayToast("Acquaintance");
			}
    		if(z==m[i])
    		{
    			DisplayToast("Marriage");
			}
			if(z==e[i])
			{
				DisplayToast("Engaged");
			}
    		if(z==s[i])
    		{
    			DisplayToast("Sweethearts");
			}
	   }
	}
    
    public void DisplayToast(String str)
    {
    	Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public void Validate()
    {
    	if(Boyname.equals(""))
    	{
    		DisplayToast("** Enter Boys Name **");
    	}
    	else if(Girlname.equals(""))
    	{
    		DisplayToast("** Enter Girls Name **");
    	}
    	
    	for(int i=0;i<Boyname.length();i++)
    	{
    		if((Boyname.codePointAt(i) >= 97 && Boyname.codePointAt(i) <=122) || (Boyname.codePointAt(i) >= 65 && Boyname.codePointAt(i) <=90))
    		{
    			flag = true;
    		}
    		else
    		{
    			flag = false;
    		}
    	}
    	
    	for(int i=0;i<Girlname.length();i++)
    	{
    		if((Girlname.codePointAt(i) >= 97 && Girlname.codePointAt(i) <=122) || (Girlname.codePointAt(i) >= 65 && Girlname.codePointAt(i) <=90))
    		{
    			flag = true;
    		}
    		else
    		{
    			flag = false;
    		}
    	}
    	
    	if(flag)
    	{
    		DisplayToast(getFLAMES());
    	}
    	else
    	{
    		DisplayToast("** Pls Enter Alphabets only **");
    	}
    }
}
