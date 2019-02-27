package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit myOneInstance;

    private RetrofitSingleton() {
    }

    public static Retrofit getInstance() {
        if (myOneInstance != null) {
            return myOneInstance;
        }
        myOneInstance = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gist.githubusercontent.com/")
                .build();
        return myOneInstance;
    }
}
