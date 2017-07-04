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

    // Hier wird das startActivity instanziert
    //StartActivity startActvity = new StartActivity();
    StartActivity context;

    public ToDosAdapter(Context context) {
        super(context, R.layout.todos_list_item);
        this.context = (StartActivity)context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ToDos todos = getItem(position);

        // Hier wird gecheckt ob ein View existiert
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
                ToDosDAO.getInstance(getContext()).closeToDo(position);
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

    // Hier werden die Daten refreshd

    public void refreshData() {
        clear();
        addAll(ToDosDAO.getInstance(getContext()).getToDos(context.getIsOpenShown()));
        notifyDataSetChanged();
    }




}
