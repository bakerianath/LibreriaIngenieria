
package ingenierialibreria;

import libreriausuario.DAO;
/**
 *
 * @author bakeriana
 */
public class FachadaCliente {
    
    DAO l = new DAO();

    public FachadaCliente() {
    }
 
    public boolean validarUsuario (Cliente cl){
            boolean res = false;
            
            String nUsuario = cl.getName();
            String apellido = cl.getLastName();
            String cedula = String.valueOf(cl.getCedula()); 
            String fecha = cl.getLastBuy();
            String id= String.valueOf(cl.getID()+1);
            res = l.buscarPersona(cedula);
            
            if (res != true){ 
                    
               res=  l.agregarUsuario(nUsuario, apellido, cedula, fecha, id);
               return res;
            }
            else {
                System.out.println("Usuario duplicado. \n");
            }
            return true;
    }
}
