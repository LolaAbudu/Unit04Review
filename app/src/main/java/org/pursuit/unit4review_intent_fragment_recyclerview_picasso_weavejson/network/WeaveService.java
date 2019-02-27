package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.network;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.WeaveList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeaveService {

    @GET("LolaAbudu/70581964617aa2d48e68bfa725167691/raw/73884cf7d4c331a23c82feeb178a2cf4b8937f7d/weave.json")
    Call<WeaveList> getWeaves();
}
