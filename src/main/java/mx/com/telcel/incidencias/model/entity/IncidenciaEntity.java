package mx.com.telcel.incidencias.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="incidencia_tb")
public class IncidenciaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nombre_incidencia")
    private String nombre_incidencia;
    @Column(name="detalle_incidencia", columnDefinition = "LONGTEXT")
    private String detalle_incidencia;

    @Column(name="fecha_incidencia")
    private Date fecha_incidencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_incidencia() {
        return nombre_incidencia;
    }

    public void setNombre_incidencia(String nombre_incidencia) {
        this.nombre_incidencia = nombre_incidencia;
    }

    public String getDetalle_incidencia() {
        return detalle_incidencia;
    }

    public void setDetalle_incidencia(String detalle_incidencia) {
        this.detalle_incidencia = detalle_incidencia;
    }

    public Date getFecha_incidencia() {
        return fecha_incidencia;
    }

    public void setFecha_incidencia(Date fecha_incidencia) {
        this.fecha_incidencia = fecha_incidencia;
    }
}
