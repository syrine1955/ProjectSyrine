package com.example.projectsyrine.contractCrud;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectsyrine.R;
import com.example.projectsyrine.clientCrud.AddClient;
import com.example.projectsyrine.hundlers.ClientDBHundler;
import com.example.projectsyrine.hundlers.ContractDBHundler;

public class AddContract extends AppCompatActivity {

    private EditText EdtReference, EdtDatedebut, EdtDatefin, EdtRedevence,EdtIdClient;
    private Button addContractBtn;
    private ContractDBHundler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contract);

        EdtReference = findViewById(R.id.idEdtReference);
        EdtDatedebut = findViewById(R.id.idEdtDatedebut);
        EdtDatefin = findViewById(R.id.idEdtDatefin);
        EdtRedevence = findViewById(R.id.idEdtRedevence);
        EdtIdClient = findViewById(R.id.idEdtIdClient);
        addContractBtn = findViewById(R.id.idAddButton);
        dbHandler = new ContractDBHundler(AddContract.this);

        addContractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reference = EdtReference.getText().toString();
                String datedebut = EdtDatedebut.getText().toString();
                String datefin = EdtDatefin.getText().toString();
                double redevence = Double.parseDouble(EdtRedevence.getText().toString());
                int idClient = Integer.parseInt(EdtIdClient.getText().toString());

                if (reference.isEmpty() && datedebut.isEmpty() && datefin.isEmpty() && redevence > 0&& idClient>0) {
                    Toast.makeText(AddContract.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.ajoutContract(reference,datedebut,datefin,redevence,idClient);
                Toast.makeText(AddContract.this, "Client has been added.", Toast.LENGTH_SHORT).show();
                EdtReference.setText("");
                EdtDatedebut.setText("");
                EdtDatefin.setText("");
                EdtRedevence.setText("");
                EdtIdClient.setText("");
            }
        });
    }
}