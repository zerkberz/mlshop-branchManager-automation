package MLShop_Admin.actual;

import MLShop_Admin.base.BaseTest;
import org.testng.annotations.Test;

public class Orders extends BaseTest {

    //For log-in only
    @Test(priority = 0, description = "Validate Admin Log In")
    public  void Admin_Login() throws Exception{
        adminOrderSteps.Admin_Login();
    }
    //For log-in only

    //Ent_001
    @Test(priority = 1,  dependsOnMethods = "Admin_Login" , description = "Validate Show Number of Entries")
    public  void NumberOfEntries() throws Exception{
        adminOrderSteps.NumberOfEntries();
    }
    @Test(priority = 2,  dependsOnMethods = "Admin_Login" , description = "The data on the list is parallel to the details seen in View Details. ")
    public  void DataComparison_Orders() throws Exception{
        adminOrderSteps.DataComparison_Orders();
    }

    //Nav_001
    @Test(priority =3,  dependsOnMethods = "Admin_Login" , description = "Navigation of Pages: Next and Previous ")
    public  void Pagination() throws Exception{
        adminOrderSteps.Pagination();
    }

    //Dtls_001
    @Test(priority =4,  dependsOnMethods = "Admin_Login" , description = "Validate View Details")
    public  void ViewDetails_Check() throws Exception{
        adminOrderSteps.ViewDetails_Check();
    }

    //Print_001
    @Test(priority =5,  dependsOnMethods = "Admin_Login" , description = "Validate Print Invoice Function")
    public  void PrintInvoice_ViewDetails() throws Exception{
        adminOrderSteps.PrintInvoice_ViewDetails();
    }

    //Date_001
    @Test(priority =6,  dependsOnMethods = "Admin_Login" , description = "Validate Correct Search using Date Range Function")
    public  void Correct_DateRange() throws Exception{
        adminOrderSteps.Correct_DateRange();
    }
    @Test(priority =7,  dependsOnMethods = "Admin_Login" , description = "Validate Incorrect Search using Date Range Function")
    public  void Incorrect_DateRange() throws Exception{
        adminOrderSteps.Incorrect_DateRange();
    }

    //Search
    @Test(priority = 8,  dependsOnMethods = "Admin_Login" , description = "Validate Seller Search")
    public  void Seller_Search() throws Exception{
        adminOrderSteps.Seller_Search();
    }
    @Test(priority = 9,  dependsOnMethods = "Admin_Login" , description = "Validate Mode Of Payment Search")
    public  void PaymentMethod_Search() throws Exception{
        adminOrderSteps.PaymentMethod_Search();
    }
    @Test(priority = 10,  dependsOnMethods = "Admin_Login" , description = "Validate Order Status Search")
    public  void OrderStatus_Search() throws Exception{
        adminOrderSteps.OrderStatus_Search();
    }

    //Search_002
    @Test(priority = 11,  dependsOnMethods = "Admin_Login" , description = "Validate Invalid Seller Search")
    public  void IncorrectSeller_Search() throws Exception{
        adminOrderSteps.IncorrectSeller_Search();
    }
    @Test(priority = 12,  dependsOnMethods = "Admin_Login" , description = "Validate Invalid Payment Method Search")
    public  void IncorrectPaymentMethod_Search() throws Exception{
        adminOrderSteps.IncorrectPaymentMethod_Search();
    }
    @Test(priority = 13,  dependsOnMethods = "Admin_Login" , description = "Validate Invalid Order Status Search")
    public  void IncorrectOrderStatus_Search() throws Exception{
        adminOrderSteps.IncorrectOrderStatus_Search();
    }
















}