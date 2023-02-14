import by.itacademy.moiseenkolydia.web.OnlinerPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OnlinerTest {
    @Test
    public void testOpenOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement COPYRIGHT_Element = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("© 2001—2023 Onlíner", COPYRIGHT_Element.getText());
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
        Assert.assertEquals( "Вход", FORM_TITLE_Element.getText());
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(OnlinerPage.LOGIN_ERROR)));
        WebElement LOGIN_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.LOGIN_ERROR));
        Assert.assertEquals("Укажите ник или e-mail", LOGIN_ERROR_Element.getText());
        WebElement PASSWORD_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", PASSWORD_ERROR_Element.getText());
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement LOGIN_NAME = driver.findElement(By.xpath(OnlinerPage.INPUT_LOGIN));
        LOGIN_NAME.sendKeys("test@test.com");
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        WebElement PASSWORD_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", PASSWORD_ERROR_Element.getText());
        driver.quit();
    }
}
