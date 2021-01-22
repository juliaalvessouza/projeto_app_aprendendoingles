package com.example.aprendendoingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendendoingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{
    private ImageButton buttonCachoro, buttonGato, buttonMacaco,
                        buttonVaca, buttonOvelha, buttonLeao;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        buttonCachoro = view.findViewById(R.id.buttonCachorro);
        buttonGato = view.findViewById(R.id.buttonGato);
        buttonLeao = view.findViewById(R.id.buttonLeao);
        buttonOvelha = view.findViewById(R.id.buttonOvelha);
        buttonVaca = view.findViewById(R.id.buttonVaca);
        buttonMacaco = view.findViewById(R.id.buttonMacaco);

        buttonCachoro.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);

    return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCachorro :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                executaSom();
                break;
            case R.id.buttonGato :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                executaSom();
                break;
            case R.id.buttonLeao :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                executaSom();
                break;
            case R.id.buttonOvelha :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                executaSom();
                break;
            case R.id.buttonVaca :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                executaSom();
                break;
            case R.id.buttonMacaco :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                executaSom();
                break;

        }
//        Log.i("Elemento Clicado", "Item: " + v.getId());

    }

    public void executaSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}