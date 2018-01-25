
package libreriausuario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author bakeriana
 */
public class DAO implements IDAO  {

    private Element root;
    private static String location = "/home/bakeriana/NetBeansProjects/IngeniriaLibreria/src/Archivo/Usuarios.xml";
    //Se debe cambiar la ubicacion del XML cada vez que se quiera usar desde distintos computadores
    public DAO() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(location);
            root = doc.getRootElement();
        }
        catch(JDOMException | IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }
 
    /**
     * Metodo que se le agregan los parametros para Registrar el usuario
     * @param nUsuario
     * @param apellido
     * @param cedula
     * @param fecha
     * @param id
     * @return 
     */
    
    @Override
    public boolean agregarUsuario(String  nUsuario, String apellido, String cedula, String fecha, String id) {
        boolean resultado = false;
        root.addContent(UsuarioToXml(nUsuario,apellido,cedula,fecha,id));
        resultado = updateDocument(); 
        return resultado;
    }
    
    /**
     * Metodo Secundario el cual es llamado por el metodo buscarPersona para validar que exista
     * esto devuelve un Element en caso que exista.
     * @param raiz
     * @param cedula
     * @return 
     */   
   
    public static Element buscarU(List raiz, String cedula) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (cedula.equals(e.getChild("cedula").getText())) {
                return e;
            }
        }
        return null;
    }
    
    /**
     * Metodo PRINCIPAL que busca el usuario, 
     * En caso que exista devuelve true
     * @param cedula
     * @return 
     */
    public boolean buscarPersona(String cedula) {
        Element aux = new Element("Usuario");
        List Usuarios = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = DAO.buscarU(Usuarios, cedula);
            if (aux != null) {
                return true;
            }
        }
        return false;
    }

    private Element UsuarioToXml(String  nUsuario, String apellidoc, String cedulac, String fechac, String idc) {
        Element object = new Element("Usuario");
       
        Element nombre = new Element("nombre");
        nombre.setText(nUsuario);
        //System.out.println("nombre: "+nUsuario+"\n");
        
        Element apellido = new Element("apellido");
        apellido.setText(apellidoc);
        //System.out.println("apellido: "+apellidoc+"\n");
        
        Element cedula = new Element("cedula");
        cedula.setText(cedulac);
        //System.out.println("cedula: "+cedulac+"\n");
        
        Element fecha = new Element("fecha");
        fecha.setText(fechac);
        //System.out.println("fecha: "+fechac+"\n");
        
        Element id = new Element("id");
        id.setText(idc);
        //System.out.println("ID: "+id+"\n");
        
        
        object.addContent(nombre);
        object.addContent(apellido);
        object.addContent(cedula);
        object.addContent(fecha);
        object.addContent(id);

        return object;
    }     
        
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom2.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(location);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        }
        catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            return false;
        }
} 

    @Override
    public Element buscarU(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
