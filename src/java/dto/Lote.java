/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo.   \\

package back.dto;

public class Lote {

  private int idlote;
  private String descripcionLote;
  private double longitud;
  private double latitud;
  private Finca finca;

    /**
     * Devuelve el valor correspondiente a idlote
     * @return idlote
     */
  public int getIdlote(){
      return this.idlote;
  }

    /**
     * Modifica el valor correspondiente a idlote
     * @param idlote
     */
  public void setIdlote(int idlote){
      this.idlote = idlote;
  }
    /**
     * Devuelve el valor correspondiente a descripcionLote
     * @return descripcionLote
     */
  public String getDescripcionLote(){
      return this.descripcionLote;
  }

    /**
     * Modifica el valor correspondiente a descripcionLote
     * @param descripcionLote
     */
  public void setDescripcionLote(String descripcionLote){
      this.descripcionLote = descripcionLote;
  }
    /**
     * Devuelve el valor correspondiente a longitud
     * @return longitud
     */
  public double getLongitud(){
      return this.longitud;
  }

    /**
     * Modifica el valor correspondiente a longitud
     * @param longitud
     */
  public void setLongitud(double longitud){
      this.longitud = longitud;
  }
    /**
     * Devuelve el valor correspondiente a latitud
     * @return latitud
     */
  public double getLatitud(){
      return this.latitud;
  }

    /**
     * Modifica el valor correspondiente a latitud
     * @param latitud
     */
  public void setLatitud(double latitud){
      this.latitud = latitud;
  }
    /**
     * Devuelve el valor correspondiente a finca_idfinca
     * @return finca_idfinca
     */
  public Finca getFinca(){
      return this.finca;
  }

    /**
     * Modifica el valor correspondiente a finca_idfinca
     * @param finca_idfinca
     */
  public void setFinca(Finca finca){
      this.finca = finca;
  }


}
//That`s all folks!