package vn.edu.csc.math4computingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.menu);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.decimal).setText("To dec"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.binary).setText("To bin"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.encrypt).setText("Encrypt"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.decrypt).setText("Decrypt"));

        showFragment(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                showFragment(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void showFragment(int position){
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new BinaryToDecimalFragment();
                break;
            case 1:
                fragment = new DecimalToBinaryFragment();
                break;
            case 2:
                fragment = new RSAEncryptFragment();
                break;
            case 3:
                fragment = new RSADecryptFragment();
            default:
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);
        fragmentTransaction.commit();

    }
}
