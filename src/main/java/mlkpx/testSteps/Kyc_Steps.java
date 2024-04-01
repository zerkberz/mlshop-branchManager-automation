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

    public void searchRegisteredKYC_Invalid(){
        try{
            type(kycPageObjects.lastName_field(), "Last name field", "");
            type(kycPageObjects.firstName_field(), "First name field", "");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_required()),"LAST NAME IS REQUIRED.");
            assertEqual(getText(kycPageObjects.firstName_required()),"FIRST NAME IS REQUIRED.");


        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_Invalid03(){
        try{
            type(kycPageObjects.lastName_field(), "Numeric Last name field", "45645");
            type(kycPageObjects.firstName_field(), "Numeric First name field", "456456");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("Can't Input Numbers" +
                    " Cannot proceed to search or No Dat");


        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_Invalid04(){
        try{
            type(kycPageObjects.lastName_field(), "Special Character Last name field", "#$%@$%%#^^");
            type(kycPageObjects.firstName_field(), "Special Character First name field", "#$%@$%%#^^");
            click(kycPageObjects.searchBtn(), "Search button");
            ExtentReporter.logPass("Can't Input Special Characters" +
                    "- Cannot proceed to search or No Data");

        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_Invalid05(){
        try{
            type(kycPageObjects.lastName_field(), "60 Character Last name field", propertyReader.getproperty("MLast_name"));
            type(kycPageObjects.firstName_field(), "60 Character First name field", propertyReader.getproperty("MFirst_name"));
            type(kycPageObjects.middleName_field(), "60 Character Middle name field", propertyReader.getproperty("MMiddle_name"));
            type(kycPageObjects.suffix_field(), "Suffix field", "JRRRR");
            click(kycPageObjects.searchBtn(), "Search button");
            assertEqual(getText(kycPageObjects.lastName_max60()),"MAXIMUM OF 60 CHARACTERS.");
            assertEqual(getText(kycPageObjects.firstName_max60()),"MAXIMUM OF 60 CHARACTERS.");
            ExtentReporter.logPass("Can input only 5 letters in Suffix" +
                    "- Search button disabled");

        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }




        public void AddNewKYC_Valid(){
            try{
                click(kycPageObjects.kyc_link(), "Kyc Page");
                type(kycPageObjects.lastName_field(), "Last name field", "");
                type(kycPageObjects.firstName_field(), "First name field", "");
                click(kycPageObjects.birthDate(), "Add BirthDate");
                click(kycPageObjects.searchOtherDevice(), "Search in other Systems");


            }catch (Exception e){
                ExtentReporter.logFail(""+e);
            }


        }




}
