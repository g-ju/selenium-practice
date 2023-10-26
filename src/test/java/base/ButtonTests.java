package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ButtonPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ButtonTests
{
    private ChromeDriver driver;
    private ButtonPage buttonPage;

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(ButtonPage.URL);

        buttonPage = new ButtonPage(driver);
        buttonPage.acceptCookies();
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }

    @Test
    void can_go_to_home_page_and_back()
    {
        String homeURL = "https://letcode.in/";
        assertEquals(ButtonPage.URL, driver.getCurrentUrl());

        buttonPage.clickHomePageButton();
        assertEquals(homeURL, driver.getCurrentUrl());

        buttonPage.goBack();
        assertEquals(ButtonPage.URL, driver.getCurrentUrl());
    }

    @Test
    void verify_position_of_button()
    {
        Point position = buttonPage.getPositionOfButton();
        assertEquals(48, position.getX());
        assertEquals(329, position.getY());
    }

    @Test
    void verify_colour_of_button()
    {
        assertEquals("rgba(255, 255, 255, 1)", buttonPage.getColourOfButton());
    }

    @Test
    void verify_size_of_button()
    {
        Dimension size = buttonPage.getSizeOfButton();
        assertEquals(40, size.getHeight());
        assertEquals(176, size.getWidth());
    }

    @Test
    void verify_button_is_disabled()
    {
        assertFalse(buttonPage.isButtonEnabled());
    }

    @Test
    void holding_button_changes_text()
    {
        assertEquals("Button Hold!", buttonPage.getHoldButtonText());

        buttonPage.holdButtonAndWaitForNewText();

        assertEquals("Button has been long pressed", buttonPage.getHoldButtonText());
    }
}
