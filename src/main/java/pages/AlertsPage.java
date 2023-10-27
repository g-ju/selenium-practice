package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage
{
    public static final String URL = "https://letcode.in/alert";

    private final By simpleAlert = By.id("accept");
    private final By dismissAlert = By.id("confirm");
    private final By promptAlert = By.id("prompt");
    private final By modernAlert = By.id("modern");
    private final By modernAlertText = By.cssSelector("p.title");

    public AlertsPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickSimpleAlert()
    {
        driver.findElement(simpleAlert).click();
    }

    public void clickDismissAlert()
    {
        driver.findElement(dismissAlert).click();
    }

    public void clickPromptAlert()
    {
        driver.findElement(promptAlert).click();
    }

    public void clickModernAlert()
    {
        driver.findElement(modernAlert).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modernAlertText)));
    }

    public String getModernAlertText()
    {
        return driver.findElement(modernAlertText).getText();
    }

    public void enterNameInAlert(String name)
    {
        driver.switchTo()
              .alert()
              .sendKeys(name);
    }

    public String getAlertText()
    {
        return driver.switchTo()
                     .alert()
                     .getText();
    }

    public void acceptAlert()
    {
        driver.switchTo()
              .alert()
              .accept();
    }

    public void dismissAlert()
    {
        driver.switchTo()
              .alert()
              .dismiss();
    }

    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }

}
