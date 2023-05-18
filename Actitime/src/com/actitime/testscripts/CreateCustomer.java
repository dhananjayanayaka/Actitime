package com.actitime.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.EnterTimeTrack;
import com.actitime.pom.TaskList;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateCustomer extends BaseClass{
	
	@Test
	public void newCustomer() throws IOException, InterruptedException {
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.setTaskTab();
		
		FileLib f=new FileLib();
		String customerName = f.getExcelData("CreateCustomer", 4, 2);
		String customerDescription = f.getExcelData("CreateCustomer", 1, 3);
		
		TaskList t=new TaskList(driver);
		t.setCustomer(customerName, customerDescription);
		
		Thread.sleep(5000);
		String actualText = t.getActualCustomer().getText();
		Assert.assertEquals(actualText, customerName);
		System.out.println("Customer "+actualText+" has been created successfully");

	}

}
