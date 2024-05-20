package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;
import org.testng.Assert;

public abstract class Base_Steps extends GeneralMethod {
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    SignUp_Register_PageObjects signUpRegisterPageObjects = new SignUp_Register_PageObjects();
    SupportAdmin_PageObjects supportAdminPageObjects = new SupportAdmin_PageObjects();
    Merchant_Objects merchantObjects = new Merchant_Objects();
    Admin_PageObjects adminPageObjects= new Admin_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
    
}
