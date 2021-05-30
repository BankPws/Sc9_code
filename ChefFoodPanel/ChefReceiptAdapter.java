package com.example.sc9.ChefFoodPanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.sc9.CustomerFoodPanel.OrderDish;
import com.example.sc9.CustomerFoodPanel.UpdateReceiptModel;
import com.example.sc9.R;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class ChefReceiptAdapter extends RecyclerView.Adapter<ChefReceiptAdapter.ViewHolder> {


    private Context mcontext;
    private List<UpdateReceiptModel> updateReceiptModellist;
    DatabaseReference databaseReference;

    public ChefReceiptAdapter(Context context, List<UpdateReceiptModel> updateReceiptModellist)
    {
        this.updateReceiptModellist=updateReceiptModellist;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.chef_menu_receipt,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final UpdateReceiptModel updateReceiptModel=updateReceiptModellist.get(position);
        Glide.with(mcontext).load(updateReceiptModel.getImageURL()).into(holder.imageView);
        holder.Name.setText(updateReceiptModel.getOt());
        updateReceiptModel.getRandomUID();
        updateReceiptModel.getCusId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mcontext, OrderReceipt.class);
                intent.putExtra("Name",updateReceiptModel.getRandomUID());
                intent.putExtra("CusId",updateReceiptModel.getCusId());


                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return updateReceiptModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView Name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.menu_image);
            Name=itemView.findViewById(R.id.namee);



        }
    }
}
