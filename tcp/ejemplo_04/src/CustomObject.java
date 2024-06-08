import java.io.Serializable;

public class CustomObject implements Serializable {
    private int id;
    private String name;

    public CustomObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}