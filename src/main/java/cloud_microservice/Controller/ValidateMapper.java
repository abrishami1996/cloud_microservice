package cloud_microservice.Controller;

public class ValidateMapper {
    private String email;
    private String token;

    public ValidateMapper(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public ValidateMapper() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
