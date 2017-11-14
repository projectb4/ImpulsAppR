package b4project.impulsapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import b4project.impulsapp.Objetos.Adapter;
import b4project.impulsapp.Objetos.Proyecto_Class;

public class MisProyectosActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter2;
	RecyclerView rv;
    List<Proyecto_Class> proyectos;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectsofmine);

        rv = (RecyclerView) findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        proyectos = new ArrayList<>();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        adapter = new Adapter(proyectos);
        rv.setAdapter(adapter);
        db.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                proyectos.removeAll(proyectos);
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    Proyecto_Class proyecto = snapshot.getValue(Proyecto_Class.class);
                    proyectos.add(proyecto);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MisProyectosActivity.this, NuevoProyectoActivity.class); //Llama a la activity Projects of Mine
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

    }
    public void abre_dialogo (View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selec).setItems(R.array.opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    Intent intent=new Intent(MisProyectosActivity.this,NuevoProyectoActivity.class); //Llama a la activity Projects of Mine
                    startActivity(intent);
                }

                if(which==1){
                    Intent intent=new Intent(MisProyectosActivity.this,EditaProyectoActivity.class); //Llama a la activity Projects of Mine
                    startActivity(intent);
                }

                if(which==2){
                    Intent intent=new Intent(MisProyectosActivity.this,OkDonacionActivity.class); //Llama a la activity Projects of Mine
                    startActivity(intent);
                }
            }

        });
        Dialog dialog = builder.create();
        dialog.show();


    }
	
	}