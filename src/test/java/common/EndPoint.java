package common;

public interface EndPoint {
    /*
    Pet store
     */
    String GET_PET = "/findByStatus?status={status}";
    String GET_PET_BY_ID = "/{id}";
    String POST_PET = "http://petstore.swagger.io/v2/pet";
    String POST_PET_UPDATE = "http://petstore.swagger.io/v2/pet/";
    String DELETE_PET = "http://petstore.swagger.io/v2/pet/{id}";


    String UPDATE_PET_JSON = "C:/AutoTests/AllureRepo/src/test/resources/Post_new_pet.json";
    String ADD_PET_JSON = "C:/AutoTests/AllureRepo/src/test/resources/Post_new_pet.json";
    String DEL_PET_JSON = "C:/AutoTests/AllureRepo/src/test/resources/Delete_pet.json";



}
