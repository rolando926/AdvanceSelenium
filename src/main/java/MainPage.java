import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by RXC8414 on 2/21/2017.
 */
public class MainPage extends SeleniumUtils {

    By headerSearch = By.xpath(".//input[@id='headerSearch']");
    By headerSearchButton = By.xpath(".//button[@id='headerSearchButton']");

    public boolean verifyCanSearchByItem(String item){
        if(addStringToTextBox(item,headerSearch)){
            if(clickButton(headerSearchButton)){
                return true;
            }
        }
        return false;
    }
}
