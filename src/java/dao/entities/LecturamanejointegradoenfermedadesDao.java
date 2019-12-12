/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Todo lo que alguna vez amaste te rechazará o morirá.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturamanejointegradoenfermedadesDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturamanejointegradoenfermedadesDao implements ILecturamanejointegradoenfermedadesDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturamanejointegradoenfermedadesDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturamanejointegradoenfermedades`( `idlecturaManejoIntegradoEnfermedades`, `fechaLecturaManejoIntegradoEnfermedadescol`, `valorLecturaManejoIntegradoEnfermedades`, `metricaManejoIntegradoEnfermedades`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturamanejointegradoenfermedades.getIdlecturaManejoIntegradoEnfermedades());
          consulta.setString(2, lecturamanejointegradoenfermedades.getFechaLecturaManejoIntegradoEnfermedadescol());
          consulta.setDouble(3, lecturamanejointegradoenfermedades.getValorLecturaManejoIntegradoEnfermedades());
          consulta.setInt(4, lecturamanejointegradoenfermedades.getMetricamanejointegradoenfermedades().getIdmetricaManejoIntegradoEnfermedades());
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
     * Busca un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturamanejointegradoenfermedades select(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaManejoIntegradoEnfermedades`, `fechaLecturaManejoIntegradoEnfermedadescol`, `valorLecturaManejoIntegradoEnfermedades`, `metricaManejoIntegradoEnfermedades`"
          +"FROM `lecturamanejointegradoenfermedades`"
          +"WHERE `idlecturaManejoIntegradoEnfermedades`=?");
          consulta.setInt(1, lecturamanejointegradoenfermedades.getIdlecturaManejoIntegradoEnfermedades());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturamanejointegradoenfermedades.setIdlecturaManejoIntegradoEnfermedades(res.getInt("idlecturaManejoIntegradoEnfermedades"));
          lecturamanejointegradoenfermedades.setFechaLecturaManejoIntegradoEnfermedadescol(res.getString("fechaLecturaManejoIntegradoEnfermedadescol"));
          lecturamanejointegradoenfermedades.setValorLecturaManejoIntegradoEnfermedades(res.getDouble("valorLecturaManejoIntegradoEnfermedades"));
           Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = new Metricamanejointegradoenfermedades();
           metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(res.getInt("metricaManejoIntegradoEnfermedades"));
           lecturamanejointegradoenfermedades.setMetricamanejointegradoenfermedades(metricamanejointegradoenfermedades);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturamanejointegradoenfermedades;
  }

    /**
     * Modifica un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturamanejointegradoenfermedades` SET`idlecturaManejoIntegradoEnfermedades`=?, `fechaLecturaManejoIntegradoEnfermedadescol`=?, `valorLecturaManejoIntegradoEnfermedades`=?, `metricaManejoIntegradoEnfermedades`=? WHERE `idlecturaManejoIntegradoEnfermedades`=? ");
          consulta.setInt(1, lecturamanejointegradoenfermedades.getIdlecturaManejoIntegradoEnfermedades());
          consulta.setString(2, lecturamanejointegradoenfermedades.getFechaLecturaManejoIntegradoEnfermedadescol());
          consulta.setDouble(3, lecturamanejointegradoenfermedades.getValorLecturaManejoIntegradoEnfermedades());
          consulta.setInt(4, lecturamanejointegradoenfermedades.getMetricamanejointegradoenfermedades().getIdmetricaManejoIntegradoEnfermedades());
          consulta.setInt(5, lecturamanejointegradoenfermedades.getIdlecturaManejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturamanejointegradoenfermedades` WHERE `idlecturaManejoIntegradoEnfermedades`=?");
          consulta.setInt(1, lecturamanejointegradoenfermedades.getIdlecturaManejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturamanejointegradoenfermedades en la base de datos.
     * @return ArrayList<Lecturamanejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturamanejointegradoenfermedades> listAll() throws NullPointerException{
      ArrayList<Lecturamanejointegradoenfermedades> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaManejoIntegradoEnfermedades`, `fechaLecturaManejoIntegradoEnfermedadescol`, `valorLecturaManejoIntegradoEnfermedades`, `metricaManejoIntegradoEnfermedades`"
          +"FROM `lecturamanejointegradoenfermedades`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades= new Lecturamanejointegradoenfermedades();
          lecturamanejointegradoenfermedades.setIdlecturaManejoIntegradoEnfermedades(res.getInt("idlecturaManejoIntegradoEnfermedades"));
          lecturamanejointegradoenfermedades.setFechaLecturaManejoIntegradoEnfermedadescol(res.getString("fechaLecturaManejoIntegradoEnfermedadescol"));
          lecturamanejointegradoenfermedades.setValorLecturaManejoIntegradoEnfermedades(res.getDouble("valorLecturaManejoIntegradoEnfermedades"));
           Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = new Metricamanejointegradoenfermedades();
           metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(res.getInt("metricaManejoIntegradoEnfermedades"));
           lecturamanejointegradoenfermedades.setMetricamanejointegradoenfermedades(metricamanejointegradoenfermedades);

              lista.add(lecturamanejointegradoenfermedades);
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