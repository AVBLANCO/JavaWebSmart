/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Vine a Comala porque me dijeron que acá vivía mi padre, un tal Pedro Páramo.  \\

package back.dto;

public class Historico {

  private int idhistorico;
  private String descripcionHistorico;
  private Miagroempresa miagroempresa;
  private double valorHistorico;

    /**
     * Devuelve el valor correspondiente a idhistorico
     * @return idhistorico
     */
  public int getIdhistorico(){
      return this.idhistorico;
  }

    /**
     * Modifica el valor correspondiente a idhistorico
     * @param idhistorico
     */
  public void setIdhistorico(int idhistorico){
      this.idhistorico = idhistorico;
  }
    /**
     * Devuelve el valor correspondiente a descripcionHistorico
     * @return descripcionHistorico
     */
  public String getDescripcionHistorico(){
      return this.descripcionHistorico;
  }

    /**
     * Modifica el valor correspondiente a descripcionHistorico
     * @param descripcionHistorico
     */
  public void setDescripcionHistorico(String descripcionHistorico){
      this.descripcionHistorico = descripcionHistorico;
  }
    /**
     * Devuelve el valor correspondiente a miAgroempresa_idmiAgroempresa
     * @return miAgroempresa_idmiAgroempresa
     */
  public Miagroempresa getMiagroempresa(){
      return this.miagroempresa;
  }

    /**
     * Modifica el valor correspondiente a miAgroempresa_idmiAgroempresa
     * @param miAgroempresa_idmiAgroempresa
     */
  public void setMiagroempresa(Miagroempresa miagroempresa){
      this.miagroempresa = miagroempresa;
  }
    /**
     * Devuelve el valor correspondiente a valorHistorico
     * @return valorHistorico
     */
  public double getValorHistorico(){
      return this.valorHistorico;
  }

    /**
     * Modifica el valor correspondiente a valorHistorico
     * @param valorHistorico
     */
  public void setValorHistorico(double valorHistorico){
      this.valorHistorico = valorHistorico;
  }


}
//That`s all folks!