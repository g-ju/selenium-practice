package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage
{
    protected final WebDriver driver;

    private final By acceptCookiesButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void acceptCookies()
    {
        driver.findElement(acceptCookiesButton).click();
    }
}
