package himtiumt.co.id.himtiapps.anggota.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.anggota.model.DataAnggota;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.AnggotaViewHolder> {

    private List<DataAnggota> dataAnggotaList;
    private Context context;

    public AnggotaAdapter(List<DataAnggota> dataAnggotaList, Context context) {
        this.dataAnggotaList = dataAnggotaList;
        this.context = context;
    }

    @NonNull
    @Override
    public AnggotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anggota,parent,false);
        return new AnggotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnggotaViewHolder holder, int position) {
        holder.txtNama.setText(dataAnggotaList.get(position).getTxtNama());
        holder.txtNim.setText(dataAnggotaList.get(position).getTxtNim());
        holder.txtTahunAngkatan.setText(String.valueOf(dataAnggotaList.get(position).getTxtTahunAngkatan()));
        holder.imgProfile.setImageResource(dataAnggotaList.get(position).getImgProfle());
    }

    @Override
    public int getItemCount() {
        return dataAnggotaList.size();
    }

    public class AnggotaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView txtNama;
        TextView txtNim;
        TextView txtTahunAngkatan;

        public AnggotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile =itemView.findViewById(R.id.iv_profile);
            txtNama =itemView.findViewById(R.id.txt_nama);
            txtNim =itemView.findViewById(R.id.txt_nim);
            txtTahunAngkatan =itemView.findViewById(R.id.txt_tahun_angkatan);
        }
    }
}

