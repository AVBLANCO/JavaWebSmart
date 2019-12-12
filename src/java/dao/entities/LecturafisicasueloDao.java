/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Los animales, asombrados, pasaron su mirada del cerdo al hombre, y del hombre al cerdo; y, nuevamente, del cerdo al hombre; pero ya era imposible distinguir quién era uno y quién era otro.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILecturafisicasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class LecturafisicasueloDao implements ILecturafisicasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LecturafisicasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lecturafisicasuelo`( `idlecturaFisicaSuelo`, `fechaLecturaFisicaSuelo`, `valorLecturaFisicaSuelo`, `metricasSuelo_idmetricasSuelo`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lecturafisicasuelo.getIdlecturaFisicaSuelo());
          consulta.setString(2, lecturafisicasuelo.getFechaLecturaFisicaSuelo());
          consulta.setDouble(3, lecturafisicasuelo.getValorLecturaFisicaSuelo());
          consulta.setInt(4, lecturafisicasuelo.getMetricassuelo().getIdmetricasSuelo());
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
     * Busca un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lecturafisicasuelo select(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaFisicaSuelo`, `fechaLecturaFisicaSuelo`, `valorLecturaFisicaSuelo`, `metricasSuelo_idmetricasSuelo`"
          +"FROM `lecturafisicasuelo`"
          +"WHERE `idlecturaFisicaSuelo`=?");
          consulta.setInt(1, lecturafisicasuelo.getIdlecturaFisicaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lecturafisicasuelo.setIdlecturaFisicaSuelo(res.getInt("idlecturaFisicaSuelo"));
          lecturafisicasuelo.setFechaLecturaFisicaSuelo(res.getString("fechaLecturaFisicaSuelo"));
          lecturafisicasuelo.setValorLecturaFisicaSuelo(res.getDouble("valorLecturaFisicaSuelo"));
           Metricassuelo metricassuelo = new Metricassuelo();
           metricassuelo.setIdmetricasSuelo(res.getInt("metricasSuelo_idmetricasSuelo"));
           lecturafisicasuelo.setMetricassuelo(metricassuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lecturafisicasuelo;
  }

    /**
     * Modifica un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lecturafisicasuelo` SET`idlecturaFisicaSuelo`=?, `fechaLecturaFisicaSuelo`=?, `valorLecturaFisicaSuelo`=?, `metricasSuelo_idmetricasSuelo`=? WHERE `idlecturaFisicaSuelo`=? ");
          consulta.setInt(1, lecturafisicasuelo.getIdlecturaFisicaSuelo());
          consulta.setString(2, lecturafisicasuelo.getFechaLecturaFisicaSuelo());
          consulta.setDouble(3, lecturafisicasuelo.getValorLecturaFisicaSuelo());
          consulta.setInt(4, lecturafisicasuelo.getMetricassuelo().getIdmetricasSuelo());
          consulta.setInt(5, lecturafisicasuelo.getIdlecturaFisicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lecturafisicasuelo` WHERE `idlecturaFisicaSuelo`=?");
          consulta.setInt(1, lecturafisicasuelo.getIdlecturaFisicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lecturafisicasuelo en la base de datos.
     * @return ArrayList<Lecturafisicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lecturafisicasuelo> listAll() throws NullPointerException{
      ArrayList<Lecturafisicasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlecturaFisicaSuelo`, `fechaLecturaFisicaSuelo`, `valorLecturaFisicaSuelo`, `metricasSuelo_idmetricasSuelo`"
          +"FROM `lecturafisicasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lecturafisicasuelo lecturafisicasuelo= new Lecturafisicasuelo();
          lecturafisicasuelo.setIdlecturaFisicaSuelo(res.getInt("idlecturaFisicaSuelo"));
          lecturafisicasuelo.setFechaLecturaFisicaSuelo(res.getString("fechaLecturaFisicaSuelo"));
          lecturafisicasuelo.setValorLecturaFisicaSuelo(res.getDouble("valorLecturaFisicaSuelo"));
           Metricassuelo metricassuelo = new Metricassuelo();
           metricassuelo.setIdmetricasSuelo(res.getInt("metricasSuelo_idmetricasSuelo"));
           lecturafisicasuelo.setMetricassuelo(metricassuelo);

              lista.add(lecturafisicasuelo);
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