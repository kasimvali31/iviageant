package simplytextile.policytracker.companyresponse;

public class PolicyType
{


    private Integer id;
    private String name;
    private String description;
    private String parent_id;
    private Integer is_renewable;
    private Integer renewal_notice_days;

    public PolicyType(Integer id, String name, String description, String parent_id, Integer is_renewable, Integer renewal_notice_days) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parent_id = parent_id;
        this.is_renewable = is_renewable;
        this.renewal_notice_days = renewal_notice_days;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getIs_renewable() {
        return is_renewable;
    }

    public void setIs_renewable(Integer is_renewable) {
        this.is_renewable = is_renewable;
    }

    public Integer getRenewal_notice_days() {
        return renewal_notice_days;
    }

    public void setRenewal_notice_days(Integer renewal_notice_days) {
        this.renewal_notice_days = renewal_notice_days;
    }



}
