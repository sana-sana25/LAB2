package com.example.localtaxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;
    private Button calculButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison XML ↔ Java
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);
        calculButton = findViewById(R.id.button_calcul);

        // Bouton calcul
        calculButton.setOnClickListener(v -> calculer());
    }

    private void calculer() {

        // Vérification des champs
        if (surfaceInput.getText().toString().isEmpty() ||
                piecesInput.getText().toString().isEmpty()) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double surface = Double.parseDouble(surfaceInput.getText().toString());
            int pieces = Integer.parseInt(piecesInput.getText().toString());
            boolean piscine = piscineCheckbox.isChecked();

            // Calcul
            double impotBase = surface * 2;
            double supplement = pieces * 50 + (piscine ? 100 : 0);
            double total = impotBase + supplement;

            // Affichage détaillé
            resultView.setText(
                    "Impôt de base : " + impotBase + " DH\n" +
                            "Supplément : " + supplement + " DH\n" +
                            "Total : " + total + " DH"
            );

        } catch (Exception e) {
            Toast.makeText(this, "Erreur de saisie", Toast.LENGTH_SHORT).show();
        }
    }
}