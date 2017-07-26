package common;


import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;


import webpages.SupervisorLoginPage;


public class PageObjectFactory {

	
	private WebDriver driver;
	private IProperty prop;
	
       
                    private SupervisorLoginPage supervisorLoginPage;
	
	public PageObjectFactory(IBrowserConf browserConf, IProperty prop){
		this.prop = prop;
		driver = Driver.getDriver(browserConf);
		driver.manage().window().maximize();
		
	}
	       
                    public SupervisorLoginPage supervisorLoginPage()
                    {
                              if(null==supervisorLoginPage)
                              {
                                        supervisorLoginPage=new SupervisorLoginPage(driver,prop);
                              }
                              return supervisorLoginPage;
                    }

	
}
