package ee.reneroost.delfiee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static ee.reneroost.General.pauseSec;

public class DelfiCookiesReject {

    public static void rejectCookies(WebDriver driver, String... buttonNames) {
        for (String buttonName: buttonNames) {
            clickButton(driver, buttonName);
        }

//        List<WebElement> buttons = driver.findElements(By.className("button"));
//        for (WebElement button: buttons) {
//            System.out.println(button.getText() + " | " + button.getAttribute("id"));
//        }

//        boolean foundButton = false;
//        while (!foundButton) {
//            List<WebElement> koikDivid = driver.findElements(By.className("adform-adbox"));
//            for (WebElement div : koikDivid) {
//                if (div.getAttribute("id").equalsIgnoreCase("adf-close-button")) {
//                    System.out.println("Leidsin adf-close-button");
//                    foundButton = true;
//                }
//            }
//        }

//        WebElement adbox = driver.findElement(By.className("adform-adbox"));
//        List<WebElement> elements = adbox.findElements(By.tagName("div"));
//        for (WebElement element: elements) {
//            System.out.println(element.getAttribute("id"));
//        }

//        List<WebElement> htmlTags = driver.findElements(By.tagName("html"));
//        for (WebElement htmlTag: htmlTags) {
//            System.out.println(htmlTag.getAttribute("id"));
//        }

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0, 250)");


        //clickButtonById(driver, "adf-close-button");
    }


    public static void clickButton(WebDriver driver, String buttonName) {
        WebElement buttonTarget = findButtonByName(driver, buttonName);
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonTarget).click().perform();
    }

    public static void clickButtonById(WebDriver driver, String buttonId) {
        WebElement buttonTarget = findButtonById(driver, buttonId);
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonTarget).click().perform();
    }

    public static WebElement findButtonByName(WebDriver driver, String buttonName) {
        WebElement buttonTarget = null;
        boolean foundButton = false;

        while (!foundButton) {
            List<WebElement> buttons = driver.findElements(By.className("button__content"));
            for (WebElement button : buttons) {
                if (button.getText().equalsIgnoreCase(buttonName)) {
                    buttonTarget = button;
                    foundButton = true;
//                    System.out.println("Leidsin nupu: " + buttonName);
                }
            }
        }
        return buttonTarget;
    }

    public static WebElement findButtonById(WebDriver driver, String buttonId) {
        pauseSec(1);
        System.out.println("Enne adf-close-button");
        WebElement button = driver.findElement(By.id("adf-close-button"));
        System.out.println("Parast adf-close-button");
        return button;
    }
}
