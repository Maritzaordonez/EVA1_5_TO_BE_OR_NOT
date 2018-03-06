package edu.tectii.eva1_5_to_be_or_not;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {
    Principal ppPrinci;
    ListView lsttitulos;
    View view;
    Context context;
    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ppPrinci = (Principal)getActivity();
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lista, container, false);
        ListView lsttitulos= (ListView)view.findViewById(R.id.lsttitulos);
        ArrayAdapter <String> aaShakes = new ArrayAdapter<String>(ppPrinci, android.R.layout.simple_list_item_1, Shakespeare.TITLES);

        lsttitulos.setAdapter(aaShakes);
        lsttitulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                ppPrinci.onMsgFromFragToMain("TITU",i);
                Toast.makeText(ppPrinci,Shakespeare.TITLES[i],Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
