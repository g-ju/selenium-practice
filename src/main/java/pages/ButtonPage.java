package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonPage extends BasePage
{
    public static final String URL = "https://letcode.in/buttons";

    private final By homePageButton = By.id("home");
    private final By positionButton = By.id("position");
    private final By colourButton = By.id("color");
    private final By sizeButton = By.id("property");
    private final By disabledButton = By.xpath("//button[@id='isDisabled' and @class='button is-info']");
    private final By holdButton = By.xpath("//button[@id='isDisabled' and @class='button is-primary']");

    public ButtonPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickHomePageButton()
    {
        driver.findElement(homePageButton).click();
    }

    public Point getPositionOfButton()
    {
        return driver.findElement(positionButton).getLocation();
    }

    public String getColourOfButton()
    {
        return driver.findElement(colourButton).getCssValue("color");
    }

    public Dimension getSizeOfButton()
    {
        return driver.findElement(sizeButton).getSize();
    }

    public boolean isButtonEnabled()
    {
        return driver.findElement(disabledButton).isEnabled();
    }

    public String getHoldButtonText()
    {
        return driver.findElement(holdButton).getText();
    }

    public void holdButtonAndWaitForNewText()
    {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(holdButton))
               .perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(holdButton, "Button has been long pressed"));
    }
}
