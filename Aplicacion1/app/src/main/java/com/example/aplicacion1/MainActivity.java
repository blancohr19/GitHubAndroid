package com.example.aplicacion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText x1, x2,y2,y1;
    Button pendiente;
    Random r=new Random();
    int RandomNumber= r.nextInt(10);
    int RandomNumber2= r.nextInt(10);
    int RandomNumber3= r.nextInt(10);
    int RandomNumber4= r.nextInt(10);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            x1 = findViewById(R.id.edtx1);
            x2 = findViewById(R.id.edtx2);
            y1 = findViewById(R.id.edty1);
            y2= findViewById(R.id.edty2);
            pendiente = findViewById(R.id.btnpendiente);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_activity, m);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();


        if(id==R.id.Aleatorio){
            x1.setText(String.valueOf(RandomNumber));
            x2.setText(String.valueOf(RandomNumber2));
            y1.setText(String.valueOf(RandomNumber3));
            y2.setText(String.valueOf(RandomNumber4));
            Toast.makeText(getApplicationContext(),"Aleatorio", Toast.LENGTH_LONG).show();
        }

        if(id==R.id.Distancia){

            double dato1= Double.parseDouble(x1.getText().toString());
            double dato2= Double.parseDouble(x2.getText().toString());
            double dato3= Double.parseDouble(y1.getText().toString());
            double dato4= Double.parseDouble(y2.getText().toString());

            double distancia= Math.hypot(dato1-dato2,dato3-dato4);

            Toast.makeText(getApplicationContext(),"Distancia: "+distancia, Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onClick(View v) {

        double dato1= Double.parseDouble(x1.getText().toString());
        double dato2= Double.parseDouble(x2.getText().toString());
        double dato3= Double.parseDouble(y1.getText().toString());
        double dato4= Double.parseDouble(y2.getText().toString());

        switch (v.getId()){
            case R.id.btnpendiente:
                    if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                    TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){

                        Toast.makeText(getApplicationContext(),"Ingrese Todos los Datos", Toast.LENGTH_LONG).show();
                    }else{
                        double pendt=((dato4-dato3)/(dato2-dato1));
                        Toast.makeText(getApplicationContext(),"La Pendiente es: "+pendt, Toast.LENGTH_LONG).show();
                    }
                    break;

            case R.id.btnpuntom:
                if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                        TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){

                    Toast.makeText(getApplicationContext(),"Ingrese Todos los Datos", Toast.LENGTH_LONG).show();
                }else{
                    double xm=((dato2+dato1)/2);
                    double ym=((dato4+dato3)/2);
                    Toast.makeText(getApplicationContext(),"Punto Medio es:"+"("+xm+" ,"+ym+")", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btncuadrante:
                if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                        TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){

                    Toast.makeText(getApplicationContext(),"Ingrese Todos los Datos", Toast.LENGTH_LONG).show();
                }else{
                    if((dato1>=0 && dato2>=0 && dato3>=0 && dato4>=0)){
                        Toast.makeText(getApplicationContext(),"(x1,y1)(x2,y2) 1er Cuadrante", Toast.LENGTH_LONG).show();
                    }if((dato1<=0 && dato2<=0 && dato3<=0 && dato4<=0)){
                        Toast.makeText(getApplicationContext(),"(x1,y1)(x2,y2) 4to Cuadrante", Toast.LENGTH_LONG).show();
                    }else if((dato1>=0 && dato2>=0 && dato3<=0 && dato4<=0)){
                        Toast.makeText(getApplicationContext(),"(x1,y1) 1er y (x2,y2) 4er Cuadrante", Toast.LENGTH_LONG).show();
                    }

                }
                break;


        }

    }
}