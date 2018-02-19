package edu.eci.cosw.jpa.sample.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TiposPoliza generated by hbm2java
 */
@Entity
@Table(name="TIPOS_POLIZA")
public class TipoPoliza  implements java.io.Serializable {


     private int codigoPoliza;
     private String nombre;
     private String descripcion;
     private long montoMaximo;

    public TipoPoliza() {
    }

	
    public TipoPoliza(int codigoPoliza, String nombre, String descripcion, long montoMaximo) {
        this.codigoPoliza = codigoPoliza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMaximo = montoMaximo;
    }
    @Id
    @Column (name = "codigo_poliza")
    public int getCodigoPoliza() {
        return this.codigoPoliza;
    }
    
    public void setCodigoPoliza(int codigoPoliza) {
        this.codigoPoliza = codigoPoliza;
    }
    @Column (name = "nombre")
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column (name = "descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Column (name = "monto_maximo")
    public long getMontoMaximo() {
        return this.montoMaximo;
    }
    
    public void setMontoMaximo(long montoMaximo) {
        this.montoMaximo = montoMaximo;
    }
    
}


