package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.controller.WeaveAdapter;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.interfaces.FragmentInterface;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.Weave;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.WeaveList;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.network.RetrofitSingleton;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.network.WeaveService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    private FragmentInterface fragmentInterface;
    private RecyclerView recyclerView;
    private WeaveAdapter weaveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

//        if (context instanceof FragmentInterface) {
//            fragmentInterface = (FragmentInterface) context;
//        }
        //weaveAdapter = new WeaveAdapter(new ArrayList<Weave>(), fragmentInterface);


        Retrofit retrofit = RetrofitSingleton.getInstance();
        WeaveService weaveService = retrofit.create(WeaveService.class);
        Call<WeaveList> weaveCall = weaveService.getWeaves();
        weaveCall.enqueue(new Callback<WeaveList>() {
            @Override
            public void onResponse(Call<WeaveList> call, Response<WeaveList> response) {
                List<Weave> weaveList = response.body().getWeaves();
                Log.d("TAG", "onResponse " + response.body().getWeaves().get(2).getName());

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                weaveAdapter = new WeaveAdapter(weaveList, fragmentInterface);
                //weaveAdapter.setAdapterList(weaveList);
                recyclerView.setAdapter(weaveAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onFailure(Call<WeaveList> call, Throwable t) {
                Log.d("TAG", "onFailure" + t.toString());
            }
        });
    }

    @Override
    public void toDisplayActivity(Weave weave) {
        Log.d("testing", "isWorking" + weave.getName());

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("name", weave.getName());
        intent.putExtra("texture", weave.getTexture());
        intent.putExtra("length", weave.getLength());
        intent.putExtra("color", weave.getColor());
        intent.putExtra("image", weave.getImage());
        startActivity(intent);
        //Log.d("test", "texture" + weave.getTexture());
    }


//    @Override
//    public void toDisplayFragment(Weave weave) {
//
//    }

//    @Override
//    public void toDisplayActivity(String name, String texture, String length, String color, String image) {
//        Log.d("testing", "isWorking" + name);
//
//        Intent intent = new Intent(this, DisplayActivity.class);
//        intent.putExtra("name", name);
//        intent.putExtra("texture", texture);
//        intent.putExtra("length", length);
//        intent.putExtra("color", color);
//        intent.putExtra("image", image);
//        startActivity(intent);
//        Log.d("test", "isworking" + name);
//    }
}
