/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En lo que a mí respecta, señor Dix, lo imprevisto no existe  \\

package back.dto;

public class Usuario {

  private int idusuario;
  private String nombreUsuario;
  private String passwordUsuario;
  private Persona persona;
  private Finca finca;

    /**
     * Devuelve el valor correspondiente a idusuario
     * @return idusuario
     */
  public int getIdusuario(){
      return this.idusuario;
  }

    /**
     * Modifica el valor correspondiente a idusuario
     * @param idusuario
     */
  public void setIdusuario(int idusuario){
      this.idusuario = idusuario;
  }
    /**
     * Devuelve el valor correspondiente a nombreUsuario
     * @return nombreUsuario
     */
  public String getNombreUsuario(){
      return this.nombreUsuario;
  }

    /**
     * Modifica el valor correspondiente a nombreUsuario
     * @param nombreUsuario
     */
  public void setNombreUsuario(String nombreUsuario){
      this.nombreUsuario = nombreUsuario;
  }
    /**
     * Devuelve el valor correspondiente a passwordUsuario
     * @return passwordUsuario
     */
  public String getPasswordUsuario(){
      return this.passwordUsuario;
  }

    /**
     * Modifica el valor correspondiente a passwordUsuario
     * @param passwordUsuario
     */
  public void setPasswordUsuario(String passwordUsuario){
      this.passwordUsuario = passwordUsuario;
  }
    /**
     * Devuelve el valor correspondiente a persona_idpersona
     * @return persona_idpersona
     */
  public Persona getPersona(){
      return this.persona;
  }

    /**
     * Modifica el valor correspondiente a persona_idpersona
     * @param persona_idpersona
     */
  public void setPersona(Persona persona){
      this.persona = persona;
  }
    /**
     * Devuelve el valor correspondiente a finca_idfinca
     * @return finca_idfinca
     */
  public Finca getFinca(){
      return this.finca;
  }

    /**
     * Modifica el valor correspondiente a finca_idfinca
     * @param finca_idfinca
     */
  public void setFinca(Finca finca){
      this.finca = finca;
  }


}
//That`s all folks!