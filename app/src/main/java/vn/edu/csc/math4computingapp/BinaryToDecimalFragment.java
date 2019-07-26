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

public class BinaryToDecimalFragment extends Fragment {
    EditText txtBinary;
    TextView txtDecimal;
    Button btnConvertBinary;

    public BinaryToDecimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_binary_to_decimal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtBinary = view.findViewById(R.id.txtBinary);
        txtDecimal = view.findViewById(R.id.txtGroupDecimal);
        btnConvertBinary = view.findViewById(R.id.btnConvertBinary);

        btnConvertBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String binary = txtBinary.getText().toString();
                    DecimalObject decimalObject = DecimalObject.convertBinary(binary);

                    txtDecimal.setText(String.valueOf(decimalObject.toString()));
                }catch (Exception e){
                    txtDecimal.setText("Hi, I'm an error :)");
                }

            }
        });
    }
}
