package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class MerchantT extends BaseTest {

    @Test(priority =0)
    public void SBR_TC_01_Login() throws Exception {
        merchantSteps.SBR_TC_01_Login();
    }

    @Test(priority = 1)
    public void SBR_TC_02_NavigateShopBuilder_Page() throws Exception {
        merchantSteps.SBR_TC_02_NavigateShopBuilder_Page();
    }

    @Test(priority =2)
    public void SBR_TC_03_TotalStores() throws Exception {
        merchantSteps.SBR_TC_03_TotalStores();
    }
}

