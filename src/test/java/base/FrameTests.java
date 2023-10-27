package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FramePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTests
{
    private ChromeDriver driver;
    private FramePage framePage;

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(FramePage.URL);

        framePage = new FramePage(driver);
        framePage.acceptCookies();
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }

    @Test
    void verify_enter_details()
    {
        String fname = "John";
        String lname = "Doe";
        String email = "test@test.com";

        framePage.enterFirstName(fname);
        framePage.enterLastName(lname);
        framePage.enterEmail(email);

        assertEquals(fname, framePage.getFirstName());
        assertEquals(lname, framePage.getLastName());
        assertEquals(email, framePage.getEmail());
    }
}
