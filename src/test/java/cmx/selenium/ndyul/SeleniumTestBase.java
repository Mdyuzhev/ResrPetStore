package cmx.selenium.ndyul;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class SeleniumTestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
    }
    @Step("Перейти по ссылке Home page")
    public void goToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }
    @Step("Подтвердить создание контакта")
    public void submitContactCreate() {
        driver.findElement(By.xpath("(.//input[@name='submit'])")).click();
    }
    @Step("Заполнить поля firstname {firstname}, middlename {middlename}, lastname {lastname}," +
            " nickname {nickname}, title {title}, company {company}, address {address}, home {home}, mobile {mobile}, work {work}, fax {fax}")
    public void fillContactForm(String testname, String testmiddle, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(testname);
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(testmiddle);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(nickname);
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(home);
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(work);
        driver.findElement(By.name("fax")).clear();
        driver.findElement(By.name("fax")).sendKeys(fax);

    }

    @Step("Перейти по ссылке создания нового контакта")

    public void addContact() {
        driver.findElement(By.linkText("add new")).click();
    }

    @Step("Ввод логина {login} и пароля {password}")
    public void login(String login, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(login);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath(".//input[@value='Login']")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
