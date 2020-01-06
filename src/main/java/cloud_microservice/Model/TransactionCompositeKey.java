package cloud_microservice.Model;

import javax.persistence.*;
import java.io.Serializable;

public class TransactionCompositeKey implements Serializable {
    private int id;
    private Profile p;
    private int createAt;
    private int amount;
    private int orderID;
}
