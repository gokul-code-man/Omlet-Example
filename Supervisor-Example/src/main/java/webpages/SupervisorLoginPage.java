/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.DataEnum;

/**
 *
 * @author srivathg
 */
public class SupervisorLoginPage
{
          private WebDriver driver;
          private IProperty prop;
          
          SAssert sa = new SAssert();
          
                    @FindBy(xpath=".//*[@id='username']")
                    private WebElement loginText;
                    
                    @FindBy(xpath=".//*[@id='password']")
                    private WebElement passwordText;
                    
                    @FindBy(xpath=".//*[@id='login']")
                    private WebElement loginButton;
                    
                    @FindBy(xpath=".//*[@id='navigationButtons']/div[1]/a")
                    private WebElement HomeLink;
                    
                    public SupervisorLoginPage(WebDriver driver, IProperty prop)
                    {
                              	this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
                    }
                    public SupervisorLoginPage Accessurl()
                    {
		driver.get(prop.getValue(DataEnum.Supervisor_supervisorurl));         
		sa.assertTrue(true, "Access url: "+ prop.getValue(DataEnum.Supervisor_supervisorurl));
		return this;
	}
                    
                    public SupervisorLoginPage isLoaded()
                    {
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(loginButton), driver, 30))
                                        {
			throw new FrameworkException("Not able to load Supervisor Login page in 30 seconds");
		}
		return this;
	}
                    
                    public boolean loginUser() throws InterruptedException
                    {
		loginText.sendKeys(prop.getValue(DataEnum.Supervisor_user));
		passwordText.sendKeys(prop.getValue(DataEnum.Supervisor_password));
		loginButton.click();
		//sa.assertTrue(true, "Login as UserId: "+prop.getValue(DataEnum.Amazon_user)+", Password: "+prop.getValue(DataEnum.Amazon_password));	
		return true;
	}
                    
                    public boolean verifySupervisor()
                              {
		if(HomeLink.getText().toLowerCase().contains(prop.getValue(DataEnum.Supervisor_Homelink).toLowerCase()))
                                        {
			//sa.assertTrue(false, HomeLink.getText());
                                                                sa.assertTrue(true, "Pass");
			return true;
		}		
		//sa.assertTrue(true, HomeLink.getText());
                                        sa.assertTrue(false, "Fail");
		return false;				
	}
}
