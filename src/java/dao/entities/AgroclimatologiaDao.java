/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Únicamente cuando se pierde todo somos libres para actuar.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IAgroclimatologiaDao;
import back.dto.*;
import java.util.ArrayList;

public class AgroclimatologiaDao implements IAgroclimatologiaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public AgroclimatologiaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Agroclimatologia agroclimatologia) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `agroclimatologia`( `idagroclimatologia`, `descripcionAgroclimatologia`, `fechaAgroclimatologia`, `lote_idlote`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, agroclimatologia.getIdagroclimatologia());
          consulta.setString(2, agroclimatologia.getDescripcionAgroclimatologia());
          consulta.setString(3, agroclimatologia.getFechaAgroclimatologia());
          consulta.setInt(4, agroclimatologia.getLote().getIdlote());
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
     * Busca un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Agroclimatologia select(Agroclimatologia agroclimatologia) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idagroclimatologia`, `descripcionAgroclimatologia`, `fechaAgroclimatologia`, `lote_idlote`"
          +"FROM `agroclimatologia`"
          +"WHERE `idagroclimatologia`=?");
          consulta.setInt(1, agroclimatologia.getIdagroclimatologia());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          agroclimatologia.setIdagroclimatologia(res.getInt("idagroclimatologia"));
          agroclimatologia.setDescripcionAgroclimatologia(res.getString("descripcionAgroclimatologia"));
          agroclimatologia.setFechaAgroclimatologia(res.getString("fechaAgroclimatologia"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           agroclimatologia.setLote(lote);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return agroclimatologia;
  }

    /**
     * Modifica un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Agroclimatologia agroclimatologia) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `agroclimatologia` SET`idagroclimatologia`=?, `descripcionAgroclimatologia`=?, `fechaAgroclimatologia`=?, `lote_idlote`=? WHERE `idagroclimatologia`=? ");
          consulta.setInt(1, agroclimatologia.getIdagroclimatologia());
          consulta.setString(2, agroclimatologia.getDescripcionAgroclimatologia());
          consulta.setString(3, agroclimatologia.getFechaAgroclimatologia());
          consulta.setInt(4, agroclimatologia.getLote().getIdlote());
          consulta.setInt(5, agroclimatologia.getIdagroclimatologia());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Agroclimatologia agroclimatologia) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `agroclimatologia` WHERE `idagroclimatologia`=?");
          consulta.setInt(1, agroclimatologia.getIdagroclimatologia());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Agroclimatologia en la base de datos.
     * @return ArrayList<Agroclimatologia> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Agroclimatologia> listAll() throws NullPointerException{
      ArrayList<Agroclimatologia> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idagroclimatologia`, `descripcionAgroclimatologia`, `fechaAgroclimatologia`, `lote_idlote`"
          +"FROM `agroclimatologia`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Agroclimatologia agroclimatologia= new Agroclimatologia();
          agroclimatologia.setIdagroclimatologia(res.getInt("idagroclimatologia"));
          agroclimatologia.setDescripcionAgroclimatologia(res.getString("descripcionAgroclimatologia"));
          agroclimatologia.setFechaAgroclimatologia(res.getString("fechaAgroclimatologia"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           agroclimatologia.setLote(lote);

              lista.add(agroclimatologia);
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