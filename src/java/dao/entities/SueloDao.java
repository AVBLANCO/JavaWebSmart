/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Cuantas frases como esta crees que puedo escribir?  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ISueloDao;
import back.dto.*;
import java.util.ArrayList;

public class SueloDao implements ISueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public SueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Suelo en la base de datos.
     * @param suelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Suelo suelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `suelo`( `idsuelo`, `decripcionSuelo`, `fechaSuelo`, `lote_idlote`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, suelo.getIdsuelo());
          consulta.setString(2, suelo.getDecripcionSuelo());
          consulta.setString(3, suelo.getFechaSuelo());
          consulta.setInt(4, suelo.getLote().getIdlote());
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
     * Busca un objeto Suelo en la base de datos.
     * @param suelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Suelo select(Suelo suelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idsuelo`, `decripcionSuelo`, `fechaSuelo`, `lote_idlote`"
          +"FROM `suelo`"
          +"WHERE `idsuelo`=?");
          consulta.setInt(1, suelo.getIdsuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          suelo.setIdsuelo(res.getInt("idsuelo"));
          suelo.setDecripcionSuelo(res.getString("decripcionSuelo"));
          suelo.setFechaSuelo(res.getString("fechaSuelo"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           suelo.setLote(lote);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return suelo;
  }

    /**
     * Modifica un objeto Suelo en la base de datos.
     * @param suelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Suelo suelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `suelo` SET`idsuelo`=?, `decripcionSuelo`=?, `fechaSuelo`=?, `lote_idlote`=? WHERE `idsuelo`=? ");
          consulta.setInt(1, suelo.getIdsuelo());
          consulta.setString(2, suelo.getDecripcionSuelo());
          consulta.setString(3, suelo.getFechaSuelo());
          consulta.setInt(4, suelo.getLote().getIdlote());
          consulta.setInt(5, suelo.getIdsuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Suelo en la base de datos.
     * @param suelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Suelo suelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `suelo` WHERE `idsuelo`=?");
          consulta.setInt(1, suelo.getIdsuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Suelo en la base de datos.
     * @return ArrayList<Suelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Suelo> listAll() throws NullPointerException{
      ArrayList<Suelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idsuelo`, `decripcionSuelo`, `fechaSuelo`, `lote_idlote`"
          +"FROM `suelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Suelo suelo= new Suelo();
          suelo.setIdsuelo(res.getInt("idsuelo"));
          suelo.setDecripcionSuelo(res.getString("decripcionSuelo"));
          suelo.setFechaSuelo(res.getString("fechaSuelo"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           suelo.setLote(lote);

              lista.add(suelo);
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