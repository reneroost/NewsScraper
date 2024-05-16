package ee.reneroost.newslist.postimeesee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PostimeesCookiesRejection {

    public static final String FIRST_BUTTON = "Halda valikuid";
    public static final String SECOND_BUTTON = "Kinnita valikud";

    public static void rejectCookies(WebDriver driver) {
        clickButton(driver, FIRST_BUTTON);
        clickButton(driver, SECOND_BUTTON);
    }

    private static void clickButton(WebDriver driver, String buttonName) {
        WebElement buttonTarget = findButtonByName(driver, buttonName);
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonTarget).click().perform();
    }

    private static WebElement findButtonByName(WebDriver driver, String buttonName) {
        WebElement buttonTarget = null;
        boolean foundButton = false;

        while (!foundButton) {
            List<WebElement> buttons = driver.findElements(By.className("fc-button"));
            for (WebElement button : buttons) {
                if (button.getText().equalsIgnoreCase(buttonName)) {
                    buttonTarget = button;
                    foundButton = true;
                }
            }
        }
        return buttonTarget;
    }
}
