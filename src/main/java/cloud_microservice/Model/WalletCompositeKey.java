package cloud_microservice.Model;

import javax.persistence.*;
import java.io.Serializable;

public class WalletCompositeKey implements Serializable {
    private int id;
    private Profile profile;
    private int value;
}
