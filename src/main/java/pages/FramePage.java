package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage
{
    public static final String URL = "https://letcode.in/frame";

    private final By firstNameField = By.name("fname");
    private final By lastNameField = By.name("lname");
    private final By innerFrame = By.cssSelector("iframe[src='innerFrame']");
    private final By emailField = By.name("email");

    public FramePage(WebDriver driver)
    {
        super(driver);
    }

    private void switchToFirstFrame()
    {
        driver.switchTo().frame("firstFr");
    }

    private void switchToInnerFrame()
    {
        switchToFirstFrame();
        driver.switchTo().frame(driver.findElement(innerFrame));
    }

    public void enterFirstName(String fname)
    {
        switchToFirstFrame();
        driver.findElement(firstNameField).sendKeys(fname);
        driver.switchTo().defaultContent();
    }

    public String getFirstName()
    {
        switchToFirstFrame();
        String fname = driver.findElement(firstNameField).getAttribute("value");
        driver.switchTo().defaultContent();

        return fname;
    }

    public void enterLastName(String lname)
    {
        switchToFirstFrame();
        driver.findElement(lastNameField).sendKeys(lname);
        driver.switchTo().defaultContent();
    }

    public String getLastName()
    {
        switchToFirstFrame();
        String lname = driver.findElement(lastNameField).getAttribute("value");
        driver.switchTo().defaultContent();

        return lname;
    }

    public void enterEmail(String email)
    {
        switchToInnerFrame();
        driver.findElement(emailField).sendKeys(email);
        driver.switchTo().defaultContent();
    }

    public String getEmail()
    {
        switchToInnerFrame();
        String email = driver.findElement(emailField).getAttribute("value");
        driver.switchTo().defaultContent();

        return email;
    }
}
