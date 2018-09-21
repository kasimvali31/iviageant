package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Session
{
    private String id;
    private User user;
    private Subscriber subscriber;
    private String last_auth_at;
    private String expirationAt;
    private List<Object> configurationlist ;
    public Session(String id, User user, Subscriber subscriber, String last_auth_at, String expirationAt, List<Object> configurationlist) {
        this.id = id;
        this.user = user;
        this.subscriber = subscriber;
        this.last_auth_at = last_auth_at;
        this.expirationAt = expirationAt;
        this.configurationlist = configurationlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getLast_auth_at() {
        return last_auth_at;
    }

    public void setLast_auth_at(String last_auth_at) {
        this.last_auth_at = last_auth_at;
    }

    public String getExpirationAt() {
        return expirationAt;
    }

    public void setExpirationAt(String expirationAt) {
        this.expirationAt = expirationAt;
    }

    public List<Object> getConfigurationlist() {
        return configurationlist;
    }

    public void setConfigurationlist(List<Object> configurationlist) {
        this.configurationlist = configurationlist;
    }


}
