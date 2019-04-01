import common.EndPoint;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class TestBase {

    RequestSpecification rspec;
    RequestSpecBuilder build;
    String name;
    String id;


    @BeforeTest
    public void requestSpec() {

        build = new RequestSpecBuilder();
        build.setBaseUri("http://petstore.swagger.io/v2/pet");
        build.setContentType(ContentType.JSON);
        rspec = build.build();

    }


    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }

    public String petId() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyMMddhhmmss");
        String petId = formatForDateNow.format(dateNow);
        return petId;
    }

    @Step("Проверка получения списка со статусом {status}")
    public void getPet(String status) {
        given()
                .spec(rspec)
                .pathParam("status", status)
                .when().get(EndPoint.GET_PET)
                .then().assertThat().time(lessThan(3000L));

    }

    @Step("Создание записи и получение id")
    public void generatePet() throws IOException {
        String jsonBody = generateStringFromResource(EndPoint.ADD_PET_JSON);
        id = given()
                .spec(rspec).body(jsonBody)
                .post(EndPoint.POST_PET).jsonPath().getString("id");

    }

    @Step("Поиск записи по id {id}")
    public void getPetWithId(String id) throws IOException {
        given()
                .spec(rspec)
                .pathParam("id", id)

                .when().get(EndPoint.GET_PET_BY_ID)
                .then().statusCode(200).assertThat()
                .time(lessThan(2000L));

    }


    @Step("Заполнение поля category")
    public Map<String, Object> getCategory(int categoryId, String categoryValues) {
        Map<String, Object> category = new HashMap<>();
        category.put("id", categoryId);
        category.put("name", categoryValues);
        return category;

    }


}
