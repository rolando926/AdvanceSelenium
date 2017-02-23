import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by RXC8414 on 2/21/2017.
 */
public class LandingPage extends MainPage{
    By landingHammer = By.xpath(".//a[@class='list__link breadcrumb__link' and contains(text(),'hammer')]");
    By itemWrapper = By.xpath(".//div[@class='price']/parent::div[@class='price__wrapper']/parent::div[@class='pod-inner']");
    By itemPrice = By.xpath(".//div[@class='price']");
    By addToCart = By.xpath(".//span[@class='bttn__content' and text()='Add To Cart']");

    public boolean verifyLandPageHammer(){
        if(verifyLandingPage(landingHammer)){
            return true;
        }
        return false;
    }

    public boolean verifyCanSelectItem(){
        if(waitUntilElementDisplayed(itemWrapper)){
            for (WebElement element:getElements(itemWrapper)) {
                String price = element.findElement(itemPrice).getText();
                int intPrice = Integer.parseInt(price.substring(1,price.length()-2));
                if(intPrice > 10 && intPrice < 15){
                    element.findElement(addToCart).click();
                    return true;
                }
            }
        }
        return false;
    }
}
