
/**
 * Write a description of class Marca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marca
{
    private String nombre;
    private Linea[] linea;
    private Linea lineaI;
    
    Marca(String nombre, Integer numLinea)
    {
        this.nombre = nombre;
        this.linea = new Linea[numLinea];
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

    /**Getter method linea*/
    public Linea[] getLinea(){
        return this.linea;
    }//end method getLinea

    /**Setter method linea*/
    public void setLinea(Linea[] linea){
        this.linea = linea;
    }//end method setLinea
    
    public Linea getLineaI()
    {
        return lineaI;
    }
    
    public Boolean buscarLinea(String nombre)
    {
        Boolean lineaEncontrada = false;
        for(int i = 0; i < linea.length; i++)
        {
            if (nombre == linea[i].getNombre())
            {
                lineaEncontrada = true;
                lineaI = linea[i];
            }
        }
        return lineaEncontrada;
    }
    
    public void agregarLinea(Linea l)
    {
        for(int i = 0; i < linea.length; i++)
        {
            if (linea[i]==null)
            {
                linea[i] = l;
                break;
            }
        }
    }
    
    public String toString()
    {
        int i = 0;
        System.out.println("Nombre "+ nombre);
        while (i < linea.length)
        {
            System.out.println("Linea "+ linea[i].getNombre());
            i++;
        }
        return nombre;
    }
}
