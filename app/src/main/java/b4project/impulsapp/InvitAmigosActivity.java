package b4project.impulsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import  android.widget.ListView;
import android.widget.Toast;

public class InvitAmigosActivity extends AppCompatActivity {
    private Button mOmit;
    private Button mOkay;
    String [] values= new String[]{"Juanma Gonzalez","Luis Antonio Soto","Joselin Lara","Liliana Guzman"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendsinv);

        mOmit = (Button) findViewById(R.id.buttonOmitir);
        mOkay= (Button) findViewById(R.id.buttonAceptar);

        mOmit.setOnClickListener(new View.OnClickListener() {  //Por alguna razón cuando activas estas opciones la app se traba
            @Override
            public void onClick(View h) {
                Intent intent1= new Intent(InvitAmigosActivity.this,MisProyectosActivity.class);
                startActivity(intent1);
            }
        });

        mOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(InvitAmigosActivity.this,MisProyectosActivity.class);
                Toast.makeText(getApplicationContext(), "Amigos Invitados", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            }
        });

        final ListView mList= (ListView) findViewById(R.id.projectsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int item = position;
                String itemval = (String)mList.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Position: "+ item+" - Valor: "+itemval, Toast.LENGTH_LONG).show();
            }
        });
    }
}
