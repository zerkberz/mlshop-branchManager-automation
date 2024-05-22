package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import mlshopbuilder.testSteps.SupportAdmin_Steps;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class AdminT extends BaseTest {

    @Test(priority = 0 , description = "Login using Admin account")
    public void SBA_TC_01_Login() throws Exception {
        loginSteps.loginByRole("admin");
        if(loginSteps.isInHomePage()){
            ExtentReporter.logPass("SBA_TC_01_Login", "Successfully Logged in Administrator");
        }
    }
//    @Test(priority = 1)
//    public void SBA_TC_02_ShopBuilderRedirection() throws Exception {
//        adminSteps.SBA_TC_02_ShopBuilderRedirection();
//    }
//    @Test(priority = 2)
//    public void SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation() throws Exception {
//        adminSteps.SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation();
//    }
//    @Test(priority = 3)
//    public void SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount() throws Exception {
//        adminSteps.SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount();
//    }
//    @Test(priority = 4)
//    public void SBA_TC_07_InvalidSearches() throws Exception {
//        adminSteps.SBA_TC_07_InvalidSearches();
//    }
//    @Test(priority = 5)
//    public void SBA_TC_08_ValidSearches() throws Exception {
//        adminSteps.SBA_TC_08_ValidSearches();
//    }
//    @Test(priority = 6)
//    public void SBA_TC_09_SelectedStoreRedirection() throws Exception {
//        adminSteps.SBA_TC_09_SelectedStoreRedirection();
//    }
//    @Test(priority = 7)
//    public void SBA_TC_10_AddStore() throws Exception {
//        adminSteps.SBA_TC_10_AddStore();
//    }
//    @Test(priority = 8)
//    public void SBA_TC_11_AddCategory() throws Exception {
//        adminSteps.SBA_TC_11_AddCategory();
//    }
//    @Test(priority = 9)
//    public void SBA_TC_12_HideShowCategories() throws Exception {
//        adminSteps.SBA_TC_12_HideShowCategories();
//    }
//    @Test(priority = 10)
//    public void SBA_TC_13_AddType() throws Exception {
//        adminSteps.SBA_TC_13_AddType();
//    }
//    @Test(priority = 11)
//    public void SBA_TC_14_SortPrice() throws Exception {
//        adminSteps.SBA_TC_14_SortPrice();
//    }
//    @Test(priority = 12)
//    public void SBA_TC_14_SortPrice() throws Exception {
//        adminSteps.SBA_TC_14_SortPrice();
//    }
//    @Test(priority = 13)
//    public void SBA_TC_15_Viewtoggling() throws Exception {
//        adminSteps.SBA_TC_15_Viewtoggling();
//    }
//    @Test(priority = 14)
//    public void SBA_TC_16_ViewProduct() throws Exception {
//        adminSteps.SBA_TC_16_ViewProduct();
//    }
//    @Test(priority = 15)
//    public void SBA_TC_17_ViiewLogsFunctionalities() throws Exception {
//        adminSteps.SBA_TC_17_ViiewLogsFunctionalities();
//    }
@Test(priority = 16)
public void SBA_TC_18_BannerFunctionality() throws Exception {
    adminSteps.SBA_TC_18_BannerFunctionality();
}
//    @Test(priority = 17)
//    public void SBA_TC_20() throws Exception {
//    adminSteps.SBA_TC_20();
//}
//    @Test(priority = 17)
//    public void SBA_TC_20() throws Exception {
//        adminSteps.SBA_TC_20();
//    }
//
//    @Test(priority = 18)
//    public void SBA_TC_21_AddingAndRemovingStore() throws Exception {
//        adminSteps.SBA_TC_21_AddingAndRemovingStore();
//    }
//    @Test(priority = 18)
//    public void SBA_TC_22() throws Exception {
//        adminSteps.SBA_TC_22();
//    }
//    @Test(priority = 18)
//    public void SBA_TC_23_DeactivatingAndActivatingOfMerchantAccount() throws Exception {
//        adminSteps.SBA_TC_23_DeactivatingAndActivatingOfMerchantAccount();
//    }
//    @Test(priority = 19)
//    public void SBA_TC_25_and_26() throws Exception {
//        adminSteps.SBA_TC_25_and_26();
//    }
//    @Test(priority = 20)
//    public void SBA_TC_27_statuschange() throws Exception {
//        adminSteps.SBA_TC_27_statuschange();
//    }
//    @Test(priority = 21)
//    public void SBA_TC_28_EmptyFields() throws Exception {
//        adminSteps.SBA_TC_28_EmptyFields();
//    }
//    @Test(priority = 22)
//    public void SBA_TC_29_ValidateUpdatedMerchantInfo() throws Exception {
//        adminSteps.SBA_TC_29_ValidateUpdatedMerchantInfo();
//    }
//    @Test(priority = 23)
//    public void SBA_TC_30_AgentConfigNavigation() throws Exception {
//        adminSteps.SBA_TC_30_AgentConfigNavigation();
//    }
//    @Test(priority = 24)
//    public void SBA_TC_31() throws Exception {
//        adminSteps.SBA_TC_31();
//    }
//    @Test(priority = 25)
//    public void SBA_TC_32() throws Exception {
//        adminSteps.SBA_TC_32();
//    }

//    @Test(priority = 26)
//    public void SBA_TC_33_Logout() throws Exception {
//        adminSteps.SBA_TC_33_Logout();
//    }



}
