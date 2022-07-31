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

    private List<ItemScreens> item_screens;

    public AdapterScreens(List<ItemScreens> item_screens) {
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
        private ImageView imageContainer;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.TextTitle);
            textDescription = itemView.findViewById(R.id.TextDescription);
            imageContainer = itemView.findViewById(R.id.ImageContainer);
        }

        void setOnData(ItemScreens onItem) {
            textTitle.setText((onItem.getTitle()));
            textDescription.setText(onItem.getDescription());
            imageContainer.setImageResource(onItem.getImage());
        }
    }
}
