package cloud_microservice.Controller;
import cloud_microservice.Model.Profile;
import cloud_microservice.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AccountmanagementController {

    @Autowired
    ProfileRepository profilerepository;

    @RequestMapping(value = "/account/HeartBeat",method = RequestMethod.GET)
    public String HeartBeat() {

        return "Account Management is up and running!";

    }

    @Value("localhost:")
    private String AuthService;


    @RequestMapping(value = "/account/CreateProfile",method = RequestMethod.POST)
    private String Createprofile(@RequestBody Profile req){
        Profile profile = new Profile(req.getEmail(), req.getName(),req.getPhoneNo(),req.getNationalCode(),req.getAddress(),req.getPostalCode());
        profilerepository.save(profile);
        return "Success!";

    }
}
