package MLShop_Admin.actual;

import MLShop_Admin.base.BaseTest;
import org.testng.annotations.Test;

public class Reports_SalesReport  extends BaseTest {

    //For log-in only
    @Test(priority = 0, description = "Validate Admin Log In")
    public  void Admin_Login() throws Exception{
        adminReportsSalesReportSteps.Admin_Login();
    }
    //For log-in only

    //Search_001
    @Test(priority = 1, dependsOnMethods = "Admin_Login", description = "Validate Category Filter Using Search")
    public  void SellerName_Search() throws Exception{
        adminReportsSalesReportSteps.SellerName_Search();
    }
    @Test(priority = 2, dependsOnMethods = "Admin_Login", description = "Validate Category Filter Using Search")
    public  void BarcodeSKU_Search() throws Exception{
        adminReportsSalesReportSteps.BarcodeSKU_Search();
    }
    @Test(priority = 3, dependsOnMethods = "Admin_Login", description = "Validate Category Filter Using Search")
    public  void ProductID_Search() throws Exception{
        adminReportsSalesReportSteps.ProductID_Search();
    }
    @Test(priority = 4, dependsOnMethods = "Admin_Login", description = "Validate Category Filter Using Search")
    public  void PaymentMethod_Search() throws Exception{
        adminReportsSalesReportSteps.PaymentMethod_Search();
    }

    //Search_002
    @Test(priority = 5, dependsOnMethods = "Admin_Login", description = "Validate Invalid Seller Name Filter Using Search")
    public  void InvalidSellerName_Search() throws Exception{
        adminReportsSalesReportSteps.InvalidSellerName_Search();
    }
    @Test(priority = 6, dependsOnMethods = "Admin_Login", description = "Validate Invalid Barcode/SKU Filter Using Search")
    public  void InvalidBarcodeSKU_Search() throws Exception{
        adminReportsSalesReportSteps.InvalidBarcodeSKU_Search();
    }
    @Test(priority = 7, dependsOnMethods = "Admin_Login", description = "Validate Invalid Product ID Filter Using Search")
    public  void InvalidProductID_Search() throws Exception{
        adminReportsSalesReportSteps.InvalidProductID_Search();
    }
    @Test(priority = 8, dependsOnMethods = "Admin_Login", description = "Validate Invalid Payment Method Filter Using Search")
    public  void InvalidPaymentMethod_Search() throws Exception{
        adminReportsSalesReportSteps.InvalidPaymentMethod_Search();
    }

    //Date_001
    @Test(priority = 9,  dependsOnMethods = "Admin_Login" , description = "Validate Correct Search using Date Range Function")
    public  void Correct_DateRange() throws Exception {
        adminReportsSalesReportSteps.Correct_DateRange();
    }
    @Test(priority =10,  dependsOnMethods = "Admin_Login" , description = "Validate Incorrect Search using Date Range Function")
    public  void Incorrect_DateRange() throws Exception {
        adminReportsSalesReportSteps.Incorrect_DateRange();
    }

    //Nav_001
    @Test(priority =11,  dependsOnMethods = "Admin_Login" , description = "Navigation of Pages: Next and Previous ")
    public  void Pagination() throws Exception {
        adminReportsSalesReportSteps.Pagination();
    }

    //XPRT_001
    @Test(priority =12,  dependsOnMethods = "Admin_Login" , description = "Verify Export: PDF")
    public  void PDF_Export() throws Exception {
        adminReportsSalesReportSteps.PDF_Export();
    }
    @Test(priority =13,  dependsOnMethods = "Admin_Login" , description = "Verify Export: Excel")
    public  void Excel_Export() throws Exception {
        adminReportsSalesReportSteps.Excel_Export();
    }
    @Test(priority =14,  dependsOnMethods = "Admin_Login" , description = "Verify Export: Excel = Year")
    public  void YearlyExcel_Export() throws Exception {
        adminReportsSalesReportSteps.YearlyExcel_Export();
    }
}
