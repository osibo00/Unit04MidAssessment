package productions.darthplagueis.unit04midassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import productions.darthplagueis.unit04midassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private View rootView;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootView.findViewById(R.id.mainfrag_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayFragment displayFragment = new DisplayFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, displayFragment).addToBackStack("display");
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

}
