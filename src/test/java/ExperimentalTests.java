import Kotlin.PetKt;
import common.EndPoint;
import lombok.val;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static sun.misc.Version.println;

public class ExperimentalTests extends TestBase {
    @Title("Обновление записи из файла с использованием Lombok")
    @Test(description = "Обновление записи из файла")
    public void testPojoL() {


        PetL newPetL = new PetL(888777888, getCategory(423, "pets"),  "Testovoe-zhivotno", "pending");

        given()
                .spec(rspec).body(newPetL)
                .post(EndPoint.POST_PET)
                .then().statusCode(200)
                .assertThat().body("name", equalTo(newPetL.name))
                .log().all();
    }


    @Title("Обновление записи из файла с использованием Lombok")
    @Test(description = "Обновление записи из файла")
    public void testPojoK() {

        val newPetK = new PetKt(777333, getCategory(456, "Kotlin-psina"),
                "Testovoe-zhivotnoe-Kotlin", "pending");



        given()
                .spec(rspec).body(newPetK)
                .post(EndPoint.POST_PET)
                .then().statusCode(200)
                .assertThat().body("name", equalTo(newPetK.getName()))
                .log().all();
    }


}
