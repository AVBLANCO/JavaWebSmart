/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ahora tú puedes ser el tipo con el látigo  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturaevotranspiracionDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturaevotranspiracionDao implements ILecturaevotranspiracionDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturaevotranspiracionDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturaevotranspiracion`( `idlecturaEvotranspiracion`, `fechaLecturaEvotranspiracion`, `valorLecturaEvotranspiracion`, `metricaEvotranspiracion_idmetricaEvotranspiracion`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturaevotranspiracion.getIdlecturaEvotranspiracion());
          consulta.setString(2, lecturaevotranspiracion.getFechaLecturaEvotranspiracion());
          consulta.setDouble(3, lecturaevotranspiracion.getValorLecturaEvotranspiracion());
          consulta.setInt(4, lecturaevotranspiracion.getMetricaevotranspiracion().getIdmetricaEvotranspiracion());
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
     * Busca un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturaevotranspiracion select(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaEvotranspiracion`, `fechaLecturaEvotranspiracion`, `valorLecturaEvotranspiracion`, `metricaEvotranspiracion_idmetricaEvotranspiracion`"
          +"FROM `lecturaevotranspiracion`"
          +"WHERE `idlecturaEvotranspiracion`=?");
          consulta.setInt(1, lecturaevotranspiracion.getIdlecturaEvotranspiracion());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturaevotranspiracion.setIdlecturaEvotranspiracion(res.getInt("idlecturaEvotranspiracion"));
          lecturaevotranspiracion.setFechaLecturaEvotranspiracion(res.getString("fechaLecturaEvotranspiracion"));
          lecturaevotranspiracion.setValorLecturaEvotranspiracion(res.getDouble("valorLecturaEvotranspiracion"));
           Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
           metricaevotranspiracion.setIdmetricaEvotranspiracion(res.getInt("metricaEvotranspiracion_idmetricaEvotranspiracion"));
           lecturaevotranspiracion.setMetricaevotranspiracion(metricaevotranspiracion);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturaevotranspiracion;
  }

    /**
     * Modifica un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturaevotranspiracion` SET`idlecturaEvotranspiracion`=?, `fechaLecturaEvotranspiracion`=?, `valorLecturaEvotranspiracion`=?, `metricaEvotranspiracion_idmetricaEvotranspiracion`=? WHERE `idlecturaEvotranspiracion`=? ");
          consulta.setInt(1, lecturaevotranspiracion.getIdlecturaEvotranspiracion());
          consulta.setString(2, lecturaevotranspiracion.getFechaLecturaEvotranspiracion());
          consulta.setDouble(3, lecturaevotranspiracion.getValorLecturaEvotranspiracion());
          consulta.setInt(4, lecturaevotranspiracion.getMetricaevotranspiracion().getIdmetricaEvotranspiracion());
          consulta.setInt(5, lecturaevotranspiracion.getIdlecturaEvotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturaevotranspiracion` WHERE `idlecturaEvotranspiracion`=?");
          consulta.setInt(1, lecturaevotranspiracion.getIdlecturaEvotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturaevotranspiracion en la base de datos.
     * @return ArrayList<Lecturaevotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturaevotranspiracion> listAll() throws NullPointerException{
      ArrayList<Lecturaevotranspiracion> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaEvotranspiracion`, `fechaLecturaEvotranspiracion`, `valorLecturaEvotranspiracion`, `metricaEvotranspiracion_idmetricaEvotranspiracion`"
          +"FROM `lecturaevotranspiracion`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturaevotranspiracion lecturaevotranspiracion= new Lecturaevotranspiracion();
          lecturaevotranspiracion.setIdlecturaEvotranspiracion(res.getInt("idlecturaEvotranspiracion"));
          lecturaevotranspiracion.setFechaLecturaEvotranspiracion(res.getString("fechaLecturaEvotranspiracion"));
          lecturaevotranspiracion.setValorLecturaEvotranspiracion(res.getDouble("valorLecturaEvotranspiracion"));
           Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
           metricaevotranspiracion.setIdmetricaEvotranspiracion(res.getInt("metricaEvotranspiracion_idmetricaEvotranspiracion"));
           lecturaevotranspiracion.setMetricaevotranspiracion(metricaevotranspiracion);

              lista.add(lecturaevotranspiracion);
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