package com.Test.day20191129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Readmap
{
	
	private int level,mx,my;
	private char[][] mymap=new char[20][20];
	FileReader r;
	BufferedReader br;
	String bb="";
	char[] x;
	int c=0;
	Readmap(int k)
	{
		level=k;
		String s;
		try
		{
			File f=new File("maps\\"+level+".map");
			r=new FileReader(f);
			br=new BufferedReader(r);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		try
		{
			while ((s=br.readLine())!=null)
			{
				bb=bb+s;
				
			}
		}
		catch (IOException g)
		{
			System.out.println(g);
		}
		char[] d=bb.toCharArray();
		int len=bb.length();
		char[] x=new char[len];
		for(int i=0;i<bb.length();i++){
			x[i]=d[i];
		}
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
		    {
				mymap[i][j]=(char)(x[c]);		        
				if(mymap[i][j]=='5')
		        {
					mx=j;my=i;
		        }
		        c++;
		    }
	    }
	}
	char[][] getmap(){return mymap;}
	int getmanX(){return mx;}
	int getmanY(){return my;}
}
