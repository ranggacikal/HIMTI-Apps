package himtiumt.co.id.himtiapps.anggota.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.anggota.model.AnggotaItem;

public class AnggotaAngkatanAdapter extends RecyclerView.Adapter<AnggotaAngkatanAdapter.AnggotaAngkatanViewHolder>{
    private List<AnggotaItem> angkatanItems;
    private Context context;

    public AnggotaAngkatanAdapter(List<AnggotaItem> angkatanItems, Context context) {
        this.angkatanItems = angkatanItems;
        this.context = context;
    }

    @NonNull
    @Override
    public AnggotaAngkatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anggota,parent,false);
        return new AnggotaAngkatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnggotaAngkatanViewHolder holder, int position) {
        holder.tvNama.setText(angkatanItems.get(position).getNama());
        holder.tvNim.setText(angkatanItems.get(position).getNim());
        holder.tvTahunAngkatan.setText(String.valueOf(angkatanItems.get(position).getAngkatan()));
    }

    @Override
    public int getItemCount() {
        return angkatanItems.size();
    }

    public class AnggotaAngkatanViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvNim;
        TextView tvTahunAngkatan;
        public AnggotaAngkatanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama =itemView.findViewById(R.id.tv_nama);
            tvNim =itemView.findViewById(R.id.tv_nim);
            tvTahunAngkatan =itemView.findViewById(R.id.tv_tahun);
        }
    }
}
