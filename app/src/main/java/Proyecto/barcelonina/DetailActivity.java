package Proyecto.barcelonina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Proyecto.barcelonina.model.Tour;
import Proyecto.barcelonina.model.TourDetail;

import static android.media.CamcorderProfile.get;

public class DetailActivity extends AppCompatActivity {

    TextView textViewNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String tourId = getIntent().getStringExtra("TOUR_ID");

        ViewModelProviders.of(this).get(MainViewModel.class).obtenerTour(tourId).observe(this, new Observer<TourDetail>() {
            @Override
            public void onChanged(TourDetail tourDetail) {
                textViewNombre.setText(tourDetail.tourName);

            }
        });

    }
}
