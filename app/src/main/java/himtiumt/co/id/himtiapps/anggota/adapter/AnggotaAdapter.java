package himtiumt.co.id.himtiapps.anggota.adapter;

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
        holder.tvNama.setText(dataAnggotaList.get(position).getTxtNama());
        holder.tvNim.setText(dataAnggotaList.get(position).getTxtNim());
        holder.tvTahunAngkatan.setText(String.valueOf(dataAnggotaList.get(position).getTxtTahunAngkatan()));
        holder.imgProfile.setImageResource(dataAnggotaList.get(position).getImgProfle());
    }

    @Override
    public int getItemCount() {
        return dataAnggotaList.size();
    }

    public class AnggotaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView tvNama;
        TextView tvNim;
        TextView tvTahunAngkatan;

        public AnggotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile =itemView.findViewById(R.id.iv_profile);
            tvNama =itemView.findViewById(R.id.tv_nama);
            tvNim =itemView.findViewById(R.id.tv_nim);
            tvTahunAngkatan =itemView.findViewById(R.id.tv_tahun_angkatan);
        }
    }
}

