import javax.swing.JOptionPane;
import java.io.*;
/**
 * Write a description of class CalculadorImpuestos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalculadorImpuestos
{
    private Boolean descProntoPago;
    private Boolean descServicioPublico;
    private Boolean descTraslado;
    private Marca[] marca;
    private RangoImpuesto[] impuesto;
    private Marca marcaI;

    CalculadorImpuestos(Integer vehiculos, Integer impuestos)
    {
        this.marca = new Marca[vehiculos];
        this.impuesto = new RangoImpuesto[impuestos];
    }

    //Start GetterSetterExtension Code
    /**Getter method marca*/
    public Marca[] getMarca(){
        return this.marca;
    }//end method getMarca

    /**Setter method marca*/
    public void setMarca(Marca[] marca){
        this.marca = marca;
    }//end method setMarca

    /**Getter method impuesto*/
    public RangoImpuesto[] getImpuesto(){
        return this.impuesto;
    }//end method getImpuesto

    /**Setter method impuesto*/
    public void setImpuesto(RangoImpuesto[] impuesto){
        this.impuesto = impuesto;
    }//end method setImpuesto

    /**Setter method descProntoPago*/
    public void setDescProntoPago(Boolean descProntoPago){
        this.descProntoPago = descProntoPago;
    }//end method setDescProntoPago

    /**Setter method descServicioPublico*/
    public void setDescServicioPublico(Boolean descServicioPublico){
        this.descServicioPublico = descServicioPublico;
    }//end method setDescServicioPublico
    
    /**Getter method descTraslado*/
    public Boolean getDescTraslado(){
        return this.descTraslado;
    }//end method getDescTraslado
    
    /**Getter method descProntoPago*/
    public Boolean getDescProntoPago(){
        return this.descProntoPago;
    }//end method getDescProntoPago

    /**Getter method descServicioPublico*/
    public Boolean getDescServicioPublico(){
        return this.descServicioPublico;
    }//end method getDescServicioPublico

    /**Setter method descTraslado*/
    public void setDescTraslado(Boolean descTraslado){
        this.descTraslado = descTraslado;
    }//end method setDescTraslado

    public Marca getMarcaI()
    {
        return marcaI;
    }
    
    public Boolean buscarMarca(String nombre)
    {
        Boolean marcaEncontrada = false;
        for(int i = 0; i < this.marca.length; i++)
        {
            if (marca[i].getNombre() == nombre)
            {
                marcaEncontrada = true;
                marcaI = marca[i];
            }
        }
        return marcaEncontrada;
    }

    public Double impuestoTotal(String marca, String linea, String anio)
    {
        Double total = 0.00;
        final String prefijo = "0.0";
        
        for (int i = 0; i<impuesto.length; i++)
        {
            if (buscarVehiculo(marca, linea, anio) >= impuesto[i].getInicio() && buscarVehiculo(marca, linea, anio) <= impuesto[i].getFin())
            {
                String stPorcentaje = Double.toString(impuesto[i].getPorcentaje());
                total = buscarVehiculo(marca, linea, anio) * impuesto[i].multiplicable();
            }
        }
        
        if (descProntoPago){total = total*0.10;}
        if (descServicioPublico){total = total - 50000;}
        if (descTraslado){total = total * 0.05;}
        
        try {total = 0.00;}
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return total;
    }

    public Double buscarVehiculo(String marca, String linea, String anio)
    {
        Double precio = 0.00;
        Double total = 0.00;

        if (buscarMarca(marca) == true)
        {
            if (marcaI.buscarLinea(linea) == true)
            {
                if (marcaI.getLineaI().buscarAnio(anio) == true)
                {
                    precio = marcaI.getLineaI().getModeloI().getPrecio();
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Modelo no registrado");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Linea no registrada");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Marca no registrada");
        }
        
        return total;
    }
    
    public void agregarMarca(Marca m)
    {
        for(int i = 0; i < marca.length; i++)
        {
            if (marca[i]==null)
            {
                marca[i] = m;
                break;
            }
        }
    }
    
    public void agregarImpuesto(RangoImpuesto ri)
    {
        for(int i = 0; i < impuesto.length; i++)
        {
            if (impuesto[i]==null)
            {
                impuesto[i] = ri;
                break;
            }
        }
    }
}
