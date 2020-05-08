package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	
	WebDriver driver;
	
      @BeforeTest
	  public void login()
	  {
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("http://183.82.100.55/ranford2");
		  
		  //Pagefactory
		  
		  RanfordHp RHP=PageFactory.initElements(driver,RanfordHp.class);
		  RHP.login();
		  
	  }
      @Test(dataProvider="Rdata")
      public void Rolec(String Rna,String Rty)
      {
    	  
		  AdminHp AHP=PageFactory.initElements(driver,AdminHp.class);
		  AHP.Rol();
		  
		  
		  //New role
		  
		  RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
		  RD.NewRole();
		  
		  //Role creation
		 
		  Rolecre Rc=PageFactory.initElements(driver,Rolecre.class);
		  Rc.rcre(Rna,Rty);
		  
		  
		  //Alert
		  driver.switchTo().alert().accept();

		  //Home
		  RD.Rhome();
		  
      }
		  
      @DataProvider
  	
  	public Object [][] Rdata()
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
