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

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement BTN_SUBMIT = driver.findElement(By.xpath("//div[@id='auth-container']//button[@type='submit']"));
        BTN_SUBMIT.click();
        //тут падает тест
        WebElement nickname = driver.findElement(By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div"));
        Assert.assertEquals(nickname.getText(), "Укажите ник или e-mail");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div"));
        Assert.assertEquals(password.getText(), "Укажите пароль");
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement LOGIN_NAME = driver.findElement(By.xpath("//input[@placeholder=\"Ник или e-mail\"]"));
        LOGIN_NAME.sendKeys("test@test.com");
        WebElement BTN_SUBMIT = driver.findElement(By.xpath("//div[@id='auth-container']//button[@type='submit']"));
        BTN_SUBMIT.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div"));
        Assert.assertEquals(password.getText(), "Укажите пароль");

        driver.quit();
    }
}
