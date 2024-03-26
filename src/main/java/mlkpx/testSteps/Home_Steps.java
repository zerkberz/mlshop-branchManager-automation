package mlkpx.testSteps;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Home_Steps extends Base_Steps {
    public boolean isInHomePage()throws Exception{
        try{
            if(homePageObjects.searchField().isDisplayed()){
                LoggingUtils.info("Successfully directed to the Homepage");
                return true;
            }
        }catch (Exception e){
            LoggingUtils.info("Failed directed to the Homepage");
            ExtentReporter.logFail("Failed directed to the Homepage " + e);
        }
        return false;
    }
}
