package Proyecto.barcelonina.api;

import Proyecto.barcelonina.BarceloninaApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarceloninaApiModule {

    public static BarceloninaApi itunesApi = new Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Albertvedu/Barcelonina_BBDD/master/bd.json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BarceloninaApi.class);

}
