package productions.darthplagueis.unit04midassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import productions.darthplagueis.unit04midassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private View rootView;
    private TextView titleText, authorText, yearText;


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_top, container, false);
        titleText = (TextView) rootView.findViewById(R.id.top_frag_title);
        authorText = (TextView) rootView.findViewById(R.id.top_frag_author);
        yearText = (TextView) rootView.findViewById(R.id.top_frag_year);

        Bundle bundle = getArguments();
        String title = bundle.getString("title", "");
        String author = bundle.getString("author", "");
        String year = bundle.getString("year", "");

        titleText.setText(title);
        authorText.setText(author);
        yearText.setText(year);

        return rootView;
    }

}
