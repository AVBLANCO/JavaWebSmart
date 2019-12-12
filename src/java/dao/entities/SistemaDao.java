/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Muerte a todos los humanos!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ISistemaDao;
import back.dto.*;
import java.util.ArrayList;

public class SistemaDao implements ISistemaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public SistemaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Sistema en la base de datos.
     * @param sistema objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Sistema sistema) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `sistema`( `idsistema`, `descripcion`)"
          +"VALUES (?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, sistema.getIdsistema());
          consulta.setString(2, sistema.getDescripcion());
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
     * Busca un objeto Sistema en la base de datos.
     * @param sistema objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Sistema select(Sistema sistema) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idsistema`, `descripcion`"
          +"FROM `sistema`"
          +"WHERE `idsistema`=?");
          consulta.setInt(1, sistema.getIdsistema());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          sistema.setIdsistema(res.getInt("idsistema"));
          sistema.setDescripcion(res.getString("descripcion"));

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return sistema;
  }

    /**
     * Modifica un objeto Sistema en la base de datos.
     * @param sistema objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Sistema sistema) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `sistema` SET`idsistema`=?, `descripcion`=? WHERE `idsistema`=? ");
          consulta.setInt(1, sistema.getIdsistema());
          consulta.setString(2, sistema.getDescripcion());
          consulta.setInt(3, sistema.getIdsistema());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Sistema en la base de datos.
     * @param sistema objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Sistema sistema) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `sistema` WHERE `idsistema`=?");
          consulta.setInt(1, sistema.getIdsistema());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Sistema en la base de datos.
     * @return ArrayList<Sistema> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Sistema> listAll() throws NullPointerException{
      ArrayList<Sistema> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idsistema`, `descripcion`"
          +"FROM `sistema`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Sistema sistema= new Sistema();
          sistema.setIdsistema(res.getInt("idsistema"));
          sistema.setDescripcion(res.getString("descripcion"));

              lista.add(sistema);
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