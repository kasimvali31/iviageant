package simplytextile.policytracker.NotificationResponse;

public class Policy
{


    private Integer id;

    private String policyNumber;

    private CoverageInfo coverageInfo;

    private Customer customer;

    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public CoverageInfo getCoverageInfo() {
        return coverageInfo;
    }

    public void setCoverageInfo(CoverageInfo coverageInfo) {
        this.coverageInfo = coverageInfo;
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
}
