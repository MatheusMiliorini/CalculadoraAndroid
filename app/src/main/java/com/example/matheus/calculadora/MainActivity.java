package com.example.matheus.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText tela;
    private String txtEmTela = "";

    private List<Float> numeros = new ArrayList<>();
    private List<String> operacoes = new ArrayList<>();

    private Float resultado = 0f;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMais;
    private Button btnMenos;
    private Button btnDivide;
    private Button btnVezes;
    private Button btnVirgula;
    private Button btnIgual;

    private Boolean jaComVirgula = false;
    private Boolean proximoLimpa = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tela = findViewById(R.id.resultado);


        // Botões numéricos
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnVirgula = findViewById(R.id.btnVirgula);

        // Botões de função
        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnDivide = findViewById(R.id.btnDivide);
        btnVezes = findViewById(R.id.btnVezes);
        btnIgual = findViewById(R.id.btnIgual);

        adicionaListeners();
    }

    private void adicionaListeners() {
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela("9");
            }
        });

        btnVirgula.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                concatenaResultadoTela(".");
            }
        });

        btnMais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeros.add(Float.parseFloat(txtEmTela));
                operacoes.add("SOMA");
                limpaTela();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeros.add(Float.parseFloat(txtEmTela));
                operacoes.add("SUBTRAI");
                limpaTela();
            }
        });

        btnVezes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeros.add(Float.parseFloat(txtEmTela));
                operacoes.add("MULT");
                limpaTela();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeros.add(Float.parseFloat(txtEmTela));
                operacoes.add("DIV");
                limpaTela();
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeros.add(Float.parseFloat(txtEmTela));
                calcula();
                tela.setText(resultado.toString());

                numeros.clear();
                operacoes.clear();

                proximoLimpa = true;
            }
        });
    }

    private void calcula() {
        for (int i = 0; i < operacoes.size(); i++) {
            if (i == 0) {
                switch (operacoes.get(i)) {
                    case "SOMA":
                        resultado = numeros.get(i) + numeros.get(i+1);
                        break;
                    case "SUBTRAI":
                        resultado = numeros.get(i) - numeros.get(i+1);
                        break;
                    case "MULT":
                        resultado = numeros.get(i) * numeros.get(i+1);
                        break;
                    case "DIV":
                        resultado = numeros.get(i) / numeros.get(i+1);
                        break;
                    default:
                        break;
                }
            } else {
                switch (operacoes.get(i)) {
                    case "SOMA":
                        resultado += numeros.get(i+1);
                        break;
                    case "SUBTRAI":
                        resultado -= numeros.get(i+1);
                        break;
                    case "MULT":
                        resultado *= numeros.get(i+1);
                        break;
                    case "DIV":
                        resultado /= numeros.get(i+1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void concatenaResultadoTela(String numero) {
        // Impede que a virgula seja adicionada mais de uma vez
        if (numero.equals(".") && jaComVirgula) {
            return;
        } else if (numero.equals(".")) {
            jaComVirgula = true;
        }

        if (proximoLimpa) {
            txtEmTela = "";
            proximoLimpa = false;
        }
        txtEmTela += numero;
        tela.setText(txtEmTela);
    }

    private void limpaTela() {
        txtEmTela = "";
        tela.setText(txtEmTela);
        jaComVirgula = false;
    }
}
