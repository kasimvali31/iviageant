package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private Integer entity_id;
    private Integer sys_role_id;
    private String login_name;
    private String password;
    private Integer status_id;
    private Address address;
    private Integer update_counter;
    private String created;
    private String last_updated;
    private Integer address_id;

    public User(Integer id, String first_name, String last_name, String middle_name, Integer entity_id, Integer sys_role_id, String login_name, String password, Integer status_id, Address address, Integer update_counter, String created, String last_updated, Integer address_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.entity_id = entity_id;
        this.sys_role_id = sys_role_id;
        this.login_name = login_name;
        this.password = password;
        this.status_id = status_id;
        this.address = address;
        this.update_counter = update_counter;
        this.created = created;
        this.last_updated = last_updated;
        this.address_id = address_id;
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

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    public Integer getSys_role_id() {
        return sys_role_id;
    }

    public void setSys_role_id(Integer sys_role_id) {
        this.sys_role_id = sys_role_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }


}
