package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.fragments.DisplayFragment;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.interfaces.FragmentInterface;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.Weave;

public class DisplayActivity extends AppCompatActivity{
    private Weave weave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String texture = intent.getStringExtra("texture");
        String length = intent.getStringExtra("length");
        String color = intent.getStringExtra("color");
        String image = intent.getStringExtra("image");


        DisplayFragment displayFragment = DisplayFragment.newInstance(name, texture, length, color, image);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, displayFragment)
                .addToBackStack(null)
                .commit();

    }

//    @Override
//    public void toDisplayFragment(Weave weave) {
////        DisplayFragment displayFragment = DisplayFragment.newInstance(weave);
////        FragmentManager fragmentManager = getSupportFragmentManager();
////        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////        fragmentTransaction.replace(R.id.main_container, displayFragment)
////                .addToBackStack(null)
////                .commit();
//    }
//
//    @Override
//    public void toDisplayActivity(String name) {
////        Intent intent = new Intent(this, DisplayActivity.class);
////        intent.putExtra("name", name);
////        startActivity(intent);
////        Log.d("test", "isworking" + weave.getColor());
//    }

}
