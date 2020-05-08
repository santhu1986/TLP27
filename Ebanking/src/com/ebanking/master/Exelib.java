package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		
		//Instance Class
		
		Library Lb=new Library();
		
		String Rval=Lb.OpenApp("http://183.82.100.55/ranford2");
		System.out.println(Rval);
		Lb.AdminLgn("Admin","M1ndq");
		Lb.Branchcre("Hdfcbanksrnagar","Ammerpet","12345","INDIA","GOA","GOA");
		
	}

}
