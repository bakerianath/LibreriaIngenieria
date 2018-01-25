
package libreriausuario;

import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author bakeriana
 */
public interface IDAO {
    
    public boolean agregarUsuario (String  nUsuario, String apellido, String cedula, String fecha, String id);    
    public Element buscarU (String cedula);

}
