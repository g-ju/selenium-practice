package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputPage extends BasePage
{
    public static final String URL = "https://letcode.in/edit";

    private final By nameField = By.id("fullName");
    private final By appendField = By.id("join");
    private final By textField = By.id("getMe");
    private final By clearTextField = By.id("clearMe");
    private final By editField = By.id("noEdit");
    private final By readOnlyField = By.id("dontwrite");

    public InputPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterName(String name)
    {
        driver.findElement(nameField).sendKeys(name);
    }

    public String getName()
    {
        return driver.findElement(nameField).getAttribute("value");
    }

    public void appendTextAndPressTab(String text)
    {
        driver.findElement(appendField).sendKeys(text + Keys.TAB);
    }

    public String getTextFromAppendedField()
    {
        return driver.findElement(appendField).getAttribute("value");
    }

    public WebElement getTextFieldElement()
    {
        return driver.findElement(textField);
    }

    public String getTextFieldText()
    {
        return driver.findElement(textField).getAttribute("value");
    }

    public void clearTextField()
    {
        driver.findElement(clearTextField).clear();
    }

    public String getClearTextFieldText()
    {
        return driver.findElement(clearTextField).getAttribute("value");
    }

    public boolean isEditFieldEnabled()
    {
        return driver.findElement(editField).isEnabled();
    }

    public boolean isReadOnlyFieldReadOnly()
    {
        return driver.findElement(readOnlyField)
                     .getAttribute("readonly")
                     .equals("true");
    }
}
