package MLShop.testStepsBranch;

import MLShop.pageObjectBranch.Branch_PageObjects;
import MLShop.pageObjectBranch.Login_PageObjects;
import utilities.FileUtils.FilePathUtils;
import utilities.PropertyReader.propertyReader;
import utilities.ReusableComponents.GeneralMethod;

public abstract class Base_Steps extends GeneralMethod {

    //BRANCH
    Login_PageObjects branchLoginPageObjects = new Login_PageObjects();
    Branch_PageObjects branchPageObjects = new Branch_PageObjects();

    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
}
