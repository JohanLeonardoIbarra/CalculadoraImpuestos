import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * Write a description of class Interfaz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interfaz extends JFrame implements ActionListener
{
    JPanel p1,p2,p3,p4,p5,p6;
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JButton b1,b2,b3;
    JCheckBox c1,c2,c3;
    Border borde1, borde2, borde3;
    
    Interfaz()
    {
        borde1 = new TitledBorder(new EtchedBorder(), "Datos Del Vehiculo");
        borde2 = new TitledBorder(new EtchedBorder(), "Descuentos");
        borde3 = new TitledBorder(new EtchedBorder(), "Resultados");
        generarInterfaz();
    }
    
    public void generarInterfaz()
    {
        JFrame marco = new JFrame();
        marco.setSize(250,457);
        marco.setTitle("CalculadoraImpuestos");
        marco.setDefaultCloseOperation(EXIT_ON_CLOSE);
        marco.setVisible(true);
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
        
        p1 = new JPanel();
        
        
        p1.setSize(300,457);
        p1.setBackground(Color.GRAY);
        
        marco.add(p1);
        
        p2 = new JPanel();
        
        p2.setPreferredSize(new Dimension(240,200));
        p2.setLayout(new GridLayout(5,2));
        p2.setForeground(Color.BLACK);
        p2.setBorder(borde1);
        
        p1.add(p2);
        
        p2.add(l1 = new JLabel("Marca"));
        p2.add(t1 = new JTextField());
        p2.add(l2 = new JLabel("Linea"));
        p2.add(t2 = new JTextField());
        p2.add(l3 = new JLabel("Modelo"));
        p2.add(t3 = new JTextField());
        p2.add(l4 = new JLabel("Precio"));
        p2.add(t4 = new JTextField());
        p2.add(l5 = new JLabel(""));
        p2.add(b1 = new JButton("Buscar"));
        
        p3 = new JPanel();
        
        p3.setPreferredSize(new Dimension(240,150));;
        p3.setLayout(new BorderLayout());
        p3.setBorder(borde2);
        p1.add(p3);
        
        p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        p5 = new JPanel();
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
        
        p3.add(p4, BorderLayout.WEST);
        p3.add(p5, BorderLayout.CENTER);
        
        p4.add(Box.createRigidArea(new Dimension(40,0)));
        p4.add(Box.createVerticalStrut(9));
        p4.add(c1 = new JCheckBox());
        p4.add(Box.createVerticalStrut(17));
        p4.add(c1 = new JCheckBox());
        p4.add(Box.createVerticalStrut(17));
        p4.add(c1 = new JCheckBox());
        
        
        p5.add(Box.createVerticalStrut(11));
        p5.add(Box.createRigidArea(new Dimension(60,0)));
        p5.add(l6 = new JLabel("Descuento Pronto Pago"));
        p5.add(Box.createVerticalStrut(20));
        p5.add(l7 = new JLabel("Descuento Servicio Publico"));
        p5.add(Box.createVerticalStrut(23));
        p5.add(l8 = new JLabel("Descuento Traslado"));
        
        
        p6 = new JPanel();
        p6.setPreferredSize(new Dimension(240,60));
        p6.setLayout(new GridLayout(2,3));
        p6.setBorder(borde3);
        p1.add(p6);
        
        p6.add(l9 = new JLabel(""));
        p6.add(l10 = new JLabel(""));
        p6.add(b2 = new JButton("Limpiar"));
        p6.add(l11 = new JLabel("Total a Pagar"));
        p6.add(t5 = new JTextField());
        p6.add(b3 = new JButton("Calcular"));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    } 
    
    public void actionPerformed(ActionEvent evento)
    {        
        String comando = evento.getActionCommand();
        
        CalculadorImpuestos dm = new CalculadoraImpuestos(2,2);
        
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
        
        if (comando.equals("Buscar"))
        {
            t4.setText(Double.toString(dm.buscarVehiculo(t1.getText(), t2.getText(), t3.getText())));
        }
        else if (comando.equals("Limpiar"))
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
        }
        else if (comando.equals("Calcular"))
        {
            t4.setText(Double.toString(dm.buscarVehiculo(t1.getText(), t2.getText(), t3.getText())));
            if (c1.isSelected()){dm.setDescProntoPago(true);}
            if (c2.isSelected()){dm.setDescServicioPublico(true);}
            if (c3.isSelected()){dm.setDescTraslado(true);}
            t5.setText(Double.toString(dm.impuestoTotal(t1.getText(), t2.getText(), t3.getText())));
        }    
    }
}
