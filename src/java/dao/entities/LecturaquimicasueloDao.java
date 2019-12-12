/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Lolita, luz de mi vida, fuego de mis entrañas. Pecado mío, alma mía.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturaquimicasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturaquimicasueloDao implements ILecturaquimicasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturaquimicasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturaquimicasuelo`( `idlecturaQuimicaSuelo`, `fechaLecturaQuimicaSuelo`, `valorLecturaQuimicaSuelo`, `metricaQuimicaSuelo_idmetricaQuimicaSuelo`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturaquimicasuelo.getIdlecturaQuimicaSuelo());
          consulta.setString(2, lecturaquimicasuelo.getFechaLecturaQuimicaSuelo());
          consulta.setDouble(3, lecturaquimicasuelo.getValorLecturaQuimicaSuelo());
          consulta.setInt(4, lecturaquimicasuelo.getMetricaquimicasuelo().getIdmetricaQuimicaSuelo());
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
     * Busca un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturaquimicasuelo select(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaQuimicaSuelo`, `fechaLecturaQuimicaSuelo`, `valorLecturaQuimicaSuelo`, `metricaQuimicaSuelo_idmetricaQuimicaSuelo`"
          +"FROM `lecturaquimicasuelo`"
          +"WHERE `idlecturaQuimicaSuelo`=?");
          consulta.setInt(1, lecturaquimicasuelo.getIdlecturaQuimicaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturaquimicasuelo.setIdlecturaQuimicaSuelo(res.getInt("idlecturaQuimicaSuelo"));
          lecturaquimicasuelo.setFechaLecturaQuimicaSuelo(res.getString("fechaLecturaQuimicaSuelo"));
          lecturaquimicasuelo.setValorLecturaQuimicaSuelo(res.getDouble("valorLecturaQuimicaSuelo"));
           Metricaquimicasuelo metricaquimicasuelo = new Metricaquimicasuelo();
           metricaquimicasuelo.setIdmetricaQuimicaSuelo(res.getInt("metricaQuimicaSuelo_idmetricaQuimicaSuelo"));
           lecturaquimicasuelo.setMetricaquimicasuelo(metricaquimicasuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturaquimicasuelo;
  }

    /**
     * Modifica un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturaquimicasuelo` SET`idlecturaQuimicaSuelo`=?, `fechaLecturaQuimicaSuelo`=?, `valorLecturaQuimicaSuelo`=?, `metricaQuimicaSuelo_idmetricaQuimicaSuelo`=? WHERE `idlecturaQuimicaSuelo`=? ");
          consulta.setInt(1, lecturaquimicasuelo.getIdlecturaQuimicaSuelo());
          consulta.setString(2, lecturaquimicasuelo.getFechaLecturaQuimicaSuelo());
          consulta.setDouble(3, lecturaquimicasuelo.getValorLecturaQuimicaSuelo());
          consulta.setInt(4, lecturaquimicasuelo.getMetricaquimicasuelo().getIdmetricaQuimicaSuelo());
          consulta.setInt(5, lecturaquimicasuelo.getIdlecturaQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturaquimicasuelo` WHERE `idlecturaQuimicaSuelo`=?");
          consulta.setInt(1, lecturaquimicasuelo.getIdlecturaQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturaquimicasuelo en la base de datos.
     * @return ArrayList<Lecturaquimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturaquimicasuelo> listAll() throws NullPointerException{
      ArrayList<Lecturaquimicasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaQuimicaSuelo`, `fechaLecturaQuimicaSuelo`, `valorLecturaQuimicaSuelo`, `metricaQuimicaSuelo_idmetricaQuimicaSuelo`"
          +"FROM `lecturaquimicasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturaquimicasuelo lecturaquimicasuelo= new Lecturaquimicasuelo();
          lecturaquimicasuelo.setIdlecturaQuimicaSuelo(res.getInt("idlecturaQuimicaSuelo"));
          lecturaquimicasuelo.setFechaLecturaQuimicaSuelo(res.getString("fechaLecturaQuimicaSuelo"));
          lecturaquimicasuelo.setValorLecturaQuimicaSuelo(res.getDouble("valorLecturaQuimicaSuelo"));
           Metricaquimicasuelo metricaquimicasuelo = new Metricaquimicasuelo();
           metricaquimicasuelo.setIdmetricaQuimicaSuelo(res.getInt("metricaQuimicaSuelo_idmetricaQuimicaSuelo"));
           lecturaquimicasuelo.setMetricaquimicasuelo(metricaquimicasuelo);

              lista.add(lecturaquimicasuelo);
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