package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DropdownPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTests
{
    private ChromeDriver driver;
    private DropdownPage dropdownPage;

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(DropdownPage.URL);

        dropdownPage = new DropdownPage(driver);
        dropdownPage.acceptCookies();
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Mango", "Orange", "Banana", "Pine Apple"})
    void can_select_fruits(String fruit)
    {
        dropdownPage.selectFruit(fruit);
        assertEquals(fruit, dropdownPage.getSelectedFruit());
    }

    @Test
    void can_select_hero()
    {
        dropdownPage.selectHero("Thor");
        assertEquals("You have selected Thor", dropdownPage.getNotificationText());
    }

    @Test
    void can_select_multiple_heroes()
    {
        dropdownPage.selectHero("Thor");
        dropdownPage.selectHero("Wonder Woman");

        // Only displays the first one alphabetically it looks like
        assertEquals("You have selected Thor", dropdownPage.getNotificationText());
        assertThat(dropdownPage.getSelectedHeroes(), contains("Thor", "Wonder Woman"));
    }

    @Test
    void can_select_by_index()
    {
        dropdownPage.selectLanguageByIndex(dropdownPage.getAllLanguages().size() - 1);

        assertEquals("C#", dropdownPage.getSelectedLanguage());
        assertEquals("You have selected C#", dropdownPage.getNotificationText());
    }

    @Test
    void correct_language_options_present()
    {
        assertThat(dropdownPage.getAllLanguages(), contains("JavaScript", "Java", "Python", "Swift", "C#"));
    }

    @Test
    void can_select_country_by_value()
    {
        dropdownPage.selectCountryByValue("India");

        assertEquals("India", dropdownPage.getSelectedCountry());
    }
}
