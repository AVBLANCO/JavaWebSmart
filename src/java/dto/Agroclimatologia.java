/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ...con el mayor de los disgustos, el benévolo señor Arciniegas.  \\

package back.dto;

public class Agroclimatologia {

  private int idagroclimatologia;
  private String descripcionAgroclimatologia;
  private String fechaAgroclimatologia;
  private Lote lote;

    /**
     * Devuelve el valor correspondiente a idagroclimatologia
     * @return idagroclimatologia
     */
  public int getIdagroclimatologia(){
      return this.idagroclimatologia;
  }

    /**
     * Modifica el valor correspondiente a idagroclimatologia
     * @param idagroclimatologia
     */
  public void setIdagroclimatologia(int idagroclimatologia){
      this.idagroclimatologia = idagroclimatologia;
  }
    /**
     * Devuelve el valor correspondiente a descripcionAgroclimatologia
     * @return descripcionAgroclimatologia
     */
  public String getDescripcionAgroclimatologia(){
      return this.descripcionAgroclimatologia;
  }

    /**
     * Modifica el valor correspondiente a descripcionAgroclimatologia
     * @param descripcionAgroclimatologia
     */
  public void setDescripcionAgroclimatologia(String descripcionAgroclimatologia){
      this.descripcionAgroclimatologia = descripcionAgroclimatologia;
  }
    /**
     * Devuelve el valor correspondiente a fechaAgroclimatologia
     * @return fechaAgroclimatologia
     */
  public String getFechaAgroclimatologia(){
      return this.fechaAgroclimatologia;
  }

    /**
     * Modifica el valor correspondiente a fechaAgroclimatologia
     * @param fechaAgroclimatologia
     */
  public void setFechaAgroclimatologia(String fechaAgroclimatologia){
      this.fechaAgroclimatologia = fechaAgroclimatologia;
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