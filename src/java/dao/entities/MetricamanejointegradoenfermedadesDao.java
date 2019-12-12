/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ella existió sólo en un sueño. Él es un poema que el poeta nunca escribió.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricamanejointegradoenfermedadesDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricamanejointegradoenfermedadesDao implements IMetricamanejointegradoenfermedadesDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricamanejointegradoenfermedadesDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricamanejointegradoenfermedades`( `idmetricaManejoIntegradoEnfermedades`, `descricionMetricaManejoIntegradoEnfermedades`, `manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricamanejointegradoenfermedades.getIdmetricaManejoIntegradoEnfermedades());
          consulta.setString(2, metricamanejointegradoenfermedades.getDescricionMetricaManejoIntegradoEnfermedades());
          consulta.setInt(3, metricamanejointegradoenfermedades.getManejointegradoenfermedades().getIdmanejoIntegradoEnfermedades());
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
     * Busca un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricamanejointegradoenfermedades select(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaManejoIntegradoEnfermedades`, `descricionMetricaManejoIntegradoEnfermedades`, `manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades`"
          +"FROM `metricamanejointegradoenfermedades`"
          +"WHERE `idmetricaManejoIntegradoEnfermedades`=?");
          consulta.setInt(1, metricamanejointegradoenfermedades.getIdmetricaManejoIntegradoEnfermedades());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(res.getInt("idmetricaManejoIntegradoEnfermedades"));
          metricamanejointegradoenfermedades.setDescricionMetricaManejoIntegradoEnfermedades(res.getString("descricionMetricaManejoIntegradoEnfermedades"));
           Manejointegradoenfermedades manejointegradoenfermedades = new Manejointegradoenfermedades();
           manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(res.getInt("manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades"));
           metricamanejointegradoenfermedades.setManejointegradoenfermedades(manejointegradoenfermedades);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricamanejointegradoenfermedades;
  }

    /**
     * Modifica un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricamanejointegradoenfermedades` SET`idmetricaManejoIntegradoEnfermedades`=?, `descricionMetricaManejoIntegradoEnfermedades`=?, `manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades`=? WHERE `idmetricaManejoIntegradoEnfermedades`=? ");
          consulta.setInt(1, metricamanejointegradoenfermedades.getIdmetricaManejoIntegradoEnfermedades());
          consulta.setString(2, metricamanejointegradoenfermedades.getDescricionMetricaManejoIntegradoEnfermedades());
          consulta.setInt(3, metricamanejointegradoenfermedades.getManejointegradoenfermedades().getIdmanejoIntegradoEnfermedades());
          consulta.setInt(4, metricamanejointegradoenfermedades.getIdmetricaManejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricamanejointegradoenfermedades` WHERE `idmetricaManejoIntegradoEnfermedades`=?");
          consulta.setInt(1, metricamanejointegradoenfermedades.getIdmetricaManejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricamanejointegradoenfermedades en la base de datos.
     * @return ArrayList<Metricamanejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricamanejointegradoenfermedades> listAll() throws NullPointerException{
      ArrayList<Metricamanejointegradoenfermedades> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaManejoIntegradoEnfermedades`, `descricionMetricaManejoIntegradoEnfermedades`, `manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades`"
          +"FROM `metricamanejointegradoenfermedades`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricamanejointegradoenfermedades metricamanejointegradoenfermedades= new Metricamanejointegradoenfermedades();
          metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(res.getInt("idmetricaManejoIntegradoEnfermedades"));
          metricamanejointegradoenfermedades.setDescricionMetricaManejoIntegradoEnfermedades(res.getString("descricionMetricaManejoIntegradoEnfermedades"));
           Manejointegradoenfermedades manejointegradoenfermedades = new Manejointegradoenfermedades();
           manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(res.getInt("manejoIntegradoEnfermedades_idmanejoIntegradoEnfermedades"));
           metricamanejointegradoenfermedades.setManejointegradoenfermedades(manejointegradoenfermedades);

              lista.add(metricamanejointegradoenfermedades);
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