package productions.darthplagueis.unit04midassessment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import productions.darthplagueis.unit04midassessment.R;
import productions.darthplagueis.unit04midassessment.fragment.TopFragment;
import productions.darthplagueis.unit04midassessment.model.Book;

/**
 * Created by oleg on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout linearLayout;
    private TextView textView;
    private Context context;

    public BookViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.bottom_frag_linear);
        textView = (TextView) itemView.findViewById(R.id.bottom_frag_textview);
        context = itemView.getContext();
    }

    public void onBind(final Book book) {
        textView.setText(book.getTitle());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopFragment topFragment = new TopFragment();
                FragmentManager fragmentManagerTop = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransactionTop = fragmentManagerTop.beginTransaction();

                Bundle bundle = new Bundle();
                String titleContents = book.getTitle();
                String authorContents = book.getAuthor();
                String yearContents = String.valueOf(book.getYear());

                bundle.putString("title", titleContents);
                bundle.putString("author", authorContents);
                bundle.putString("year", yearContents);

                topFragment.setArguments(bundle);
                fragmentTransactionTop.replace(R.id.top_frag_container, topFragment);
                fragmentTransactionTop.commit();
            }
        });
    }
}
