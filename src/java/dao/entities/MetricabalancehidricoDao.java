/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Santos frameworks Batman!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricabalancehidricoDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricabalancehidricoDao implements IMetricabalancehidricoDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricabalancehidricoDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricabalancehidrico metricabalancehidrico) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricabalancehidrico`( `idmetricaBalanceHidrico`, `descripcionMetricaBalanceHidrico`, `balanceHidrico_idbalanceHidrico`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricabalancehidrico.getIdmetricaBalanceHidrico());
          consulta.setString(2, metricabalancehidrico.getDescripcionMetricaBalanceHidrico());
          consulta.setInt(3, metricabalancehidrico.getBalancehidrico().getIdbalanceHidrico());
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
     * Busca un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricabalancehidrico select(Metricabalancehidrico metricabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaBalanceHidrico`, `descripcionMetricaBalanceHidrico`, `balanceHidrico_idbalanceHidrico`"
          +"FROM `metricabalancehidrico`"
          +"WHERE `idmetricaBalanceHidrico`=?");
          consulta.setInt(1, metricabalancehidrico.getIdmetricaBalanceHidrico());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricabalancehidrico.setIdmetricaBalanceHidrico(res.getInt("idmetricaBalanceHidrico"));
          metricabalancehidrico.setDescripcionMetricaBalanceHidrico(res.getString("descripcionMetricaBalanceHidrico"));
           Balancehidrico balancehidrico = new Balancehidrico();
           balancehidrico.setIdbalanceHidrico(res.getInt("balanceHidrico_idbalanceHidrico"));
           metricabalancehidrico.setBalancehidrico(balancehidrico);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricabalancehidrico;
  }

    /**
     * Modifica un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricabalancehidrico metricabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricabalancehidrico` SET`idmetricaBalanceHidrico`=?, `descripcionMetricaBalanceHidrico`=?, `balanceHidrico_idbalanceHidrico`=? WHERE `idmetricaBalanceHidrico`=? ");
          consulta.setInt(1, metricabalancehidrico.getIdmetricaBalanceHidrico());
          consulta.setString(2, metricabalancehidrico.getDescripcionMetricaBalanceHidrico());
          consulta.setInt(3, metricabalancehidrico.getBalancehidrico().getIdbalanceHidrico());
          consulta.setInt(4, metricabalancehidrico.getIdmetricaBalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricabalancehidrico metricabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricabalancehidrico` WHERE `idmetricaBalanceHidrico`=?");
          consulta.setInt(1, metricabalancehidrico.getIdmetricaBalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricabalancehidrico en la base de datos.
     * @return ArrayList<Metricabalancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricabalancehidrico> listAll() throws NullPointerException{
      ArrayList<Metricabalancehidrico> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricaBalanceHidrico`, `descripcionMetricaBalanceHidrico`, `balanceHidrico_idbalanceHidrico`"
          +"FROM `metricabalancehidrico`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricabalancehidrico metricabalancehidrico= new Metricabalancehidrico();
          metricabalancehidrico.setIdmetricaBalanceHidrico(res.getInt("idmetricaBalanceHidrico"));
          metricabalancehidrico.setDescripcionMetricaBalanceHidrico(res.getString("descripcionMetricaBalanceHidrico"));
           Balancehidrico balancehidrico = new Balancehidrico();
           balancehidrico.setIdbalanceHidrico(res.getInt("balanceHidrico_idbalanceHidrico"));
           metricabalancehidrico.setBalancehidrico(balancehidrico);

              lista.add(metricabalancehidrico);
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