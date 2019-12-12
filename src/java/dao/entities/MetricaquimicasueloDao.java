/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En un lugar de La Mancha, de cuyo nombre no quiero acordarme...  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricaquimicasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricaquimicasueloDao implements IMetricaquimicasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricaquimicasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricaquimicasuelo`( `idmetricaQuimicaSuelo`, `descripcionMetricaQuimicaSuelocol`, `quimicaSuelo_idQuimicaSuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricaquimicasuelo.getIdmetricaQuimicaSuelo());
          consulta.setString(2, metricaquimicasuelo.getDescripcionMetricaQuimicaSuelocol());
          consulta.setInt(3, metricaquimicasuelo.getQuimicasuelo().getIdQuimicaSuelo());
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
     * Busca un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricaquimicasuelo select(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaQuimicaSuelo`, `descripcionMetricaQuimicaSuelocol`, `quimicaSuelo_idQuimicaSuelo`"
          +"FROM `metricaquimicasuelo`"
          +"WHERE `idmetricaQuimicaSuelo`=?");
          consulta.setInt(1, metricaquimicasuelo.getIdmetricaQuimicaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricaquimicasuelo.setIdmetricaQuimicaSuelo(res.getInt("idmetricaQuimicaSuelo"));
          metricaquimicasuelo.setDescripcionMetricaQuimicaSuelocol(res.getString("descripcionMetricaQuimicaSuelocol"));
           Quimicasuelo quimicasuelo = new Quimicasuelo();
           quimicasuelo.setIdQuimicaSuelo(res.getInt("quimicaSuelo_idQuimicaSuelo"));
           metricaquimicasuelo.setQuimicasuelo(quimicasuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricaquimicasuelo;
  }

    /**
     * Modifica un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricaquimicasuelo` SET`idmetricaQuimicaSuelo`=?, `descripcionMetricaQuimicaSuelocol`=?, `quimicaSuelo_idQuimicaSuelo`=? WHERE `idmetricaQuimicaSuelo`=? ");
          consulta.setInt(1, metricaquimicasuelo.getIdmetricaQuimicaSuelo());
          consulta.setString(2, metricaquimicasuelo.getDescripcionMetricaQuimicaSuelocol());
          consulta.setInt(3, metricaquimicasuelo.getQuimicasuelo().getIdQuimicaSuelo());
          consulta.setInt(4, metricaquimicasuelo.getIdmetricaQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricaquimicasuelo` WHERE `idmetricaQuimicaSuelo`=?");
          consulta.setInt(1, metricaquimicasuelo.getIdmetricaQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricaquimicasuelo en la base de datos.
     * @return ArrayList<Metricaquimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricaquimicasuelo> listAll() throws NullPointerException{
      ArrayList<Metricaquimicasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaQuimicaSuelo`, `descripcionMetricaQuimicaSuelocol`, `quimicaSuelo_idQuimicaSuelo`"
          +"FROM `metricaquimicasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricaquimicasuelo metricaquimicasuelo= new Metricaquimicasuelo();
          metricaquimicasuelo.setIdmetricaQuimicaSuelo(res.getInt("idmetricaQuimicaSuelo"));
          metricaquimicasuelo.setDescripcionMetricaQuimicaSuelocol(res.getString("descripcionMetricaQuimicaSuelocol"));
           Quimicasuelo quimicasuelo = new Quimicasuelo();
           quimicasuelo.setIdQuimicaSuelo(res.getInt("quimicaSuelo_idQuimicaSuelo"));
           metricaquimicasuelo.setQuimicasuelo(quimicasuelo);

              lista.add(metricaquimicasuelo);
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