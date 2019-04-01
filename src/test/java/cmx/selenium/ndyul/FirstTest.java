package cmx.selenium.ndyul;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class FirstTest extends SeleniumTestBase{




    @Test(description = "Создание нового контакта")
    public void testUntitledTestCase() throws Exception {


        login("admin", "secret");

        addContact();
        fillContactForm("testname", "testmiddle", "lastname", "nickname", "title", "company", "address", "8999", "8888", "8777", "8555");

        saveAllureScreenshot();
        submitContactCreate();
        goToHomePage();
    }

}
