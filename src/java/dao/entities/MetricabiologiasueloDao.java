/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    No quiero morir sin tener cicatrices.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricabiologiasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricabiologiasueloDao implements IMetricabiologiasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricabiologiasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricabiologiasuelo`( `idmetricaBiologiaSuelo`, `descripcionMetricaBiologiaSuelo`, `biologiaSuelo_idbiologiaSuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricabiologiasuelo.getIdmetricaBiologiaSuelo());
          consulta.setString(2, metricabiologiasuelo.getDescripcionMetricaBiologiaSuelo());
          consulta.setInt(3, metricabiologiasuelo.getBiologiasuelo().getIdbiologiaSuelo());
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
     * Busca un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricabiologiasuelo select(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaBiologiaSuelo`, `descripcionMetricaBiologiaSuelo`, `biologiaSuelo_idbiologiaSuelo`"
          +"FROM `metricabiologiasuelo`"
          +"WHERE `idmetricaBiologiaSuelo`=?");
          consulta.setInt(1, metricabiologiasuelo.getIdmetricaBiologiaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricabiologiasuelo.setIdmetricaBiologiaSuelo(res.getInt("idmetricaBiologiaSuelo"));
          metricabiologiasuelo.setDescripcionMetricaBiologiaSuelo(res.getString("descripcionMetricaBiologiaSuelo"));
           Biologiasuelo biologiasuelo = new Biologiasuelo();
           biologiasuelo.setIdbiologiaSuelo(res.getInt("biologiaSuelo_idbiologiaSuelo"));
           metricabiologiasuelo.setBiologiasuelo(biologiasuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricabiologiasuelo;
  }

    /**
     * Modifica un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricabiologiasuelo` SET`idmetricaBiologiaSuelo`=?, `descripcionMetricaBiologiaSuelo`=?, `biologiaSuelo_idbiologiaSuelo`=? WHERE `idmetricaBiologiaSuelo`=? ");
          consulta.setInt(1, metricabiologiasuelo.getIdmetricaBiologiaSuelo());
          consulta.setString(2, metricabiologiasuelo.getDescripcionMetricaBiologiaSuelo());
          consulta.setInt(3, metricabiologiasuelo.getBiologiasuelo().getIdbiologiaSuelo());
          consulta.setInt(4, metricabiologiasuelo.getIdmetricaBiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricabiologiasuelo` WHERE `idmetricaBiologiaSuelo`=?");
          consulta.setInt(1, metricabiologiasuelo.getIdmetricaBiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricabiologiasuelo en la base de datos.
     * @return ArrayList<Metricabiologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricabiologiasuelo> listAll() throws NullPointerException{
      ArrayList<Metricabiologiasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaBiologiaSuelo`, `descripcionMetricaBiologiaSuelo`, `biologiaSuelo_idbiologiaSuelo`"
          +"FROM `metricabiologiasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricabiologiasuelo metricabiologiasuelo= new Metricabiologiasuelo();
          metricabiologiasuelo.setIdmetricaBiologiaSuelo(res.getInt("idmetricaBiologiaSuelo"));
          metricabiologiasuelo.setDescripcionMetricaBiologiaSuelo(res.getString("descripcionMetricaBiologiaSuelo"));
           Biologiasuelo biologiasuelo = new Biologiasuelo();
           biologiasuelo.setIdbiologiaSuelo(res.getInt("biologiaSuelo_idbiologiaSuelo"));
           metricabiologiasuelo.setBiologiasuelo(biologiasuelo);

              lista.add(metricabiologiasuelo);
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