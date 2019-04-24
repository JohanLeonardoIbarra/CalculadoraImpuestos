
/**
 * Write a description of class RangoImpuesto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangoImpuesto
{
    private Double inicio;
    private Double fin;
    private Double porcentaje;
    
    RangoImpuesto(Double inicio, Double fin, Double porcentaje)
    {
        this.inicio = inicio;
        this.fin = fin;
        this.porcentaje = porcentaje;
    }

    //Start GetterSetterExtension Code
    /**Getter method inicio*/
    public Double getInicio(){
        return this.inicio;
    }//end method getInicio

    /**Setter method inicio*/
    public void setInicio(Double inicio){
        this.inicio = inicio;
    }//end method setInicio

    /**Getter method fin*/
    public Double getFin(){
        return this.fin;
    }//end method getFin

    /**Setter method fin*/
    public void setFin(Double fin){
        this.fin = fin;
    }//end method setFin

    /**Getter method porcentaje*/
    public Double getPorcentaje(){
        return this.porcentaje;
    }//end method getPorcentaje

    /**Setter method porcentaje*/
    public void setPorcentaje(Double porcentaje){
        this.porcentaje = porcentaje;
    }//end method setPorcentaje

    public Double multiplicable()
    {
        String num = Double.toString(porcentaje).substring(0, 1);
        String ret = "0.0"+num;
        if (Double.toString(porcentaje).substring(2,3) != "0")
        {
            String nam = num+Double.toString(porcentaje).substring(2,3);
            ret = "0.0"+nam;
        }        
        System.out.println(ret);
        return Double.parseDouble(ret);
    }
    
    //End GetterSetterExtension Code
//!
}