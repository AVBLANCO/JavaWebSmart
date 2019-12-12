/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Has escuchado hablar del grandioso señor Arciniegas?  \\

package back.dto;

public class Miagroempresa {

  private int idmiAgroempresa;
  private String descipcionMiAgroempresa;
  private Lote lote;

    /**
     * Devuelve el valor correspondiente a idmiAgroempresa
     * @return idmiAgroempresa
     */
  public int getIdmiAgroempresa(){
      return this.idmiAgroempresa;
  }

    /**
     * Modifica el valor correspondiente a idmiAgroempresa
     * @param idmiAgroempresa
     */
  public void setIdmiAgroempresa(int idmiAgroempresa){
      this.idmiAgroempresa = idmiAgroempresa;
  }
    /**
     * Devuelve el valor correspondiente a descipcionMiAgroempresa
     * @return descipcionMiAgroempresa
     */
  public String getDescipcionMiAgroempresa(){
      return this.descipcionMiAgroempresa;
  }

    /**
     * Modifica el valor correspondiente a descipcionMiAgroempresa
     * @param descipcionMiAgroempresa
     */
  public void setDescipcionMiAgroempresa(String descipcionMiAgroempresa){
      this.descipcionMiAgroempresa = descipcionMiAgroempresa;
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