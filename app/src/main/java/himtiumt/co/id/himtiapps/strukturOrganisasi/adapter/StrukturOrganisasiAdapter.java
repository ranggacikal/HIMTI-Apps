package himtiumt.co.id.himtiapps.strukturOrganisasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.PengurusItem;

public class StrukturOrganisasiAdapter extends RecyclerView.Adapter<StrukturOrganisasiAdapter.StrukturViewHolder> {

    private Context context;
    private List<PengurusItem> pengurusItems;

    public StrukturOrganisasiAdapter(Context context, List<PengurusItem> pengurusItems) {
        this.context = context;
        this.pengurusItems = pengurusItems;
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
        holder.tvSnama.setText(pengurusItems.get(position).getNama());
        holder.tvSnim.setText(pengurusItems.get(position).getNim());
        holder.tvSjabatan.setText(pengurusItems.get(position).getJabatan());

    }

    @Override
    public int getItemCount() {
        return pengurusItems.size();
    }

    public class StrukturViewHolder extends RecyclerView.ViewHolder {

        TextView tvSnama;
        TextView tvSnim;
        TextView tvSjabatan;

        public StrukturViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSnama = itemView.findViewById(R.id.tv_struktur_nama);
            tvSnim = itemView.findViewById(R.id.tv_struktur_nim);
            tvSjabatan = itemView.findViewById(R.id.tv_jabatan);
        }
    }
}
