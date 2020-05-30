package com.aa183.candra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListHolder> {
    private List<ModelList> items;
    private Context mContext;
    private ListAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(ModelList mdlList);
    }

    public ListAdapter(Context context, List<ModelList> items, ListAdapter.onSelectData onSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = onSelectData;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_musik, parent, false);
        return new ListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        final ModelList data = items.get(position);
        holder.tvJudul.setText("Judul : " + items.get(position).getJdlMsk());
        holder.tvPenyayi.setText("Penyanyi : " +items.get(position).getPenyanyi());
        holder.tvTahun.setText("Tahun : " +items.get(position).getThnMsk());

        holder.cvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
