package simplytextile.policytracker.companyresponse;

public class Compres
{

    private Integer statuscode;
    private String message;
    private Data data;



    public Compres(Integer statuscode, String message, Data data) {
        this.statuscode = statuscode;
        this.message = message;
        this.data = data;
    }

    public Integer getStatuscode()
    {
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


