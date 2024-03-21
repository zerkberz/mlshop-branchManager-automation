package utilities.ReusableComponents;
import org.jboss.aerogear.security.otp.Totp;
public class TOTPGenerator {
    public static String getTwoFactorCode(){
        Totp totp = new Totp(System.getProperty("token"));
        return totp.now();
    }
}
