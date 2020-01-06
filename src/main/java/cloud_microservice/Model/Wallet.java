package cloud_microservice.Model;
import javax.persistence.*;
import java.io.Serializable;




@Entity
@Table(name="Wallet")
@IdClass(WalletCompositeKey.class)
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Profile profile;

    @Id
    @Column(name = "value")
    private int value;

    public Wallet(Profile profile, int value) {
        this.profile = profile;
        this.value = value;
    }

    public Wallet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
