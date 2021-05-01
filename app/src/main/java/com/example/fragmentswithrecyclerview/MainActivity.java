package com.example.fragmentswithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ContactSelected {

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAddPerson;
    ListFrag listFrag;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String tel = etTel.getText().toString().trim();
                if(name.isEmpty() || tel.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Name or Phone number is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ContactsData.contacts.add(new Person(name, tel));
                    listFrag.myNotifyDatasetChangedMethod();
                    etName.setText("");
                    etTel.setText("");
                }
            }
        });

        onContactClick(0);
    }

    private void init() {
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAddPerson = findViewById(R.id.btnAddPerson);
        manager = getSupportFragmentManager();
        listFrag = (ListFrag) manager.findFragmentById(R.id.listFragment);
    }

    @Override
    public void onContactClick(int index) {
        tvName.setText(ContactsData.contacts.get(index).getName());
        tvTel.setText(ContactsData.contacts.get(index).getPhone());
    }
}