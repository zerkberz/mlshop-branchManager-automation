package MLShop_Admin.actual;

import MLShop_Admin.base.BaseTest;
import org.testng.annotations.Test;

public class OrdersT extends BaseTest {

//    @Test(priority = 0, description = "Validate Admin Log In")
//    public  void Administrator_Login() throws Exception{
//        adminOrderSteps.Administrator_Login();
//    }
    @Test(priority = 1,  description = "Validate Admins' Order Searches")
    public  void Admin_Search() throws Exception{
        adminOrderSteps.Admin_Search();
    }

}
