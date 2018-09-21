package simplytextile.policytracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shmahe on 21-09-2018.
 */

public class PremiumInfo
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("period_number")
    @Expose
    private Integer period_number;
    @SerializedName("next_payment_due_date")
    @Expose
    private String next_payment_due_date;
    @SerializedName("renewal_amount")
    @Expose
    private Object renewal_amount;
    @SerializedName("last_payment_date")
    @Expose
    private String last_payment_date;
    @SerializedName("end_date")
    @Expose
    private String end_date;
    @SerializedName("amount")
    @Expose
    private Integer amount;

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

    public String getNext_payment_due_date() {
        return next_payment_due_date;
    }

    public void setNext_payment_due_date(String next_payment_due_date) {
        this.next_payment_due_date = next_payment_due_date;
    }

    public Object getRenewal_amount() {
        return renewal_amount;
    }

    public void setRenewal_amount(Object renewal_amount) {
        this.renewal_amount = renewal_amount;
    }

    public String getLast_payment_date() {
        return last_payment_date;
    }

    public void setLast_payment_date(String last_payment_date) {
        this.last_payment_date = last_payment_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
