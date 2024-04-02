package ee.reneroost.delfiee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static ee.reneroost.Util.pauseSec;

public class DelfiCookiesReject {

    public static final String FIRST_BUTTON = "PRIVAATSUSSÄTTED";
    public static final String SECOND_BUTTON = "SALVESTA JA VÄLJU";

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
            List<WebElement> buttons = driver.findElements(By.className("button__content"));
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
