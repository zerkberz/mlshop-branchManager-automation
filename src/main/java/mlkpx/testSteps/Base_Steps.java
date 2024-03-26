package mlkpx.testSteps;

import org.mlkpx.pageObject.Google_PageObjects;
import org.mlkpx.pageObject.Home_PageObjects;
import org.mlkpx.pageObject.Kyc_PageObjects;
import org.mlkpx.pageObject.Login_PageObjects;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;

public abstract class Base_Steps extends GeneralMethod {
    Kyc_PageObjects kycPageObjects = new Kyc_PageObjects();
    Home_PageObjects homePageObjects = new Home_PageObjects();
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    Google_PageObjects googlePageObjects = new Google_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);

}
