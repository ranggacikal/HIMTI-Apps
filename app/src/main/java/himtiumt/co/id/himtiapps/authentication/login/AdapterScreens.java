package himtiumt.co.id.himtiapps.authentication.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import himtiumt.co.id.himtiapps.R;

public class AdapterScreens extends RecyclerView.Adapter<AdapterScreens.AdapterViewHolder> {

    private List<Item_Screens> item_screens;

    public AdapterScreens(List<Item_Screens> item_screens) {
        this.item_screens = item_screens;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.setOnData(item_screens.get(position));
    }

    @Override
    public int getItemCount() {
        return item_screens.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitle;
        private TextView textDescription;
        private ImageView ImageContainer;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            ImageContainer = itemView.findViewById(R.id.ImageContainer);
        }

        void setOnData(Item_Screens onItem) {
            textTitle.setText((onItem.getTitle()));
            textDescription.setText(onItem.getDescription());
            ImageContainer.setImageResource(onItem.getImage());
        }
    }
}
