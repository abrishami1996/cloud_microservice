package cloud_microservice.Model;

import javax.persistence.*;
import java.io.Serializable;


public class ProfileRequest {

    private String Email;
    private String Name;
    private long PhoneNo;
    private long NationalCode;
    private String Address;
    private long PostalCode;
    private String Password;


    public ProfileRequest (String email, String name, long phoneNo, long nationalCode, String address, long postalCode, String password) {
        this.Email = email;
        this.Name = name;
        this.PhoneNo = phoneNo;
        this.NationalCode = nationalCode;
        this.Address = address;
        this.PostalCode = postalCode;
        this.Password = password;

    }

    public ProfileRequest () {
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public void setPostalCode(long postalCode) {
        PostalCode = postalCode;
    }

    public String getPassword() { return Password; }

    public void setPassword(String password) { Password = password; }
}