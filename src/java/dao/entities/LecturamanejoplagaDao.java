/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Era más fácil crear un framework que aprender a usar uno existente  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturamanejoplagaDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturamanejoplagaDao implements ILecturamanejoplagaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturamanejoplagaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturamanejoplaga`( `idlecturaManejoPlaga`, `valorLecturaManejoPlagacol`, `fechaLecturaManejoPlaga`, `metricaManejoPlagas_idmetricaManejoPlagas`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturamanejoplaga.getIdlecturaManejoPlaga());
          consulta.setDouble(2, lecturamanejoplaga.getValorLecturaManejoPlagacol());
          consulta.setString(3, lecturamanejoplaga.getFechaLecturaManejoPlaga());
          consulta.setInt(4, lecturamanejoplaga.getMetricamanejoplagas().getIdmetricaManejoPlagas());
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
     * Busca un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturamanejoplaga select(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaManejoPlaga`, `valorLecturaManejoPlagacol`, `fechaLecturaManejoPlaga`, `metricaManejoPlagas_idmetricaManejoPlagas`"
          +"FROM `lecturamanejoplaga`"
          +"WHERE `idlecturaManejoPlaga`=?");
          consulta.setInt(1, lecturamanejoplaga.getIdlecturaManejoPlaga());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturamanejoplaga.setIdlecturaManejoPlaga(res.getInt("idlecturaManejoPlaga"));
          lecturamanejoplaga.setValorLecturaManejoPlagacol(res.getDouble("valorLecturaManejoPlagacol"));
          lecturamanejoplaga.setFechaLecturaManejoPlaga(res.getString("fechaLecturaManejoPlaga"));
           Metricamanejoplagas metricamanejoplagas = new Metricamanejoplagas();
           metricamanejoplagas.setIdmetricaManejoPlagas(res.getInt("metricaManejoPlagas_idmetricaManejoPlagas"));
           lecturamanejoplaga.setMetricamanejoplagas(metricamanejoplagas);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturamanejoplaga;
  }

    /**
     * Modifica un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturamanejoplaga` SET`idlecturaManejoPlaga`=?, `valorLecturaManejoPlagacol`=?, `fechaLecturaManejoPlaga`=?, `metricaManejoPlagas_idmetricaManejoPlagas`=? WHERE `idlecturaManejoPlaga`=? ");
          consulta.setInt(1, lecturamanejoplaga.getIdlecturaManejoPlaga());
          consulta.setDouble(2, lecturamanejoplaga.getValorLecturaManejoPlagacol());
          consulta.setString(3, lecturamanejoplaga.getFechaLecturaManejoPlaga());
          consulta.setInt(4, lecturamanejoplaga.getMetricamanejoplagas().getIdmetricaManejoPlagas());
          consulta.setInt(5, lecturamanejoplaga.getIdlecturaManejoPlaga());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturamanejoplaga` WHERE `idlecturaManejoPlaga`=?");
          consulta.setInt(1, lecturamanejoplaga.getIdlecturaManejoPlaga());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturamanejoplaga en la base de datos.
     * @return ArrayList<Lecturamanejoplaga> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturamanejoplaga> listAll() throws NullPointerException{
      ArrayList<Lecturamanejoplaga> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaManejoPlaga`, `valorLecturaManejoPlagacol`, `fechaLecturaManejoPlaga`, `metricaManejoPlagas_idmetricaManejoPlagas`"
          +"FROM `lecturamanejoplaga`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturamanejoplaga lecturamanejoplaga= new Lecturamanejoplaga();
          lecturamanejoplaga.setIdlecturaManejoPlaga(res.getInt("idlecturaManejoPlaga"));
          lecturamanejoplaga.setValorLecturaManejoPlagacol(res.getDouble("valorLecturaManejoPlagacol"));
          lecturamanejoplaga.setFechaLecturaManejoPlaga(res.getString("fechaLecturaManejoPlaga"));
           Metricamanejoplagas metricamanejoplagas = new Metricamanejoplagas();
           metricamanejoplagas.setIdmetricaManejoPlagas(res.getInt("metricaManejoPlagas_idmetricaManejoPlagas"));
           lecturamanejoplaga.setMetricamanejoplagas(metricamanejoplagas);

              lista.add(lecturamanejoplaga);
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