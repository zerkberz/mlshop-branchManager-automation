package MLshopBuilders.actual;

import org.testng.annotations.Test;

import MLshopBuilders.base.BaseTest;
import utilities.ExtentReport.ExtentReporter;

public class AdminT extends BaseTest {

    @Test(priority = 0, description = "Login using Admin account")
    public void SBA_TC_01_Login() throws Exception {
        loginSteps.loginByRole("admin");
        if (loginSteps.isInHomePage()) {
            ExtentReporter.logPass("SBA_TC_01_Login", "Successfully Logged in Administrator");
        }
    }

    @Test(priority = 1, description = "Redirection to ShopBuilder Page", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_02_ShopBuilderRedirection() throws Exception {
        adminSteps.SBA_TC_02_ShopBuilderRedirection();
    }
    @Test(priority = 2, description = "Dashboard Contents Validation", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation() throws Exception {
        adminSteps.SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation();
    }
    @Test(priority = 3, description = "Shop Builder Store Count", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount() throws Exception {
        adminSteps.SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount();
    }
    @Test(priority = 4, description = "Invalid Searching for Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_07_InvalidSearches() throws Exception {
        adminSteps.SBA_TC_07_InvalidSearches();
    }
    @Test(priority = 5, description = "Valid Searching of Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_08_ValidSearches() throws Exception {
        adminSteps.SBA_TC_08_ValidSearches();
    }
    @Test(priority = 6, description = "Validate Selected Store Redirection", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_09_SelectedStoreRedirection() throws Exception {
        adminSteps.SBA_TC_09_SelectedStoreRedirection();
    }
    @Test(priority = 7, description = "Add New Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_10_AddStore() throws Exception {
        adminSteps.SBA_TC_10_AddStore();
    }
    @Test(priority = 8, description = "Add Category on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_11_AddCategory() throws Exception {
        adminSteps.SBA_TC_11_AddCategory();
    }
    @Test(priority = 9, description = "Hide and Show Category on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_12_HideShowCategories() throws Exception {
        adminSteps.SBA_TC_12_HideShowCategories();
    }
    @Test(priority = 10, description = "Add Type on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_13_AddType() throws Exception {
        adminSteps.SBA_TC_13_AddType();
    }
    @Test(priority = 11, description = "Add Sort Price on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_14_AddingSortPrice() throws Exception {
        adminSteps.SBA_TC_14_AddingSortPrice();
    }
    @Test(priority = 13, description = "View Toggling on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_15_Viewtoggling() throws Exception {
        adminSteps.SBA_TC_15_Viewtoggling();
    }
    @Test(priority = 14, description = "View Product of Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_16_ViewProduct() throws Exception {
        adminSteps.SBA_TC_16_ViewProduct();
    }
    @Test(priority = 15, description = "View Logs of Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_17_ViewLogsFunctionalities() throws Exception {
        adminSteps.SBA_TC_17_ViewLogsFunctionalities();
    }
    @Test(priority = 16, dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_18_BannerFunctionality() throws Exception {
        adminSteps.SBA_TC_18_BannerFunctionality();
    }
    @Test(priority = 17, description = "Edit Profile of the Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_19_EditProfileFunctionalities() throws Exception {
    adminSteps.SBA_TC_19_EditProfileFunctionalities();
}
    @Test(priority = 18, description = "Adding Sub Accounts on Dashboard Page", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_20_AddingSubaccount() throws Exception {
        adminSteps.SBA_TC_20_AddingSubaccount();
    }
    @Test(priority = 19, description = "Adding and Removing Store on Selected Merchant", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_21_AddingAndRemovingStore() throws Exception {
        adminSteps.SBA_TC_21_AddingAndRemovingStore();
    }
    @Test(priority = 20, description = "Validate Edits made on Selected Store", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_22() throws Exception {
        adminSteps.SBA_TC_22();
    }
    @Test(priority = 21, description = "Status Changes on Merchant Account", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_23_DeactivatingAndActivatingOfMerchantAccount() throws Exception {
        adminSteps.SBA_TC_23_DeactivatingAndActivatingOfMerchantAccount();
    }

    @Test(priority = 22, description = "Validate Main Account and Merchant: View Details", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_24_and_25() throws Exception {
        adminSteps.SBA_TC_24_and_25();
    }

    @Test(priority = 23, description = "Merchant: Status Change", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_26_statuschange() throws Exception {
        adminSteps.SBA_TC_26_statuschange();
    }

    @Test(priority = 24, description = "Empty Edit Fields on Merchant Details proceeds to Error", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_27_EmptyFields() throws Exception {
        adminSteps.SBA_TC_27_EmptyFields();
    }
    @Test(priority = 25, description = "Validation of edited Merchant Information", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_28_ValidateUpdatedMerchantInfo() throws Exception {
        adminSteps.SBA_TC_28_ValidateUpdatedMerchantInfo();
    }
    @Test(priority = 26, description = "Agent Configuration Tab Navigation on User Avatar", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_29_AgentConfigNavigation() throws Exception {
        adminSteps.SBA_TC_29_AgentConfigNavigation();
    }



//    @Test(priority = 24)
//    public void SBA_TC_30 () throws Exception {
//        adminSteps.SBA_TC_30();
//    }
//    @Test(priority = 25)
//    public void SBA_TC_31 () throws Exception {
//        adminSteps.SBA_TC_31();
//    }

    @Test(priority = 27, description = "Log Out", dependsOnMethods = "SBA_TC_01_Login")
    public void SBA_TC_32_Logout() throws Exception {
        adminSteps.SBA_TC_32_Logout();
    }
}

