package server;

public class SharedObject {

    private String data;

    public SharedObject() {
        this.data = "Prueba";
    }

    public void update(String newData) {
        this.data = newData;
    }

    public String getData() {
        return data;
    }
}