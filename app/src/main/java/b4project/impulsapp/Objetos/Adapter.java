package b4project.impulsapp.Objetos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import b4project.impulsapp.R;

/**
 * Created by Volcoff lap on 13/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ProyectosViewHolder> implements View.OnClickListener {
    List<Proyecto_Class> proyectos;

    public Adapter(List<Proyecto_Class> proyectos) {

        this.proyectos = proyectos;
    }

    @Override
    public ProyectosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent,false);
        ProyectosViewHolder holder=new ProyectosViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProyectosViewHolder holder, int position) {
        Proyecto_Class proyecto = proyectos.get(position);
        holder.textViewNombreProyecto.setText(proyecto.getNombreProyecto());
    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    @Override
    public void onClick(View v) {

    }


    public static class ProyectosViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNombreProyecto;

        public ProyectosViewHolder(View itemView){
            super(itemView);
            textViewNombreProyecto = (TextView) itemView.findViewById(R.id.textview_nbreproyecto);
        }

    }
    

}
