package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class SignUpT extends BaseTest {

    @Test(priority = 0)
    public  void SBSU_TC_01_and_02() throws Exception{
        signUpSteps.SBSU_TC_01_and_02();
    }
    @Test(priority = 1)
    public  void SBSU_TC_03_Emptytxtboxes() throws Exception{
        signUpSteps.SBSU_TC_03_Emptytxtboxes();
    }
    @Test(priority = 1)
    public  void SBSU_TC_04_Tickbox() throws Exception{
        signUpSteps.SBSU_TC_04_Tickbox();
    }
    @Test(priority = 2)
    public  void SBSU_TC_05_InvalidStoreEmail() throws Exception{
        signUpSteps.SBSU_TC_05_InvalidStoreEmail();
    }
    @Test(priority = 3)
    public  void SBSU_TC_06_InvalidNumber() throws Exception{
        signUpSteps.SBSU_TC_06_InvalidNumber();
    }
    @Test(priority = 4)
    public  void SBSU_TC_07_InvalidBranchName() throws Exception{
        signUpSteps.SBSU_TC_07_InvalidBranchName();
    }
    @Test(priority = 5)
    public  void SBSU_TC_08_SuccesfulSignUp() throws Exception{
        signUpSteps.SBSU_TC_08_SuccesfulSignUp();
    }

}
