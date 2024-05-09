package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.Login_PageObjects;
import mlshopbuilder.pageObject.Merchant_Objects;
import mlshopbuilder.pageObject.SignUp_Register_PageObjects;
import mlshopbuilder.pageObject.SupportAdmin_PageObjects;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import org.testng.Assert;

public abstract class Base_Steps extends GeneralMethod {
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    SignUp_Register_PageObjects signUpRegisterPageObjects = new SignUp_Register_PageObjects();
    SupportAdmin_PageObjects supportAdminPageObjects = new SupportAdmin_PageObjects();
    Merchant_Objects merchantObjects = new Merchant_Objects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);
}
