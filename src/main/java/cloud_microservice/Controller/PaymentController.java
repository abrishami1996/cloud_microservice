package cloud_microservice.Controller;

import cloud_microservice.Model.Profile;
import cloud_microservice.Model.Transaction;
import cloud_microservice.Model.Wallet;
import cloud_microservice.Repository.ProfileRepository;
import cloud_microservice.Repository.TransactionRepository;
import cloud_microservice.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    ProfileRepository profilerepository;

    @Autowired
    WalletRepository walletrepository;

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(value = "/account/wallet")
    public int getWallet(String jwttoken){
        String c = Validator.Validate(jwttoken);
        Profile p = profilerepository.findByEmail(c);
        return walletrepository.findByProfile(p).getValue();
    }

    @RequestMapping(value = "/account/transaction")
    public List<Transaction> getTransactions(String jwttoken){
        String c = Validator.Validate(jwttoken);
        Profile p = profilerepository.findByEmail(c);
        return transactionRepository.findAllByProfile(p);
    }

    @RequestMapping(value = "/account/pay")
    public List<Transaction> pay(String jwttoken){
        String c = Validator.Validate(jwttoken);
        Profile p = profilerepository.findByEmail(c);
        return transactionRepository.findAllByProfile(p);
    }


}

