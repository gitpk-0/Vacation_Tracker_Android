package wgu.patrick_kell_d308.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wgu.patrick_kell_d308.Entities.Vacation;
import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class VacationAdapter extends RecyclerView.Adapter<VacationAdapter.VacationViewHolder> {


    class VacationViewHolder extends RecyclerView.ViewHolder {
        private final TextView vacationItemView;

        // view holder constructor
        public VacationViewHolder(View itemView) {
            super(itemView);
            vacationItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Vacation current = mVacations.get(position);

                    Intent vacationDetails = new Intent(context, VacationDetails.class);
                    vacationDetails.putExtra("id", current.getVacationID());
                    vacationDetails.putExtra("title", current.getVacationTitle());
                    vacationDetails.putExtra("lodging type", current.getLodgingType());
                    vacationDetails.putExtra("start", current.getStartDate());
                    vacationDetails.putExtra("end", current.getEndDate());
                    context.startActivity(vacationDetails);
                }
            });
        }
    }

    private List<Vacation> mVacations;
    private final Context context;
    private final LayoutInflater mInflater; // opens a layout

    // adapter constructor
    public VacationAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new { ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * { #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public VacationAdapter.VacationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.vacation_dashboard_item, parent, false);

        return new VacationViewHolder((itemView));
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the { ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use { ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override { #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VacationAdapter.VacationViewHolder holder, int position) {
        if (mVacations != null) {
            Vacation current = mVacations.get(position);
            String title = current.getVacationTitle();
            holder.vacationItemView.setText(title);
        } else {
            holder.vacationItemView.setText("No Vacation Title");
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mVacations.size();
    }

    public void setVacations(List<Vacation> vacations) {
        mVacations = vacations;
        notifyDataSetChanged();
    }


}
