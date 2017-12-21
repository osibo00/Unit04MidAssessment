package productions.darthplagueis.unit04midassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import productions.darthplagueis.unit04midassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    private View rootView;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_display, container, false);

        BottomFragment bottomFragment = new BottomFragment();
        FragmentManager fragmentManagerBottom = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBottom = fragmentManagerBottom.beginTransaction();
        fragmentTransactionBottom.replace(R.id.bottom_frag_container, bottomFragment);
        fragmentTransactionBottom.commit();

        return rootView;
    }

}
