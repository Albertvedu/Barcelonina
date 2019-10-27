package Proyecto.barcelonina;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Proyecto.barcelonina.Model.Bbdd_Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Bbdd_Response> buscar(String term){
        final MutableLiveData<Bbdd_Response> bbdd_Response = new MutableLiveData<>();

        BarceloninaApiModule.barceloninaApi.buscar(term).enqueue(new Callback<Bbdd_Response>() {
            @Override
            public void onResponse(Call<Bbdd_Response> call, Response<Bbdd_Response> response) {

            }

            @Override
            public void onFailure(Call<Bbdd_Response> call, Throwable t) {

            }

            @Override
            public void onResponse(Call<ItunesResponse> call, Response<ItunesResponse> response) {
                itunesResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ItunesResponse> call, Throwable t) {}
        });

        return itunesResponse;
    }
}