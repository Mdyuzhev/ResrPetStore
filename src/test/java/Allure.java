import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Allure {


    @Test
    public void simpleTest2() {
        checkSubtractionStep(3, 2, 5);
        checkSubtractionStep(5, 4, 9);
    }

    @Step("Проверка сложения числа {num1} и числа {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {

        Assert.assertTrue(num1 + num2 == expectedResult, "Результат сложения соответствует ожидаемому значению");
    }

    @Test
    public void simpleTest4() throws IOException {
        String darkSouls = "Dark souls 3";
        checkStringEqualsStep(darkSouls, darkSouls);
    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources/", resourceName));
    }

    @Step("Проверка эквивалентности строки {str1} строке {str2}")
    public static void checkStringEqualsStep(String str1, String str2) throws IOException {
        Assert.assertTrue(str1.equals(str2),"Строки не эквивалентны");
        getBytes("photo.jpg");
        getBytes("text.txt");
    }

}


