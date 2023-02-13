import by.itacademy.moiseenkolydia.web.AmazonPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonTest {
    @Test
    public void testOpenAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);

        WebElement COPYRIGHT_Element = driver.findElement(By.xpath(AmazonPage.COPYRIGHT));
        Assert.assertEquals(COPYRIGHT_Element.getText(), "© 1996-2023, Amazon.com, Inc. or its affiliates");
        driver.quit();
    }
    @Test
    public void testOpenAmazonCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);

        WebElement CART_Element = driver.findElement(By.xpath(AmazonPage.CART));
        CART_Element.click();
        WebElement EMPTY_CART_Element = driver.findElement(By.xpath(AmazonPage.EMPTY_CART));
        Assert.assertEquals(EMPTY_CART_Element.getText(), "Your Amazon Cart is empty");
        driver.quit();
    }
    @Test
    public void testOpenAmazonLoginForm() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);

        WebElement CART_Element = driver.findElement(By.xpath(AmazonPage.CART));
        CART_Element.click();

        WebElement BTN_LOGIN_Element = driver.findElement(By.xpath(AmazonPage.BTN_LOGIN));
        BTN_LOGIN_Element.click();
        WebElement FORM_TITLE_Element = driver.findElement(By.xpath(AmazonPage.FORM_TITLE));
        Assert.assertEquals(FORM_TITLE_Element.getText(), "Sign in");
        driver.quit();
    }
}
