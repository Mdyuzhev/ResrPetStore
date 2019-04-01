import Kotlin.PetKt
import common.EndPoint
import io.restassured.RestAssured.given
import org.hamcrest.Matchers.equalTo
import org.testng.annotations.Test
import ru.yandex.qatools.allure.annotations.Title

class PetKt : TestBase() {

    @Title("Обновление записи из файла с использованием Kotlin")
    @Test(description = "Обновление записи из файла")
    fun postPetKotlin() {
        val newPetK = PetKt(777333, getCategory(456, "Kotlin-psina"),
                "Testovoe-zhivotnoe-Kotlin", "pending")


        given()
                .spec(rspec).body(newPetK)
                .post(EndPoint.POST_PET)
                .then().statusCode(200)
                .assertThat().body("name", equalTo(newPetK.name))
                .log().all()
    }

}

