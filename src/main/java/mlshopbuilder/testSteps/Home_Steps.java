package mlshopbuilder.testSteps;

import org.openqa.selenium.WebElement;

public class Home_Steps extends Base_Steps{

    //Method for clicking random products from home page
    public void clickProduct(){ 
        for(WebElement products : home_PageObjects.itemNames()){
            click(products, products.getText());
            break;
        }
    }

    public void addToCart(){
        click(cart_PageObjects.addToCart_btn(), "Add to Cart");
        isVisible(cart_PageObjects.itemAddedtoCart_msg(), getText(cart_PageObjects.itemAddedtoCart_msg()));
        click(cart_PageObjects.confirm_btn(), "Confirm");
    }

    public String getItemPrice(){
        return cart_PageObjects.itemPrice_p().getText();
    }
    public String getItemName(){
        return cart_PageObjects.itemName_p().getText();
    }

    


}
