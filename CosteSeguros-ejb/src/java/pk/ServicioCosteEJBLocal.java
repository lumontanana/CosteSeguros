/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.util.LinkedList;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface ServicioCosteEJBLocal {
    int CalcularCoste(int edad);              // Servicio de calculo de coste
    LinkedList<String> ListOfertas(); 
}
