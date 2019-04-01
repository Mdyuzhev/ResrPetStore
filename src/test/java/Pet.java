import java.util.ArrayList;
import java.util.Map;

public class Pet {
    int id;
    Map<String, Object> category;
    String name;
    ArrayList photoUrls;
    ArrayList tags;
    String status;


    public Pet() {

    }

    public Pet(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Pet(int id, Map<String, Object> category, String name, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getCategory() {
        return this.category;
    }

    public void setCategory(Map<String, Object> category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList getTags() {
        return tags;
    }

    public void setTags(ArrayList tags) {
        this.tags = tags;
    }

    public ArrayList getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList photoUrls) {
        this.photoUrls = photoUrls;
    }


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
