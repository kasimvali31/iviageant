package simplytextile.policytracker.companyresponse;

public class CompanyList
{

    private Integer id;
    private String first_name;
    private String last_name;
    private String business_name;
    private String status_id;
    private Address address;
    private String irdai_number;
    private String govt_id_number;
    private String created;
    private String last_updated;
    private Integer update_counter;
    private More more;
    private PolicyType policy_type;

    public CompanyList(Integer id, String first_name, String last_name, String business_name, String status_id, Address address, String irdai_number, String govt_id_number, String created, String last_updated, Integer update_counter, More more, PolicyType policy_type) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.business_name = business_name;
        this.status_id = status_id;
        this.address = address;
        this.irdai_number = irdai_number;
        this.govt_id_number = govt_id_number;
        this.created = created;
        this.last_updated = last_updated;
        this.update_counter = update_counter;
        this.more = more;
        this.policy_type = policy_type;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Object getIrdai_number() {
        return irdai_number;
    }

    public void setIrdai_number(String irdai_number) {
        this.irdai_number = irdai_number;
    }

    public Object getGovt_id_number() {
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

    public More getMore() {
        return more;
    }

    public void setMore(More more) {
        this.more = more;
    }

    public PolicyType getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(PolicyType policy_type) {
        this.policy_type = policy_type;
    }
}
