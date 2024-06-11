package com.example.pm0142024tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Calculos.Calculos;

public class MainActivity extends AppCompatActivity {

    Button btnSuma, btnResta, btnMulti, btnDiv;
    EditText Num1;
    EditText Num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        Num1 = (EditText) findViewById(R.id.Num1);
        Num2 = (EditText) findViewById(R.id.Num2);
        Calculos op = new Calculos();
        Intent intent = new Intent(MainActivity.this, ActivityResultado.class);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultado = op.sumar(num1, num2);
                intent.putExtra("Resultado", resultado);
                startActivity(intent);
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultado = op.restar(num1, num2);
                intent.putExtra("Resultado", resultado);
                startActivity(intent);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultado = op.multiplicar(num1, num2);
                intent.putExtra("Resultado", resultado);
                startActivity(intent);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultado = op.dividir(num1, num2);
                intent.putExtra("Resultado", resultado);
                startActivity(intent);
            }
        });
    }
}
