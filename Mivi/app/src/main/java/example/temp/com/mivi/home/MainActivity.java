package example.temp.com.mivi.home;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.temp.com.mivi.MyApplication;
import example.temp.com.mivi.R;
import example.temp.com.mivi.WebService.attributes;
import example.temp.com.mivi.WebService.collection;
import example.temp.com.mivi.WebService.included;
import example.temp.com.mivi.databinding.ActivityMainBinding;
import example.temp.com.mivi.util.CommonMethods;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        initUI();

        initListener();

    }


    private void initUI(){
        collection collection= MyApplication.collection;
        if(collection!=null) {
            activityMainBinding.tvUserName.setText(collection.data.attributes.title+" "+collection.data.attributes.firstname+" "+collection.data.attributes.lastname);

            if(!collection.data.attributes.emailAddressVerified.equalsIgnoreCase("true")){
                activityMainBinding.imgEmailVerification.setVisibility(View.VISIBLE);
            }else {
                activityMainBinding.imgEmailVerification.setVisibility(View.GONE);
            }





            for (included included:collection.included) {
                if(included.type.equalsIgnoreCase("subscriptions")){
                    activityMainBinding.tvHomeRemainingData.setText(included.attributes.dataBalance);
                    activityMainBinding.tvHomeExpiryData.setText(included.attributes.expiryData);
                }


                if(included.type.equalsIgnoreCase("products")){
                activityMainBinding.tvProductName.setText(included.attributes.name);
                activityMainBinding.tvProductPrice.setText("Rs "+included.attributes.price);

                if(included.attributes.unlimitedIntTalk.equalsIgnoreCase("true")){
                    activityMainBinding.tvIntCall.setText("Unlimited");
                }else {
                    activityMainBinding.tvIntCall.setText("Restricted");
                }


                    if(included.attributes.unlimtedIntText.equalsIgnoreCase("true")){
                        activityMainBinding.tvIntText.setText("Unlimited");
                    }else {
                        activityMainBinding.tvIntText.setText("Restricted");
                    }

                    if(included.attributes.unlimitedTalk.equalsIgnoreCase("true")){
                        activityMainBinding.tvUnilimitedTalk.setText("Unlimited");
                    }else {
                        activityMainBinding.tvUnilimitedTalk.setText("Restricted");
                    }


                    if(included.attributes.unlimtText.equalsIgnoreCase("true")){
                        activityMainBinding.tvUnlimitedText.setText("Unlimited");
                    }else {
                        activityMainBinding.tvUnlimitedText.setText("Restricted");
                    }




                }
            }

        }
    }



    private void initListener(){
        activityMainBinding.imgEmailVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please verify your email", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }
}
