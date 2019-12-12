/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando Gregorio Samsa se despertó una mañana después de un sueño intranquilo, se encontró sobre su cama convertido en un monstruoso insecto.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricamanejoplagasDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricamanejoplagasDao implements IMetricamanejoplagasDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricamanejoplagasDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricamanejoplagas metricamanejoplagas) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricamanejoplagas`( `idmetricaManejoPlagas`, `descripcionMetricaManejoPlagas`, `manejoIntegradoPlagas_idmanejoIntegradoPlagas`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricamanejoplagas.getIdmetricaManejoPlagas());
          consulta.setString(2, metricamanejoplagas.getDescripcionMetricaManejoPlagas());
          consulta.setInt(3, metricamanejoplagas.getManejointegradoplagas().getIdmanejoIntegradoPlagas());
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
     * Busca un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricamanejoplagas select(Metricamanejoplagas metricamanejoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaManejoPlagas`, `descripcionMetricaManejoPlagas`, `manejoIntegradoPlagas_idmanejoIntegradoPlagas`"
          +"FROM `metricamanejoplagas`"
          +"WHERE `idmetricaManejoPlagas`=?");
          consulta.setInt(1, metricamanejoplagas.getIdmetricaManejoPlagas());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricamanejoplagas.setIdmetricaManejoPlagas(res.getInt("idmetricaManejoPlagas"));
          metricamanejoplagas.setDescripcionMetricaManejoPlagas(res.getString("descripcionMetricaManejoPlagas"));
           Manejointegradoplagas manejointegradoplagas = new Manejointegradoplagas();
           manejointegradoplagas.setIdmanejoIntegradoPlagas(res.getInt("manejoIntegradoPlagas_idmanejoIntegradoPlagas"));
           metricamanejoplagas.setManejointegradoplagas(manejointegradoplagas);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricamanejoplagas;
  }

    /**
     * Modifica un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricamanejoplagas metricamanejoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricamanejoplagas` SET`idmetricaManejoPlagas`=?, `descripcionMetricaManejoPlagas`=?, `manejoIntegradoPlagas_idmanejoIntegradoPlagas`=? WHERE `idmetricaManejoPlagas`=? ");
          consulta.setInt(1, metricamanejoplagas.getIdmetricaManejoPlagas());
          consulta.setString(2, metricamanejoplagas.getDescripcionMetricaManejoPlagas());
          consulta.setInt(3, metricamanejoplagas.getManejointegradoplagas().getIdmanejoIntegradoPlagas());
          consulta.setInt(4, metricamanejoplagas.getIdmetricaManejoPlagas());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricamanejoplagas metricamanejoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricamanejoplagas` WHERE `idmetricaManejoPlagas`=?");
          consulta.setInt(1, metricamanejoplagas.getIdmetricaManejoPlagas());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricamanejoplagas en la base de datos.
     * @return ArrayList<Metricamanejoplagas> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricamanejoplagas> listAll() throws NullPointerException{
      ArrayList<Metricamanejoplagas> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaManejoPlagas`, `descripcionMetricaManejoPlagas`, `manejoIntegradoPlagas_idmanejoIntegradoPlagas`"
          +"FROM `metricamanejoplagas`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricamanejoplagas metricamanejoplagas= new Metricamanejoplagas();
          metricamanejoplagas.setIdmetricaManejoPlagas(res.getInt("idmetricaManejoPlagas"));
          metricamanejoplagas.setDescripcionMetricaManejoPlagas(res.getString("descripcionMetricaManejoPlagas"));
           Manejointegradoplagas manejointegradoplagas = new Manejointegradoplagas();
           manejointegradoplagas.setIdmanejoIntegradoPlagas(res.getInt("manejoIntegradoPlagas_idmanejoIntegradoPlagas"));
           metricamanejoplagas.setManejointegradoplagas(manejointegradoplagas);

              lista.add(metricamanejoplagas);
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