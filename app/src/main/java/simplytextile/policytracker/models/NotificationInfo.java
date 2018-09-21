package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmahe on 21-09-2018.
 */

public class NotificationInfo
{
    @SerializedName("emails")
    @Expose
    private String emails;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("phone_flag")
    @Expose
    private Integer phone_flag;
    @SerializedName("email_flag")
    @Expose
    private Integer email_flag;

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPhone_flag() {
        return phone_flag;
    }

    public void setPhone_flag(Integer phone_flag) {
        this.phone_flag = phone_flag;
    }

    public Integer getEmail_flag() {
        return email_flag;
    }

    public void setEmail_flag(Integer email_flag) {
        this.email_flag = email_flag;
    }
}
