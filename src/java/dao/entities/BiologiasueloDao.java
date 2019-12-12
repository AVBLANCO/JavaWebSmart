/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Le he dedicado más tiempo a las frases que al software interno  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IBiologiasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class BiologiasueloDao implements IBiologiasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public BiologiasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Biologiasuelo biologiasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `biologiasuelo`( `idbiologiaSuelo`, `biologiaSuelo`, `suelo_idsuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, biologiasuelo.getIdbiologiaSuelo());
          consulta.setString(2, biologiasuelo.getBiologiaSuelo());
          consulta.setInt(3, biologiasuelo.getSuelo().getIdsuelo());
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
     * Busca un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Biologiasuelo select(Biologiasuelo biologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idbiologiaSuelo`, `biologiaSuelo`, `suelo_idsuelo`"
          +"FROM `biologiasuelo`"
          +"WHERE `idbiologiaSuelo`=?");
          consulta.setInt(1, biologiasuelo.getIdbiologiaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          biologiasuelo.setIdbiologiaSuelo(res.getInt("idbiologiaSuelo"));
          biologiasuelo.setBiologiaSuelo(res.getString("biologiaSuelo"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           biologiasuelo.setSuelo(suelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return biologiasuelo;
  }

    /**
     * Modifica un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Biologiasuelo biologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `biologiasuelo` SET`idbiologiaSuelo`=?, `biologiaSuelo`=?, `suelo_idsuelo`=? WHERE `idbiologiaSuelo`=? ");
          consulta.setInt(1, biologiasuelo.getIdbiologiaSuelo());
          consulta.setString(2, biologiasuelo.getBiologiaSuelo());
          consulta.setInt(3, biologiasuelo.getSuelo().getIdsuelo());
          consulta.setInt(4, biologiasuelo.getIdbiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Biologiasuelo biologiasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `biologiasuelo` WHERE `idbiologiaSuelo`=?");
          consulta.setInt(1, biologiasuelo.getIdbiologiaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Biologiasuelo en la base de datos.
     * @return ArrayList<Biologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Biologiasuelo> listAll() throws NullPointerException{
      ArrayList<Biologiasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idbiologiaSuelo`, `biologiaSuelo`, `suelo_idsuelo`"
          +"FROM `biologiasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Biologiasuelo biologiasuelo= new Biologiasuelo();
          biologiasuelo.setIdbiologiaSuelo(res.getInt("idbiologiaSuelo"));
          biologiasuelo.setBiologiaSuelo(res.getString("biologiaSuelo"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           biologiasuelo.setSuelo(suelo);

              lista.add(biologiasuelo);
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