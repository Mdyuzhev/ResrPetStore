import common.EndPoint;
import io.qameta.allure.*;
import org.json.JSONObject;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Epic("Tests for REST")
@Feature("Petstore")
public class AllureApi extends TestBase{


    @Test(priority = 0, description = "Получение всех записей с определенным статусом")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.BLOCKER)
    public void testGetPet() {
        getPet("sold");
        getPet("pending");
        getPet("available");

    }


    @Test(description = "Создание новой записи и олучение информации по питомцу по его id")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.BLOCKER)
    public void testGetPetById200() throws IOException {
        generatePet();
        getPetWithId(id);
    }


    @Test(description = "Выбор питомца из списка питомцев со статусом pending и получение детальной информации по id")
    public void testDoubleRest() {
        id = given()
                .spec(rspec)
                .pathParam("status", "pending")
                .when().get(EndPoint.GET_PET)
                .path("[0].id").toString();
        given()
                .spec(rspec)
                .pathParam("id", id)
                .when().get(EndPoint.GET_PET_BY_ID)
                .then().statusCode(200).assertThat()
                .body("name", equalTo("doggieUpdated"));


    }

    @Title("Создание записи из файла")
    @Test(description = "Создание записи из файла")
    public void testPostPetWithFile() throws IOException {
        String jsonBody = generateStringFromResource(EndPoint.ADD_PET_JSON);

        given()
                .spec(rspec).body(jsonBody)
                .post(EndPoint.POST_PET)
                .then().statusCode(200)
                .assertThat().body("name", equalTo("Test-sobachka-second"))
                .log().all();

    }

    @Title("Обновление записи из файла")
    @Test(description = "Обновление записи из файла")
    public void testUpdatePetWithFile() throws IOException {
        String jsonBody = generateStringFromResource(EndPoint.UPDATE_PET_JSON);

        given()
                .spec(rspec).body(jsonBody)
                .put(EndPoint.POST_PET_UPDATE)
                .then().statusCode(200)
                .assertThat().body("name", equalTo("Update-sobachka"))
                .log().all();

    }

    @Title("Обновление записи из файла")
    @Test(description = "Обновление записи из файла")
    public void testPojo() throws IOException {


        Pet newPet = new Pet(888777888, getCategory(423, "pets"),  "Testovoe-zhivotno", "pending");

        given()
                .spec(rspec).body(newPet)
                .put(EndPoint.POST_PET_UPDATE)
                .then().statusCode(200)
                .assertThat().body("name", equalTo(newPet.name))
                .log().all();
    }

    @Title("Удаление записи")
    @Test(description = "Удаление записи")
    public void testDeletePetWithFile() throws IOException {
        String jsonBody = generateStringFromResource(EndPoint.ADD_PET_JSON);
        id = given()
                .spec(rspec).body(jsonBody)
                .post(EndPoint.POST_PET).jsonPath().getString("id");

        given()
                .spec(rspec).pathParam("id", id)
                .delete(EndPoint.DELETE_PET)
                .then().statusCode(200)
                .log().all();

    }

    @Title("Добавление записи без файла примера")
    @Test(description = "Добавление записи без файла примера")
    public void testPostPet() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", petId());
        requestBody.put("name", "Bobert-test1");
        requestBody.put("status", "available");

        given()
                .spec(rspec).body(requestBody.toString())
                .post(EndPoint.POST_PET)
                .then().statusCode(200)
                .assertThat().body("name", equalTo("Bobert-test1"))
                .log().all();

    }

    @Title("Добавление записи без файла примера")
    @Test(description = "Добавление записи без файла примера")
    public void testJsonPath() {


        List list = (List) given()
                .spec(rspec)
                .pathParam("status", "available")
                .when().get(EndPoint.GET_PET).jsonPath().getList("name");

        list.stream().forEach(element -> System.out.println("Pet's name is " + element));

    }


}
