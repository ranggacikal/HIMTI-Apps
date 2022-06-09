package himtiumt.co.id.himtiapps.strukturOrganisasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.StrukturOrganisasi;

public class StrukturOrganisasiAdapter extends RecyclerView.Adapter<StrukturOrganisasiAdapter.StrukturViewHolder> {

    private Context context;
    private List<StrukturOrganisasi> strukturOrganisasiList;

    public StrukturOrganisasiAdapter(Context context, List<StrukturOrganisasi> strukturOrganisasiList) {
        this.context = context;
        this.strukturOrganisasiList = strukturOrganisasiList;
    }

    @NonNull
    @Override
    public StrukturViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_struktur_organisasi, parent, false);
        return new StrukturViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StrukturViewHolder holder, int position) {
        holder.imgSprofile.setImageResource(strukturOrganisasiList.get(position).getImgStrukturProfile());
        holder.txtSnama.setText(strukturOrganisasiList.get(position).getTxtStrukturNama());
        holder.txtSnim.setText(strukturOrganisasiList.get(position).getTxtStrukturNim());
        holder.txtSjabatan.setText(strukturOrganisasiList.get(position).getTxtJabatan());

    }

    @Override
    public int getItemCount() {
        return strukturOrganisasiList.size();
    }

    public class StrukturViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSprofile;
        TextView txtSnama;
        TextView txtSnim;
        TextView txtSjabatan;

        public StrukturViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSprofile = itemView.findViewById(R.id.iv_struktur_profile);
            txtSnama = itemView.findViewById(R.id.txt_struktur_nama);
            txtSnim = itemView.findViewById(R.id.txt_struktur_nim);
            txtSjabatan = itemView.findViewById(R.id.txt_jabatan);
        }
    }
}
