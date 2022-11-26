package com.example.projectsyrine.clientCrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectsyrine.R;
import com.example.projectsyrine.hundlers.ClientDBHundler;

public class AddClient extends AppCompatActivity {

    private EditText EdtClientName, EdtClientAdresse, EdtClientTel, EdtClientTelFax,EdtClientTelContact,EdtClientContact;
    private Button addClientBtn;
    private ClientDBHundler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        EdtClientName = findViewById(R.id.idEdtClientName);
        EdtClientAdresse = findViewById(R.id.idEdtClientAdresse);
        EdtClientTel = findViewById(R.id.idEdtClientTel);
        EdtClientTelFax = findViewById(R.id.idEdtClientTelFax);
        EdtClientTelContact = findViewById(R.id.idEdtClientTelContact);
        EdtClientContact = findViewById(R.id.idEdtClientContact);
        addClientBtn = findViewById(R.id.idAddButton);
        dbHandler = new ClientDBHundler(AddClient.this);

        addClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String clientName = EdtClientName.getText().toString();
                String clientAdresse = EdtClientAdresse.getText().toString();
                int clientTel = Integer.parseInt(EdtClientTel.getText().toString());
                int clientFax = Integer.parseInt(EdtClientTelFax.getText().toString());
                String clientContact = EdtClientContact.getText().toString();
                int clientTelContact = Integer.parseInt(EdtClientTelContact.getText().toString());

                if (clientName.isEmpty() && clientAdresse.isEmpty() && clientTel > 0 && clientFax > 0&& clientContact.isEmpty()&& clientTelContact > 0) {
                    Toast.makeText(AddClient.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.ajoutClient(clientName,clientAdresse,clientTel,clientFax,clientContact,clientTelContact);
                Toast.makeText(AddClient.this, "Client has been added.", Toast.LENGTH_SHORT).show();
                EdtClientName.setText("");
                EdtClientAdresse.setText("");
                EdtClientTel.setText("");
                EdtClientTelFax.setText("");
                EdtClientContact.setText("");
                EdtClientTelContact.setText("");
            }
        });
    }
}