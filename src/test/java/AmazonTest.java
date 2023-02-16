import by.itacademy.moiseenkolydia.web.AmazonPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonTest {
    WebDriver driver;
    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
    }
    @Test
    public void testOpenAmazon() {

        WebElement COPYRIGHT_Element = driver.findElement(By.xpath(AmazonPage.COPYRIGHT));
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates", COPYRIGHT_Element.getText());
    }
    @Test
    public void testOpenAmazonCart() {

        WebElement CART_Element = driver.findElement(By.xpath(AmazonPage.CART));
        CART_Element.click();
        WebElement EMPTY_CART_Element = driver.findElement(By.xpath(AmazonPage.EMPTY_CART));
        Assert.assertEquals("Your Amazon Cart is empty", EMPTY_CART_Element.getText());
    }
    @Test
    public void testOpenAmazonLoginForm() {

        WebElement CART_Element = driver.findElement(By.xpath(AmazonPage.CART));
        CART_Element.click();
        WebElement BTN_LOGIN_Element = driver.findElement(By.xpath(AmazonPage.BTN_LOGIN));
        BTN_LOGIN_Element.click();
        WebElement FORM_TITLE_Element = driver.findElement(By.xpath(AmazonPage.FORM_TITLE));
        Assert.assertEquals("Sign in", FORM_TITLE_Element.getText());
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {

        WebElement CART_Element = driver.findElement(By.xpath(AmazonPage.CART));
        CART_Element.click();
        WebElement BTN_LOGIN_Element = driver.findElement(By.xpath(AmazonPage.BTN_LOGIN));
        BTN_LOGIN_Element.click();
        WebElement BTN_LOGIN_CONTINUE_Element = driver.findElement(By.xpath(AmazonPage.BTN_CONTINUE));
        BTN_LOGIN_CONTINUE_Element.click();
        Assert.assertEquals("Enter your email or mobile phone number",
                driver.findElement(By.xpath("//*[@id='auth-email-missing-alert']")).getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}