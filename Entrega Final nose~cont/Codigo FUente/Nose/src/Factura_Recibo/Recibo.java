/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factura_Recibo;

/**
 *
 * @author Lenovo
 */
public class Recibo {
 private int folio;
 private float importe;
 private String fecha;
 private String receptor_nombre;
 private String emisor_nombre;
 private String RFC_receptor;
 private String RFC_emisor;
 private float retenciones;
 private float traslados;
  
  public Recibo(){
      folio =0;
      importe = 0;
      fecha = " ";
      receptor_nombre=" ";
      emisor_nombre=" ";
      RFC_receptor = " ";
      RFC_emisor = " ";
      retenciones=0;
      traslados=0;
  }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReceptor_nombre() {
        return receptor_nombre;
    }

    public void setReceptor_nombre(String receptor_nombre) {
        this.receptor_nombre = receptor_nombre;
    }

    public String getEmisor_nombre() {
        return emisor_nombre;
    }

    public void setEmisor_nombre(String emisor_nombre) {
        this.emisor_nombre = emisor_nombre;
    }

    public String getRFC_receptor() {
        return RFC_receptor;
    }

    public void setRFC_receptor(String RFC_receptor) {
        this.RFC_receptor = RFC_receptor;
    }

    public String getRFC_emisor() {
        return RFC_emisor;
    }

    public void setRFC_emisor(String RFC_emisor) {
        this.RFC_emisor = RFC_emisor;
    }

    public float getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(float retenciones) {
        this.retenciones = retenciones;
    }

    public float getTraslados() {
        return traslados;
    }

    public void setTraslados(float traslados) {
        this.traslados = traslados;
    }
    
}
