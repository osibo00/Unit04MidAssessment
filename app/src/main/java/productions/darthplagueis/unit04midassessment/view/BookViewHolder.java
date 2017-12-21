package productions.darthplagueis.unit04midassessment.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import productions.darthplagueis.unit04midassessment.R;
import productions.darthplagueis.unit04midassessment.model.Book;

/**
 * Created by oleg on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout linearLayout;
    private TextView textView;

    public BookViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.bottom_frag_linear);
        textView = (TextView) itemView.findViewById(R.id.bottom_frag_textview);
    }

    public void onBind(Book book) {
        textView.setText(book.getTitle());
    }
}
