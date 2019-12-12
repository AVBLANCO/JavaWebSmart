/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Se buscan memeros profesionales. Contacto: El benévolo señor Arciniegas  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IUsuarioDao;
import back.dto.*;
import java.util.ArrayList;

public class UsuarioDao implements IUsuarioDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public UsuarioDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Usuario en la base de datos.
     * @param usuario objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Usuario usuario) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `usuario`( `idusuario`, `nombreUsuario`, `passwordUsuario`, `persona_idpersona`, `finca_idfinca`)"
          +"VALUES (?,?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, usuario.getIdusuario());
          consulta.setString(2, usuario.getNombreUsuario());
          consulta.setString(3, usuario.getPasswordUsuario());
          consulta.setInt(4, usuario.getPersona().getIdpersona());
          consulta.setInt(5, usuario.getFinca().getIdfinca());
          consulta.executeUpdate();
          ResultSet rs = consulta.getGeneratedKeys();
          if(rs.next()){
              last_inserted_id = rs.getInt(1);
          }
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      return last_inserted_id;
  }

    /**
     * Busca un objeto Usuario en la base de datos.
     * @param usuario objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Usuario select(Usuario usuario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idusuario`, `nombreUsuario`, `passwordUsuario`, `persona_idpersona`, `finca_idfinca`"
          +"FROM `usuario`"
          +"WHERE `idusuario`=?");
          consulta.setInt(1, usuario.getIdusuario());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          usuario.setIdusuario(res.getInt("idusuario"));
          usuario.setNombreUsuario(res.getString("nombreUsuario"));
          usuario.setPasswordUsuario(res.getString("passwordUsuario"));
           Persona persona = new Persona();
           persona.setIdpersona(res.getInt("persona_idpersona"));
           usuario.setPersona(persona);
           Finca finca = new Finca();
           finca.setIdfinca(res.getInt("finca_idfinca"));
           usuario.setFinca(finca);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return usuario;
  }

    /**
     * Modifica un objeto Usuario en la base de datos.
     * @param usuario objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Usuario usuario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `usuario` SET`idusuario`=?, `nombreUsuario`=?, `passwordUsuario`=?, `persona_idpersona`=?, `finca_idfinca`=? WHERE `idusuario`=? ");
          consulta.setInt(1, usuario.getIdusuario());
          consulta.setString(2, usuario.getNombreUsuario());
          consulta.setString(3, usuario.getPasswordUsuario());
          consulta.setInt(4, usuario.getPersona().getIdpersona());
          consulta.setInt(5, usuario.getFinca().getIdfinca());
          consulta.setInt(6, usuario.getIdusuario());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Usuario en la base de datos.
     * @param usuario objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Usuario usuario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `usuario` WHERE `idusuario`=?");
          consulta.setInt(1, usuario.getIdusuario());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Usuario en la base de datos.
     * @return ArrayList<Usuario> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Usuario> listAll() throws NullPointerException{
      ArrayList<Usuario> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idusuario`, `nombreUsuario`, `passwordUsuario`, `persona_idpersona`, `finca_idfinca`"
          +"FROM `usuario`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Usuario usuario= new Usuario();
          usuario.setIdusuario(res.getInt("idusuario"));
          usuario.setNombreUsuario(res.getString("nombreUsuario"));
          usuario.setPasswordUsuario(res.getString("passwordUsuario"));
           Persona persona = new Persona();
           persona.setIdpersona(res.getInt("persona_idpersona"));
           usuario.setPersona(persona);
           Finca finca = new Finca();
           finca.setIdfinca(res.getInt("finca_idfinca"));
           usuario.setFinca(finca);

              lista.add(usuario);
          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lista;
  }

    /**
     * Cierra la conexión actual a la base de datos
     */
  @Override
  public void close(){
      try {
        cn.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
  }
}
//That`s all folks!