package cloud_microservice.Model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

public class ZarinPal {
    int TransactionID;

    @OneToOne
    @JoinColumn(name="Profile_ID")
    private Profile profile;
    String athority;
    int amount;
    long refID;
    int  withdrawn;
    Date date;

    public ZarinPal(int transactionID, Profile profile, String authority, int amount, long refID, int withdrawn) {
        TransactionID = transactionID;
        this.profile = profile;
        authority = authority;
        amount = amount;
        refID = refID;
        withdrawn = withdrawn;
    }

    public ZarinPal() {
    }

    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int transactionID) {
        TransactionID = transactionID;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getAthority() {
        return athority;
    }

    public void setAthority(String athority) {
        this.athority = athority;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getRefID() {
        return refID;
    }

    public void setRefID(long refID) {
        this.refID = refID;
    }

    public int getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(int withdrawn) {
        this.withdrawn = withdrawn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
