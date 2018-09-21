package simplytextile.policytracker.apis;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.http.Body;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;
        import retrofit2.http.POST;
        import simplytextile.policytracker.companyresponse.CompanyList;
        import simplytextile.policytracker.companyresponse.Compres;
        import simplytextile.policytracker.companyresponse.Data;
        import simplytextile.policytracker.response.AgentsResponse;
        import simplytextile.policytracker.response.CustomerResponse;
        import simplytextile.policytracker.response.PoliciesResponse;
        import simplytextile.policytracker.responses.loginresponses.LoginResponse;

public interface ApiService
{
//    @Headers("Content-Type: application/json")
//    @POST("api/subscribers/")
//    Call<SignUpResponse> signupdetails(@Body Subscriber subscriber);



    @FormUrlEncoded
    @POST("api/users/me/login")
    Call<LoginResponse> Logindetails(@Field("login_name") String login_name, @Field("password") String password);


    @GET("api/companies")
    Call<Compres> getCompanies( );

    @GET("api/companies")
    Call<List<CompanyList>> getCompaniesList();



    @Headers({"Content-Type:application/json"
            ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/customers")
    Call<CustomerResponse> getCustomers();


    @Headers({"Content-Type:application/json"
            ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/agents/")
    Call<AgentsResponse> getAgents();


    //api/policies
    @Headers({"Content-Type:application/json"
            ,"app_sid:37a559d3bcd211e8be14aa3a52b410b4"})
    @GET("api/policies")
    Call<PoliciesResponse> getPolicies();









    //Call<SignUpResponse> signupdetails( Integer type_id,String first_name, String last_name, String email1, String phone1, String login_name, String password);



}
