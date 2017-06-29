package ch.bbcag.todos;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class ToDosAdapter extends ArrayAdapter<ToDos> {

    StartActvity startActvity = new StartActvity();


    public ToDosAdapter(Context context) {
        super(context, R.layout.todos_list_item);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ToDos todos = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todos_list_item, parent, false);
        }

        // Name setzen
        TextView title_date = (TextView) convertView.findViewById(R.id.title_date);
        String text = todos.getTitle() + "  " + todos.getDate();
        title_date.setText(text);


        // Action zu Button hinzufügen
        Button doneButton = (Button) convertView.findViewById(R.id.mark_done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDosDAO.getInstance(getContext()).updateIsOpen(position);
                refreshData();
            }
        });

        Button deleteButton = (Button) convertView.findViewById(R.id.mark_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDosDAO.getInstance(getContext()).deleteToDo(position);
                refreshData();
            }
        });

        return convertView;
    }

    public void refreshData() {
        clear();
        addAll(ToDosDAO.getInstance(getContext()).getToDos(startActvity.getIsOpenShown()));
        notifyDataSetChanged();
    }




}
