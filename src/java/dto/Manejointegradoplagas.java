/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Recuerda, cuando enciendas la molotov, debes arrojarla  \\

package back.dto;

public class Manejointegradoplagas {

  private int idmanejoIntegradoPlagas;
  private String descricionManejoIntegradoPlagas;
  private Mipe mipe;

    /**
     * Devuelve el valor correspondiente a idmanejoIntegradoPlagas
     * @return idmanejoIntegradoPlagas
     */
  public int getIdmanejoIntegradoPlagas(){
      return this.idmanejoIntegradoPlagas;
  }

    /**
     * Modifica el valor correspondiente a idmanejoIntegradoPlagas
     * @param idmanejoIntegradoPlagas
     */
  public void setIdmanejoIntegradoPlagas(int idmanejoIntegradoPlagas){
      this.idmanejoIntegradoPlagas = idmanejoIntegradoPlagas;
  }
    /**
     * Devuelve el valor correspondiente a descricionManejoIntegradoPlagas
     * @return descricionManejoIntegradoPlagas
     */
  public String getDescricionManejoIntegradoPlagas(){
      return this.descricionManejoIntegradoPlagas;
  }

    /**
     * Modifica el valor correspondiente a descricionManejoIntegradoPlagas
     * @param descricionManejoIntegradoPlagas
     */
  public void setDescricionManejoIntegradoPlagas(String descricionManejoIntegradoPlagas){
      this.descricionManejoIntegradoPlagas = descricionManejoIntegradoPlagas;
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