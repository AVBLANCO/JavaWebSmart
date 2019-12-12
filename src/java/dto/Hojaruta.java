/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Me arreglas mi impresora?  \\

package back.dto;

public class Hojaruta {

  private int idhojaRuta;
  private String fechaHojaRuta;
  private Costo costo;

    /**
     * Devuelve el valor correspondiente a idhojaRuta
     * @return idhojaRuta
     */
  public int getIdhojaRuta(){
      return this.idhojaRuta;
  }

    /**
     * Modifica el valor correspondiente a idhojaRuta
     * @param idhojaRuta
     */
  public void setIdhojaRuta(int idhojaRuta){
      this.idhojaRuta = idhojaRuta;
  }
    /**
     * Devuelve el valor correspondiente a fechaHojaRuta
     * @return fechaHojaRuta
     */
  public String getFechaHojaRuta(){
      return this.fechaHojaRuta;
  }

    /**
     * Modifica el valor correspondiente a fechaHojaRuta
     * @param fechaHojaRuta
     */
  public void setFechaHojaRuta(String fechaHojaRuta){
      this.fechaHojaRuta = fechaHojaRuta;
  }
    /**
     * Devuelve el valor correspondiente a costo_idcosto
     * @return costo_idcosto
     */
  public Costo getCosto(){
      return this.costo;
  }

    /**
     * Modifica el valor correspondiente a costo_idcosto
     * @param costo_idcosto
     */
  public void setCosto(Costo costo){
      this.costo = costo;
  }


}
//That`s all folks!