package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

public class Address {
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer update_counter;
    private String created;

    public Address(Integer id, String first_name, String last_name, Integer update_counter, String created, String last_updated) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.update_counter = update_counter;
        this.created = created;
        this.last_updated = last_updated;
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

    private String last_updated;


}
