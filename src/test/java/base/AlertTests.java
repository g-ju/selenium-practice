package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AlertsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlertTests
{
    private ChromeDriver driver;
    private AlertsPage alertsPage;

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(AlertsPage.URL);

        alertsPage = new AlertsPage(driver);
        alertsPage.acceptCookies();
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }

    @Test
    void verify_simple_alert()
    {
        alertsPage.clickSimpleAlert();

        assertEquals("Hey! Welcome to LetCode", alertsPage.getAlertText());

        alertsPage.acceptAlert();

        assertFalse(alertsPage.isAlertPresent());
    }

    @Test
    void verify_dismiss_alert()
    {
        alertsPage.clickDismissAlert();

        assertEquals("Are you happy with LetCode?", alertsPage.getAlertText());

        alertsPage.dismissAlert();
        assertFalse(alertsPage.isAlertPresent());
    }

    @Test
    void can_enter_name_in_alert()
    {
        alertsPage.clickPromptAlert();
        alertsPage.enterNameInAlert("John Doe");
        alertsPage.acceptAlert();
        assertFalse(alertsPage.isAlertPresent());
    }

    @Test
    void verify_modern_alert()
    {
        alertsPage.clickModernAlert();

        assertEquals("Modern Alert - Some people address me as sweet alert as well", alertsPage.getModernAlertText());
    }
}
