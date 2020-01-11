package cloud_microservice.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Profile")
public class Profile implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Name")
    private String Name;
    @Column(name = "PhoneNo")
    private long PhoneNo;
    @Column(name = "NationalCode")
    private long NationalCode;
    @Column(name = "Address")
    private String Address;
    @Column(name = "PostalCode")
    private long PostalCode;

    @OneToOne(mappedBy = "profile",cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToOne(mappedBy = "profile",cascade = CascadeType.ALL)
    private Transaction transaction;

    @OneToOne(mappedBy = "profile",cascade = CascadeType.ALL)
    private ZarinPal zarinPal;

    public Profile(String email, String name, long phoneNo, long nationalCode, String address, long postalCode, Wallet wallet, Transaction transaction, ZarinPal zarinPal) {
        this.email = email;
        Name = name;
        PhoneNo = phoneNo;
        NationalCode = nationalCode;
        Address = address;
        PostalCode = postalCode;
        this.wallet = wallet;
        this.transaction = transaction;
        this.zarinPal = zarinPal;
    }

    public Profile(String email, String name, long phoneNo, long nationalCode, String address, long postalCode) {
        email = email;
        Name = name;
        PhoneNo = phoneNo;
        NationalCode = nationalCode;
        Address = address;
        PostalCode = postalCode;
    }

    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        PhoneNo = phoneNo;
    }

    public long getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(long nationalCode) {
        NationalCode = nationalCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getPostalCode() {
        return PostalCode;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setPostalCode(long postalCode) {
        PostalCode = postalCode;
    }

    public ZarinPal getZarinPal() {
        return zarinPal;
    }

    public void setZarinPal(ZarinPal zarinPal) {
        this.zarinPal = zarinPal;
    }
}