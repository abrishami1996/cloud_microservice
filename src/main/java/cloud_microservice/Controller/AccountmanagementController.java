package cloud_microservice.Controller;
import cloud_microservice.Model.Profile;
import cloud_microservice.Model.ProfileRequest;
import cloud_microservice.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountmanagementController {

    @Autowired
    ProfileRepository profilerepository;

    @RequestMapping(value = "/account/HeartBeat", method = RequestMethod.GET)
    public String HeartBeat() {

        return "Account Management is up and running!";

    }

//    @Value("localhost:")
//    private String AuthService;

    @RequestMapping(value = "/account/CreateProfile", method = RequestMethod.POST)
    private String Createprofile(@RequestBody ProfileRequest req) {
        String url = "This must be the docker container address";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("email", req.getEmail());
        map.put("password", req.getPassword());
        ResponseEntity<Mapper> response = restTemplate.postForEntity(url, map, Mapper.class);
        HttpStatus statusCode = response.getStatusCode();
        String token = response.getBody().getToken();
        // check response
        if (statusCode.value() == 201) {
            Profile profile = new Profile(req.getEmail(), req.getName(), req.getPhoneNo(), req.getNationalCode(), req.getAddress(), req.getPostalCode());
            profilerepository.save(profile);
            return token;
        } else if (statusCode.value() == 400) {
            return ("Invalid Parameters");
        } else {
            return "Email Already Exists!";
        }

    }

    private Boolean Validator(String jwttoken) {
        final String uri = ".../authentiq/v1/validate/token";
        System.out.println(jwttoken);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwttoken);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        entity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        HttpStatus statusCode = ((ResponseEntity<String>) entity).getStatusCode();
        if (statusCode.value() == 200) {
            return true;
        }
        return false;

    }

    @RequestMapping(value = "/account/UpdateProfile",method = RequestMethod.POST)
    public String UpdateProfile(String jwttoken, @RequestBody ProfileRequest req){
        if (Validator(jwttoken)) {
            Profile p = profilerepository.findByEmail(req.getEmail());
            if ( p!= null) {
                p.setName(req.getName());
                p.setAddress(req.getAddress());
                p.setNationalCode(req.getNationalCode());
                p.setPhoneNo(req.getPhoneNo());
                p.setPostalCode(req.getPostalCode());
                profilerepository.save(p);
                return "ok";
            }
            return "Not Found";
        }
        return "not authenticated";

    }
}

