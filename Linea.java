
/**
 * Write a description of class Modelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Linea
{
    private String nombre;
    private Modelo[] modelo;
    private Modelo modeloI;
    
    Linea(String nombre, Integer modelos)
    {
        this.nombre = nombre;
        this.modelo = new Modelo[modelos];
    }
    
    //Start GetterSetterExtension Code
    /**Getter method nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**Setter method nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**Getter method modelo*/
    public Modelo[] getModelo(){
        return this.modelo;
    }//end method getModelo

    /**Setter method modelo*/
    public void setModelo(Modelo[] modelo){
        this.modelo = modelo;
    }//end method setModelo
    
    public Modelo getModeloI()
    {
        return modeloI;
    }

    public Boolean buscarAnio(String anio)
    {
        Boolean anioEncontrada = false;
        for(int i = 0; i < modelo.length; i++)
        {
            if (anio == modelo[i].getAnio())
            {
                anioEncontrada = true;
                modeloI = modelo[i];
            }
        }
        return anioEncontrada;
    }
    
    public void agregarModelo(Modelo m)
    {
        for(int i = 0; i < modelo.length; i++)
        {
            if (modelo[i]==null)
            {
                modelo[i] = m;
                break;
            }
        }
    }
}
