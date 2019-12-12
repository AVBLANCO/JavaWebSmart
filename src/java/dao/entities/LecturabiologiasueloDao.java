/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Me pagan USD 10,000 por cada frase que invento. 20,000 por las más tontas  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturabiologiasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturabiologiasueloDao implements ILecturabiologiasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturabiologiasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturabiologiasuelo`( `idlecturaBiologiaSuelo`, `fechaLecturaBiologiaSuelo`, `valorLecturaBiologiaSuelocol`, `metricaBiologiaSuelo_idmetricaBiologiaSuelo`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturabiologiasuelo.getIdlecturaBiologiaSuelo());
          consulta.setString(2, lecturabiologiasuelo.getFechaLecturaBiologiaSuelo());
          consulta.setDouble(3, lecturabiologiasuelo.getValorLecturaBiologiaSuelocol());
          consulta.setInt(4, lecturabiologiasuelo.getMetricabiologiasuelo().getIdmetricaBiologiaSuelo());
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
     * Busca un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturabiologiasuelo select(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaBiologiaSuelo`, `fechaLecturaBiologiaSuelo`, `valorLecturaBiologiaSuelocol`, `metricaBiologiaSuelo_idmetricaBiologiaSuelo`"
          +"FROM `lecturabiologiasuelo`"
          +"WHERE `idlecturaBiologiaSuelo`=?");
          consulta.setInt(1, lecturabiologiasuelo.getIdlecturaBiologiaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturabiologiasuelo.setIdlecturaBiologiaSuelo(res.getInt("idlecturaBiologiaSuelo"));
          lecturabiologiasuelo.setFechaLecturaBiologiaSuelo(res.getString("fechaLecturaBiologiaSuelo"));
          lecturabiologiasuelo.setValorLecturaBiologiaSuelocol(res.getDouble("valorLecturaBiologiaSuelocol"));
           Metricabiologiasuelo metricabiologiasuelo = new Metricabiologiasuelo();
           metricabiologiasuelo.setIdmetricaBiologiaSuelo(res.getInt("metricaBiologiaSuelo_idmetricaBiologiaSuelo"));
           lecturabiologiasuelo.setMetricabiologiasuelo(metricabiologiasuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturabiologiasuelo;
  }

    /**
     * Modifica un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturabiologiasuelo` SET`idlecturaBiologiaSuelo`=?, `fechaLecturaBiologiaSuelo`=?, `valorLecturaBiologiaSuelocol`=?, `metricaBiologiaSuelo_idmetricaBiologiaSuelo`=? WHERE `idlecturaBiologiaSuelo`=? ");
          consulta.setInt(1, lecturabiologiasuelo.getIdlecturaBiologiaSuelo());
          consulta.setString(2, lecturabiologiasuelo.getFechaLecturaBiologiaSuelo());
          consulta.setDouble(3, lecturabiologiasuelo.getValorLecturaBiologiaSuelocol());
          consulta.setInt(4, lecturabiologiasuelo.getMetricabiologiasuelo().getIdmetricaBiologiaSuelo());
          consulta.setInt(5, lecturabiologiasuelo.getIdlecturaBiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturabiologiasuelo` WHERE `idlecturaBiologiaSuelo`=?");
          consulta.setInt(1, lecturabiologiasuelo.getIdlecturaBiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturabiologiasuelo en la base de datos.
     * @return ArrayList<Lecturabiologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturabiologiasuelo> listAll() throws NullPointerException{
      ArrayList<Lecturabiologiasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaBiologiaSuelo`, `fechaLecturaBiologiaSuelo`, `valorLecturaBiologiaSuelocol`, `metricaBiologiaSuelo_idmetricaBiologiaSuelo`"
          +"FROM `lecturabiologiasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturabiologiasuelo lecturabiologiasuelo= new Lecturabiologiasuelo();
          lecturabiologiasuelo.setIdlecturaBiologiaSuelo(res.getInt("idlecturaBiologiaSuelo"));
          lecturabiologiasuelo.setFechaLecturaBiologiaSuelo(res.getString("fechaLecturaBiologiaSuelo"));
          lecturabiologiasuelo.setValorLecturaBiologiaSuelocol(res.getDouble("valorLecturaBiologiaSuelocol"));
           Metricabiologiasuelo metricabiologiasuelo = new Metricabiologiasuelo();
           metricabiologiasuelo.setIdmetricaBiologiaSuelo(res.getInt("metricaBiologiaSuelo_idmetricaBiologiaSuelo"));
           lecturabiologiasuelo.setMetricabiologiasuelo(metricabiologiasuelo);

              lista.add(lecturabiologiasuelo);
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