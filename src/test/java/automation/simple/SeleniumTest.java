package automation.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseWebTest;


public class SeleniumTest extends BaseWebTest {

    @Test
    public void loginTestSuccess() {

        driver.get().findElement(By.id("username")).sendKeys("tomsmith");
        driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.get().findElement(By.xpath("//button[@class='radius']")).click();

        String txtActualBerhasilLogin = driver.get().findElement(By.xpath("//h2[contains(.,'Secure Area')]")).getText();
        String txtExpectedBerhasilLogin = "Secure Area";

        Assert.assertEquals(txtActualBerhasilLogin, txtExpectedBerhasilLogin);

    }

    @Test
    public void loginTestFailed() {

        driver.get().findElement(By.id("username")).sendKeys("tomsmith");
        driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.get().findElement(By.xpath("//button[@class='radius']")).click();


        String txtErrorFailedPassActual = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
        String txtErrorFailedPassExpected = "Your password is invalid!";

        Assert.assertTrue(txtErrorFailedPassActual.contains("Your password is invalid!"));

    }
}


