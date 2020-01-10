package cloud_microservice.Controller;
import cloud_microservice.Model.Profile;
import cloud_microservice.Model.ProfileRequest;
import cloud_microservice.Model.Wallet;
import cloud_microservice.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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


    @RequestMapping(value = "/account/UpdateProfile",method = RequestMethod.POST)
    public String UpdateProfile(String jwttoken, @RequestBody ProfileRequest req){
        String c = Validator.Validate(jwttoken);
        if (c != "fail") {
            Profile p = profilerepository.findByEmail(c);
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

    @RequestMapping(value = "/account/getProfile")
    public Profile getProfile(String jwttoken){
        String c = Validator.Validate(jwttoken);
            Profile p = profilerepository.findByEmail(c);
            return p;
    }
}

