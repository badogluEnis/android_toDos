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


public class ToDosAdapter extends ArrayAdapter<ClipData.Item> {


    public ToDosAdapter(Context context) {
        super(context, R.layout.todos_list_item);
    }
    private Integer isopen = 1;

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ClipData.Item item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todos_list_item, parent, false);
        }

        // Name setzen
        TextView nameView = (TextView) convertView.findViewById(R.id.name);
        nameView.setText(item.getName());
        nameView.setPaintFlags(item.isDone() ? Paint.STRIKE_THRU_TEXT_FLAG : 0);

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
        addAll(ToDosDAO.getInstance(getContext()).getToDos(isopen));
        notifyDataSetChanged();
    }




}
