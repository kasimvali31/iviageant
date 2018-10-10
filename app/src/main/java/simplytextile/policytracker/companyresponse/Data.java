package simplytextile.policytracker.companyresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import simplytextile.policytracker.NotificationResponse.NotificationList;
import simplytextile.policytracker.models.AgentList;
import simplytextile.policytracker.models.CustomerList;
import simplytextile.policytracker.models.PolicyList;

public class Data
{



    public ArrayList<CompanyList> company_list;
    private Integer totalrecords;

    @SerializedName("policy_list")
    @Expose
    private List<PolicyList> policy_list;

    public List<PolicyList> getPolicy_list() {
        return policy_list;
    }

    public void setPolicy_list(List<PolicyList> policy_list) {
        this.policy_list = policy_list;
    }

    @SerializedName("agent_list")
    @Expose
    private List<AgentList> agentList = null;

    public List<AgentList> getAgentList() {
        return agentList;
    }

    @SerializedName("notification_list")
    @Expose
    private List<NotificationList> notification_list ;

    public List<NotificationList> getNotification_list() {
        return notification_list;
    }

    public void setNotification_list(List<NotificationList> notification_list) {
        this.notification_list = notification_list;
    }

    public void setAgentList(List<AgentList> agentList) {
        this.agentList = agentList;
    }

    @SerializedName("customer_list")
    @Expose
    private List<CustomerList> customer_list;

    public List<CustomerList> getCustomer_list() {
        return customer_list;
    }

    public void setCustomer_list(List<CustomerList> customer_list) {
        this.customer_list = customer_list;
    }

    public ArrayList<CompanyList> getCompany_list()
    {
        return company_list;
    }

    public void setCompany_list(ArrayList<CompanyList> company_list)
    {
        this.company_list = company_list;
    }

    public Integer getTotalrecords()
    {
        return totalrecords;
    }

    public void setTotalrecords(Integer totalrecords)
    {
        this.totalrecords = totalrecords;
    }

    public Data(ArrayList<CompanyList> company_list, Integer totalrecords)
    {
        this.company_list = company_list;
        this.totalrecords = totalrecords;
    }
}
