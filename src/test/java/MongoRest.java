import common.EndPoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MongoRest extends TestBase {


    @Test
    public void testPojo() {


        Pet newPet = new Pet(888777888, getCategory(423, "pets"), "Testovoe-zhivotnoe", "pending");

        Pet myNewPet = given()
                .spec(rspec).body(newPet)
                .put(EndPoint.POST_PET_UPDATE)
                .then().statusCode(200).extract().body().as(Pet.class);
        System.out.println(myNewPet.toString());
    }


    @Test
    public void testPojo1() {

        /*Pet myNewPet = */
        String myNewPet = given()
                .spec(rspec)
                .pathParam("status", "available")
                .when().get(EndPoint.GET_PET)/*.as(Pet.class)*/.path("[0]").toString();
        ;
        System.out.println(myNewPet.toString());
    }


    /*@Test
    public void testPojo2() {

        List list = given()
                .spec(rspec)
                .pathParam("status", "pending")
                .when().get(EndPoint.GET_PET)
                .then().path("[0]").as((Type) Pet.class);
        list.stream().forEach(element -> System.out.println("Pet's name is " + element));

    }*/

    @Test
    public void testJsonPath() {


        Pet myNewPet =  given()
                .spec(rspec)
                .pathParam("status", "available")
                .when().get(EndPoint.GET_PET).then().extract().body().as(Pet.class);


        System.out.println(myNewPet.toString());

        //list.stream().forEach(element -> System.out.println("Pet's name is " + element));

    }


}
