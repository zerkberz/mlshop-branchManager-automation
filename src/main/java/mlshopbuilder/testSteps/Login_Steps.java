package mlshopbuilder.testSteps;

public class Login_Steps extends Base_Steps{
    String loginUrl = "https://mlshoppreprod.mlhuillier.com/authlogin";

   public void login(){
    try{
        click(home_PageObjects.userIcon(), "User Icon");
        waitSleep(2000);
        assertEqual(driver.getCurrentUrl(), loginUrl);
        typeEnter(loginPageObjects.mobileNumber_field(), "Mobile Number Field", reader.getRandomUser());
        waitSleep(5000);
        if(isVisible(loginPageObjects.otpMessage(), getText(loginPageObjects.otpMessage()))){
            inputOTP();
            click(loginPageObjects.okay_Btn(), "Okay Button");
            waitSleep(1000);
            assertEqual(driver.getCurrentUrl(), System.getProperty("targetUrl"));
            passTest("LOGIN SUCESS", "");
        }else{
            failTest("FAILED TO LOGIN", "");
        }
    }catch(Exception e){
        failTest("FAILED TO LOGIN", "Due to :" + e);
    }
      
   }
   public void inputOTP(){
       for(int i = 1; i <= 6 ; i++){
        typeActiveElement(String.valueOf(i));
       }
   }
}
