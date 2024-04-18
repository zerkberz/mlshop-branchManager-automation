package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.Login_PageObjects;
import mlshopbuilder.pageObject.SignUp_Register_PageObjects;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import org.testng.Assert;

public abstract class Base_Steps extends GeneralMethod {
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    SignUp_Register_PageObjects signUpRegisterPageObjects = new SignUp_Register_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);
    Login_Steps loginSteps = new Login_Steps();

}
