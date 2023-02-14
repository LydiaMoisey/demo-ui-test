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
    public void testOnlinerLoginFormWithEmptyCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        //тут падает тест
        WebElement nickname = driver.findElement(By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div"));
        Assert.assertEquals("Укажите ник или e-mail", nickname.getText());
        WebElement password = driver.findElement(By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[2]/div/div"));
        Assert.assertEquals("Укажите пароль", password.getText());
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
        WebElement password = driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div"));
        Assert.assertEquals("Укажите пароль", password.getText());
        driver.quit();
    }
}
