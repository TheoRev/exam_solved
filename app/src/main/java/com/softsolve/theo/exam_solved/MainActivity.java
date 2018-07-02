package com.softsolve.theo.exam_solved;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.softsolve.theo.exam_solved.model.Alumno;
import com.softsolve.theo.exam_solved.util.ConstsUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etAlumno;
    EditText etCategoria;
    RadioButton rbMorning;
    RadioButton rbTarde;
    RadioButton rbNoche;
    CheckBox ckbInternet;
    CheckBox ckbCafeteria;
    CheckBox ckbBiblioteca;
    Spinner spCarrera;
    Button btnMostrar;
    TextView tvResultado;

    Alumno alumno = null;

    ArrayList<String> carreras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("First Exercise");

        findViews();
        onClickedViews();
    }

    private void findViews() {
        alumno = new Alumno();

        etAlumno = findViewById(R.id.etAlumno);
        etCategoria = findViewById(R.id.etCategoria);
        rbMorning = findViewById(R.id.rbMorning);
        rbTarde = findViewById(R.id.rbTarde);
        rbNoche = findViewById(R.id.rbNoche);
        ckbInternet = findViewById(R.id.ckbInternet);
        ckbCafeteria = findViewById(R.id.ckbCafeteria);
        ckbBiblioteca = findViewById(R.id.ckbBiblioteca);
        spCarrera = findViewById(R.id.spCarrera);
        btnMostrar = findViewById(R.id.btnMostrar);
        tvResultado = findViewById(R.id.tvResultado);

        carreras.add("Contabilidad");
        carreras.add("Administración");
        carreras.add("Ingenieria Industrial");
        carreras.add("Ingenieria de Sistemas");

        ArrayAdapter<String> adapterCarreras
                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carreras);
        adapterCarreras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCarrera.setAdapter(adapterCarreras);
    }

    private void onClickedViews() {
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumno.setMatricula(getMatricula());
                alumno.setServicio(getServicio());
                double total = (alumno.getMatricula() - (alumno.getMatricula() * ConstsUtil.DESCUENTO))
                        + alumno.getTurno()
                        + alumno.getServicio()
                        + alumno.getCarrera();
                alumno.setPagoTotal(total);

                tvResultado.setText(etAlumno.getText() + " tu matrícula asciende a: " + String.valueOf(alumno.getPagoTotal()));
            }
        });

        rbMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumno.setTurno(getPago(v));
            }
        });
        rbTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumno.setTurno(getPago(v));
            }
        });
        rbNoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumno.setTurno(getPago(v));
            }
        });

        spCarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alumno.setCarrera(getCarrera((String) parent.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private double getMatricula() {
        String tempMat = etCategoria.getText().toString();

        switch (tempMat) {
            case ConstsUtil.CAT_A:
                return 5000;
            case ConstsUtil.CAT_B:
                return 4000;
            case ConstsUtil.CAT_C:
                return 3000;
            default:
                return 2000;
        }
    }

    private double getPago(View view) {
        boolean pressed = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbMorning:
                return pressed ? 30 : 0;
            case R.id.rbTarde:
                return pressed ? 20 : 0;
            case R.id.rbNoche:
                return pressed ? 10 : 0;
            default:
                return 0;
        }
    }

    private double getServicio() {
        double sum = 0;

        if (ckbInternet.isChecked()) {
            sum += 40;
        }
        if (ckbCafeteria.isChecked()) {
            sum += 30;
        }
        if (ckbBiblioteca.isChecked()) {
            sum += 20;
        }
        return sum;
    }

    private double getCarrera(String value) {
        switch (value) {
            case ConstsUtil.CONTABILIDAD:
                return 550;
            case ConstsUtil.ADMINISTRACION:
                return 500;
            case ConstsUtil.ING_INDUSTRIAL:
                return 600;
            case ConstsUtil.ING_SISTEMAS:
                return 400;
            default:
                return 0;
        }
    }
}
