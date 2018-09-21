package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("session")

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
