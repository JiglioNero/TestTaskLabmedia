package com.example.testtasklabmedia.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.testtasklabmedia.R;

public class AnswerCardFragment extends Fragment {

    public static final String IS_ANSWER = "isAnswer";
    public static final String TEXT = "text";

    private boolean isAnswer;
    private boolean isBlocked;
    private String text;

    private ConstraintLayout button;
    private CardView playerIndicator;
    private CardView enemyIndicator;

    private OnFragmentInteractionListener mListener;

    public AnswerCardFragment() {
        // Required empty public constructor
    }

    public static AnswerCardFragment newInstance(boolean isAnswer, String text) {
        AnswerCardFragment fragment = new AnswerCardFragment();
        Bundle args = new Bundle();
        args.putBoolean(IS_ANSWER, isAnswer);
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isAnswer = getArguments().getBoolean(IS_ANSWER);
            text = getArguments().getString(TEXT);
            isBlocked = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_card, container, false);

        button = view.findViewById(R.id.button);
        playerIndicator = view.findViewById(R.id.player_indicator);
        enemyIndicator = view.findViewById(R.id.enemy_indicator);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isBlocked) {
                    playerIndicator.setVisibility(View.VISIBLE);

                    if (!isAnswer) {
                        button.setForeground(getResources().getDrawable(R.drawable.blink_white, null));
                    }

                    Bundle res = new Bundle();
                    res.putBoolean(IS_ANSWER, isAnswer);
                    mListener.onFragmentInteraction(res);
                }
            }
        });


        TextView Btext = view.findViewById(R.id.button_text);
        Btext.setText(text);

        return view;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void endOfSelect() {
        if (isAnswer) {
            button.setBackgroundResource(R.drawable.border_radius_all_15_green);
        }
        isBlocked = true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Bundle bundle);
    }
}
