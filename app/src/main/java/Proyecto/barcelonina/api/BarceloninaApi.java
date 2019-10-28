package Proyecto.barcelonina.api;

import Proyecto.barcelonina.model.BarceloninaResponse;
import retrofit2.http.GET;
import retrofit2.Call;


public interface BarceloninaApi {
    @GET("bd.json")
    Call<BarceloninaResponse> obtenerTours();
}
