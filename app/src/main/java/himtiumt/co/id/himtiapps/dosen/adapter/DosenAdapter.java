package himtiumt.co.id.himtiapps.dosen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.model.DosenItem;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenViewHolder> {

    private List<DosenItem> dosenItemList;
    private Context context;

    public DosenAdapter(List<DosenItem> dosenItemList, Context context) {
        this.dosenItemList = dosenItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public DosenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dosen, parent, false);
        return new DosenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DosenViewHolder holder, int position) {

        holder.tvNama.setText(dosenItemList.get(position).getNama());
        holder.tvMataKuliah.setText(dosenItemList.get(position).getMatakuliah());
        holder.tvNoHp.setText(dosenItemList.get(position).getNoHp());

    }

    @Override
    public int getItemCount() {
        return dosenItemList.size();
    }

    public class DosenViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvMataKuliah, tvNoHp;

        public DosenViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.text_namaDosen);
            tvMataKuliah = itemView.findViewById(R.id.text_Matkul);
            tvNoHp = itemView.findViewById(R.id.text_noTelp);
        }
    }
}
