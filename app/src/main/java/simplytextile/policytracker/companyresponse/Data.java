package simplytextile.policytracker.companyresponse;

import java.util.ArrayList;
import java.util.List;

public class Data  {



    public ArrayList<CompanyList> company_list;
    private Integer totalrecords;

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
