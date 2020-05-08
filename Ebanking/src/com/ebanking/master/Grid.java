package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid 
{

	DesiredCapabilities Cap=null;
	@Parameters("browser")
	@Test
	public void Gd(String Br) throws MalformedURLException, InterruptedException
	{
		if (Br.equalsIgnoreCase("firefox"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);	
		}
		else if (Br.equalsIgnoreCase("chrome"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.ANY);	
		}
		
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),Cap);
		
		 driver.manage().window().maximize();
		  driver.get("http://183.82.100.55/ranford2");
		  
		  //Pagefactory
		  
		  RanfordHp RHP=PageFactory.initElements(driver,RanfordHp.class);
		  RHP.login();
		 Thread.sleep(4000);
		  AdminHp AHP=PageFactory.initElements(driver,AdminHp.class);
		  AHP.Rol();
		  
		  Thread.sleep(4000); 
		  //New role
		  
		  RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
		  RD.NewRole();
		  
		  //Role creation
		 
		  Rolecre Rc=PageFactory.initElements(driver,Rolecre.class);
		  Rc.rcre("Tellersd","E");
		  Thread.sleep(4000);
		  
		  //Alert
		  driver.switchTo().alert().accept();

		  //Home
		  RD.Rhome();
		  
      }
}
