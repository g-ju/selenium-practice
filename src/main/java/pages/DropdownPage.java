package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage
{
    public static final String URL = "https://letcode.in/dropdowns";

    private final By fruitSelector = By.id("fruits");
    private final By heroSelector = By.id("superheros");
    private final By selectionNotification = By.cssSelector(".notification.is-success");
    private final By langSelector = By.id("lang");
    private final By countrySelector = By.id("country");

    public DropdownPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectFruit(String fruit)
    {
        Select select = new Select(driver.findElement(fruitSelector));
        select.selectByVisibleText(fruit);
    }

    public String getSelectedFruit()
    {
        Select select = new Select(driver.findElement(fruitSelector));
        return select.getFirstSelectedOption().getText();
    }

    public void selectHero(String hero)
    {
        Select select = new Select(driver.findElement(heroSelector));
        select.selectByVisibleText(hero);

        waitForNotification();
    }

    private void waitForNotification()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectionNotification)));
    }

    public String getNotificationText()
    {
        return driver.findElement(selectionNotification).getText();
    }

    public List<String> getSelectedHeroes()
    {
        Select select = new Select(driver.findElement(heroSelector));
        return select.getAllSelectedOptions()
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public void selectLanguageByIndex(int index)
    {
        Select select = new Select(driver.findElement(langSelector));
        select.selectByIndex(index);
    }

    public String getSelectedLanguage()
    {
        Select select = new Select(driver.findElement(langSelector));
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getAllLanguages()
    {
        Select select = new Select(driver.findElement(langSelector));
        return select.getOptions()
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public void selectCountryByValue(String value)
    {
        Select select = new Select(driver.findElement(countrySelector));
        select.selectByValue(value);
    }

    public String getSelectedCountry()
    {
        Select select = new Select(driver.findElement(countrySelector));
        // Just using this for the sake of the exercise
        return select.getFirstSelectedOption().getAttribute("value");
    }
}
