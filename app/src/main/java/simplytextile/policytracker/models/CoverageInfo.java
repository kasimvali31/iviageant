package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmahe on 21-09-2018.
 */

public class CoverageInfo
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("period_number")
    @Expose
    private Integer period_number;
    @SerializedName("end_date")
    @Expose
    private String end_date;
    @SerializedName("start_date")
    @Expose
    private String start_date;
    @SerializedName("value")
    @Expose
    private Integer value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriod_number() {
        return period_number;
    }

    public void setPeriod_number(Integer period_number) {
        this.period_number = period_number;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
