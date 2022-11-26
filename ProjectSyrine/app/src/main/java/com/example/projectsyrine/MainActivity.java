package com.example.projectsyrine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectsyrine.clientCrud.ViewClient;
import com.example.projectsyrine.contractCrud.ViewContract;
import com.example.projectsyrine.hundlers.ClientDBHundler;
import com.example.projectsyrine.hundlers.ContractDBHundler;

public class MainActivity extends AppCompatActivity {

    private Button readClientBtn,readContractBtn;
    ContractDBHundler CCDB;
    ClientDBHundler CDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readClientBtn = findViewById(R.id.btnListClients);
        readContractBtn = findViewById(R.id.btnListCtr);
        CCDB = new ContractDBHundler(MainActivity.this);
        CDB = new ClientDBHundler(MainActivity.this);

        readClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewClient.class);
                startActivity(i);
            }
        });
        readContractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewContract.class);
                startActivity(i);
            }
        });
    }

}