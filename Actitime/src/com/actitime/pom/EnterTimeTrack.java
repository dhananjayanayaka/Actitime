package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrack {
	
	@FindBy(id="logoutLink")
	private WebElement logoutlink;
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasklisttab;
	
	public EnterTimeTrack(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setLogout() {
		logoutlink.click();
	}
	public void setTaskTab() {
		tasklisttab.click();
	}

}
