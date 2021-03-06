package com.example.dijonkariz.washme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dijonkariz.washme.Model.Service;

import java.util.List;

public class ServiceViewAdapter  extends RecyclerView.Adapter<ServiceViewAdapter.ServiceViewHolder>
{
    private Context mContext;
    private List<Service> itemList;

    public class ServiceViewHolder extends RecyclerView.ViewHolder
    {
        public TextView service_name, price, duration, details;
        CardView cardView;

        public ServiceViewHolder(View view)
        {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardview_services);
            service_name = (TextView) view.findViewById(R.id.service_name);
            price = (TextView) view.findViewById(R.id.service_price);
            duration = (TextView) view.findViewById(R.id.duration);
            details = (TextView) view.findViewById(R.id.service_details);
        }
    }
    public ServiceViewAdapter(Context mContext, List<Service> itemList)
    {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ServiceViewAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.services, parent, false);
        return new ServiceViewAdapter.ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewAdapter.ServiceViewHolder holder, int position) {
        Service item = itemList.get(position);
        holder.service_name.setText(item.getServiceName());
        holder.price.setText(item.getPrice());
        holder.duration.setText(item.getDuration());
        holder.details.setText(item.getDetails());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.txt_service_toast, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, finishBooking.class);
//                intent.putExtra("Vehicle_id", itemList.get(position).getId());
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
