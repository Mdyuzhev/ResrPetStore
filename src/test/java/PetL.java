import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
public class PetL {
    int id;
    Map<String, Object> category;
    String name;
    ArrayList photoUrls;
    ArrayList tags;
    String status;


    public PetL() {

    }

    public PetL(int id, Map<String, Object> category, String name, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;
    }
}
