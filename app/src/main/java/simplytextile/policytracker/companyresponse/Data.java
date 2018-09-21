package simplytextile.policytracker.companyresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import simplytextile.policytracker.models.AgentList;
import simplytextile.policytracker.models.CustomerList;

public class Data  {



    public ArrayList<CompanyList> company_list;
    private Integer totalrecords;


    @SerializedName("agent_list")
    @Expose
    private List<AgentList> agentList = null;

    public List<AgentList> getAgentList() {
        return agentList;
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
