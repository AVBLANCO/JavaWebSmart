/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Sabías que hay una vida afuera de tu cuarto?  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IEscenarioDao;
import back.dto.*;
import java.util.ArrayList;

public class EscenarioDao implements IEscenarioDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public EscenarioDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Escenario en la base de datos.
     * @param escenario objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Escenario escenario) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `escenario`( `idescenario`, `descripcionEscenario`, `proyeccion_idproyeccion`, `valorEscenario`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, escenario.getIdescenario());
          consulta.setString(2, escenario.getDescripcionEscenario());
          consulta.setInt(3, escenario.getProyeccion().getIdproyeccion());
          consulta.setInt(4, escenario.getValorEscenario());
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
     * Busca un objeto Escenario en la base de datos.
     * @param escenario objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Escenario select(Escenario escenario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idescenario`, `descripcionEscenario`, `proyeccion_idproyeccion`, `valorEscenario`"
          +"FROM `escenario`"
          +"WHERE `idescenario`=?");
          consulta.setInt(1, escenario.getIdescenario());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          escenario.setIdescenario(res.getInt("idescenario"));
          escenario.setDescripcionEscenario(res.getString("descripcionEscenario"));
           Proyeccion proyeccion = new Proyeccion();
           proyeccion.setIdproyeccion(res.getInt("proyeccion_idproyeccion"));
           escenario.setProyeccion(proyeccion);
          escenario.setValorEscenario(res.getInt("valorEscenario"));

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return escenario;
  }

    /**
     * Modifica un objeto Escenario en la base de datos.
     * @param escenario objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Escenario escenario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `escenario` SET`idescenario`=?, `descripcionEscenario`=?, `proyeccion_idproyeccion`=?, `valorEscenario`=? WHERE `idescenario`=? ");
          consulta.setInt(1, escenario.getIdescenario());
          consulta.setString(2, escenario.getDescripcionEscenario());
          consulta.setInt(3, escenario.getProyeccion().getIdproyeccion());
          consulta.setInt(4, escenario.getValorEscenario());
          consulta.setInt(5, escenario.getIdescenario());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Escenario en la base de datos.
     * @param escenario objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Escenario escenario) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `escenario` WHERE `idescenario`=?");
          consulta.setInt(1, escenario.getIdescenario());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Escenario en la base de datos.
     * @return ArrayList<Escenario> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Escenario> listAll() throws NullPointerException{
      ArrayList<Escenario> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idescenario`, `descripcionEscenario`, `proyeccion_idproyeccion`, `valorEscenario`"
          +"FROM `escenario`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Escenario escenario= new Escenario();
          escenario.setIdescenario(res.getInt("idescenario"));
          escenario.setDescripcionEscenario(res.getString("descripcionEscenario"));
           Proyeccion proyeccion = new Proyeccion();
           proyeccion.setIdproyeccion(res.getInt("proyeccion_idproyeccion"));
           escenario.setProyeccion(proyeccion);
          escenario.setValorEscenario(res.getInt("valorEscenario"));

              lista.add(escenario);
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