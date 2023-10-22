package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseurl="https://www.saucedemo.com";

    @Given("Halaman login saucedemo")
    public void halaman_login_saucedemo() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        throw new io.cucumber.java.PendingException();
    }

    @When("Input standar user")
    public void inputStandarUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input valid password")
    public void inputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        String dashboardPageAssert = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
        driver.close();
    }

    @When("Input invalid username")
    public void inputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user00");
    }

    @Then("User get error login message")
    public void userGetErrorLoginMessage() {
        String errorLogin = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce00");
    }

    @When("Input locked out user")
    public void inputLockedOutUser() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("User get locked error message")
    public void userGetLockedErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Sorry, this user has been locked out.");
    }
}
