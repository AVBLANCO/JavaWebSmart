/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ya están los patrones implementados, ahora sí viene lo chido...  \\

package back.dto;

public class Metricassuelo {

  private int idmetricasSuelo;
  private String descripcioMetricasSuelo;
  private Fisicasuelo fisicasuelo;

    /**
     * Devuelve el valor correspondiente a idmetricasSuelo
     * @return idmetricasSuelo
     */
  public int getIdmetricasSuelo(){
      return this.idmetricasSuelo;
  }

    /**
     * Modifica el valor correspondiente a idmetricasSuelo
     * @param idmetricasSuelo
     */
  public void setIdmetricasSuelo(int idmetricasSuelo){
      this.idmetricasSuelo = idmetricasSuelo;
  }
    /**
     * Devuelve el valor correspondiente a descripcioMetricasSuelo
     * @return descripcioMetricasSuelo
     */
  public String getDescripcioMetricasSuelo(){
      return this.descripcioMetricasSuelo;
  }

    /**
     * Modifica el valor correspondiente a descripcioMetricasSuelo
     * @param descripcioMetricasSuelo
     */
  public void setDescripcioMetricasSuelo(String descripcioMetricasSuelo){
      this.descripcioMetricasSuelo = descripcioMetricasSuelo;
  }
    /**
     * Devuelve el valor correspondiente a fisicaSuelo_idfisicaSuelo
     * @return fisicaSuelo_idfisicaSuelo
     */
  public Fisicasuelo getFisicasuelo(){
      return this.fisicasuelo;
  }

    /**
     * Modifica el valor correspondiente a fisicaSuelo_idfisicaSuelo
     * @param fisicaSuelo_idfisicaSuelo
     */
  public void setFisicasuelo(Fisicasuelo fisicasuelo){
      this.fisicasuelo = fisicasuelo;
  }


}
//That`s all folks!