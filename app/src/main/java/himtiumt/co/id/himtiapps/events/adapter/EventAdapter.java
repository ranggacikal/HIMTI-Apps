package himtiumt.co.id.himtiapps.events.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import himtiumt.co.id.himtiapps.R;
import himtiumt.co.id.himtiapps.events.DetailEventActivity;
import himtiumt.co.id.himtiapps.events.model.DataArtikelItem;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    private List<DataArtikelItem> listEvent;
    private Context context;

    public EventAdapter(List<DataArtikelItem> listEvent, Context context) {
        this.listEvent = listEvent;
        this.context = context;
    }

    @NonNull
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_event_himti, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.tvJudulEvent.setText(listEvent.get(position).getTittle());
        holder.tvTanggalEvent.setText(listEvent.get(position).getJadwal());
        holder.tvDeskripsi.setText(listEvent.get(position).getDeskripsi());
        Glide.with(context)
                .load(listEvent.get(position).getImage())
                .into(holder.image);
        holder.rlDetailEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetailEventActivity.class);
                detail.putExtra("id", listEvent.get(position).getId());
                detail.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(detail);
            }
        });

    }

    @Override
    public int getItemCount() { return listEvent.size();}

    public class EventViewHolder extends RecyclerView.ViewHolder {

        private TextView tvJudulEvent, tvTanggalEvent, tvDeskripsi;
        private ImageView image, imgDetail;
        private RelativeLayout rlDetailEvent;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudulEvent = itemView.findViewById(R.id.tv_judul_event);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi_event);
            tvTanggalEvent = itemView.findViewById(R.id.tv_tanggal_event);
            image = itemView.findViewById(R.id.img_jadwal_event);
            rlDetailEvent = itemView.findViewById(R.id.rl_detail_event);
            imgDetail = itemView.findViewById(R.id.imgToDetilEvent);
        }
    }
}
