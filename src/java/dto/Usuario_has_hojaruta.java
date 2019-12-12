/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    No dejes el código del futuro en manos humanas  \\

package back.dto;

public class Usuario_has_hojaruta {

  private Usuario usuario;
  private Hojaruta hojaruta;

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
    /**
     * Devuelve el valor correspondiente a hojaRuta_idhojaRuta
     * @return hojaRuta_idhojaRuta
     */
  public Hojaruta getHojaruta(){
      return this.hojaruta;
  }

    /**
     * Modifica el valor correspondiente a hojaRuta_idhojaRuta
     * @param hojaRuta_idhojaRuta
     */
  public void setHojaruta(Hojaruta hojaruta){
      this.hojaruta = hojaruta;
  }


}
//That`s all folks!