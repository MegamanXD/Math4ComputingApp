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

public class RSAEncryptFragment extends Fragment {
    EditText txtMessage, txtNEncrypt, txtE;
    Button btnEncrypt;
    TextView txtEncryption;

    public RSAEncryptFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rsaencrypt, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtE = view.findViewById(R.id.txtE);
        txtEncryption = view.findViewById(R.id.txtEncryption);
        txtMessage = view.findViewById(R.id.txtMessage);
        txtNEncrypt = view.findViewById(R.id.txtNEncrypt);
        btnEncrypt = view.findViewById(R.id.btnEncrypt);

        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String message = txtMessage.getText().toString();
                    int n = Integer.parseInt(txtNEncrypt.getText().toString());
                    int e = Integer.parseInt(txtE.getText().toString());

                    RSAEncryptObject rsaEncryptObject = RSAEncryptObject.encryptRSA(message,n,e);
                    txtEncryption.setText(rsaEncryptObject.toString());
                }catch (Exception e){
                    txtEncryption.setText("Hi, I'm an error :)");
                }
            }
        });
    }
}
