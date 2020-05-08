package com.ebanking.master;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Libraryng 
{
	
       WebDriver driver;
       String Expval,Actval;
	   FileInputStream FIS;
	   Properties PR;
	   
	   @Test()
	   public void OpenApp() throws IOException
	{
		   
		   FIS=new FileInputStream("E:\\Tlp27Workspace\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
	       PR=new Properties();
		   PR.load(FIS);   
		   
		   
		   Expval="Ranford Bank";
			
			//Launch Browser
			
		    driver=new FirefoxDriver();
			
			//Url
			
			driver.get("http://183.82.100.55/ranford2");
			
			//Maximise
			
			driver.manage().window().maximize();
			
		 Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
			
			//Comparision
			
			if (Expval.equalsIgnoreCase(Actval)) 
			{
			System.out.println("Ranford Application Launch Succ");	
			}
			else
			{
				System.out.println("Ranford Application Not Launch");	
			}
			
		//	return "Pass";
			
	}
	
	public void AdminLgn(String Un,String Pwd) throws InterruptedException
	{
		Expval="Welcome to Admin";
		Thread.sleep(3000);
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		Thread.sleep(3000);
		driver.findElement(By.id(PR.getProperty("Lgn"))).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		
				if (Expval.equalsIgnoreCase(Actval)) 
				{
				System.out.println("Admin Login Succ");	
				}
				else
				{
					System.out.println("Admin Login Failed");	
				}
		
	}
	
	public void Branchcre(String Bn,String Add1,String Zc,String cty,String state,String city) throws InterruptedException
	{
		Expval="Sucessfully";		
		
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
		driver.findElement(By.id("BtnNewBR")).click();
		
		
		driver.findElement(By.id("txtbName")).sendKeys(Bn);
		driver.findElement(By.id("txtAdd1")).sendKeys(Add1);
		driver.findElement(By.id("txtZip")).sendKeys(Zc);
		
		//dropdown
		
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText(cty);
		
		Select Sta=new Select(driver.findElement(By.id("lst_stateI")));
		Sta.selectByVisibleText(state);

		Select Cty=new Select(driver.findElement(By.id("lst_cityI")));
		Cty.selectByVisibleText(city);

		driver.findElement(By.id("btn_insert")).click();
		
		Thread.sleep(4000);
		
		//Alert
		
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		//Comparision
		
		if (Actval.contains(Expval)) 
		{
		System.out.println("Branch Created");	
		}
		else
		{
			System.out.println("Branch Already Exist");
		}
		

	}
	
	public String Role(String RN,String RT) throws InterruptedException
	{
		Expval="Sucessfully";
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Thread.sleep(4000);
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  
	      }
	      return Actval;
	     }


	
	//Rolecre
	//Empcre
	//Logout
	//Close
	
}
