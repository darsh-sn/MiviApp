package example.temp.com.mivi.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import example.temp.com.mivi.MyApplication;
import example.temp.com.mivi.databinding.ActivityLoginBinding;

import example.temp.com.mivi.home.MainActivity;
import example.temp.com.mivi.util.CommonMethods;
import example.temp.com.mivi.R;
import example.temp.com.mivi.WebService.VolleyServerCaller;
import example.temp.com.mivi.WebService.collection;


public class LoginActivity extends AppCompatActivity  implements LoginChecker{

    ActivityLoginBinding activityLoginBinding;

    private Gson gson;

    ProgressDialog progressDialog;

    String sEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityLoginBinding=DataBindingUtil.setContentView(this, R.layout.activity_login);
        progressDialog=new ProgressDialog(this);
        initListener();

       // getSupportActionBar().hide();


    }

    private void initListener(){
        activityLoginBinding.btActivityLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sEmail=activityLoginBinding.etLoginEmail.getText().toString().trim();
                String sPassword=activityLoginBinding.etLoginPassword.getText().toString().trim();

                if(sEmail.equalsIgnoreCase("")){
                    activityLoginBinding.etLoginEmail.setError("Please enter email address");

                }else if (sPassword.equalsIgnoreCase("")){
                    activityLoginBinding.etLoginPassword.setError("Please enter password");
                }else {

                    progressDialog.setTitle(getString(R.string.app_name));
                    progressDialog.setMessage("Please wait...");
                    progressDialog.show();
                   VolleyServerCaller volleyServerCaller=new VolleyServerCaller(LoginActivity.this,getApplicationContext());
                   volleyServerCaller.makeRequest();

                }

            }
        });
    }







    @Override
    public void successLogin(String response) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        collection collection = gson.fromJson(response, collection.class);
        Log.i("LoginActivity", response);
       
        progressDialog.dismiss();


        if(sEmail.equalsIgnoreCase(collection.data.attributes.emailaddress)){

            MyApplication.collection=collection;

            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else {
            CommonMethods commonMethods=new CommonMethods(this);
            commonMethods.showAlert("Invalid email/password");
        }

    }

    @Override
    public void FailedLogin(String sError) {
        Log.i("PostActivity", sError);
        progressDialog.dismiss();

        CommonMethods commonMethods=new CommonMethods(this);
        commonMethods.showAlert(sError);
    }
}
