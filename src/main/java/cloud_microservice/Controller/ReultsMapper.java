package cloud_microservice.Controller;

public class ReultsMapper {
    String Authority;

    public ReultsMapper(String authority) {
        Authority = authority;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}
