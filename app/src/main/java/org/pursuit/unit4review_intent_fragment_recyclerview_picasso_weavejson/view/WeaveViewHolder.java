package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.DisplayActivity;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.R;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.interfaces.FragmentInterface;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.Weave;

public class WeaveViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private FragmentInterface fragmentInterface;


    public WeaveViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.name_text_view);
    }

    public void onBind(final Weave weave, final FragmentInterface fragmentInterface){
        nameTextView.setText(weave.getName());
        //this.fragmentInterface = fragmentInterface;
       // Log.d("test", "isworking" + weave.getName());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
//                intent.putExtra("weaves", weave.getName());
//                v.getContext().startActivity(intent);
                Log.d("test", "isworking" + weave.getColor());


                 //fragmentInterface.toDisplayActivity(weave.getName(), weave.getTexture(), weave.getLength(), weave.getColor(), weave.getImage());
                fragmentInterface.toDisplayActivity(weave);


            }
        });
    }
}
