package cloud_microservice.Controller;

import cloud_microservice.Model.Profile;
import cloud_microservice.Model.Wallet;
import cloud_microservice.Repository.ProfileRepository;
import cloud_microservice.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    ProfileRepository profilerepository;

    @Autowired
    WalletRepository walletrepository;

    @RequestMapping(value = "/account/wallet")
    public int getWallet(String jwttoken){
        String c = Validator.Validate(jwttoken);
        Profile p = profilerepository.findByEmail(c);
        return walletrepository.findByProfile(p).getValue();
    }



}

