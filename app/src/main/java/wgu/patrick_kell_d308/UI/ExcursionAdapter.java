package wgu.patrick_kell_d308.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wgu.patrick_kell_d308.Entities.Excursion;
import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class ExcursionAdapter extends RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder> {

    private List<Excursion> mExcursions;
    private final Context context;
    private final LayoutInflater mInflater;

    class ExcursionViewHolder extends RecyclerView.ViewHolder {
        private final Button excursionItemView;

        // view holder constructor
        public ExcursionViewHolder(View itemView) {
            super(itemView);
            excursionItemView = itemView.findViewById(R.id.excursionItem);

            excursionItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Excursion current = mExcursions.get(position);

                    Intent excursionDetails = new Intent(context, ExcursionDetails.class);
                    excursionDetails.putExtra("id", current.getExcursionID());
                    excursionDetails.putExtra("title", current.getExcursionTitle());
                    excursionDetails.putExtra("date", current.getExcursionDate());
                    excursionDetails.putExtra("vid", current.getVacationID());
                    context.startActivity(excursionDetails);
                }
            });
        }
    }

    public ExcursionAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public ExcursionAdapter.ExcursionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.excursion_dashboard_item, parent, false);
        return new ExcursionViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull ExcursionAdapter.ExcursionViewHolder holder, int position) {
        if (mExcursions != null) {
            Excursion current = mExcursions.get(position);
            String title = current.getExcursionTitle();
            holder.excursionItemView.setText(title);
        } else {
            holder.excursionItemView.setText("No Excursion Title");
        }

    }

    @Override
    public int getItemCount() {
        return mExcursions.size();
    }

    public void setExcursions(List<Excursion> excursions) {
        mExcursions = excursions;
        notifyDataSetChanged();
    }
}
