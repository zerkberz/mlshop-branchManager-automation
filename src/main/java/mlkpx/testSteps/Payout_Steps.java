package mlkpx.testSteps;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Payout_Steps extends Base_Steps{
    public void navigatePayoutPage()throws Exception{
        try{
            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Search Payout Page");
            }
        }catch (Exception e){
            LoggingUtils.info("Failed to Navigate Search Payout Page "+ e);
        }
    }

//    public void validateSuccessfulDomesticPayout()throws Exception{
//        try{
//            click(kycPageObjects.PayoutTransaction(), "Payout Transaction");
//            click(kycPageObjects.UnremoteTransaction(), "Un-remote Transaction");
//            click(kycPageObjects.DomesticTransaction(), "Un-remote Transaction");
//            type(kycPageObjects.KTPN(), "First name field", propertyReader.getproperty("First_name"));
//
//
////            type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("Last_name"));
////            type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("First_name"));
////            click(kycPageObjects.searchBtn(), "Search button");
////            if(!kycPageObjects.buttonList().isEmpty()){
////                ExtentReporter.logPass("Successfully Search KYC");
////            }
//        }catch (Exception e){
//            ExtentReporter.logFail(""+e);
//        }
//    }

}
