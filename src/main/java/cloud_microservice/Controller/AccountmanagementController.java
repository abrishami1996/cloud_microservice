package cloud_microservice.Controller;
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

    @RequestMapping(value = "/account/HeartBeat",method = RequestMethod.GET)
    public String HeartBeat() {

        return "Account Management is up and running!";

    }
}
