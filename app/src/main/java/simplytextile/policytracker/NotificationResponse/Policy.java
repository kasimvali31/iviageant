package simplytextile.policytracker.NotificationResponse;

public class Policy
{


    //private Integer id;

    private String policy_number ;

    private CoverageInfo coverage_info;

    private Customer customer;

    private Company company;


    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public CoverageInfo getCoverage_info() {
        return coverage_info;
    }

    public void setCoverage_info(CoverageInfo coverage_info) {
        this.coverage_info = coverage_info;
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
