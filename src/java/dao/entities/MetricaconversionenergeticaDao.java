/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuenta la leyenda que si gritas 'Soy programador' las nenas caerán a tus pies  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricaconversionenergeticaDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricaconversionenergeticaDao implements IMetricaconversionenergeticaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricaconversionenergeticaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricaconversionenergetica`( `idmetricaConversionEnergetica`, `desripcionMetricaConversionEnergetica`, `conversionEnergetica_idconversionEnergetica`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricaconversionenergetica.getIdmetricaConversionEnergetica());
          consulta.setString(2, metricaconversionenergetica.getDesripcionMetricaConversionEnergetica());
          consulta.setInt(3, metricaconversionenergetica.getConversionenergetica().getIdconversionEnergetica());
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
     * Busca un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricaconversionenergetica select(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaConversionEnergetica`, `desripcionMetricaConversionEnergetica`, `conversionEnergetica_idconversionEnergetica`"
          +"FROM `metricaconversionenergetica`"
          +"WHERE `idmetricaConversionEnergetica`=?");
          consulta.setInt(1, metricaconversionenergetica.getIdmetricaConversionEnergetica());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricaconversionenergetica.setIdmetricaConversionEnergetica(res.getInt("idmetricaConversionEnergetica"));
          metricaconversionenergetica.setDesripcionMetricaConversionEnergetica(res.getString("desripcionMetricaConversionEnergetica"));
           Conversionenergetica conversionenergetica = new Conversionenergetica();
           conversionenergetica.setIdconversionEnergetica(res.getInt("conversionEnergetica_idconversionEnergetica"));
           metricaconversionenergetica.setConversionenergetica(conversionenergetica);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricaconversionenergetica;
  }

    /**
     * Modifica un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricaconversionenergetica` SET`idmetricaConversionEnergetica`=?, `desripcionMetricaConversionEnergetica`=?, `conversionEnergetica_idconversionEnergetica`=? WHERE `idmetricaConversionEnergetica`=? ");
          consulta.setInt(1, metricaconversionenergetica.getIdmetricaConversionEnergetica());
          consulta.setString(2, metricaconversionenergetica.getDesripcionMetricaConversionEnergetica());
          consulta.setInt(3, metricaconversionenergetica.getConversionenergetica().getIdconversionEnergetica());
          consulta.setInt(4, metricaconversionenergetica.getIdmetricaConversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricaconversionenergetica` WHERE `idmetricaConversionEnergetica`=?");
          consulta.setInt(1, metricaconversionenergetica.getIdmetricaConversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricaconversionenergetica en la base de datos.
     * @return ArrayList<Metricaconversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricaconversionenergetica> listAll() throws NullPointerException{
      ArrayList<Metricaconversionenergetica> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaConversionEnergetica`, `desripcionMetricaConversionEnergetica`, `conversionEnergetica_idconversionEnergetica`"
          +"FROM `metricaconversionenergetica`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricaconversionenergetica metricaconversionenergetica= new Metricaconversionenergetica();
          metricaconversionenergetica.setIdmetricaConversionEnergetica(res.getInt("idmetricaConversionEnergetica"));
          metricaconversionenergetica.setDesripcionMetricaConversionEnergetica(res.getString("desripcionMetricaConversionEnergetica"));
           Conversionenergetica conversionenergetica = new Conversionenergetica();
           conversionenergetica.setIdconversionEnergetica(res.getInt("conversionEnergetica_idconversionEnergetica"));
           metricaconversionenergetica.setConversionenergetica(conversionenergetica);

              lista.add(metricaconversionenergetica);
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