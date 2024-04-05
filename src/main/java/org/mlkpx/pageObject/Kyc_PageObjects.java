package org.mlkpx.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Kyc_PageObjects {
    public WebElement kyc_link(){
        return getDriver().findElement(By.cssSelector("[href='/kyc']"));
    }
    public WebElement kycPage_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement lastName_field(){
        return getDriver().findElement(By.name("lastName"));
    }
    public WebElement firstName_field(){
        return getDriver().findElement(By.name("firstName"));
    }
    public WebElement middleName_field(){
        return getDriver().findElement(By.name("middleName"));
    }
    public WebElement suffix_field(){
        return getDriver().findElement(By.name("suffix"));
    }
    public WebElement searchBtn(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }

    public List<WebElement> buttonList(){
        return getDriver().findElements(By.cssSelector("[type='button']"));
    }
    public WebElement lastName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'Last name is required.')]"));}
    public WebElement firstName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'First name is required.')]"));}
    public WebElement birthdate1_field(){return getDriver().findElement(By.cssSelector("[max=\"2024-04-01\"]"));}
    public WebElement birthdate2_field(){return getDriver().findElement(By.cssSelector("[class = form-control-sm form-control]"));}

    public WebElement birthDate(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Birth Date']"));
    }


    public WebElement lastName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[1]/div/small"));}
    public WebElement firstName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[2]/div/small"));}
    public WebElement middleName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[3]/div/small"));}
    public WebElement birthdate_field(){return getDriver().findElement(By.cssSelector("[placeholder='Birth Date']"));}
    public WebElement searchOtherDevice(){return getDriver().findElement(By.xpath("//button[normalize-space()='Search in Other Systems']"));
    }

    public WebElement searchInOtherSystemButton() {
        return getDriver().findElement(By.cssSelector("[class='btn btn-primary']"));
    }
    public WebElement kycNotFoundText(){return getDriver().findElement(By.xpath("//div[@role='alert']"));}
    public WebElement AddLName(){return getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));}
    public WebElement AddFName(){return getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));}
    public WebElement AddMName(){return getDriver().findElement(By.xpath("//input[@placeholder='Middle Name']"));}
    public WebElement Checkbox(){return getDriver().findElement(By.xpath("//input[@name='hasNoMiddleName']"));}
    public WebElement AddBirthPlace(){return getDriver().findElement(By.xpath("//input[@placeholder='Place of Birth']"));}
    public WebElement AddSuffix(){return getDriver().findElement(By.xpath("//option[@value='JR']"));}
    public WebElement SelectNational(){return getDriver().findElement(By.xpath("//option[@value='FILIPINO']"));}
    public WebElement SelectCivilStatus(){return getDriver().findElement(By.xpath("//option[@value='single']"));}
    public WebElement SelectGender(){return getDriver().findElement(By.xpath("//option[@value='male']"));}
    public WebElement SelectCountry(){return getDriver().findElement(By.xpath("//option[@value='PHILIPPINES']"));}
    public WebElement ContactInfo(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Contact Information')]"));}
    public WebElement MobileField(){return getDriver().findElement(By.xpath("//input[@name='cellphoneNumber']"));}
    public WebElement MobileCheckout(){return getDriver().findElement(By.cssSelector("[name='hasNoMobileNumber'"));}
    public WebElement TelephoneField(){return getDriver().findElement(By.xpath("//input[@name='telephoneNumber']"));}
    public WebElement EmailField(){return getDriver().findElement(By.xpath("//input[@name='email']"));}

    public WebElement CAddressInfo(){return getDriver().findElement(By.xpath("//h6[contains(text(),'Current Address')]"));}
    public WebElement SelectProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'ABRA') and @value='1'])[1]"));}
    public WebElement SelectMunicipality(){return getDriver().findElement(By.xpath("//option[contains(text(),'BOLINEY') and @value='323']"));}
    public WebElement HouseStreetInfo(){return getDriver().findElement(By.xpath("(//input[@placeholder='HOUSE NO, STREET / SITIO / BARANGAY'])[1]"));}


    public WebElement PAddressInfo(){return getDriver().findElement(By.xpath("//h6[contains(text(),'Permanent Address')]"));}
    public WebElement PSelectProvince(){return getDriver().findElement(By.xpath("(//option[contains(text(),'AGUSAN DEL NORTE') and @value='2'])[2]"));}
    public WebElement PSelectMunicipality(){return getDriver().findElement(By.xpath("//option[contains(text(),'BUENAVISTA') and @value='589']"));}
    public WebElement PHouseStreetInfo(){return getDriver().findElement(By.xpath("(//input[@placeholder='HOUSE NO, STREET / SITIO / BARANGAY'])[2]"));}
    public WebElement SameCurrentAddress(){return getDriver().findElement(By.xpath("//input[@placeholder='House No, Street']"));}

    public WebElement WorkNature(){return getDriver().findElement(By.xpath("//h5[contains(text(),'Nature of Work')]"));}
    public WebElement SourceIncome(){return getDriver().findElement(By.xpath("//select[@placeholder='Source of Income']"));}
    public WebElement CompanyName(){return getDriver().findElement(By.xpath("//input[@placeholder='Company/Employer Name']"));}
    public WebElement ProductOffered(){return getDriver().findElement(By.xpath("//option[@value='INFORMATION TECHNOLOGY']"));}
    public WebElement WorkAddress(){return getDriver().findElement(By.xpath("//input[@placeholder='Work Address']"));}
    public WebElement PositionAtWork(){return getDriver().findElement(By.xpath("//option[@value='ENGINEER/SPECIALIST/TECHNICIAN']"));}
    public WebElement NatureOfWork(){return getDriver().findElement(By.xpath("//option[@value='BPO AGENT/OFFICER']"));}



    public WebElement Identification(){return getDriver().findElement(By.xpath("//h5[contains(text(),'ID')]"));}
    public WebElement IDType(){return getDriver().findElement(By.xpath("(//option[@value='5'])[5]"));}
    public WebElement IDNumber(){return getDriver().findElement(By.xpath("(//input[@placeholder='ID No'])[1]"));}


    public WebElement FrontID(){return getDriver().findElement(By.xpath("(//label[contains(text(),'ID')])[6]"));}
    public WebElement FCamera(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Camera'])[1]"));}
    public WebElement FCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement FSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}


    public WebElement BackID(){return getDriver().findElement(By.xpath("(//label[contains(text(),'ID')])[7]"));}
    public WebElement BCamera(){return getDriver().findElement(By.cssSelector("[type='button'][name='id2File']"));}
    public WebElement BCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement BSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}


    public WebElement CustomerPhoto(){return getDriver().findElement(By.xpath("(//label[@class='subheading'])[4]"));}
    public WebElement CCamera(){return getDriver().findElement(By.cssSelector("[name='customerPhoto']"));}
    public WebElement CCapture(){return getDriver().findElement(By.xpath("//button[normalize-space()='Capture Photo']"));}
    public WebElement CSet(){return getDriver().findElement(By.xpath("//button[normalize-space()='Set Photo']"));}

    public WebElement ActiveStatus(){return getDriver().findElement(By.xpath("//label[contains(text(),'Is Customer Active?')]"));}
    public WebElement KYCEdit(){return getDriver().findElement(By.xpath("(//button[@class='btn-sm btn btn-secondary'])[4]"));}
    public WebElement YesActive(){return getDriver().findElement(By.xpath("(//input[@value='1'])[3]"));}
    public WebElement KYCDone(){return getDriver().findElement(By.xpath("//button[normalize-space()='Done']"));}
    public WebElement SaveNewKYC(){return getDriver().findElement(By.xpath("//button[normalize-space()='Save New KYC']"));}



}
