package cloud_microservice.Controller;

public class Mapper {
    private String message;
    private String token;

    public Mapper(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public Mapper() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
