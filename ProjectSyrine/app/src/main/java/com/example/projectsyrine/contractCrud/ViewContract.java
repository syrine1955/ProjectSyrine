package com.example.projectsyrine.contractCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.projectsyrine.Entites.Contrat;
import com.example.projectsyrine.R;
import com.example.projectsyrine.hundlers.ContractDBHundler;

import java.util.ArrayList;

public class ViewContract extends AppCompatActivity {

    private ArrayList<Contrat> contractModalArrayList;
    private ContractDBHundler dbHandler;
    private ListView contractRV;
    private Button AddContracBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contract);
        dbHandler = new ContractDBHundler(ViewContract.this);
        contractModalArrayList = dbHandler.readContracts();
        ArrayAdapter<Contrat> adapter = new ArrayAdapter<Contrat>(this,
                android.R.layout.simple_list_item_1, contractModalArrayList);
        contractRV = findViewById(R.id.list_view);
        contractRV.setAdapter(adapter);
        AddContracBtn = findViewById(R.id.idBtnAddContract);
        AddContracBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewContract.this, AddContract.class);
                startActivity(i);
            }
        });
    }
}