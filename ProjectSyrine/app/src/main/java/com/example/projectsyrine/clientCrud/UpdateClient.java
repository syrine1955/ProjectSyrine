package com.example.projectsyrine.clientCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectsyrine.R;
import com.example.projectsyrine.hundlers.ClientDBHundler;

public class UpdateClient extends AppCompatActivity {

    private EditText EdtClientName, EdtClientAdresse, EdtClientTel, EdtClientTelFax,EdtClientTelContact,EdtClientContact;
    private Button addClientBtn,deleteClientBtn;
    private ClientDBHundler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_client);

        EdtClientName = findViewById(R.id.idEdtClientName);
        EdtClientAdresse = findViewById(R.id.idEdtClientAdresse);
        EdtClientTel = findViewById(R.id.idEdtClientTel);
        EdtClientTelFax = findViewById(R.id.idEdtClientTelFax);
        EdtClientTelContact = findViewById(R.id.idEdtClientTelContact);
        EdtClientContact = findViewById(R.id.idEdtClientContact);
        addClientBtn = findViewById(R.id.idUpdateButton);
        deleteClientBtn = findViewById(R.id.idBtnDelete);
        dbHandler = new ClientDBHundler(UpdateClient.this);

        String clientId = getIntent().getStringExtra("id");
        String clientName = getIntent().getStringExtra("nom");
        String clientAdresse = getIntent().getStringExtra("adresse");
        String clientTel = getIntent().getStringExtra("tel");
        String clientFax = getIntent().getStringExtra("fax");
        String clientTelContact = getIntent().getStringExtra("tel_Contact");
        String clientContact = getIntent().getStringExtra("contact");

        EdtClientName.setText(clientName);
        EdtClientAdresse.setText(clientAdresse);
        EdtClientTel.setText(clientTel);
        EdtClientTelFax.setText(clientFax);
        EdtClientTelContact.setText(clientTelContact);
        EdtClientContact.setText(clientContact);

        dbHandler = new ClientDBHundler(UpdateClient.this);
        addClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clientName.isEmpty() && clientAdresse.isEmpty() && Integer.parseInt(clientTel) > 0 && Integer.parseInt(clientFax) > 0&& clientContact.isEmpty()&& Integer.parseInt(clientTelContact) > 0) {
                Toast.makeText(UpdateClient.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
                dbHandler.modClient(clientId,clientName,clientAdresse,Integer.parseInt(clientTel),Integer.parseInt(clientFax),clientContact,Integer.parseInt(clientTelContact));
                Toast.makeText(UpdateClient.this, "Client has been updated.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateClient.this, ViewClient.class);
                startActivity(i);
            }
        });

        deleteClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteClient(clientId);
                Toast.makeText(UpdateClient.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateClient.this, ViewClient.class);
                startActivity(i);
            }
        });
    }
}