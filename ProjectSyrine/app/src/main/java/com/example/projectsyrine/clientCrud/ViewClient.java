package com.example.projectsyrine.clientCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.projectsyrine.Entites.Client;
import com.example.projectsyrine.R;
import com.example.projectsyrine.hundlers.ClientDBHundler;

import java.util.ArrayList;

public class ViewClient extends AppCompatActivity {

    private ArrayList<Client> clientModalArrayList;
    private ClientDBHundler dbHandler;
    private ListView clientRV;
    private Button AddClientBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_client);
        dbHandler = new ClientDBHundler(ViewClient.this);
        clientModalArrayList = dbHandler.readClients();
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, clientModalArrayList);
        clientRV = findViewById(R.id.list_view);
        clientRV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Intent i = new Intent(ViewClient.this, UpdateClient.class);
                Client c = (Client)parent.getItemAtPosition(position);
                i.putExtra("id",String.valueOf(c.getId()));
                i.putExtra("nom",c.getNom());
                i.putExtra("adresse",c.getAdresse());
                i.putExtra("tel",String.valueOf(c.getTel()));
                i.putExtra("fax",String.valueOf(c.getFax()));
                i.putExtra("contact",c.getContact());
                i.putExtra("tel_Contact",String.valueOf(c.getTel_Contact()));

                startActivity(i);
            }
        });
        clientRV.setAdapter(adapter);
        AddClientBtn = findViewById(R.id.idBtnAddClient);

        AddClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewClient.this, AddClient.class);
                startActivity(i);
            }
        });
    }
}