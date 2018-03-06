package edu.tectii.eva1_5_to_be_or_not;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {
    View vlayout;
    TextView txtdetalle;

    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         vlayout = inflater.inflate(R.layout.fragment_detalle, container, false);
        txtdetalle = (TextView)vlayout.findViewById(R.id.txtVwDetail);
        return vlayout;
    }
    public void onMsgFromMain(int index) {
        //Evaluamos si la vista es nula evitando un NullPointeException
        if (vlayout != null) {
            txtdetalle.setText(Shakespeare.DIALOGUE[index]);
        }
    }
}
