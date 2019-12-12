/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ojitos de luz de luna  \\

package back.dto;

public class Mipe {

  private int idmipe;
  private String decripcionMipe;
  private String fechaMipe;
  private Lote lote;

    /**
     * Devuelve el valor correspondiente a idmipe
     * @return idmipe
     */
  public int getIdmipe(){
      return this.idmipe;
  }

    /**
     * Modifica el valor correspondiente a idmipe
     * @param idmipe
     */
  public void setIdmipe(int idmipe){
      this.idmipe = idmipe;
  }
    /**
     * Devuelve el valor correspondiente a decripcionMipe
     * @return decripcionMipe
     */
  public String getDecripcionMipe(){
      return this.decripcionMipe;
  }

    /**
     * Modifica el valor correspondiente a decripcionMipe
     * @param decripcionMipe
     */
  public void setDecripcionMipe(String decripcionMipe){
      this.decripcionMipe = decripcionMipe;
  }
    /**
     * Devuelve el valor correspondiente a fechaMipe
     * @return fechaMipe
     */
  public String getFechaMipe(){
      return this.fechaMipe;
  }

    /**
     * Modifica el valor correspondiente a fechaMipe
     * @param fechaMipe
     */
  public void setFechaMipe(String fechaMipe){
      this.fechaMipe = fechaMipe;
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