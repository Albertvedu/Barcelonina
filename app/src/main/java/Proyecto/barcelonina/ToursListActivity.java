package Proyecto.barcelonina;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import Proyecto.barcelonina.model.BarceloninaResponse;
import Proyecto.barcelonina.model.Tour;

public class ToursListActivity extends AppCompatActivity {

    TourAdapter tourAdapter;
    MainViewModel mainViewModel;
    List<Tour> tourList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours_list);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.itemList);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));

        tourAdapter = new TourAdapter();
        recyclerView.setAdapter(tourAdapter);

        mainViewModel.obtenerTours().observe(this, new Observer<BarceloninaResponse>() {
            @Override
            public void onChanged(BarceloninaResponse barceloninaResponse) {
                tourList =  barceloninaResponse.tours;
                tourAdapter.notifyDataSetChanged();
            }
        });


    }

    class TourViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc;
        ImageView imageTour;

        TourViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tour_name);
            desc = itemView.findViewById(R.id.tour_desc);
            imageTour = itemView.findViewById(R.id.tour_image);
        }
    }

    class TourAdapter extends RecyclerView.Adapter<TourViewHolder>{

        @NonNull
        @Override
        public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TourViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tour, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull TourViewHolder holder, final int position) {

            final Tour tour = tourList.get(position);

            holder.name.setText(tour.tourName);
            holder.desc.setText(tour.tourDescription);
            Glide.with(ToursListActivity.this).load(tour.tourImage).into(holder.imageTour);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ToursListActivity.this, DetailActivity.class);
                    intent.putExtra("TOUR_ID", tour.tourId);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tourList.size();
        }
    }
}


