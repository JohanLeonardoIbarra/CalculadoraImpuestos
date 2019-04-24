
/**
 * Write a description of class Model here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Modelo
{
   private String anio;
   private Double precio;
    
    Modelo(String anio, Double precio)
    {
        this.anio = anio;
        this.precio = precio;
    }

    //Start GetterSetterExtension Code
    /**Getter method anio*/
    public String getAnio(){
        return this.anio;
    }//end method getAnio

    /**Setter method anio*/
    public void setAnio(String anio){
        this.anio = anio;
    }//end method setAnio

    /**Getter method precio*/
    public Double getPrecio(){
        return this.precio;
    }//end method getPrecio

    /**Setter method precio*/
    public void setPrecio(Double precio){
        this.precio = precio;
    }//end method setPrecio

    //End GetterSetterExtension Code
//!
}