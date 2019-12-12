/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Si crees que las mujeres son difíciles, no conoces Anarchy  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IFisicasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class FisicasueloDao implements IFisicasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public FisicasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Fisicasuelo fisicasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `fisicasuelo`( `idfisicaSuelo`, `decscricionfisicaSuelo`, `suelo_idsuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, fisicasuelo.getIdfisicaSuelo());
          consulta.setString(2, fisicasuelo.getDecscricionfisicaSuelo());
          consulta.setInt(3, fisicasuelo.getSuelo().getIdsuelo());
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
     * Busca un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Fisicasuelo select(Fisicasuelo fisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idfisicaSuelo`, `decscricionfisicaSuelo`, `suelo_idsuelo`"
          +"FROM `fisicasuelo`"
          +"WHERE `idfisicaSuelo`=?");
          consulta.setInt(1, fisicasuelo.getIdfisicaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          fisicasuelo.setIdfisicaSuelo(res.getInt("idfisicaSuelo"));
          fisicasuelo.setDecscricionfisicaSuelo(res.getString("decscricionfisicaSuelo"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           fisicasuelo.setSuelo(suelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return fisicasuelo;
  }

    /**
     * Modifica un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Fisicasuelo fisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `fisicasuelo` SET`idfisicaSuelo`=?, `decscricionfisicaSuelo`=?, `suelo_idsuelo`=? WHERE `idfisicaSuelo`=? ");
          consulta.setInt(1, fisicasuelo.getIdfisicaSuelo());
          consulta.setString(2, fisicasuelo.getDecscricionfisicaSuelo());
          consulta.setInt(3, fisicasuelo.getSuelo().getIdsuelo());
          consulta.setInt(4, fisicasuelo.getIdfisicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Fisicasuelo fisicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `fisicasuelo` WHERE `idfisicaSuelo`=?");
          consulta.setInt(1, fisicasuelo.getIdfisicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Fisicasuelo en la base de datos.
     * @return ArrayList<Fisicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Fisicasuelo> listAll() throws NullPointerException{
      ArrayList<Fisicasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idfisicaSuelo`, `decscricionfisicaSuelo`, `suelo_idsuelo`"
          +"FROM `fisicasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Fisicasuelo fisicasuelo= new Fisicasuelo();
          fisicasuelo.setIdfisicaSuelo(res.getInt("idfisicaSuelo"));
          fisicasuelo.setDecscricionfisicaSuelo(res.getString("decscricionfisicaSuelo"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           fisicasuelo.setSuelo(suelo);

              lista.add(fisicasuelo);
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