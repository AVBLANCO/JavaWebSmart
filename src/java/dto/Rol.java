/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Estadistas informan que una linea de código equivale a un sorbo de café  \\

package back.dto;

public class Rol {

  private int idrol;
  private String descripcion;
  private Usuario usuario;

    /**
     * Devuelve el valor correspondiente a idrol
     * @return idrol
     */
  public int getIdrol(){
      return this.idrol;
  }

    /**
     * Modifica el valor correspondiente a idrol
     * @param idrol
     */
  public void setIdrol(int idrol){
      this.idrol = idrol;
  }
    /**
     * Devuelve el valor correspondiente a descripcion
     * @return descripcion
     */
  public String getDescripcion(){
      return this.descripcion;
  }

    /**
     * Modifica el valor correspondiente a descripcion
     * @param descripcion
     */
  public void setDescripcion(String descripcion){
      this.descripcion = descripcion;
  }
    /**
     * Devuelve el valor correspondiente a usuario_idusuario
     * @return usuario_idusuario
     */
  public Usuario getUsuario(){
      return this.usuario;
  }

    /**
     * Modifica el valor correspondiente a usuario_idusuario
     * @param usuario_idusuario
     */
  public void setUsuario(Usuario usuario){
      this.usuario = usuario;
  }


}
//That`s all folks!