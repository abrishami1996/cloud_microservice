package cloud_microservice.Model;

import javax.persistence.*;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    @OneToOne
    @PrimaryKeyJoinColumn
    private Profile p;

    @Id
    @Column(name = "CreatedAt")
    private int CreatedAt;
    @Column(name = "ModifiedAt")
    private int ModifiedAt;
    @Id
    @Column(name = "amount")
    private int amount;
    @Id
    @Column(name = "orderID")
    private int orderID;
    @Column(name = "statuscode")
    private int statuscode;
    @Column(name = "refID")
    private int refID;

    public Transaction(int createdAt, int modifiedAt, int amount, int orderID, int statuscode, int refID, Profile profile) {
        CreatedAt = createdAt;
        ModifiedAt = modifiedAt;
        this.amount = amount;
        this.orderID = orderID;
        this.statuscode = statuscode;
        this.refID = refID;
        this.p = profile;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(int createdAt) {
        CreatedAt = createdAt;
    }

    public int getModifiedAt() {
        return ModifiedAt;
    }

    public void setModifiedAt(int modifiedAt) {
        ModifiedAt = modifiedAt;
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

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public int getRefID() {
        return refID;
    }

    public void setRefID(int refID) {
        this.refID = refID;
    }

    public Profile getProfile() {
        return p;
    }

    public void setProfile(Profile profile) {
        this.p = profile;
    }
}
