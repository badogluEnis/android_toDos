package ch.bbcag.todos;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ListView listView = (ListView) parent.findViewById(R.id.listview);
        final ToDos todos = getItem(position);

        // Hier wird gecheckt ob ein View existiert
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todos_list_item, parent, false);
        }

        // Name setzen
        TextView title_date = (TextView) convertView.findViewById(R.id.title_date);
        String text = todos.getTitle() + "  " + todos.getDate();
        title_date.setText(text);

        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                int toDoId = getItem(position).getId();
                intent.putExtra("id", toDoId);
                getContext().startActivity(intent);
            }
        };
        listView.setOnItemClickListener(mListClickedHandler);
        return convertView;
    }

    // Hier werden die Daten refreshd

    public void refreshData() {

        clear();
        addAll(ToDosDAO.getInstance(getContext()).getToDos(context.getIsOpenShown()));
        notifyDataSetChanged();

    }




}
