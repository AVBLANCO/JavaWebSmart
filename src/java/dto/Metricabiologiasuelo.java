/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La noche está estrellada, y tiritan, azules, los astros, a lo lejos  \\

package back.dto;

public class Metricabiologiasuelo {

  private int idmetricaBiologiaSuelo;
  private String descripcionMetricaBiologiaSuelo;
  private Biologiasuelo biologiasuelo;

    /**
     * Devuelve el valor correspondiente a idmetricaBiologiaSuelo
     * @return idmetricaBiologiaSuelo
     */
  public int getIdmetricaBiologiaSuelo(){
      return this.idmetricaBiologiaSuelo;
  }

    /**
     * Modifica el valor correspondiente a idmetricaBiologiaSuelo
     * @param idmetricaBiologiaSuelo
     */
  public void setIdmetricaBiologiaSuelo(int idmetricaBiologiaSuelo){
      this.idmetricaBiologiaSuelo = idmetricaBiologiaSuelo;
  }
    /**
     * Devuelve el valor correspondiente a descripcionMetricaBiologiaSuelo
     * @return descripcionMetricaBiologiaSuelo
     */
  public String getDescripcionMetricaBiologiaSuelo(){
      return this.descripcionMetricaBiologiaSuelo;
  }

    /**
     * Modifica el valor correspondiente a descripcionMetricaBiologiaSuelo
     * @param descripcionMetricaBiologiaSuelo
     */
  public void setDescripcionMetricaBiologiaSuelo(String descripcionMetricaBiologiaSuelo){
      this.descripcionMetricaBiologiaSuelo = descripcionMetricaBiologiaSuelo;
  }
    /**
     * Devuelve el valor correspondiente a biologiaSuelo_idbiologiaSuelo
     * @return biologiaSuelo_idbiologiaSuelo
     */
  public Biologiasuelo getBiologiasuelo(){
      return this.biologiasuelo;
  }

    /**
     * Modifica el valor correspondiente a biologiaSuelo_idbiologiaSuelo
     * @param biologiaSuelo_idbiologiaSuelo
     */
  public void setBiologiasuelo(Biologiasuelo biologiasuelo){
      this.biologiasuelo = biologiasuelo;
  }


}
//That`s all folks!