package MLShop.actualBranch;

import MLShop.base.BaseTest;
import org.testng.annotations.Test;

public class Branch extends BaseTest {

    //LogIn_001
    @Test(priority = 0, description = "Successfully Logged In.")
    public  void Branch_Login() throws Exception{
        branchSteps.Branch_Login();
    }

    //Nav_001
    @Test(priority = 1,  dependsOnMethods = "Branch_Login" , description = "Validate Sidebar Navigation")
    public  void Sidebar_Navigation() throws Exception{
        branchSteps.Sidebar_Navigation();
    }

    //Entry_001
    @Test(priority = 2,  dependsOnMethods = "Branch_Login" , description = "Validate Entry Selection")
    public  void Entries() throws Exception{
        branchSteps.Entries();
    }

    //Search_001
    @Test(priority = 3,  dependsOnMethods = "Branch_Login" , description = "Validate Search via Sidebars")
    public  void Search_via_Sidebars() throws Exception{
        branchSteps.Search_via_Sidebars();
    }

    //Search_002
    @Test(priority = 4,  dependsOnMethods = "Branch_Login" , description = "Validate Invalid Search via Sidebars")
    public  void InvalidSearch_via_Sidebars() throws Exception{
        branchSteps.InvalidSearch_via_Sidebars();
    }
}
