package cloud_microservice.Model;
import javax.persistence.*;



@Entity
@Table(name="Transaction")
@IdClass(TransactionCompositeKey.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Profile_ID", referencedColumnName = "id")
    private Profile profile;
    @Id
    @Column(name = "createAt")
    private int createAt;
    @Column(name = "modifiedAt")
    private int modifiedAt;
    @Id
    @Column(name = "amount")
    private int amount;
    @Id
    @Column(name = "orderID")
    private int orderID;
    @Column(name = "statusCode")
    private int statusCode;
    @Column(name = "refID")
    private int refID;

    public Transaction(Profile profile, int createAt, int modifiedAt, int amount, int orderID, int statusCode, int refID) {
        this.profile = profile;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.amount = amount;
        this.orderID = orderID;
        this.statusCode = statusCode;
        this.refID = refID;
    }

    public Transaction() {
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

    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public int getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(int modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getRefID() {
        return refID;
    }

    public void setRefID(int refID) {
        this.refID = refID;
    }
}
