package MLShop_Admin.testSteps;

import MLShop_Admin.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;

public abstract class Base_Steps extends GeneralMethod {

    //ADMIN
    Login_PageObjects adminLoginPageObjects = new Login_PageObjects();
    Dashboard_PageObjects adminDashboardPageObjects = new Dashboard_PageObjects();
    Orders_PageObjects adminOrdersPageObjects = new Orders_PageObjects();

    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
    
}
