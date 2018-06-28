package example.temp.com.mivi.WebService;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import example.temp.com.mivi.login.LoginChecker;


public class VolleyServerCaller {

    private RequestQueue requestQueue;
    private static final String SERVER_URL = "https://gitlab.com/mfebrianto/mivi-ios-android-test/raw/master/collection.json";

    LoginChecker loginChecker;
    Context context;


    public VolleyServerCaller(LoginChecker loginChecker, Context context){
        this.loginChecker=loginChecker;
        this.context=context;
    }

    public void makeRequest(){
        StringRequest request = new StringRequest(Request.Method.GET, SERVER_URL, onSuccess, onError);
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onSuccess = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

        loginChecker.successLogin(response);


        }
    };

    private final Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("VolleyServerCaller", error.toString());
            loginChecker.FailedLogin(error.getMessage());
        }
    };

}
