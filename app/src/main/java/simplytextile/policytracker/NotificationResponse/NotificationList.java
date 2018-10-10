package simplytextile.policytracker.NotificationResponse;

import java.util.List;

public class NotificationList
{

    private Integer id;

    private Policy policy;

    private Customer customer;

    private Company company;

    private Format format;

    private Type type;

    private String sent_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSent_date() {
        return sent_date;
    }

    public void setSent_date(String sent_date) {
        this.sent_date = sent_date;
    }
}
