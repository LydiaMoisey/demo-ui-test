import by.itacademy.moiseenkolydia.web.OnlinerPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
        @Test
        public void testOpenOnliner() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(OnlinerPage.URL);

            WebElement COPYRIGHT_Element = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
            //COPYRIGHT_Element.getText();

            Assert.assertEquals(COPYRIGHT_Element.getText(), "© 2001—2023 Onlíner");
            driver.quit();
        }
        @Test
        public void testOpenOnlinerLoginForm() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(OnlinerPage.URL);

            WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
            BTN_ENTER_Element.click();
            WebElement FORM_TITLE_Element = driver.findElement(By.xpath(OnlinerPage.FORM_TITLE));
            Assert.assertEquals(FORM_TITLE_Element.getText(), "Вход");
            driver.quit();
        }
}
