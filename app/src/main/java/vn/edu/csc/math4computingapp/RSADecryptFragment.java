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

public class RSADecryptFragment extends Fragment {
    EditText txtCodedChar, txtN, txtD;
    Button btnDecrypt;
    TextView txtDecryption;

    public RSADecryptFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rsadecrypt, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtCodedChar =view.findViewById(R.id.txtCodedChar);
        txtN = view.findViewById(R.id.txtN);
        txtD = view.findViewById(R.id.txtD);
        btnDecrypt = view.findViewById(R.id.btnDecrypt);
        txtDecryption = view.findViewById(R.id.txtDecryption);

        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int codedChar = Integer.parseInt(txtCodedChar.getText().toString());
                    int n = Integer.parseInt(txtN.getText().toString());
                    int d = Integer.parseInt(txtD.getText().toString());

                    RSADecryptObject rsaDecryptObject = RSADecryptObject.decryptRSA(codedChar,n,d);
                    txtDecryption.setText(rsaDecryptObject.toString());
                }catch (Exception e){
                    txtDecryption.setText("Hi, I'm an error :)");
                }

            }
        });
    }
}
