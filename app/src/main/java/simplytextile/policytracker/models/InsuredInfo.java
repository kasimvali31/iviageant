package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmahe on 21-09-2018.
 */

public class InsuredInfo
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("identification")
    @Expose
    private String identification;
    @SerializedName("details")
    @Expose
    private Object details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
