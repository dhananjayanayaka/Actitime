package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskList {
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newCustomer;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name' and @class]")
	private WebElement CustomerNametxt;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement CustomerDescriptiontxt;
	
	@FindBy(xpath="//div[.='- Select Customer -' and @class='emptySelection']")
	private WebElement selectCustomerDD;
	
	@FindBy(xpath="//div[.='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompanyOpt;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createCustomer;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement actualCusomer;
	
	public TaskList(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void setCustomer(String custName,String custDesp) {
		addNewBtn.click();
		newCustomer.click();
		CustomerNametxt.sendKeys(custName);
		CustomerDescriptiontxt.sendKeys(custDesp);
		selectCustomerDD.click();
		ourCompanyOpt.click();
		createCustomer.click();
	}

	public WebElement getActualCustomer() {
		return actualCusomer;
	}

	
	

}
