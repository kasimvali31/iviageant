package simplytextile.policytracker.responses.loginresponses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse
{
    @SerializedName("statuscode")

    private Integer statuscode;
    @SerializedName("message")

    private String message;
    @SerializedName("data")

    private Data data;

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}
