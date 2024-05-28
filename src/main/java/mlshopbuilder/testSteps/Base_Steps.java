package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;
import org.testng.Assert;

public abstract class Base_Steps extends GeneralMethod {

    Login_PageObjects loginPageObjects = new Login_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
    
}
