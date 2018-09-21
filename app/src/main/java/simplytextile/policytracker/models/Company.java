package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import simplytextile.policytracker.companyresponse.PolicyType;

/**
 * Created by shmahe on 21-09-2018.
 */

public class Company
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("business_name")
    @Expose
    private String business_name;
    @SerializedName("status_id")
    @Expose
    private String status_id;
    @SerializedName("irdai_number")
    @Expose
    private String irdai_number;
    @SerializedName("govt_id_number")
    @Expose
    private String govt_id_number;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("last_updated")
    @Expose
    private String last_updated;
    @SerializedName("update_counter")
    @Expose
    private Integer update_counter;
    //    @SerializedName("more")
//    @Expose
//    private More___ more;
    @SerializedName("license_number")
    @Expose
    private String license_number;
    @SerializedName("activation_date")
    @Expose
    private String activation_date;
    @SerializedName("policy_type")
    @Expose
    private PolicyType policy_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getIrdai_number() {
        return irdai_number;
    }

    public void setIrdai_number(String irdai_number) {
        this.irdai_number = irdai_number;
    }

    public String getGovt_id_number() {
        return govt_id_number;
    }

    public void setGovt_id_number(String govt_id_number) {
        this.govt_id_number = govt_id_number;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Integer getUpdate_counter() {
        return update_counter;
    }

    public void setUpdate_counter(Integer update_counter) {
        this.update_counter = update_counter;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(String activation_date) {
        this.activation_date = activation_date;
    }

    public PolicyType getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(PolicyType policy_type) {
        this.policy_type = policy_type;
    }
}
