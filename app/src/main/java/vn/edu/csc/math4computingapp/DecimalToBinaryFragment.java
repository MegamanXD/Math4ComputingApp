package vn.edu.csc.math4computingapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecimalToBinaryFragment extends Fragment {
    EditText txtDecimal1;
    TextView txtBinary1;
    Button btnConvertDecimal;


    public DecimalToBinaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_decimal_to_binary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtBinary1 = view.findViewById(R.id.txtDecryption);
        txtDecimal1 = view.findViewById(R.id.txtGroupDecimal);
        btnConvertDecimal = view.findViewById(R.id.btnDecrypt);

        btnConvertDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int decimal = Integer.parseInt(txtDecimal1.getText().toString());
                    BinaryObject binaryObject = BinaryObject.convertDecimal(decimal);

                    txtBinary1.setText(String.valueOf(binaryObject.toString()));
                } catch (Exception e){
                    txtBinary1.setText("Hi, I'm an error :)");
                }

            }
        });
    }
}
