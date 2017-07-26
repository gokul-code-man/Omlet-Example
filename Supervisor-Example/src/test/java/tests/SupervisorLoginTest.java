package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import common.PageObjectFactory;

// To work with omelet framework go to : http://springer-opensource.github.io/omelet/Quick-Start

public class SupervisorLoginTest {
	
	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData",
			groups ={"All","SmokeTest", "UserLoginTest"})
	public void userLoginTest(IBrowserConf browserConf, IProperty prop) throws InterruptedException 
                    {
                                        boolean login_result=true;
                                        boolean verify_result=true;
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
                                        pof.supervisorLoginPage();
                                        pof.supervisorLoginPage().Accessurl();
                                        pof.supervisorLoginPage().isLoaded();
                                        pof.supervisorLoginPage().loginUser();
                                        verify_result=pof.supervisorLoginPage().verifySupervisor();	
	}

}
