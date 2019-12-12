/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Se buscan memeros profesionales. Contacto: El benévolo señor Arciniegas  \\

package back.dto;

public class Proyeccion {

  private int idproyeccion;
  private String descripcionProyeccion;
  private String fechaProyeccion;
  private Lote lote;

    /**
     * Devuelve el valor correspondiente a idproyeccion
     * @return idproyeccion
     */
  public int getIdproyeccion(){
      return this.idproyeccion;
  }

    /**
     * Modifica el valor correspondiente a idproyeccion
     * @param idproyeccion
     */
  public void setIdproyeccion(int idproyeccion){
      this.idproyeccion = idproyeccion;
  }
    /**
     * Devuelve el valor correspondiente a descripcionProyeccion
     * @return descripcionProyeccion
     */
  public String getDescripcionProyeccion(){
      return this.descripcionProyeccion;
  }

    /**
     * Modifica el valor correspondiente a descripcionProyeccion
     * @param descripcionProyeccion
     */
  public void setDescripcionProyeccion(String descripcionProyeccion){
      this.descripcionProyeccion = descripcionProyeccion;
  }
    /**
     * Devuelve el valor correspondiente a fechaProyeccion
     * @return fechaProyeccion
     */
  public String getFechaProyeccion(){
      return this.fechaProyeccion;
  }

    /**
     * Modifica el valor correspondiente a fechaProyeccion
     * @param fechaProyeccion
     */
  public void setFechaProyeccion(String fechaProyeccion){
      this.fechaProyeccion = fechaProyeccion;
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