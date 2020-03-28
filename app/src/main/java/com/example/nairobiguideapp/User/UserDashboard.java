package com.example.nairobiguideapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.nairobiguideapp.HelperClasses.HomeAdapters.FeaturedAdapter;
import com.example.nairobiguideapp.HelperClasses.HomeAdapters.FeaturedHelperClass;
import com.example.nairobiguideapp.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        setFeaturedRecycler();

    }

    private void setFeaturedRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mainstreet, "KenCom's", "This place has several important strategic factors i.e major banks,near Kenyatta avenue and several stages"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mainstreet, "Muthurwa Bus Stop", "Strategic factors i.e major banks,near Kenyatta avenue and several stages"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mainstreet, "OTC's", "Major banks,near Kenyatta avenue and several stages"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }
}
