import by.itacademy.moiseenkolydia.web.OnlinerPage;
import by.itacademy.moiseenkolydia.web.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    WebDriver driver;

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {

        WebElement COPYRIGHT_Element = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("© 2001—2023 Onlíner", COPYRIGHT_Element.getText());
    }

    @Test
    public void testOpenOnlinerLoginForm() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement FORM_TITLE_Element = driver.findElement(By.xpath(OnlinerPage.FORM_TITLE));
        Assert.assertEquals("Вход", FORM_TITLE_Element.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        Util.waitFor(driver, 1, OnlinerPage.LOGIN_ERROR);
        WebElement LOGIN_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.LOGIN_ERROR));
        Assert.assertEquals("Укажите ник или e-mail", LOGIN_ERROR_Element.getText());
        WebElement PASSWORD_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", PASSWORD_ERROR_Element.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement LOGIN_NAME = driver.findElement(By.xpath(OnlinerPage.INPUT_LOGIN));
        LOGIN_NAME.sendKeys("test@test.com");
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        Util.waitFor(driver, 1, OnlinerPage.PASSWORD_ERROR);
        WebElement PASSWORD_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", PASSWORD_ERROR_Element.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyEmail() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement PASS = driver.findElement(By.xpath(OnlinerPage.INPUT_PASS));
        PASS.sendKeys("123456!");
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        Util.waitFor(driver, 1, OnlinerPage.LOGIN_ERROR);
        WebElement LOGIN_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.LOGIN_ERROR));
        Assert.assertEquals("Укажите ник или e-mail", LOGIN_ERROR_Element.getText());
    }

    @Test
    public void testOnlinerLoginFormWithWrongCredentials() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement LOGIN_NAME = driver.findElement(By.xpath(OnlinerPage.INPUT_LOGIN));
        LOGIN_NAME.sendKeys("test@test.com");
        WebElement PASS = driver.findElement(By.xpath(OnlinerPage.INPUT_PASS));
        PASS.sendKeys("123456!");
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        Util.waitFor(driver, 1, OnlinerPage.CREDS_ERROR);
        WebElement CREDS_ERROR_Element = driver.findElement(By.xpath(OnlinerPage.CREDS_ERROR));
        Assert.assertEquals("Неверный логин или пароль", CREDS_ERROR_Element.getText());
    }

    @Test
    public void testOnlinerLogin() {

        WebElement BTN_ENTER_Element = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
        BTN_ENTER_Element.click();
        WebElement LOGIN_NAME = driver.findElement(By.xpath(OnlinerPage.INPUT_LOGIN));
        LOGIN_NAME.sendKeys("rqyabkr173@tmail3.com");
        WebElement PASS = driver.findElement(By.xpath(OnlinerPage.INPUT_PASS));
        PASS.sendKeys("Qwerty!1");
        WebElement BTN_SUBMIT_Element = driver.findElement(By.xpath(OnlinerPage.BTN_SUBMIT));
        BTN_SUBMIT_Element.click();
        Util.waitFor(driver, 20, OnlinerPage.PROFILE);
        boolean PROFILE_Element = driver.findElement(By.xpath(OnlinerPage.PROFILE)).isDisplayed();
        Assert.assertTrue(PROFILE_Element);
        WebElement PROFILE_ICON = driver.findElement(By.xpath(OnlinerPage.PROFILE));
        PROFILE_ICON.click();
        WebElement OPEN_PROFILE = driver.findElement(By.xpath(OnlinerPage.OPEN_PROFILE));
        OPEN_PROFILE.click();
        Util.waitFor(driver, 5, OnlinerPage.PERSONAL_TAB);
        WebElement PROFILE_INFO = driver.findElement(By.xpath(OnlinerPage.PERSONAL_TAB));
        PROFILE_INFO.click();
        WebElement EMAIL_Element = driver.findElement(By.xpath(OnlinerPage.EMAIL));
        Assert.assertEquals("rqyabkr173@tmail3.com", EMAIL_Element.getText());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}