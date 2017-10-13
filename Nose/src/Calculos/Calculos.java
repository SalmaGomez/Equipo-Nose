/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Calculos;

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
    public void CalcularGanancias(){
        
    }
    public void CalcularPerdidas(){
        
    }
    public void CalcularUtilidad_Bruta(){
        
    }
    
}
