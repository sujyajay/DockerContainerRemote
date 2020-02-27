package com.Feb26.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Feb26.Master.Master;

public class HomePage extends Master{
	

	@FindBy(xpath="//button[@data-track='navigation|projects_quick_add']") WebElement createProjectButton;
	
	@FindBy(id="edit_project_modal_field_name") WebElement projectName;
	@FindBy(xpath="//*[@class=\"color_dropdown_select__name\"]") WebElement projectColor;
	@FindBy(xpath="//button[@class='ist_button ist_button_red']") WebElement addProjectButton;
	@FindBy(xpath="//span[text() = 'Sky Blue']") WebElement selectColor;
	
	
	 
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}	
	
	
	public void createNewProject() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(createProjectButton)).click();
		
		//createProjectButton.click();
		projectName.sendKeys("Test Project");
		projectColor.click();
		selectColor.click();

		//Select myList = new Select(projectColor);
		//myList.selectByIndex(0);		
		addProjectButton.click();		
	}
	
}