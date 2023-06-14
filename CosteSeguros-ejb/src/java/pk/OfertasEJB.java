/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author usuario
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "TopicoOfertas"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "TopicoOfertas"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "TopicoOfertas"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class OfertasEJB implements MessageListener {

    public OfertasEJB() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage txtmsg = (TextMessage) message; //Convertimos message a TextMessage

        //Codigo para crear archivo y añadir texto si es que no esta creado
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = txtmsg.getText();//Guardamos contenido del mensaje en un string
            File file = new File("/home/usuario/Escritorio/Ofertas.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data + "\n");
            System.out.println("información agregada!");
        } catch (IOException e) {
        } catch (JMSException ex) {
            Logger.getLogger(OfertasEJB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}
