/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En esto paso mis sábados en la noche ( ¬.¬)  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IFincaDao;
import back.dto.*;
import java.util.ArrayList;

public class FincaDao implements IFincaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public FincaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Finca en la base de datos.
     * @param finca objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Finca finca) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `finca`( `idfinca`, `descripcionFinca`)"
          +"VALUES (?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, finca.getIdfinca());
          consulta.setString(2, finca.getDescripcionFinca());
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
     * Busca un objeto Finca en la base de datos.
     * @param finca objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Finca select(Finca finca) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idfinca`, `descripcionFinca`"
          +"FROM `finca`"
          +"WHERE `idfinca`=?");
          consulta.setInt(1, finca.getIdfinca());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          finca.setIdfinca(res.getInt("idfinca"));
          finca.setDescripcionFinca(res.getString("descripcionFinca"));

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return finca;
  }

    /**
     * Modifica un objeto Finca en la base de datos.
     * @param finca objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Finca finca) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `finca` SET`idfinca`=?, `descripcionFinca`=? WHERE `idfinca`=? ");
          consulta.setInt(1, finca.getIdfinca());
          consulta.setString(2, finca.getDescripcionFinca());
          consulta.setInt(3, finca.getIdfinca());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Finca en la base de datos.
     * @param finca objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Finca finca) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `finca` WHERE `idfinca`=?");
          consulta.setInt(1, finca.getIdfinca());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Finca en la base de datos.
     * @return ArrayList<Finca> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Finca> listAll() throws NullPointerException{
      ArrayList<Finca> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idfinca`, `descripcionFinca`"
          +"FROM `finca`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Finca finca= new Finca();
          finca.setIdfinca(res.getInt("idfinca"));
          finca.setDescripcionFinca(res.getString("descripcionFinca"));

              lista.add(finca);
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