package productions.darthplagueis.unit04midassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.unit04midassessment.R;
import productions.darthplagueis.unit04midassessment.controller.BookAdapter;
import productions.darthplagueis.unit04midassessment.model.Book;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    private View rootView;


    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bottom, container, false);

        JSONObject books = new JSONObject();
        try {
            books.put("book",
                    new JSONArray()
                            .put(new JSONObject()
                                    .put("title", "Northanger Abbey")
                                    .put("author", "Austen, Jane")
                                    .put("year", 1814)
                            )
                            .put(new JSONObject()
                                    .put("title", "War and Peace")
                                    .put("author", "Tolstoy, Leo")
                                    .put("year", 1865)
                            )
                            .put(new JSONObject()
                                    .put("title", "Anna Karenina")
                                    .put("author", "Tolstoy, Leo")
                                    .put("year", 1875)
                            )
                            .put(new JSONObject()
                                    .put("title", "Mrs. Dalloway")
                                    .put("author", "Woolf, Virginia")
                                    .put("year", 1925)
                            )
                            .put(new JSONObject()
                                    .put("title", "The Hours")
                                    .put("author", "Cunnningham, Michael")
                                    .put("year", 1999)
                            )
                            .put(new JSONObject()
                                    .put("title", "Huckleberry Finn")
                                    .put("author", "Twain, Mark")
                                    .put("year", 1865)
                            )
                            .put(new JSONObject()
                                    .put("title", "Bleak House")
                                    .put("author", "Dickens, Charles")
                                    .put("year", 1870)
                            )
                            .put(new JSONObject()
                                    .put("title", "Tom Sawyer")
                                    .put("author", "Twain, Mark")
                                    .put("year", 1862)
                            )
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonString = books.toString();

        List<Book> bookList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("book");

            for (int i = 0; i < jsonArray.length(); i++) {
                Book book = new Book();

                JSONObject obj = (JSONObject) jsonArray.get(i);

                book.setTitle(obj.getString("title"));
                book.setAuthor(obj.getString("author"));
                book.setYear(obj.getInt("year"));
                bookList.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView bottomRecycler = (RecyclerView) rootView.findViewById(R.id.bottom_frag_recycler);
        bottomRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        bottomRecycler.setAdapter(new BookAdapter(bookList));
        return rootView;
    }

}
