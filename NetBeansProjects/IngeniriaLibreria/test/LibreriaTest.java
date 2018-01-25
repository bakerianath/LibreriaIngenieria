
import ingenierialibreria.Cliente;
import ingenierialibreria.FachadaCliente;
import libreriausuario.DAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author bakeriana
 */
public class LibreriaTest {
    
    DAO d;
    Cliente c;
    FachadaCliente f;
    
    @Before
    public void initTest() {
        d = new DAO();
        c = new Cliente();
        f = new FachadaCliente();
    }

    //Ver si el usuario ya registrado por DAO
    @Test
    public void testDAOUsuarioYaRegistrado(){
        
        boolean s = d.buscarPersona("26055828");
        String x = String.valueOf(s); 
        assertEquals(x,"true");
    }
    
    //Registrar usuario por DAO
    @Test
    public void testDAORegistro(){
        
        assertTrue(d.agregarUsuario("Sammi", "Scovino", "9641624", "11-01-2018", "2"));
    }
    
    //Registrar usuario por logica
    @Test
    public void testLogicaRegistro() {
        c.setCedula(30161928);
        c.setName("Daniela");
        c.setLastName("Bakerian");
        c.setLastBuy("13-01-2018");
        c.setID(1);
        
        boolean s = f.validarUsuario(c);
        String x = String.valueOf(s);
        
        assertEquals(x,"true");
        
    }

    @After
    public void tearDown(){
        d = null;
        c = null;
        f = null;
    }
    
}
