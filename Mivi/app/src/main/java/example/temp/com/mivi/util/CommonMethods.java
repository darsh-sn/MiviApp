package example.temp.com.mivi.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import example.temp.com.mivi.R;

public class CommonMethods {
    Context context;



    public CommonMethods(Context context){
        this.context=context;
    }

    public void showAlert(String sMessage){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(context.getString(R.string.app_name));
        alertDialogBuilder.setMessage(sMessage);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialogBuilder.show();
    }

}
