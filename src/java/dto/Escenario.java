/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando Gregorio Samsa se despertó una mañana después de un sueño intranquilo, se encontró sobre su cama convertido en un monstruoso insecto.  \\

package back.dto;

public class Escenario {

  private int idescenario;
  private String descripcionEscenario;
  private Proyeccion proyeccion;
  private int valorEscenario;

    /**
     * Devuelve el valor correspondiente a idescenario
     * @return idescenario
     */
  public int getIdescenario(){
      return this.idescenario;
  }

    /**
     * Modifica el valor correspondiente a idescenario
     * @param idescenario
     */
  public void setIdescenario(int idescenario){
      this.idescenario = idescenario;
  }
    /**
     * Devuelve el valor correspondiente a descripcionEscenario
     * @return descripcionEscenario
     */
  public String getDescripcionEscenario(){
      return this.descripcionEscenario;
  }

    /**
     * Modifica el valor correspondiente a descripcionEscenario
     * @param descripcionEscenario
     */
  public void setDescripcionEscenario(String descripcionEscenario){
      this.descripcionEscenario = descripcionEscenario;
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
    /**
     * Devuelve el valor correspondiente a valorEscenario
     * @return valorEscenario
     */
  public int getValorEscenario(){
      return this.valorEscenario;
  }

    /**
     * Modifica el valor correspondiente a valorEscenario
     * @param valorEscenario
     */
  public void setValorEscenario(int valorEscenario){
      this.valorEscenario = valorEscenario;
  }


}
//That`s all folks!