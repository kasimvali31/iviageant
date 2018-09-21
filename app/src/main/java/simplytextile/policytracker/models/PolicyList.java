package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmahe on 21-09-2018.
 */

public class PolicyList
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    //    @SerializedName("agent")
//    @Expose
//    private Agent_ agent;
    @SerializedName("company")
    @Expose
    private Company company;
        @SerializedName("policy_type")
    @Expose
    private PolicyType_ policy_type;
    @SerializedName("policy_type_sub")
    @Expose
    private PolicyTypeSub policy_type_sub;
    @SerializedName("policy_status")
    @Expose
    private PolicyStatus policy_status;
    @SerializedName("coverage_info")
    @Expose
    private CoverageInfo coverage_info;
    @SerializedName("renewal_info")
    @Expose
    private RenewalInfo renewal_info;
        @SerializedName("premium_info")
    @Expose
    private PremiumInfo premium_info;
    @SerializedName("insured_type")
    @Expose
    private InsuredType insured_type;
    @SerializedName("policy_number")
    @Expose
    private String policy_number;
    @SerializedName("insured_details")
    @Expose
    private String insured_details;
    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("commission_amount")
    @Expose
    private Integer commission_amount;
    @SerializedName("parent_id")
    @Expose
    private Object parent_id;
    @SerializedName("grace_days")
    @Expose
    private Integer grace_days;
    //    @SerializedName("more")
//    @Expose
//    private More____ more;
    @SerializedName("update_counter")
    @Expose
    private Integer update_counter;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("last_updated")
    @Expose
    private String last_updated;
    @SerializedName("lapsation_date")
    @Expose
    private String lapsation_date;
        @SerializedName("insured_info")
    @Expose
    private InsuredInfo insured_info;
    @SerializedName("notification_info")
    @Expose
    private NotificationInfo notification_info;
    @SerializedName("beneficiary_information")
    @Expose
    private String beneficiary_information;
    @SerializedName("last_update")
    @Expose
    private String last_update;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PolicyType_ getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(PolicyType_ policy_type) {
        this.policy_type = policy_type;
    }

    public PolicyTypeSub getPolicy_type_sub() {
        return policy_type_sub;
    }

    public void setPolicy_type_sub(PolicyTypeSub policy_type_sub) {
        this.policy_type_sub = policy_type_sub;
    }

    public PolicyStatus getPolicy_status() {
        return policy_status;
    }

    public void setPolicy_status(PolicyStatus policy_status) {
        this.policy_status = policy_status;
    }

    public CoverageInfo getCoverage_info() {
        return coverage_info;
    }

    public void setCoverage_info(CoverageInfo coverage_info) {
        this.coverage_info = coverage_info;
    }

    public RenewalInfo getRenewal_info() {
        return renewal_info;
    }

    public void setRenewal_info(RenewalInfo renewal_info) {
        this.renewal_info = renewal_info;
    }

    public PremiumInfo getPremium_info() {
        return premium_info;
    }

    public void setPremium_info(PremiumInfo premium_info) {
        this.premium_info = premium_info;
    }

    public InsuredType getInsured_type() {
        return insured_type;
    }

    public void setInsured_type(InsuredType insured_type) {
        this.insured_type = insured_type;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public String getInsured_details() {
        return insured_details;
    }

    public void setInsured_details(String insured_details) {
        this.insured_details = insured_details;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getCommission_amount() {
        return commission_amount;
    }

    public void setCommission_amount(Integer commission_amount) {
        this.commission_amount = commission_amount;
    }

    public Object getParent_id() {
        return parent_id;
    }

    public void setParent_id(Object parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getGrace_days() {
        return grace_days;
    }

    public void setGrace_days(Integer grace_days) {
        this.grace_days = grace_days;
    }

    public Integer getUpdate_counter() {
        return update_counter;
    }

    public void setUpdate_counter(Integer update_counter) {
        this.update_counter = update_counter;
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

    public String getLapsation_date() {
        return lapsation_date;
    }

    public void setLapsation_date(String lapsation_date) {
        this.lapsation_date = lapsation_date;
    }

    public InsuredInfo getInsured_info() {
        return insured_info;
    }

    public void setInsured_info(InsuredInfo insured_info) {
        this.insured_info = insured_info;
    }

    public NotificationInfo getNotification_info() {
        return notification_info;
    }

    public void setNotification_info(NotificationInfo notification_info) {
        this.notification_info = notification_info;
    }

    public String getBeneficiary_information() {
        return beneficiary_information;
    }

    public void setBeneficiary_information(String beneficiary_information) {
        this.beneficiary_information = beneficiary_information;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
