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

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.AnggotaViewHolder> {

    private List<AnggotaItem> anggotaItems;
    private Context context;

    public AnggotaAdapter(List<AnggotaItem> anggotaItems, Context context) {
        this.anggotaItems = anggotaItems;
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
        holder.tvNama.setText(anggotaItems.get(position).getNama());
        holder.tvNim.setText(anggotaItems.get(position).getNim());
        holder.tvTahunAngkatan.setText(String.valueOf(anggotaItems.get(position).getAngkatan()));

    }

    @Override
    public int getItemCount() {
        return anggotaItems.size();
    }

    public class AnggotaViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama;
        TextView tvNim;
        TextView tvTahunAngkatan;

        public AnggotaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama =itemView.findViewById(R.id.tv_nama);
            tvNim =itemView.findViewById(R.id.tv_nim);
            tvTahunAngkatan =itemView.findViewById(R.id.tv_tahun);
        }
    }
}

