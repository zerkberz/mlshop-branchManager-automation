package mlkpx.testSteps;

import org.mlkpx.pageObject.Kyc_PageObjects;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Kyc_Steps extends Base_Steps {
    public void navigateKycPage()throws Exception{
        try{
            click(kycPageObjects.kyc_link(), "Kyc Page");
            if(isVisible(kycPageObjects.kycPage_h2(), getText(kycPageObjects.kycPage_h2()))){
                LoggingUtils.info("Navigated to Search KYC Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Search KYC Page "+ e);
        }
    }

    public void searchRegisteredKYC_Valid()throws Exception{
        try{
            type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("First_name"));
            type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("Last_name"));
            click(kycPageObjects.searchBtn(), "Search button");
            if(!kycPageObjects.buttonList().isEmpty()){
                ExtentReporter.logPass("Successfully Search KYC");
            }
        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }

}
