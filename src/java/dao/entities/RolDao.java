/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿En serio? ¿Tantos buenos frameworks y estás usando Anarchy?  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IRolDao;
import back.dto.*;
import java.util.ArrayList;

public class RolDao implements IRolDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public RolDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Rol en la base de datos.
     * @param rol objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Rol rol) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `rol`( `idrol`, `descripcion`, `usuario_idusuario`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, rol.getIdrol());
          consulta.setString(2, rol.getDescripcion());
          consulta.setInt(3, rol.getUsuario().getIdusuario());
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
     * Busca un objeto Rol en la base de datos.
     * @param rol objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Rol select(Rol rol) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idrol`, `descripcion`, `usuario_idusuario`"
          +"FROM `rol`"
          +"WHERE `idrol`=?");
          consulta.setInt(1, rol.getIdrol());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          rol.setIdrol(res.getInt("idrol"));
          rol.setDescripcion(res.getString("descripcion"));
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           rol.setUsuario(usuario);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return rol;
  }

    /**
     * Modifica un objeto Rol en la base de datos.
     * @param rol objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Rol rol) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `rol` SET`idrol`=?, `descripcion`=?, `usuario_idusuario`=? WHERE `idrol`=? ");
          consulta.setInt(1, rol.getIdrol());
          consulta.setString(2, rol.getDescripcion());
          consulta.setInt(3, rol.getUsuario().getIdusuario());
          consulta.setInt(4, rol.getIdrol());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Rol en la base de datos.
     * @param rol objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Rol rol) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `rol` WHERE `idrol`=?");
          consulta.setInt(1, rol.getIdrol());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Rol en la base de datos.
     * @return ArrayList<Rol> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Rol> listAll() throws NullPointerException{
      ArrayList<Rol> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idrol`, `descripcion`, `usuario_idusuario`"
          +"FROM `rol`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Rol rol= new Rol();
          rol.setIdrol(res.getInt("idrol"));
          rol.setDescripcion(res.getString("descripcion"));
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           rol.setUsuario(usuario);

              lista.add(rol);
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