package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.fragments;


import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.R;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.interfaces.FragmentInterface;
import org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model.Weave;

public class DisplayFragment extends Fragment {

    public static final String WEAVE_NAME = "name";
    public static final String WEAVE_TEXTURE = "texture";
    public static final String WEAVE_LENGTH = "length";
    public static final String WEAVE_COLOR = "color";
    public static final String WEAVE_IMAGE = "image";


    private String name;
    private String texture;
    private String length;
    private String color;
    private String image;

    private TextView nameTextView;
    private TextView textureTextView;
    private TextView lengthTextView;
    private TextView colorTextView;
    private ImageView imageImageView;


    public DisplayFragment() {
        // Required empty public constructor
    }


    public static DisplayFragment newInstance(String name, String texture, String length, String color, String image) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(WEAVE_NAME, name);
        args.putString(WEAVE_TEXTURE, texture);
        args.putString(WEAVE_LENGTH, length);
        args.putString(WEAVE_COLOR,color);
        args.putString(WEAVE_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(WEAVE_NAME);
            texture = getArguments().getString(WEAVE_TEXTURE);
            length = getArguments().getString(WEAVE_LENGTH);
            color = getArguments().getString(WEAVE_COLOR);
            image = getArguments().getString(WEAVE_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameTextView = view.findViewById(R.id.fragment_name_text_view);
        textureTextView = view.findViewById(R.id.fragment_texture_text_view);
        lengthTextView = view.findViewById(R.id.fragment_length_text_view);
        colorTextView = view.findViewById(R.id.fragment_color_text_view);
        imageImageView = view.findViewById(R.id.fragment_image_image_view);

        nameTextView.setText(name);
        textureTextView.setText(texture);
        lengthTextView.setText(length);
        colorTextView.setText(color);
        Picasso.get().load(image).into(imageImageView);
    }
}
