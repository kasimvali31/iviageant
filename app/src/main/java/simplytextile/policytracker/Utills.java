package simplytextile.policytracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import simplytextile.policytracker.activties.AddAgentActivity;
import simplytextile.policytracker.activties.AddCustomerActivity;

public class Utills
{

    public static void getVolleyResponseJson(final Context mContext, int method, final String url, final JSONObject params, final VolleyCallback callback)
    {
        final String s=AddAgentActivity.S_id;

//        AddAgentActivity add=new AddAgentActivity();
//        final String s=add.S_id;


        AppController.getInstance().addToRequestQueue(new JsonObjectRequest(method, url, params, new Response.Listener<JSONObject>()
        {

            @Override
            public void onResponse(JSONObject response)
            {



                if (response != null)
                {

                    callback.onSuccessResponse(response.toString());





                }
                //hidepDialog();
            }

        }, new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                if (error.toString().equalsIgnoreCase("com.android.volley.ServerError"))
                {
                    callback.onSuccessResponse("com.android.volley.ServerError");
                }
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog

            }






        }

        )

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {

                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("app_sid", s);
                return params;
            }
        });




    }

}
