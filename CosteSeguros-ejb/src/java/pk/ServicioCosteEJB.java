/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;

/**
 *
 * @author usuario
 */
@Stateless
public class ServicioCosteEJB implements ServicioCosteEJBLocal {
    
    //*@Resource(mappedName="factoriaTopicos")
    //private TopicConnectionFactory tcf;
    //@Resource(mappedName="TopicoOfertas")
    //private Topic t;
    

    @Override
    public int CalcularCoste(int edad) {
        int coste =125;
        
        if(edad>=18 && edad<=30){
            return (coste*2);
        }else if (edad>=30 && edad<=60){
            return (coste*3);
        }else if (edad>=60 && edad<=80){
            return coste*4;}
        else{
            return -1;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> ListOfertas() {
        LinkedList temp = new LinkedList();
        String text;
        try {
            Scanner Filast = new Scanner(new File("/home/usuario/Escritorio/Ofertas.txt"));
            while (Filast.hasNext()) {
            // Va linea por linea
            text = Filast.nextLine();
            temp.add(text);
        }
            Filast.close();
            System.out.println(temp);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicioCosteEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
