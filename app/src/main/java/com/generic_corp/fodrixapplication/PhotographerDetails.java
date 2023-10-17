package com.generic_corp.fodrixapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PhotographerDetails extends AppCompatActivity {
    String name, number,description,type,profile_pic,rating;
    TextView name_pd, service_pd, description_pd, rating_pd;
    Button contact_now_pd;
    ImageView profile_pic_pd;
    String message_string, phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer_details);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        number = intent.getStringExtra("number");
        description = intent.getStringExtra("description");
        type = intent.getStringExtra("type");
        profile_pic = intent.getStringExtra("image");
        rating = intent.getStringExtra("rating");

        name_pd = findViewById(R.id.textView_pd_name);
        service_pd = findViewById(R.id.textView_pd_service);
        description_pd = findViewById(R.id.textView_pd_service);
        rating_pd = findViewById(R.id.textView_pd_rating);
        profile_pic_pd = findViewById(R.id.pd_profile_image);
        contact_now_pd = findViewById(R.id.pd_contact_now);

        name_pd.setText(name);
        description_pd.setText(description);
        service_pd.setText(type);
        rating_pd.setText(rating);
        Picasso.get().load(profile_pic).into(profile_pic_pd);
        message_string = "I%20would%20like%20to%20know%20details%20for%20photography%20services%20provided%20by%20"+name+".Type%20is%20"+type;
        phone_number = "+917020147576";
        contact_now_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isWhatsappInstalled()){
                String finalStr = "https://api.whatsapp.com/send?phone="+phone_number+"&text="+message_string;
                System.out.println("stringggg--->"+finalStr);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+phone_number+"&text="+message_string));
                    startActivity(i);
                //}
                //else {
                    //Toast.makeText(PhotographerDetails.this, "Please Install Whatsapp to contact photographer", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
    private boolean isWhatsappInstalled(){
        PackageManager packageManager = getPackageManager();
        boolean whatsappInstalled;
        try {
            packageManager.getPackageInfo("com.whatsapp",PackageManager.GET_ACTIVITIES);
            whatsappInstalled = true;
        }catch (PackageManager.NameNotFoundException e){
            whatsappInstalled = false;
        }
        return whatsappInstalled;
    }
}