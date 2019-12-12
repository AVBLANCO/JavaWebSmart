/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Somos los amish del software  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetricassueloDao;
import back.dto.*;
import java.util.ArrayList;

public class MetricassueloDao implements IMetricassueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetricassueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Metricassuelo metricassuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `metricassuelo`( `idmetricasSuelo`, `descripcioMetricasSuelo`, `fisicaSuelo_idfisicaSuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, metricassuelo.getIdmetricasSuelo());
          consulta.setString(2, metricassuelo.getDescripcioMetricasSuelo());
          consulta.setInt(3, metricassuelo.getFisicasuelo().getIdfisicaSuelo());
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
     * Busca un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Metricassuelo select(Metricassuelo metricassuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricasSuelo`, `descripcioMetricasSuelo`, `fisicaSuelo_idfisicaSuelo`"
          +"FROM `metricassuelo`"
          +"WHERE `idmetricasSuelo`=?");
          consulta.setInt(1, metricassuelo.getIdmetricasSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          metricassuelo.setIdmetricasSuelo(res.getInt("idmetricasSuelo"));
          metricassuelo.setDescripcioMetricasSuelo(res.getString("descripcioMetricasSuelo"));
           Fisicasuelo fisicasuelo = new Fisicasuelo();
           fisicasuelo.setIdfisicaSuelo(res.getInt("fisicaSuelo_idfisicaSuelo"));
           metricassuelo.setFisicasuelo(fisicasuelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return metricassuelo;
  }

    /**
     * Modifica un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Metricassuelo metricassuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `metricassuelo` SET`idmetricasSuelo`=?, `descripcioMetricasSuelo`=?, `fisicaSuelo_idfisicaSuelo`=? WHERE `idmetricasSuelo`=? ");
          consulta.setInt(1, metricassuelo.getIdmetricasSuelo());
          consulta.setString(2, metricassuelo.getDescripcioMetricasSuelo());
          consulta.setInt(3, metricassuelo.getFisicasuelo().getIdfisicaSuelo());
          consulta.setInt(4, metricassuelo.getIdmetricasSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Metricassuelo metricassuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `metricassuelo` WHERE `idmetricasSuelo`=?");
          consulta.setInt(1, metricassuelo.getIdmetricasSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Metricassuelo en la base de datos.
     * @return ArrayList<Metricassuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Metricassuelo> listAll() throws NullPointerException{
      ArrayList<Metricassuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmetricasSuelo`, `descripcioMetricasSuelo`, `fisicaSuelo_idfisicaSuelo`"
          +"FROM `metricassuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Metricassuelo metricassuelo= new Metricassuelo();
          metricassuelo.setIdmetricasSuelo(res.getInt("idmetricasSuelo"));
          metricassuelo.setDescripcioMetricasSuelo(res.getString("descripcioMetricasSuelo"));
           Fisicasuelo fisicasuelo = new Fisicasuelo();
           fisicasuelo.setIdfisicaSuelo(res.getInt("fisicaSuelo_idfisicaSuelo"));
           metricassuelo.setFisicasuelo(fisicasuelo);

              lista.add(metricassuelo);
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