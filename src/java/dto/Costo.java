/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando eres Ingeniero en sistemas, pero tu vocación siempre fueron los memes  \\

package back.dto;

public class Costo {

  private int idcosto;
  private String descripcionCosto;
  private double valorCosto;
  private Miagroempresa miagroempresa;

    /**
     * Devuelve el valor correspondiente a idcosto
     * @return idcosto
     */
  public int getIdcosto(){
      return this.idcosto;
  }

    /**
     * Modifica el valor correspondiente a idcosto
     * @param idcosto
     */
  public void setIdcosto(int idcosto){
      this.idcosto = idcosto;
  }
    /**
     * Devuelve el valor correspondiente a descripcionCosto
     * @return descripcionCosto
     */
  public String getDescripcionCosto(){
      return this.descripcionCosto;
  }

    /**
     * Modifica el valor correspondiente a descripcionCosto
     * @param descripcionCosto
     */
  public void setDescripcionCosto(String descripcionCosto){
      this.descripcionCosto = descripcionCosto;
  }
    /**
     * Devuelve el valor correspondiente a valorCosto
     * @return valorCosto
     */
  public double getValorCosto(){
      return this.valorCosto;
  }

    /**
     * Modifica el valor correspondiente a valorCosto
     * @param valorCosto
     */
  public void setValorCosto(double valorCosto){
      this.valorCosto = valorCosto;
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


}
//That`s all folks!