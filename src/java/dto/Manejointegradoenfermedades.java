/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La primera regla del proyecto es no hacer preguntas  \\

package back.dto;

public class Manejointegradoenfermedades {

  private int idmanejoIntegradoEnfermedades;
  private String descripcioManejoIntegradoEnfermedades;
  private Mipe mipe;

    /**
     * Devuelve el valor correspondiente a idmanejoIntegradoEnfermedades
     * @return idmanejoIntegradoEnfermedades
     */
  public int getIdmanejoIntegradoEnfermedades(){
      return this.idmanejoIntegradoEnfermedades;
  }

    /**
     * Modifica el valor correspondiente a idmanejoIntegradoEnfermedades
     * @param idmanejoIntegradoEnfermedades
     */
  public void setIdmanejoIntegradoEnfermedades(int idmanejoIntegradoEnfermedades){
      this.idmanejoIntegradoEnfermedades = idmanejoIntegradoEnfermedades;
  }
    /**
     * Devuelve el valor correspondiente a descripcioManejoIntegradoEnfermedades
     * @return descripcioManejoIntegradoEnfermedades
     */
  public String getDescripcioManejoIntegradoEnfermedades(){
      return this.descripcioManejoIntegradoEnfermedades;
  }

    /**
     * Modifica el valor correspondiente a descripcioManejoIntegradoEnfermedades
     * @param descripcioManejoIntegradoEnfermedades
     */
  public void setDescripcioManejoIntegradoEnfermedades(String descripcioManejoIntegradoEnfermedades){
      this.descripcioManejoIntegradoEnfermedades = descripcioManejoIntegradoEnfermedades;
  }
    /**
     * Devuelve el valor correspondiente a mipe_idmipe
     * @return mipe_idmipe
     */
  public Mipe getMipe(){
      return this.mipe;
  }

    /**
     * Modifica el valor correspondiente a mipe_idmipe
     * @param mipe_idmipe
     */
  public void setMipe(Mipe mipe){
      this.mipe = mipe;
  }


}
//That`s all folks!