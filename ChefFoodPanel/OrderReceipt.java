package com.example.sc9.ChefFoodPanel;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.sc9.Chef;
import com.example.sc9.Customer;
import com.example.sc9.CustomerFoodPanel.Cart;
import com.example.sc9.CustomerFoodPanel.UpdateReceiptModel;
import com.example.sc9.CustomerFoodPanel_BottomNavigation;
import com.example.sc9.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class OrderReceipt extends AppCompatActivity {


    String RandomId, CusID;
    ImageView imageView;
    TextView CusName;
    DatabaseReference databaseReference, dataaa, cusdata, reference, data, dataref;
    String Name;
    String chefID;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_receipt);


        CusName = (TextView) findViewById(R.id.cus_name);

        imageView = (ImageView) findViewById(R.id.image);


        final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        dataaa = FirebaseDatabase.getInstance().getReference("Customer").child(userid);
        dataaa.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Chef chef = dataSnapshot.getValue(Chef.class);


                RandomId = getIntent().getStringExtra("Name");
                CusID = getIntent().getStringExtra("CusId");

                databaseReference = FirebaseDatabase.getInstance().getReference("Receipt").child(CusID).child(RandomId);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        UpdateReceiptModel updateReceiptModel = dataSnapshot.getValue(UpdateReceiptModel.class);
                        Glide.with(OrderReceipt.this).load(updateReceiptModel.getImageURL()).into(imageView);

                        cusdata = FirebaseDatabase.getInstance().getReference("Customer").child(CusID);
                        cusdata.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Customer customer = dataSnapshot.getValue(Customer.class);

                                String name = "<b>" + " Name : " + "</b>" + customer.getFirstName();
                                CusName.setText(Html.fromHtml(name));

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


