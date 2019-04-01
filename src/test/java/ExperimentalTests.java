import common.EndPoint;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
}
