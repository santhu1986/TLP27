package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Rolecreation extends Base
{
	@Test(dataProvider="Rdata")
	public void Rcre(String Rn,String Rt) throws InterruptedException
	{
		Lb.Role(Rn,Rt);
	}

	
	@DataProvider
	
	public String [][] Rdata()
	{
		Object [][] Obj =new Object[3][2];
		
		Obj[0][0]="managerhdfc";
		Obj[0][1]="E";
		
		Obj[1][0]="Manageraxis";
		Obj[1][1]="E";
		
		Obj[2][0]="Managericici";
		Obj[2][1]="E";
		
		return Obj;
		
	}
	
}
