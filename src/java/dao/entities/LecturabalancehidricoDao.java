/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Si crees que las mujeres son difíciles, no conoces Anarchy  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturabalancehidricoDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturabalancehidricoDao implements ILecturabalancehidricoDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturabalancehidricoDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturabalancehidrico`( `idlecturaBalanceHidrico`, `fechaLecturaBalanceHidrico`, `valorLecturaBalanceHidrico`, `metricaBalanceHidrico_idmetricaBalanceHidrico`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturabalancehidrico.getIdlecturaBalanceHidrico());
          consulta.setString(2, lecturabalancehidrico.getFechaLecturaBalanceHidrico());
          consulta.setDouble(3, lecturabalancehidrico.getValorLecturaBalanceHidrico());
          consulta.setInt(4, lecturabalancehidrico.getMetricabalancehidrico().getIdmetricaBalanceHidrico());
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
     * Busca un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturabalancehidrico select(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaBalanceHidrico`, `fechaLecturaBalanceHidrico`, `valorLecturaBalanceHidrico`, `metricaBalanceHidrico_idmetricaBalanceHidrico`"
          +"FROM `lecturabalancehidrico`"
          +"WHERE `idlecturaBalanceHidrico`=?");
          consulta.setInt(1, lecturabalancehidrico.getIdlecturaBalanceHidrico());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturabalancehidrico.setIdlecturaBalanceHidrico(res.getInt("idlecturaBalanceHidrico"));
          lecturabalancehidrico.setFechaLecturaBalanceHidrico(res.getString("fechaLecturaBalanceHidrico"));
          lecturabalancehidrico.setValorLecturaBalanceHidrico(res.getDouble("valorLecturaBalanceHidrico"));
           Metricabalancehidrico metricabalancehidrico = new Metricabalancehidrico();
           metricabalancehidrico.setIdmetricaBalanceHidrico(res.getInt("metricaBalanceHidrico_idmetricaBalanceHidrico"));
           lecturabalancehidrico.setMetricabalancehidrico(metricabalancehidrico);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturabalancehidrico;
  }

    /**
     * Modifica un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturabalancehidrico` SET`idlecturaBalanceHidrico`=?, `fechaLecturaBalanceHidrico`=?, `valorLecturaBalanceHidrico`=?, `metricaBalanceHidrico_idmetricaBalanceHidrico`=? WHERE `idlecturaBalanceHidrico`=? ");
          consulta.setInt(1, lecturabalancehidrico.getIdlecturaBalanceHidrico());
          consulta.setString(2, lecturabalancehidrico.getFechaLecturaBalanceHidrico());
          consulta.setDouble(3, lecturabalancehidrico.getValorLecturaBalanceHidrico());
          consulta.setInt(4, lecturabalancehidrico.getMetricabalancehidrico().getIdmetricaBalanceHidrico());
          consulta.setInt(5, lecturabalancehidrico.getIdlecturaBalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturabalancehidrico` WHERE `idlecturaBalanceHidrico`=?");
          consulta.setInt(1, lecturabalancehidrico.getIdlecturaBalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturabalancehidrico en la base de datos.
     * @return ArrayList<Lecturabalancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturabalancehidrico> listAll() throws NullPointerException{
      ArrayList<Lecturabalancehidrico> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaBalanceHidrico`, `fechaLecturaBalanceHidrico`, `valorLecturaBalanceHidrico`, `metricaBalanceHidrico_idmetricaBalanceHidrico`"
          +"FROM `lecturabalancehidrico`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturabalancehidrico lecturabalancehidrico= new Lecturabalancehidrico();
          lecturabalancehidrico.setIdlecturaBalanceHidrico(res.getInt("idlecturaBalanceHidrico"));
          lecturabalancehidrico.setFechaLecturaBalanceHidrico(res.getString("fechaLecturaBalanceHidrico"));
          lecturabalancehidrico.setValorLecturaBalanceHidrico(res.getDouble("valorLecturaBalanceHidrico"));
           Metricabalancehidrico metricabalancehidrico = new Metricabalancehidrico();
           metricabalancehidrico.setIdmetricaBalanceHidrico(res.getInt("metricaBalanceHidrico_idmetricaBalanceHidrico"));
           lecturabalancehidrico.setMetricabalancehidrico(metricabalancehidrico);

              lista.add(lecturabalancehidrico);
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