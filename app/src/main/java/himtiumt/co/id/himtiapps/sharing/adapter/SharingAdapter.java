package himtiumt.co.id.himtiapps.sharing.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.sharing.DetailSharingActivity;
import himtiumt.co.id.himtiapps.sharing.model.JadwalItem;

public class SharingAdapter extends RecyclerView.Adapter<SharingAdapter.SharingViewHolder> {

    private List<JadwalItem> listSharing;
    private Context context;

    public SharingAdapter(List<JadwalItem> listSharing, Context context) {
        this.listSharing = listSharing;
        this.context = context;
    }

    @NonNull
    @Override
    public SharingAdapter.SharingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_sharing, parent, false);
        return new SharingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SharingAdapter.SharingViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvJudul.setText(listSharing.get(position).getTittle());
        holder.tvTanggal.setText(listSharing.get(position).getJadwal());
        Glide.with(context)
                .load(listSharing.get(position).getImage())
                .into(holder.image);
        holder.cvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetailSharingActivity.class);
                detail.putExtra("id", listSharing.get(position).getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSharing.size();
    }

    public class SharingViewHolder extends RecyclerView.ViewHolder{

        private TextView tvJudul, tvTanggal, tvDeskripsi;
        private ImageView image;
        private CardView cvDetail;

        public SharingViewHolder (View view){
            super(view);
            tvJudul = view.findViewById(R.id.tv_judul_sharing);
            tvDeskripsi = view.findViewById(R.id.tv_deskripsi_sharing);
            tvTanggal = view.findViewById(R.id.tv_tanggal_sharing);
            image = view.findViewById(R.id.img_jadwal_sharing);
            cvDetail = view.findViewById(R.id.cv_detail_sharing);

        }
    }
}