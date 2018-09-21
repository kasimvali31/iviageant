package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Subscriber {

    private Integer id;
    private String first_name;
    private String last_name;
    private String business_name;
    private Integer status_id;
    private Integer type_id;
    private String aadhar_number;
    private Object govt_id_number;
    private String created;
    private String last_updated;

    private Integer update_counter;
    private String notes;
    private More more;
    private List<Object> company_list;
    private Address_ address;
    private String irdai_number;

    public Subscriber(Integer id, String first_name, String last_name, String business_name, Integer status_id, Integer type_id, String aadhar_number, Object govt_id_number, String created, String last_updated, Integer update_counter, String notes, More more, List<Object> company_list, Address_ address, String irdai_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.business_name = business_name;
        this.status_id = status_id;
        this.type_id = type_id;
        this.aadhar_number = aadhar_number;
        this.govt_id_number = govt_id_number;
        this.created = created;
        this.last_updated = last_updated;
        this.update_counter = update_counter;
        this.notes = notes;
        this.more = more;
        this.company_list = company_list;
        this.address = address;
        this.irdai_number = irdai_number;
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

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getAadhar_number() {
        return aadhar_number;
    }

    public void setAadhar_number(String aadhar_number) {
        this.aadhar_number = aadhar_number;
    }

    public Object getGovt_id_number() {
        return govt_id_number;
    }

    public void setGovt_id_number(Object govt_id_number) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public More getMore() {
        return more;
    }

    public void setMore(More more) {
        this.more = more;
    }

    public List<Object> getCompany_list() {
        return company_list;
    }

    public void setCompany_list(List<Object> company_list) {
        this.company_list = company_list;
    }

    public Address_ getAddress() {
        return address;
    }

    public void setAddress(Address_ address) {
        this.address = address;
    }

    public String getIrdai_number() {
        return irdai_number;
    }

    public void setIrdai_number(String irdai_number) {
        this.irdai_number = irdai_number;
    }


}
