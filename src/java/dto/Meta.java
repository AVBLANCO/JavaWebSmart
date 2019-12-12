/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Me arreglas mi impresora?  \\

package back.dto;

public class Meta {

  private int idmeta;
  private String descripcionMeta;
  private double valorMeta;
  private Proyeccion proyeccion;

    /**
     * Devuelve el valor correspondiente a idmeta
     * @return idmeta
     */
  public int getIdmeta(){
      return this.idmeta;
  }

    /**
     * Modifica el valor correspondiente a idmeta
     * @param idmeta
     */
  public void setIdmeta(int idmeta){
      this.idmeta = idmeta;
  }
    /**
     * Devuelve el valor correspondiente a descripcionMeta
     * @return descripcionMeta
     */
  public String getDescripcionMeta(){
      return this.descripcionMeta;
  }

    /**
     * Modifica el valor correspondiente a descripcionMeta
     * @param descripcionMeta
     */
  public void setDescripcionMeta(String descripcionMeta){
      this.descripcionMeta = descripcionMeta;
  }
    /**
     * Devuelve el valor correspondiente a valorMeta
     * @return valorMeta
     */
  public double getValorMeta(){
      return this.valorMeta;
  }

    /**
     * Modifica el valor correspondiente a valorMeta
     * @param valorMeta
     */
  public void setValorMeta(double valorMeta){
      this.valorMeta = valorMeta;
  }
    /**
     * Devuelve el valor correspondiente a proyeccion_idproyeccion
     * @return proyeccion_idproyeccion
     */
  public Proyeccion getProyeccion(){
      return this.proyeccion;
  }

    /**
     * Modifica el valor correspondiente a proyeccion_idproyeccion
     * @param proyeccion_idproyeccion
     */
  public void setProyeccion(Proyeccion proyeccion){
      this.proyeccion = proyeccion;
  }


}
//That`s all folks!