package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Rolecre 
{

	
	@FindBy (id="txtRname")
    WebElement Rname;
	
	@FindBy (id="lstRtypeN")
	WebElement Rtyp;
	
	@FindBy (xpath=".//*[@id='btninsert']")
	WebElement Submit;
	
	public void rcre(String Rn,String Rt)
	{
		Rname.sendKeys(Rn);
		Rtyp.click();
		Rtyp.sendKeys(Rt);
		Submit.click();
		
		}

}
