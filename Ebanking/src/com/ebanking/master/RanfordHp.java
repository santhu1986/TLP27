package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHp 
{
	//Element Properties
	
	@FindBy (id="txtuId")
	WebElement Uname;
	
	@FindBy (id="txtPword")
    WebElement Pwd;
	
	@FindBy (xpath="//input[@id='login']")
    WebElement Lgn;


	//Element Methods
	
	public void login()
	{
		Uname.sendKeys("Admin");
		Pwd.sendKeys("M1ndq");
		Lgn.click();
	}


}
