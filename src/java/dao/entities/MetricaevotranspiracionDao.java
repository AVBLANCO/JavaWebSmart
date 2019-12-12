/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Anarchy! Apoyando la vagancia desde 2017  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricaevotranspiracionDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricaevotranspiracionDao implements IMetricaevotranspiracionDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricaevotranspiracionDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricaevotranspiracion`( `idmetricaEvotranspiracion`, `descripcionMetricaEvotranspiracion`, `evotranspiracion_idevotranspiracion`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricaevotranspiracion.getIdmetricaEvotranspiracion());
          consulta.setString(2, metricaevotranspiracion.getDescripcionMetricaEvotranspiracion());
          consulta.setInt(3, metricaevotranspiracion.getEvotranspiracion().getIdevotranspiracion());
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
     * Busca un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricaevotranspiracion select(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaEvotranspiracion`, `descripcionMetricaEvotranspiracion`, `evotranspiracion_idevotranspiracion`"
          +"FROM `metricaevotranspiracion`"
          +"WHERE `idmetricaEvotranspiracion`=?");
          consulta.setInt(1, metricaevotranspiracion.getIdmetricaEvotranspiracion());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricaevotranspiracion.setIdmetricaEvotranspiracion(res.getInt("idmetricaEvotranspiracion"));
          metricaevotranspiracion.setDescripcionMetricaEvotranspiracion(res.getString("descripcionMetricaEvotranspiracion"));
           Evotranspiracion evotranspiracion = new Evotranspiracion();
           evotranspiracion.setIdevotranspiracion(res.getInt("evotranspiracion_idevotranspiracion"));
           metricaevotranspiracion.setEvotranspiracion(evotranspiracion);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricaevotranspiracion;
  }

    /**
     * Modifica un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricaevotranspiracion` SET`idmetricaEvotranspiracion`=?, `descripcionMetricaEvotranspiracion`=?, `evotranspiracion_idevotranspiracion`=? WHERE `idmetricaEvotranspiracion`=? ");
          consulta.setInt(1, metricaevotranspiracion.getIdmetricaEvotranspiracion());
          consulta.setString(2, metricaevotranspiracion.getDescripcionMetricaEvotranspiracion());
          consulta.setInt(3, metricaevotranspiracion.getEvotranspiracion().getIdevotranspiracion());
          consulta.setInt(4, metricaevotranspiracion.getIdmetricaEvotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricaevotranspiracion` WHERE `idmetricaEvotranspiracion`=?");
          consulta.setInt(1, metricaevotranspiracion.getIdmetricaEvotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricaevotranspiracion en la base de datos.
     * @return ArrayList<Metricaevotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricaevotranspiracion> listAll() throws NullPointerException{
      ArrayList<Metricaevotranspiracion> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaEvotranspiracion`, `descripcionMetricaEvotranspiracion`, `evotranspiracion_idevotranspiracion`"
          +"FROM `metricaevotranspiracion`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricaevotranspiracion metricaevotranspiracion= new Metricaevotranspiracion();
          metricaevotranspiracion.setIdmetricaEvotranspiracion(res.getInt("idmetricaEvotranspiracion"));
          metricaevotranspiracion.setDescripcionMetricaEvotranspiracion(res.getString("descripcionMetricaEvotranspiracion"));
           Evotranspiracion evotranspiracion = new Evotranspiracion();
           evotranspiracion.setIdevotranspiracion(res.getInt("evotranspiracion_idevotranspiracion"));
           metricaevotranspiracion.setEvotranspiracion(evotranspiracion);

              lista.add(metricaevotranspiracion);
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