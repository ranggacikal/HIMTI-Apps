package himtiumt.co.id.himtiapps.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import himtiumt.co.id.himtiapps.R;

public class LoadingBar {

    private Activity activity;
    private AlertDialog alertDialog;

    public LoadingBar(Activity myActivity) {
        activity = myActivity;
    }

    public void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_progressbar, null));

        alertDialog = builder.create();
        alertDialog.show();
    }

    public void dismissDialog() {
        alertDialog.dismiss();
    }

}
