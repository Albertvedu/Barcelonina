package Proyecto.barcelonina;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Proyecto.barcelonina.model.BarceloninaResponse;
import Proyecto.barcelonina.api.BarceloninaApiModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<BarceloninaResponse> obtenerTours(){
        final MutableLiveData<BarceloninaResponse> apiResponse = new MutableLiveData<>();

        BarceloninaApiModule.barceloninaApi.obtenerTours().enqueue(new Callback<BarceloninaResponse>() {
            @Override
            public void onResponse(Call<BarceloninaResponse> call, Response<BarceloninaResponse> response) {
                apiResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BarceloninaResponse> call, Throwable t) {
            }
        });

        return apiResponse;
    }
}