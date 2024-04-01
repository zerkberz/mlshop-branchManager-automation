package mlkpx.testSteps;

import org.mlkpx.pageObject.Kyc_PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

            type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("Last_name"));
            type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("First_name"));
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
        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_InvalidInputNumbers(){
        try{
            type(kycPageObjects.lastName_field(), "Last name field", "3234");
            type(kycPageObjects.firstName_field(), "First name field", "12312");
            click(kycPageObjects.searchBtn(), "Search button");
        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_InvalidInputSpecialCharacters(){
        try{
            type(kycPageObjects.lastName_field(), "Last name field", "@_#@#@*(#&@$^$");
            type(kycPageObjects.firstName_field(), "First name field", "$@@!()$)(@$");
            click(kycPageObjects.searchBtn(), "Search button");
        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }
    public void searchRegisteredKYC_InvalidInputMoreThan60Characters(){
        try{
            type(kycPageObjects.lastName_field(), "Last name field", "sdfdssssssssssssssssssssssssssssssssssssssssssssssssssssssfDSfsssssssssssssssgggggggggggggggASSSSSSSSSSSS");
            type(kycPageObjects.firstName_field(), "First name field", "sfsdfdsfffffffffffffffffffffffffffSDDDDDDDFFfdsffffffffffffffffffffffffffffffffasfffffffffaaaaaaaaasfccc");
            click(kycPageObjects.searchBtn(), "Search button");
        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }



    public void ValidInputsInAddKYCNameSectionPositiveTesting() throws Exception {
        try {
            type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("L_name"));
            type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("F_Name"));
            click(kycPageObjects.searchBtn(), "Search button");
            click(kycPageObjects.birthdate_field(), "Birthdate field");
            type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("birthDate"));
            kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
            kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
            kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
            type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
            click(kycPageObjects.searchInOtherSystemButton(), "Search in other system");
            if (kycPageObjects.kycNotFoundText().getText().contains("KYC Not Found!")) {
                ExtentReporter.logPass("KYC Not Found!, Please add the customer KYC details");
            }
        } catch (Exception e) {
            ExtentReporter.logFail("" + e);
        }
    }

}
