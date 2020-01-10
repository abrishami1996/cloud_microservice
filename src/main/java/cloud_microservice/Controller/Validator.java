package cloud_microservice.Controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Validator {

    public static String Validate(String jwttoken) {
        final String uri = ".../authentiq/v1/validate/token";
        System.out.println(jwttoken);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwttoken);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ValidateMapper> entity = null;
        entity = restTemplate.exchange(uri, HttpMethod.GET, entity, ValidateMapper.class);
        HttpStatus statusCode = ((ResponseEntity<ValidateMapper>) entity).getStatusCode();
        if (statusCode.value() == 200) {
            return entity.getBody().getEmail();
        }
        return "fail";

    }
}
