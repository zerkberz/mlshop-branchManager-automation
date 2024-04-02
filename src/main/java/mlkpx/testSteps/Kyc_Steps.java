package mlkpx.testSteps;

import org.mlkpx.pageObject.Kyc_PageObjects;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import org.openqa.selenium.By;
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
                type(kycPageObjects.lastName_field(), "Last name field", propertyReader.getproperty("ELName"));
                type(kycPageObjects.firstName_field(), "First name field", propertyReader.getproperty("EFName"));
                click(kycPageObjects.searchBtn(), "Search button");
                click(kycPageObjects.birthdate_field(), "Birthdate field");
                type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("year"));
                kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
                type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("month"));
                kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
                kycPageObjects.birthdate_field().sendKeys(Keys.ARROW_LEFT);
                type(kycPageObjects.birthdate_field(), "Birthdate field", propertyReader.getproperty("day"));
                click(kycPageObjects.searchInOtherSystemButton(), "Search in other Systems");
                if (kycPageObjects.kycNotFoundText().getText().contains("KYC Not Found!")) {
                    ExtentReporter.logPass("KYC Not Found!, Please add the customer KYC details");

                }
            }catch (Exception e){
                ExtentReporter.logFail(""+e);
            }

        }
    public void AddNewKYC01(){
        try{
            if (kycPageObjects.AddLName().isEnabled()) {
                type(kycPageObjects.AddLName(), "Last name field", "Siarot");
                ExtentReporter.logPass("Inputted Last name will display and editable");
            } else if (kycPageObjects.AddFName().isEnabled()) {
                type(kycPageObjects.AddFName(), "First name field", "Enrique");
                ExtentReporter.logPass("Inputted First name will display and editable");
                wait(5000);
            }
            type(kycPageObjects.AddFName(), "Middle name field", "Alferez");
            click(kycPageObjects.Checkbox(), "Chick Check Button");
            click(kycPageObjects.AddSuffix(), "Select Suffix");
            type(kycPageObjects.AddBirthPlace(), "Edit/Input Valid BirthDate", "Bohol, Philippines");
            click(kycPageObjects.SelectNational(), "Select Nationality");
            click(kycPageObjects.SelectCivilStatus(), "Select Civil Status");
            click(kycPageObjects.SelectGender(), "Select Gender at Birth");
            click(kycPageObjects.SelectCountry(), "Select Country Birth");
            if (kycPageObjects.ContactInfo().getText().contains("Contact Information")) {
                type(kycPageObjects.MobileField(),"Input Mobile Number","0920-344-7377");
                type(kycPageObjects.TelephoneField(),"Input Telephone","02454321345");
                type(kycPageObjects.EmailField(),"Input Email","testing@gmail.com");
                click(kycPageObjects.MobileCheckout(),"Click Checkout");

            }
            if (kycPageObjects.CAddressInfo().getText().contains("CURRENT ADDRESS")) {
                click(kycPageObjects.SelectProvince(),"Select Province");
                click(kycPageObjects.SelectMunicipality(),"Select Municipality");
                type(kycPageObjects.HouseStreetInfo(),"House No, Street/ Sitio/Baranggay","Testing,testing,testing");

            }
            if (kycPageObjects.PAddressInfo().getText().contains("PERMANENT ADDRESS")) {
                click(kycPageObjects.PSelectProvince(), "Select Permanent Province");
                click(kycPageObjects.PSelectMunicipality(), "Select Permanent Municipality");
                type(kycPageObjects.PHouseStreetInfo(), "House No, Street/ Sitio/Baranggay", "Testing,testing,testing");
                click(kycPageObjects.SameCurrentAddress(), "Click Checkout");

            }
            if (kycPageObjects.WorkNature().getText().contains("Nature of Work")) {
                click(kycPageObjects.SourceIncome(), "Select Source of Income");
                type(kycPageObjects.CompanyName(), "Select Company Employee Name","Mlhuillier");
                click(kycPageObjects.ProductOffered(), "Select Product and Services");
                type(kycPageObjects.WorkAddress(), "Input Work Address","Cebu City");
                click(kycPageObjects.PositionAtWork(), "Select Position at Work");
                click(kycPageObjects.NatureOfWork(), "Select Nature of Work");

            }
            if (kycPageObjects.Identification().getText().contains("ID")) {
                click(kycPageObjects.IDType(), "Select ID Type");
                type(kycPageObjects.IDNumber(), "Input ID Number","1234567891011213");

            }
            if (kycPageObjects.FrontID().getText().contains("FRONT ID")) {
                click(kycPageObjects.FCamera(), "Select Camera");
                click(kycPageObjects.FCapture(), "Select Capture Photo");
                click(kycPageObjects.FSet(), "Select Set Photo");
            }
            if (kycPageObjects.BackID().getText().contains("BACK ID")) {
                click(kycPageObjects.BCamera(), "Select Camera");
                click(kycPageObjects.BCapture(), "Select Capture Photo");
                click(kycPageObjects.BSet(), "Select Set Photo");
            }



        }catch (Exception e){
            ExtentReporter.logFail(""+e);
        }
    }




}
