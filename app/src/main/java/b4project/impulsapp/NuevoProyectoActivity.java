package b4project.impulsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import b4project.impulsapp.Objetos.Proyecto_Class;


public class NuevoProyectoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText ET_nombre;
    EditText ET_descripcion;
    EditText ET_cantidad;
    private Button mSave; //Guarda los datos ingresados
    private Button mCancel; //Cancela la creación de un nuevo proyecto
    private TextView mTitleElements1, mTitleElements2; //utilizar los elementos texto del Layout


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_nombre = (EditText) findViewById(R.id.Text);
        ET_descripcion = (EditText) findViewById(R.id.descriptionText);
        ET_cantidad = (EditText) findViewById(R.id.CantidadText);

        mSave = (Button) findViewById(R.id.button1);  //Referencias al button
        mCancel= (Button) findViewById(R.id.button2);
        mTitleElements1= (TextView) findViewById(R.id.descriptionText); //Referencias al texto
        mTitleElements2= (TextView) findViewById(R.id.Text);

        mCancel.setOnClickListener(new View.OnClickListener() { //Escuchador del botón Cancelar
            @Override
            public void onClick(View v) {
                mTitleElements1.setText(null); //Se actualiza el String como vacío
                mTitleElements2.setText(null);
                ET_cantidad.setText(null);
                Intent intent= new Intent(NuevoProyectoActivity.this,MisProyectosActivity.class);
                startActivity(intent);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef=database.getReference();

        mSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String aux_nombre = ET_nombre.getText().toString();
                String aux_descripcion = ET_descripcion.getText().toString();
                String aux_cantidad=ET_cantidad.getText().toString();

                if(!aux_nombre.matches("") && !aux_descripcion.matches("") && !aux_cantidad.matches("")) {
                    //comprueba que las cadenas tengan contenido
                    // este es el orden
                    // int IdProyecto; String NombreProyecto; int idUsuario; String  fecha_inicio; String fecha_limite; float cantidad_actual; float cantidad_meta;  String descripcion;
                    Proyecto_Class proyectos = new Proyecto_Class(1,aux_nombre,1,"23/10/217","23/10/217",0,Float.parseFloat(aux_cantidad),aux_descripcion);
                    myRef.push().setValue(proyectos);
                    /*

                    Proyecto NP = new Proyecto(aux_nombre, aux_descripcion, aux_cantidad);
                    Proyectos.alta(NP);*/
                    Intent intent=new Intent(NuevoProyectoActivity.this,InvitAmigosActivity.class); //Llama a la activity Projects of Mine
                    intent.putExtra("nombre",aux_nombre);
                    /*
                    intent.putExtra("Descripcion",aux_descripcion);
                    intent.putExtra("Cantidad",aux_cantidad);
                    * */
                    Toast.makeText(getApplicationContext(), "Proyecto Creado", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Debe ingresar datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
    /*    if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_projectofmine) {
            Intent lol= new Intent(NuevoProyectoActivity.this,MisProyectosActivity.class);  //Dirige a la Activity para ver proyectos creados
            startActivity(lol);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_donaciones) {
            Intent lol1= new Intent(NuevoProyectoActivity.this,OkDonacionActivity.class);  //Dirige a la Activity para ver proyectos creados
            startActivity(lol1);
        } else if (id == R.id.nav_editaproyecto){
            Intent lol2= new Intent(NuevoProyectoActivity.this,EditaProyectoActivity.class);  //Dirige a la Activity para ver proyectos creados
            startActivity(lol2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
