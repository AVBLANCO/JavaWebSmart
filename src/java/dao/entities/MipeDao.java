/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Todo lo que alguna vez amaste te rechazará o morirá.  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMipeDao;
import back.dto.*;
import java.util.ArrayList;

public class MipeDao implements IMipeDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MipeDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Mipe en la base de datos.
     * @param mipe objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Mipe mipe) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `mipe`( `idmipe`, `decripcionMipe`, `fechaMipe`, `lote_idlote`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, mipe.getIdmipe());
          consulta.setString(2, mipe.getDecripcionMipe());
          consulta.setString(3, mipe.getFechaMipe());
          consulta.setInt(4, mipe.getLote().getIdlote());
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
     * Busca un objeto Mipe en la base de datos.
     * @param mipe objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Mipe select(Mipe mipe) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmipe`, `decripcionMipe`, `fechaMipe`, `lote_idlote`"
          +"FROM `mipe`"
          +"WHERE `idmipe`=?");
          consulta.setInt(1, mipe.getIdmipe());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          mipe.setIdmipe(res.getInt("idmipe"));
          mipe.setDecripcionMipe(res.getString("decripcionMipe"));
          mipe.setFechaMipe(res.getString("fechaMipe"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           mipe.setLote(lote);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return mipe;
  }

    /**
     * Modifica un objeto Mipe en la base de datos.
     * @param mipe objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Mipe mipe) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `mipe` SET`idmipe`=?, `decripcionMipe`=?, `fechaMipe`=?, `lote_idlote`=? WHERE `idmipe`=? ");
          consulta.setInt(1, mipe.getIdmipe());
          consulta.setString(2, mipe.getDecripcionMipe());
          consulta.setString(3, mipe.getFechaMipe());
          consulta.setInt(4, mipe.getLote().getIdlote());
          consulta.setInt(5, mipe.getIdmipe());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Mipe en la base de datos.
     * @param mipe objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Mipe mipe) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `mipe` WHERE `idmipe`=?");
          consulta.setInt(1, mipe.getIdmipe());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Mipe en la base de datos.
     * @return ArrayList<Mipe> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Mipe> listAll() throws NullPointerException{
      ArrayList<Mipe> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmipe`, `decripcionMipe`, `fechaMipe`, `lote_idlote`"
          +"FROM `mipe`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Mipe mipe= new Mipe();
          mipe.setIdmipe(res.getInt("idmipe"));
          mipe.setDecripcionMipe(res.getString("decripcionMipe"));
          mipe.setFechaMipe(res.getString("fechaMipe"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           mipe.setLote(lote);

              lista.add(mipe);
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