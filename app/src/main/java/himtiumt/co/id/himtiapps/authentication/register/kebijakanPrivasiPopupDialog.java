package himtiumt.co.id.himtiapps.authentication.register;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import himtiumt.co.id.himtiapps.R;

public class kebijakanPrivasiPopupDialog extends AppCompatDialogFragment {
    Button btnSetuju;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.kebijakan_privasi_popup, null);

        builder.setView(view);

        btnSetuju = view.findViewById(R.id.btn_setuju);

        btnSetuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return builder.create();
    }
}
