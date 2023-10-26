package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InputPage;

import static org.junit.jupiter.api.Assertions.*;

public class InputTests
{
    private ChromeDriver driver;
    private InputPage inputPage;

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(InputPage.URL);

        inputPage = new InputPage(driver);
        inputPage.acceptCookies();
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }

    @Test
    void can_enter_full_name()
    {
        String name = "John Doe";

        inputPage.enterName(name);
        assertEquals(name, inputPage.getName());
    }

    @Test
    void can_append_text_and_verify_focus_in_next_field()
    {
        final String initialText = "I am good";
        String text = "test";

        inputPage.appendTextAndPressTab(text);
        assertEquals(initialText + text, inputPage.getTextFromAppendedField());
        assertEquals(driver.switchTo().activeElement(), inputPage.getTextFieldElement());
    }

    @Test
    void verify_text_field_text()
    {
        assertEquals("ortonikc", inputPage.getTextFieldText());
    }

    @Test
    void can_clear_text_field()
    {
        assertFalse(inputPage.getClearTextFieldText().isEmpty());

        inputPage.clearTextField();

        assertTrue(inputPage.getClearTextFieldText().isEmpty());
    }

    @Test
    void verify_edit_field_is_not_enabled()
    {
        assertFalse(inputPage.isEditFieldEnabled());
    }

    @Test
    void verify_read_only_field_is_read_only()
    {
        assertTrue(inputPage.isReadOnlyFieldReadOnly());
    }
}
