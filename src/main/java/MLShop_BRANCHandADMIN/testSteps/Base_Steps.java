package MLShop_BRANCHandADMIN.testSteps;

import MLShop_BRANCHandADMIN.pageObject.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;

public abstract class Base_Steps extends GeneralMethod {

    LoginBranch_PageObjects loginBranchPageObjects = new LoginBranch_PageObjects();
    LoginAdmin_PageObjects loginAdminPageObjects = new LoginAdmin_PageObjects();

    //    Home_PageObjects home_PageObjects = new Home_PageObjects();
    LoginBranch_PageObjects loginBranch_PageObjects = new LoginBranch_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
    
}
