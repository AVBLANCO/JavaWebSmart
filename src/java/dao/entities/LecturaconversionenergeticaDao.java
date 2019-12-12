/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Tienes que considerar la posibilidad de que a Dios no le caes bien.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturaconversionenergeticaDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturaconversionenergeticaDao implements ILecturaconversionenergeticaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturaconversionenergeticaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturaconversionenergetica`( `idlecturaConversionEnergetica`, `fechaLecturaConversionEnergetica`, `valorLecturaConversionEnergeticacol`, `metricaConversionEnergetica_idmetricaConversionEnergetica`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturaconversionenergetica.getIdlecturaConversionEnergetica());
          consulta.setString(2, lecturaconversionenergetica.getFechaLecturaConversionEnergetica());
          consulta.setDouble(3, lecturaconversionenergetica.getValorLecturaConversionEnergeticacol());
          consulta.setInt(4, lecturaconversionenergetica.getMetricaconversionenergetica().getIdmetricaConversionEnergetica());
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
     * Busca un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturaconversionenergetica select(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaConversionEnergetica`, `fechaLecturaConversionEnergetica`, `valorLecturaConversionEnergeticacol`, `metricaConversionEnergetica_idmetricaConversionEnergetica`"
          +"FROM `lecturaconversionenergetica`"
          +"WHERE `idlecturaConversionEnergetica`=?");
          consulta.setInt(1, lecturaconversionenergetica.getIdlecturaConversionEnergetica());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturaconversionenergetica.setIdlecturaConversionEnergetica(res.getInt("idlecturaConversionEnergetica"));
          lecturaconversionenergetica.setFechaLecturaConversionEnergetica(res.getString("fechaLecturaConversionEnergetica"));
          lecturaconversionenergetica.setValorLecturaConversionEnergeticacol(res.getDouble("valorLecturaConversionEnergeticacol"));
           Metricaconversionenergetica metricaconversionenergetica = new Metricaconversionenergetica();
           metricaconversionenergetica.setIdmetricaConversionEnergetica(res.getInt("metricaConversionEnergetica_idmetricaConversionEnergetica"));
           lecturaconversionenergetica.setMetricaconversionenergetica(metricaconversionenergetica);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturaconversionenergetica;
  }

    /**
     * Modifica un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturaconversionenergetica` SET`idlecturaConversionEnergetica`=?, `fechaLecturaConversionEnergetica`=?, `valorLecturaConversionEnergeticacol`=?, `metricaConversionEnergetica_idmetricaConversionEnergetica`=? WHERE `idlecturaConversionEnergetica`=? ");
          consulta.setInt(1, lecturaconversionenergetica.getIdlecturaConversionEnergetica());
          consulta.setString(2, lecturaconversionenergetica.getFechaLecturaConversionEnergetica());
          consulta.setDouble(3, lecturaconversionenergetica.getValorLecturaConversionEnergeticacol());
          consulta.setInt(4, lecturaconversionenergetica.getMetricaconversionenergetica().getIdmetricaConversionEnergetica());
          consulta.setInt(5, lecturaconversionenergetica.getIdlecturaConversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturaconversionenergetica` WHERE `idlecturaConversionEnergetica`=?");
          consulta.setInt(1, lecturaconversionenergetica.getIdlecturaConversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturaconversionenergetica en la base de datos.
     * @return ArrayList<Lecturaconversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturaconversionenergetica> listAll() throws NullPointerException{
      ArrayList<Lecturaconversionenergetica> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaConversionEnergetica`, `fechaLecturaConversionEnergetica`, `valorLecturaConversionEnergeticacol`, `metricaConversionEnergetica_idmetricaConversionEnergetica`"
          +"FROM `lecturaconversionenergetica`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturaconversionenergetica lecturaconversionenergetica= new Lecturaconversionenergetica();
          lecturaconversionenergetica.setIdlecturaConversionEnergetica(res.getInt("idlecturaConversionEnergetica"));
          lecturaconversionenergetica.setFechaLecturaConversionEnergetica(res.getString("fechaLecturaConversionEnergetica"));
          lecturaconversionenergetica.setValorLecturaConversionEnergeticacol(res.getDouble("valorLecturaConversionEnergeticacol"));
           Metricaconversionenergetica metricaconversionenergetica = new Metricaconversionenergetica();
           metricaconversionenergetica.setIdmetricaConversionEnergetica(res.getInt("metricaConversionEnergetica_idmetricaConversionEnergetica"));
           lecturaconversionenergetica.setMetricaconversionenergetica(metricaconversionenergetica);

              lista.add(lecturaconversionenergetica);
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