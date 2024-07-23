package MLShop.actualAdmin;

import MLShop.base.BaseTest;
import org.testng.annotations.Test;

public class Reports_ProductInventory extends BaseTest {

    //For log-in only
    @Test(priority = 0, description = "Validate Admin Log In")
    public  void Admin_Login() throws Exception{
        adminReportsProductInventorySteps.Admin_Login();
    }
    //For log-in only

//    //Search_001
    @Test(priority = 1, dependsOnMethods = "Admin_Login", description = "Validate Category Filter Using Search")
    public  void CategoryFilter_Search() throws Exception{
        adminReportsProductInventorySteps.CategoryFilter_Search();
    }
    @Test(priority = 2, dependsOnMethods = "Admin_Login", description = "Validate Lot Number Filter Using Search")
    public  void LotNumberFilter_Search() throws Exception{
        adminReportsProductInventorySteps.LotNumberFilter_Search();
    }
    @Test(priority = 3, dependsOnMethods = "Admin_Login", description = "Validate Product Type Filter Using Search")
    public  void ProductTypeFilter_Search() throws Exception{
        adminReportsProductInventorySteps.ProductTypeFilter_Search();
    }
    @Test(priority = 4, dependsOnMethods = "Admin_Login", description = "Validate Seller Name Filter Using Search")
    public  void SellerName_Search() throws Exception{
        adminReportsProductInventorySteps.SellerName_Search();
    }
    @Test(priority = 5, dependsOnMethods = "Admin_Login", description = "Validate ALL Barcode/SKU Filter Using Search")
    public  void BarcodeSKU_Search() throws Exception{
        adminReportsProductInventorySteps.BarcodeSKU_Search();
    }
    @Test(priority = 6, dependsOnMethods = "Admin_Login", description = "Validate Product ID Filter Using Search")
    public  void ProductID_Search() throws Exception{
        adminReportsProductInventorySteps.ProductID_Search();
    }
    //@Test(priority = 7, dependsOnMethods = "Admin_Login", description = "Validate Region Filter Using Search")
    // public  void Region_Search() throws Exception{
    //adminReportsProductInventorySteps.Region_Search();
    //}

    //    Search_002
    @Test(priority = 8, dependsOnMethods = "Admin_Login", description = "Validate Invalid Category Filter Using Search")
    public  void InvalidCategoryFilter_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidCategoryFilter_Search();
    }
    @Test(priority = 9, dependsOnMethods = "Admin_Login", description = "Validate Invalid Lot Number Filter Using Search")
    public  void InvalidLotNumberFilter_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidLotNumberFilter_Search();
    }
    @Test(priority = 10, dependsOnMethods = "Admin_Login", description = "Validate Invalid Product Type Filter Using Search")
    public  void InvalidProductTypeFilter_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidProductTypeFilter_Search();
    }
    @Test(priority = 11, dependsOnMethods = "Admin_Login", description = "Validate Invalid Seller Name Filter Using Search")
    public  void InvalidSellerName_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidSellerName_Search();
    }
    @Test(priority = 12, dependsOnMethods = "Admin_Login", description = "Validate Invalid ALL Barcode/SKU Filter Using Search")
    public  void InvalidBarcodeSKU_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidBarcodeSKU_Search();
    }
    @Test(priority = 13, dependsOnMethods = "Admin_Login", description = "Validate Invalid Product ID Filter Using Search")
    public  void InvalidProductID_Search() throws Exception{
        adminReportsProductInventorySteps.InvalidProductID_Search();
    }
    //@Test(priority = 14, dependsOnMethods = "Admin_Login", description = "Validate Invalid Region Filter Using Search")
    // public  void InvalidRegion_Search() throws Exception{
    //adminReportsProductInventorySteps.InvalidRegion_Search();
    //}

    //Date_001
    @Test(priority =15,  dependsOnMethods = "Admin_Login" , description = "Validate Correct Search using Date Range Function")
    public  void Correct_DateRange() throws Exception {
        adminReportsProductInventorySteps.Correct_DateRange();
    }
    @Test(priority =16,  dependsOnMethods = "Admin_Login" , description = "Validate Incorrect Search using Date Range Function")
    public  void Incorrect_DateRange() throws Exception {
        adminReportsProductInventorySteps.Incorrect_DateRange();
    }

    //Nav_001
    @Test(priority =17,  dependsOnMethods = "Admin_Login" , description = "Navigation of Pages: Next and Previous ")
    public  void Pagination() throws Exception {
        adminReportsProductInventorySteps.Pagination();
    }

    //XPRT_001
    @Test(priority =18,  dependsOnMethods = "Admin_Login" , description = "Verify Export: PDF")
    public  void PDF_Export() throws Exception {
        adminReportsProductInventorySteps.PDF_Export();
    }
    @Test(priority =19,  dependsOnMethods = "Admin_Login" , description = "Verify Export: Excel")
    public  void Excel_Export() throws Exception {
        adminReportsProductInventorySteps.Excel_Export();
    }
    @Test(priority =20,  dependsOnMethods = "Admin_Login" , description = "Verify Export: Excel = Year")
    public  void YearlyExcel_Export() throws Exception {
        adminReportsProductInventorySteps.YearlyExcel_Export();
    }
}
