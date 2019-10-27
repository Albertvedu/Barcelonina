package Proyecto.barcelonina;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.ImageView;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Query;

import java.util.List;

public class ToursList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours_list);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation()));

        //recyclerView.setAdapter();
    }

}



