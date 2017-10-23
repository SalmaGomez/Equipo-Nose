/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Calculos;
import BaseDatos.*;
import javax.swing.JOptionPane;

/**
 *
 * @author TaniaEsparza
 */
public class Calculos {
    private float Impuestos;
    private float Ganancias;
    private float Perdidas;
    private float Utilidad_Bruta;
    private float IVA;
    private float ISR;
    private float IVAr;
    private float Retenciones;
    private String Fecha;
    
    
    public Calculos(){
       Impuestos = 0;
       Ganancias = 0;
       Perdidas = 0;
       Utilidad_Bruta = 0;
       Fecha = " ";
    }
    
    public float CalcularImpuestosFactura(float Importe){
       IVA = (float)(Importe * 0.16);
       Impuestos = IVA;
       return Impuestos;
    }
    public float CalcularImpuestosRecibo(float Importe){
        IVA = (float)(Importe * 0.16);
        
        ISR = (float)(Importe * 0.10);
        
        IVAr = (float)(Importe * 0.1067);
        
        Retenciones = (float)( ISR + IVAr);
        
        Impuestos = ( IVA) + Retenciones;
        
        return Impuestos;   
    }
    
    public float ImpuestosMensuales(String fecha){
        try {
        // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
        Conexion mConexion = new Conexion();
        mConexion.Conectar("localhost", "nose_prueba", "root", "nose");
        String impuestos = ("select SUM(impuestos) as total from recibo_factura where fecha >= ''?1'-01' and fecha <= ''?1'-31';");
        impuestos = impuestos.replace("?1", fecha);
        mConexion.ejecutarConsulta(impuestos);
        Impuestos = Impuestos + (Float.parseFloat(impuestos));
        } catch (Exception error) {
        JOptionPane.showMessageDialog(null, "Error al realizar calculos");
        System.out.println(error.toString());
        }
    return Impuestos;
    }
    
    public void CalcularGananciasMensuales(){
        
    }
    public void CalcularPerdidasMensuales(){
        
    }
    public void CalcularUtilidad_BrutaMensuales(){
        
    }
    public void ImpuestosAnuales(){
        
    }
    public void CalcularGananciasAnuales(){
        
    }
    public void CalcularPerdidasAnuales(){
        
    }
    public void CalcularUtilidad_BrutaAnuales(){
        
    }
}
