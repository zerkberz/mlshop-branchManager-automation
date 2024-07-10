package MLShop_Admin.actual;

import MLShop_Admin.base.BaseTest;
import org.testng.annotations.Test;

public class OrdersT extends BaseTest {

    //For log-in only
    @Test(priority = 0, description = "Validate Admin Log In")
    public  void Admin_Login() throws Exception{
        adminOrderSteps.Admin_Login();
    }
    //For log-in only

    //Ent_001
//    @Test(priority = 1,  dependsOnMethods = "Admin_Login" , description = "Validate Show Number of Entries")
//    public  void NumberOfEntries() throws Exception{
//        adminOrderSteps.NumberOfEntries();
//    }
//    @Test(priority = 2,  dependsOnMethods = "Admin_Login" , description = "The data on the list is parallel to the details seen in View Details. ")
//    public  void DataComparison_Orders() throws Exception{
//        adminOrderSteps.DataComparison_Orders();
//    }

    //Nav_001
//    @Test(priority =3,  dependsOnMethods = "Admin_Login" , description = "Navigation of Pages: Next and Previous ")
//    public  void Pagination() throws Exception{
//        adminOrderSteps.Pagination();
//    }

    //Dtls_001
//    @Test(priority =4,  dependsOnMethods = "Admin_Login" , description = "Validate View Details")
//    public  void ViewDetails_Check() throws Exception{
//        adminOrderSteps.ViewDetails_Check();
//    }

    //Print_001
//    @Test(priority =5,  dependsOnMethods = "Admin_Login" , description = "Validate Print Invoice Function")
//    public  void PrintInvoice_ViewDetails() throws Exception{
//        adminOrderSteps.PrintInvoice_ViewDetails();
//    }

    //Date_001
    @Test(priority =6,  dependsOnMethods = "Admin_Login" , description = "Validate Correct Date Range Function")
    public  void Correct_DateRange() throws Exception{
        adminOrderSteps.Correct_DateRange();
    }




//    @Test(priority = 0,  dependsOnMethods = "Admin_Login" , description = "Validate Admins' Order Searches")
//    public  void Admin_Search() throws Exception{
//        adminOrderSteps.Admin_Search();
//    }




}
