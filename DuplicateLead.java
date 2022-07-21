package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver d=new ChromeDriver();
		d.get("http://leaftaps.com/opentaps/control/login");
		d.manage().window().maximize();

		//2. Enter UserName and Password Using Id Locator
		d.findElement(By.id("username")).sendKeys("demosalesmanager");
		d.findElement(By.id("password")).sendKeys("crmsfa");

		//3. Click on Login Button using Class Locator
		d.findElement(By.className("decorativeSubmit")).click();

		//4. Click on CRM/SFA Link
		d.findElement(By.linkText("CRM/SFA")).click();

		// Click on Leads Button
		d.findElement(By.linkText("Leads")).click();

		// Click on Create Lead 
		d.findElement(By.linkText("Create Lead")).click();

		// Enter CompanyName Field Using id Locator
		d.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");

		// Enter FirstName Field Using id Locator
		d.findElement(By.id("createLeadForm_firstName")).sendKeys("Archanaa");	

		// Enter LastName Field Using id Locator
		d.findElement(By.id("createLeadForm_lastName")).sendKeys("M");	

		//. Enter FirstName(Local) Field Using id Locator
		d.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Archanaa");	

		//. Enter Department Field Using any Locator of Your Choice
		d.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");	

		//. Enter Description Field Using any Locator of your choice 
		d.findElement(By.id("createLeadForm_description")).sendKeys("I am part of testing team with 10 years of experience");	

		///. Enter your email in the E-mail address Field using the locator of your choice
		d.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("archanaa11@gmail.com");	

		// Select State/Province as NewYork Using Visible Text
		//WebElement dropdown1=d.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ss=new Select(d.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		ss.selectByValue("NY");		

		//. Click on Create Button
		d.findElement(By.className("smallSubmit")).click();

		//     16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		String t=d.getTitle();
		System.out.println("The page landed on: "+t);
		
		// Click on Duplicate button
		d.findElement(By.linkText("Duplicate Lead")).click();
		
        //. Clear the CompanyName Field using .clear() And Enter new CompanyName
		d.findElement(By.id("createLeadForm_companyName")).clear();
		d.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
        //.Clear the FirstName Field using .clear() And Enter new FirstName
		d.findElement(By.id("createLeadForm_firstName")).clear();
		d.findElement(By.id("createLeadForm_firstName")).sendKeys("Varun");	
		
        //0.Click on Create Lead Button
		d.findElement(By.className("smallSubmit")).click();
		
        //1. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		String t1=d.getTitle();
		System.out.println("The page landed post duplicate: "+t1);
	}

}
