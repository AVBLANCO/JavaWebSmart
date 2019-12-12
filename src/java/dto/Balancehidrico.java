/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando Gregorio Samsa se despertó una mañana después de un sueño intranquilo, se encontró sobre su cama convertido en un monstruoso insecto.  \\

package back.dto;

public class Balancehidrico {

  private int idbalanceHidrico;
  private String descripcioBalanceHidricocol;
  private String fechabalanceHidrico;
  private Agroclimatologia agroclimatologia;

    /**
     * Devuelve el valor correspondiente a idbalanceHidrico
     * @return idbalanceHidrico
     */
  public int getIdbalanceHidrico(){
      return this.idbalanceHidrico;
  }

    /**
     * Modifica el valor correspondiente a idbalanceHidrico
     * @param idbalanceHidrico
     */
  public void setIdbalanceHidrico(int idbalanceHidrico){
      this.idbalanceHidrico = idbalanceHidrico;
  }
    /**
     * Devuelve el valor correspondiente a descripcioBalanceHidricocol
     * @return descripcioBalanceHidricocol
     */
  public String getDescripcioBalanceHidricocol(){
      return this.descripcioBalanceHidricocol;
  }

    /**
     * Modifica el valor correspondiente a descripcioBalanceHidricocol
     * @param descripcioBalanceHidricocol
     */
  public void setDescripcioBalanceHidricocol(String descripcioBalanceHidricocol){
      this.descripcioBalanceHidricocol = descripcioBalanceHidricocol;
  }
    /**
     * Devuelve el valor correspondiente a fechabalanceHidrico
     * @return fechabalanceHidrico
     */
  public String getFechabalanceHidrico(){
      return this.fechabalanceHidrico;
  }

    /**
     * Modifica el valor correspondiente a fechabalanceHidrico
     * @param fechabalanceHidrico
     */
  public void setFechabalanceHidrico(String fechabalanceHidrico){
      this.fechabalanceHidrico = fechabalanceHidrico;
  }
    /**
     * Devuelve el valor correspondiente a agroclimatologia_idagroclimatologia
     * @return agroclimatologia_idagroclimatologia
     */
  public Agroclimatologia getAgroclimatologia(){
      return this.agroclimatologia;
  }

    /**
     * Modifica el valor correspondiente a agroclimatologia_idagroclimatologia
     * @param agroclimatologia_idagroclimatologia
     */
  public void setAgroclimatologia(Agroclimatologia agroclimatologia){
      this.agroclimatologia = agroclimatologia;
  }


}
//That`s all folks!