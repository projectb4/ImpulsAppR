package b4project.impulsapp.Objetos;

/**
 * Created by Volcoff lap on 04/10/2017.
 */

public class Proyecto_Class {
    int IdProyecto;
    String NombreProyecto;
    int idUsuario;
    String  fecha_inicio;
    String fecha_limite;
    float cantidad_actual;
    float cantidad_meta;
    String descripcion;

    public Proyecto_Class() {
    }

    public Proyecto_Class(int idProyecto, String nombreProyecto, int idUsuario, String fecha_inicio, String fecha_limite, float cantidad_actual, float cantidad_meta, String descripcion) {
        IdProyecto = idProyecto;
        NombreProyecto = nombreProyecto;
        this.idUsuario = idUsuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_limite = fecha_limite;
        this.cantidad_actual = cantidad_actual;
        this.cantidad_meta = cantidad_meta;
        this.descripcion = descripcion;
    }

    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        IdProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return NombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        NombreProyecto = nombreProyecto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public float getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(float cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public float getCantidad_meta() {
        return cantidad_meta;
    }

    public void setCantidad_meta(float cantidad_meta) {
        this.cantidad_meta = cantidad_meta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
