/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    No quiero morir sin tener cicatrices.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IUsuario_has_hojarutaDao;
import back.dto.*;
import java.util.ArrayList;

public class Usuario_has_hojarutaDao implements IUsuario_has_hojarutaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public Usuario_has_hojarutaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `usuario_has_hojaruta`( `usuario_idusuario`, `hojaRuta_idhojaRuta`)"
          +"VALUES (?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, usuario_has_hojaruta.getUsuario().getIdusuario());
          consulta.setInt(2, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());
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
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Usuario_has_hojaruta select(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `usuario_idusuario`, `hojaRuta_idhojaRuta`"
          +"FROM `usuario_has_hojaruta`"
          +"WHERE `usuario_idusuario`=? AND`hojaRuta_idhojaRuta`=?");
          consulta.setInt(1, usuario_has_hojaruta.getUsuario().getIdusuario());
          consulta.setInt(2, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           usuario_has_hojaruta.setUsuario(usuario);
           Hojaruta hojaruta = new Hojaruta();
           hojaruta.setIdhojaRuta(res.getInt("hojaRuta_idhojaRuta"));
           usuario_has_hojaruta.setHojaruta(hojaruta);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return usuario_has_hojaruta;
  }

    /**
     * Modifica un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `usuario_has_hojaruta` SET`usuario_idusuario`=?, `hojaRuta_idhojaRuta`=? WHERE `usuario_idusuario`=? AND `hojaRuta_idhojaRuta`=? ");
          consulta.setInt(1, usuario_has_hojaruta.getUsuario().getIdusuario());
          consulta.setInt(2, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());
          consulta.setInt(3, usuario_has_hojaruta.getUsuario().getIdusuario());
          consulta.setInt(4, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `usuario_has_hojaruta` WHERE `usuario_idusuario`=? AND`hojaRuta_idhojaRuta`=?");
          consulta.setInt(1, usuario_has_hojaruta.getUsuario().getIdusuario());
          consulta.setInt(2, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Usuario_has_hojaruta en la base de datos.
     * @return ArrayList<Usuario_has_hojaruta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Usuario_has_hojaruta> listAll() throws NullPointerException{
      ArrayList<Usuario_has_hojaruta> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `usuario_idusuario`, `hojaRuta_idhojaRuta`"
          +"FROM `usuario_has_hojaruta`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Usuario_has_hojaruta usuario_has_hojaruta= new Usuario_has_hojaruta();
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           usuario_has_hojaruta.setUsuario(usuario);
           Hojaruta hojaruta = new Hojaruta();
           hojaruta.setIdhojaRuta(res.getInt("hojaRuta_idhojaRuta"));
           usuario_has_hojaruta.setHojaruta(hojaruta);

              lista.add(usuario_has_hojaruta);
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
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return ArrayList<Usuario_has_hojaruta> Puede contener los objetos consultados o estar vacío
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Usuario_has_hojaruta> listByUsuario(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      ArrayList<Usuario_has_hojaruta> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `usuario_idusuario`, `hojaRuta_idhojaRuta`"
          +"FROM `usuario_has_hojaruta`"
          +"WHERE `usuario_idusuario`=?");
          consulta.setInt(1, usuario_has_hojaruta.getUsuario().getIdusuario());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           usuario_has_hojaruta.setUsuario(usuario);
           Hojaruta hojaruta = new Hojaruta();
           hojaruta.setIdhojaRuta(res.getInt("hojaRuta_idhojaRuta"));
           usuario_has_hojaruta.setHojaruta(hojaruta);

              lista.add(usuario_has_hojaruta);
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
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return ArrayList<Usuario_has_hojaruta> Puede contener los objetos consultados o estar vacío
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Usuario_has_hojaruta> listByHojaruta(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException{
      ArrayList<Usuario_has_hojaruta> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `usuario_idusuario`, `hojaRuta_idhojaRuta`"
          +"FROM `usuario_has_hojaruta`"
          +"WHERE `hojaRuta_idhojaRuta`=?");
          consulta.setInt(1, usuario_has_hojaruta.getHojaruta().getIdhojaRuta());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
           Usuario usuario = new Usuario();
           usuario.setIdusuario(res.getInt("usuario_idusuario"));
           usuario_has_hojaruta.setUsuario(usuario);
           Hojaruta hojaruta = new Hojaruta();
           hojaruta.setIdhojaRuta(res.getInt("hojaRuta_idhojaRuta"));
           usuario_has_hojaruta.setHojaruta(hojaruta);

              lista.add(usuario_has_hojaruta);
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