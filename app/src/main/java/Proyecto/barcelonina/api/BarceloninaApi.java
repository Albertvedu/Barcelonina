package Proyecto.barcelonina.api;

import Proyecto.barcelonina.model.BarceloninaResponse;
import Proyecto.barcelonina.model.TourDetail;
import retrofit2.http.GET;
import retrofit2.Call;


public interface BarceloninaApi {
    @GET("bd.json")
    Call<BarceloninaResponse> obtenerTours();

    @GET("{id}")
    Call<TourDetail> obtenerTour(String id);
}
