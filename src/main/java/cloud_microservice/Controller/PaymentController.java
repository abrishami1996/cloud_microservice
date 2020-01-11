package cloud_microservice.Controller;

import cloud_microservice.Model.Profile;
import cloud_microservice.Model.Transaction;
import cloud_microservice.Model.ZarinPal;
import cloud_microservice.Repository.ProfileRepository;
import cloud_microservice.Repository.TransactionRepository;
import cloud_microservice.Repository.ZarinpalRepository;
import cloud_microservice.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    ZarinpalRepository zarinpalRepository;

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
    public String pay(String jwttoken, int OrderID){
        String c = Validator.Validate(jwttoken);
        Transaction t = transactionRepository.findByOrderID(OrderID);
        t.setStatuscode(0);
        transactionRepository.save(t);
//        $stmt = $conn->prepare("INSERT INTO `Transactions` (`ChatID`, `Authority`, `Amount`, `Withdrawn`) VALUES (?, ?, ?, ?)");
//        $stmt->execute(array($chatID, $auth, $Amount, false));

        String url = "https://www.zarinpal.com/pg/services/WebGate/wsdl";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("MerchantID", "ae21c028-8d71-11e7-be0b-005056a205be");
        map.put("Amount", new Integer(t.getAmount()).toString());
        map.put("Description", "This is a Description");
        map.put("CallbackURL",  "http://localhost:8080/account/pay/callback");
        ResponseEntity<ReultsMapper> response = restTemplate.postForEntity(url, map, ReultsMapper.class);
        HttpStatus statusCode = response.getStatusCode();
        // check response
        if (statusCode.value() == 100) {
            ZarinPal z = new ZarinPal(t.getId(), profilerepository.findByEmail(c), response.getBody().getAuthority(), t.getAmount(), 0, 0);
            zarinpalRepository.save(z);
            return "https://www.zarinpal.com/pg/StartPay/" + response.getBody().getAuthority();
        } else {
            return "Some Error";
        }

    }

//    @RequestMapping(value = "/account/pay/callback")
//    public List<Transaction> callback(String jwttoken, int OrderID){
//        String c = Validator.Validate(jwttoken);
//        Transaction t = transactionRepository.findByOrderID(OrderID);
//        t.setStatuscode(1);
//        transactionRepository.save(t);
//        Profile p = profilerepository.findByEmail(c);
//        Webb webb = Webb.create();
//        webb.post("http://example.com/index.php")
//                .param("MerchantID", "ae21c028-8d71-11e7-be0b-005056a205be")
//                .param("Amount", t.getAmount())
//                .param("Description", "This is a Description")
//                .param("CallbackURL", "http://localhost:8080/account/pay/callback")
//                .ensureSuccess()
//                .asVoid();
//    }


}

