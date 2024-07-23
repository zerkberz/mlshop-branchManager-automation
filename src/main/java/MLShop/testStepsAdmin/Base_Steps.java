package MLShop.testStepsAdmin;

import MLShop.pageObjectAdmin.*;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import utilities.FileUtils.FilePathUtils;

public abstract class Base_Steps extends GeneralMethod {

    //ADMIN
    Login_PageObjects adminLoginPageObjects = new Login_PageObjects();
    Dashboard_PageObjects adminDashboardPageObjects = new Dashboard_PageObjects();
    Orders_PageObjects adminOrdersPageObjects = new Orders_PageObjects();
    SellerList_PageObjects sellerListPageObjects = new SellerList_PageObjects();
    Reports_ProductList_PageObjects adminReportsProductListObjects = new Reports_ProductList_PageObjects();
    Reports_ProductInventory_PageObjects adminReportsProductInventoryObjects = new Reports_ProductInventory_PageObjects();
    Reports_SalesReport_PageObjects adminReportsSalesReportObjects = new Reports_SalesReport_PageObjects();

    final String filepath = "src\\test\\java\\resources\\testData.properties";
    final String imgName = "testImage.jpg";

    propertyReader propertyReader = new propertyReader(filepath);
    FilePathUtils filePathUtils = new FilePathUtils(imgName);
}
