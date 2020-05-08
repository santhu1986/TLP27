package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
        Library Lb=new Library();
		
		Lb.OpenApp("http://183.82.100.55/ranford2");
		Lb.AdminLgn("Admin","M1ndq");
		
		//To get test data file path
		
		String Fpath="E:\\Tlp27Workspace\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
		
		//To get Results file path
		
		String Rpath="E:\\Tlp27Workspace\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.txt";
		String SD;
		//To get test data file
		
		FileReader FR=new FileReader(Fpath);
		BufferedReader BR=new BufferedReader(FR);
		String Sread=BR.readLine();
		System.out.println(Sread);
		
		//write header line into results file
		
		FileWriter FW=new FileWriter(Rpath);
		BufferedWriter BW=new BufferedWriter(FW);
		BW.write(Sread);
		BW.newLine();
		
		//Multiple Iterations-----Loop
		
		//While loop
		
		while ((SD=BR.readLine())!=null) 
		{
			System.out.println(SD);
			
			//Split
			
			String SR[]=SD.split("###");
			
			      String Rname=SR[0];
			      String Rtyp=SR[1];
			      
			      String Res=Lb.Role(Rname,Rtyp);
			      System.out.println(Res);
			      
			      //Results
			      
			      BW.write(SD+"$$$$"+Res);
			      BW.newLine();
			      
		}
		
		BW.close();
		BR.close();
		}

}
