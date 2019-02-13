package com.example.lilialobato.tarea1;

import android.content.DialogInterface;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ActivityMain extends AppCompatActivity {

    String[] libros = {"100 años de soledad", "Harry Potter", "Aura", "El conde de Montecristo",
            "Gone girl", "Candy", "Horns", "Drácula"};
    String strName;
    String strPhone;
    String strEscolaridad;
    String strGenero = "Femenino";
    String strLibro;
    String strDeporte = "No";

    EditText name;
    EditText phone;
    Spinner escolaridad;
    AutoCompleteTextView libro;
    RadioButton genero;
    CheckBox deporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the instance of ArrayAdapter containing list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, libros);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto_libro);
        actv.setThreshold(1);       //will start working from first character
        actv.setAdapter(adapter);   //setting the adapter data into the AutoCompleteTextView
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;
    }

    //RadioButton
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rd_femenino:
                if (checked) {
                    genero = (RadioButton) findViewById(R.id.rd_femenino);
                    strGenero = genero.getText().toString();
                }
                break;
            case R.id.rd_masculino:
                if (checked) {
                    genero = (RadioButton) findViewById(R.id.rd_femenino);
                    strGenero = genero.getText().toString();
                }
                break;
        }
    }

    //ToogleButton
    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();
        deporte = (CheckBox) findViewById(R.id.cb_deporte);
        if (on) {
            strDeporte = "Si";
        } else {
            strDeporte = "No";
        }
    }

    //Listener for menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        name = (EditText) findViewById(R.id.txt_name);
        phone = (EditText) findViewById(R.id.txt_phone);
        escolaridad = (Spinner) findViewById(R.id.spn_esolaridad);
        libro = (AutoCompleteTextView) findViewById(R.id.auto_libro);

        strName = name.getText().toString();
        strPhone = phone.getText().toString();
        strEscolaridad = escolaridad.getSelectedItem().toString();
        strLibro = libro.getText().toString();

        Alumno toastText = new Alumno(strName, strPhone, strEscolaridad,
                strGenero, strLibro, strDeporte);

        if (item.getItemId() == R.id.save) {
            Toast.makeText(this, toastText.toString(), Toast.LENGTH_LONG).show();
            limpiar();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //AlertDialog
    public void showAlertDialog(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("¿Desea limpiar el contenido?");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                limpiar();
            }
        });
        alert.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.create().show();
    }

    //Limpiar
    public void limpiar() {
        name = (EditText) findViewById(R.id.txt_name);
        phone = (EditText) findViewById(R.id.txt_phone);
        escolaridad = (Spinner) findViewById(R.id.spn_esolaridad);
        libro = (AutoCompleteTextView) findViewById(R.id.auto_libro);
        deporte = (CheckBox) findViewById(R.id.cb_deporte);

        name.getText().clear();
        phone.getText().clear();
        escolaridad.setSelection(0);
        libro.getText().clear();
        if (deporte.isChecked()) {
            deporte.setChecked(false);
        }
        genero = (RadioButton) findViewById(R.id.rd_masculino);
        genero.setChecked(false);
            genero = (RadioButton) findViewById(R.id.rd_femenino);
            genero.setChecked(true);
    }
}
