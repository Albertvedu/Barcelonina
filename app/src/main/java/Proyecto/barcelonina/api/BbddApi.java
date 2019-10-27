package Proyecto.barcelonina.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

import Proyecto.barcelonina.Bbdd_Response;

public interface BbddApi {
    @GET("search/")
    Call<Bbdd_Response> buscar(@Query("term") String term);
}
