
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[]args)
    {
        CalculadorImpuestos ci = new CalculadorImpuestos(2,3);
        
        Modelo m1 = new Modelo("2010", 25000000.00);
        Modelo m2 = new Modelo("2015", 40000000.00);
        Modelo m3 = new Modelo("2019", 450000000.00);
        Modelo m4 = new Modelo("2009", 15000000.00);
        
        Linea l1 = new Linea("A1", 2);
        Linea l2 = new Linea("Spark", 1);
        Linea l3 = new Linea("Aveo", 1);
        
        Marca ma1 = new Marca("Audi", 1);
        Marca ma2 = new Marca("Chevrolet", 2);
        
        RangoImpuesto i1 = new RangoImpuesto(0.00, 9500000.00, 1.50);
        RangoImpuesto i2 = new RangoImpuesto(9500000.00, 25000000.00, 2.00);
        RangoImpuesto i3 = new RangoImpuesto(25000000.00, 35000000.00, 2.50);
        
        ci.agregarImpuesto(i1);
        ci.agregarImpuesto(i2);
        ci.agregarImpuesto(i3);
        
        ci.agregarMarca(ma1);
        ci.agregarMarca(ma2);
        
        ma1.agregarLinea(l1);
        ma2.agregarLinea(l2);
        ma2.agregarLinea(l3);
        
        l1.agregarModelo(m2);
        l1.agregarModelo(m3);
        l2.agregarModelo(m1);
        l3.agregarModelo(m4);

        /*for(int i = 0; i<ci.getMarca().length;i++)
        {
            System.out.println("  " + ci.getMarca()[i].toString());
        }*/
        
        Interfaz interfaz = new Interfaz(ci);
    }
}
