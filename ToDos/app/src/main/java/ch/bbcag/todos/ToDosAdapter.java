package ch.bbcag.todos;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ToDosAdapter extends ArrayAdapter<ToDos> {

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

        // Name setzen(aus Titel und Datum)
        TextView title_date = (TextView) convertView.findViewById(R.id.title_date);
        String text = todos.getTitle() + "  " + todos.getDate();
        title_date.setText(text);

        // Ein Klickewent auf der Liste

        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                int toDoId = getItem(position).getId();


                Intent intent;

                // Je nachdem ob das ToDO offen oder zu ist wird ein anderes Activity geladen(da editieren, bearbeiten bei einem geschlossenen ToDO nicht verfügbar ist)
                if (getItem(position).isopen()) {

                    intent = new Intent(getContext(), DetailsActivity.class);
                }
                else{
                    intent = new Intent(getContext(), DetailsActivityClosed.class);
                }

                // Die ID wir dem intent übergeben um die Details des richtigen ToDos zu laden
                intent.putExtra("id", toDoId);
                getContext().startActivity(intent);
            }
        };
        listView.setOnItemClickListener(mListClickedHandler);
        return convertView;
    }

    // Hier werden die Daten refreshed

    public void refreshData() {

        clear();
        addAll(ToDosDAO.getInstance(getContext()).getToDos(context.getIsOpenShown()));
        notifyDataSetChanged();

    }




}
