package com.clientsbox.ipos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.clientsbox.ipos.adapter.CustomGrid;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SuperAwesomeCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    @InjectView(R.id.textView)
    TextView textView;

    private int position;

    GridView grid;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Pinterest",
            "Quora",
            "Twitter",
            "Vimeo",
            "WordPress",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    } ;
    int[] imageId = {
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger
    };

    public static SuperAwesomeCardFragment newInstance(int position) {
        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card,container,false);
        ButterKnife.inject(this, rootView);

        CustomGrid adapter = new CustomGrid(container.getContext(), web, imageId);
        GridView grid = (GridView) rootView.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(container.getContext(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });

        ViewCompat.setElevation(rootView,50);
        textView.setText("CARD "+position);
        return rootView;
    }
}