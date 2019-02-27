package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.R;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.interfaces.FragmentInterface;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.Weave;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.view.WeaveViewHolder;

import java.util.List;

public class WeaveAdapter extends RecyclerView.Adapter<WeaveViewHolder> {
    private List<Weave> weaveList;
    private FragmentInterface fragmentInterface;

    public WeaveAdapter(@NonNull List<Weave> weaveList, FragmentInterface fragmentInterface){
        this.weaveList = weaveList;
        this.fragmentInterface = fragmentInterface;
    }

//    public void setAdapterList(List<Weave> weaveList){
//        this.weaveList = weaveList;
//
//        //telling the constructor that i got the information
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public WeaveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.weave_itemview, parent, false);
        return new WeaveViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaveViewHolder weaveViewHolder, int position) {
        weaveViewHolder.onBind(weaveList.get(position), fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return weaveList.size();
    }
}
