
package ingenierialibreria;

/**
 *
 * @author bakeriana
 */
public class Cliente {
    
    private String name;
    private String lastName;
    private long cedula;
    private String lastBuy;
    private int ID = 0;
    
    public Cliente(String name, String lastName, long cedula, String lastBuy) {
        this.name = name;
        this.lastName = lastName;
        this.cedula = cedula;
        this.lastBuy = lastBuy;
        //this.ID = this.ID + 1;
    }

    public Cliente() {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getCedula() {
        return cedula;
    }

    public String getLastBuy() {
        return lastBuy;
    }

    public int getID() {
        return ID+1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setLastBuy(String lastBuy) {
        this.lastBuy = lastBuy;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
