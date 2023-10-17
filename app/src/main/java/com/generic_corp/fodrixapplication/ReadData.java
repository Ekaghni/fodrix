package com.generic_corp.fodrixapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReadData extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.readData);

        Query query = FirebaseFirestore.getInstance().collection("Documents");
        FirestoreRecyclerOptions<Model> options = new FirestoreRecyclerOptions.Builder<Model>()
                .setQuery(query,Model.class).build();

        adapter = new FirestoreRecyclerAdapter<Model, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photographers_profile_item,parent,false);
                return new ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull Model model) {
//                holder.r_id.setText(model.getPhotographer_Type());
//                holder.r_name.setText(model.getName());
//                holder.r_number.setText(model.getNumber());
                holder.r_name.setText(model.getName());
                holder.r_photographer_type.setText(model.getPhotographer_Type());
                holder.r_rating.setText(model.getRating());
                Picasso.get().load(model.getImage_Url()).into(holder.photographers_image);
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ReadData.this,PhotographerDetails.class);
                        intent.putExtra("name",model.getName());
                        intent.putExtra("type",model.getPhotographer_Type());
                        intent.putExtra("number",model.getNumber());
                        intent.putExtra("description",model.getDescription());
                        intent.putExtra("image",model.getImage_Url());
                        intent.putExtra("rating",model.getRating());
                        startActivity(intent);

                    }
                });


            }
        };
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    private class ProductsViewHolder extends RecyclerView.ViewHolder {
        private TextView r_photographer_type,r_name,r_number,r_rating;
        private CircleImageView photographers_image;
        private CardView cardView;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            r_photographer_type = itemView.findViewById(R.id.tv_photographer_type);
            r_name = itemView.findViewById(R.id.tv_photographer_name);
            r_rating = itemView.findViewById(R.id.tv_photographer_rating);
            photographers_image = itemView.findViewById(R.id.tv_photographer_image);
            cardView = itemView.findViewById(R.id.card_photographer);
            //r_number = itemView.findViewById(R.id.getData_Number);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}