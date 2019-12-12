/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Estadistas informan que una linea de código equivale a un sorbo de café  \\

package back.dto;

public class Suelo {

  private int idsuelo;
  private String decripcionSuelo;
  private String fechaSuelo;
  private Lote lote;

    /**
     * Devuelve el valor correspondiente a idsuelo
     * @return idsuelo
     */
  public int getIdsuelo(){
      return this.idsuelo;
  }

    /**
     * Modifica el valor correspondiente a idsuelo
     * @param idsuelo
     */
  public void setIdsuelo(int idsuelo){
      this.idsuelo = idsuelo;
  }
    /**
     * Devuelve el valor correspondiente a decripcionSuelo
     * @return decripcionSuelo
     */
  public String getDecripcionSuelo(){
      return this.decripcionSuelo;
  }

    /**
     * Modifica el valor correspondiente a decripcionSuelo
     * @param decripcionSuelo
     */
  public void setDecripcionSuelo(String decripcionSuelo){
      this.decripcionSuelo = decripcionSuelo;
  }
    /**
     * Devuelve el valor correspondiente a fechaSuelo
     * @return fechaSuelo
     */
  public String getFechaSuelo(){
      return this.fechaSuelo;
  }

    /**
     * Modifica el valor correspondiente a fechaSuelo
     * @param fechaSuelo
     */
  public void setFechaSuelo(String fechaSuelo){
      this.fechaSuelo = fechaSuelo;
  }
    /**
     * Devuelve el valor correspondiente a lote_idlote
     * @return lote_idlote
     */
  public Lote getLote(){
      return this.lote;
  }

    /**
     * Modifica el valor correspondiente a lote_idlote
     * @param lote_idlote
     */
  public void setLote(Lote lote){
      this.lote = lote;
  }


}
//That`s all folks!