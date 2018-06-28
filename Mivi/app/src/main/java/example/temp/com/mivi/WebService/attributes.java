package example.temp.com.mivi.WebService;

import com.google.gson.annotations.SerializedName;

public class attributes {

    @SerializedName("payment-type")
    public String paymenttype;

    public String title;

    public String name;


    @SerializedName("first-name")
    public String firstname;

    @SerializedName("last-name")
    public String lastname;


    @SerializedName("date-of-birth")
    public String dob;


    @SerializedName("contact-number")
    public String contactnumber;



    @SerializedName("email-address")
    public String emailaddress;

    @SerializedName("email-address-verified")
    public String emailAddressVerified;

    @SerializedName("included-data-balance")
    public String dataBalance;

    @SerializedName("expiry-date")
    public String expiryData;

    @SerializedName("auto-renewal")
    public String autoRenewal;


    public String price;

    @SerializedName("unlimited-text")
    public String unlimtText;

    @SerializedName("unlimited-talk")
    public String unlimitedTalk;

    @SerializedName("unlimited-international-text")
    public String unlimtedIntText;

    @SerializedName("unlimited-international-talk")
    public String unlimitedIntTalk;


}
