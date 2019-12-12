/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    -¡UNO! -¡¡ +4 !!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILoteDao;
import back.dto.*;
import java.util.ArrayList;

public class LoteDao implements ILoteDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LoteDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Lote en la base de datos.
     * @param lote objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Lote lote) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `lote`( `idlote`, `descripcionLote`, `longitud`, `latitud`, `finca_idfinca`)"
          +"VALUES (?,?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, lote.getIdlote());
          consulta.setString(2, lote.getDescripcionLote());
          consulta.setDouble(3, lote.getLongitud());
          consulta.setDouble(4, lote.getLatitud());
          consulta.setInt(5, lote.getFinca().getIdfinca());
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
     * Busca un objeto Lote en la base de datos.
     * @param lote objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Lote select(Lote lote) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlote`, `descripcionLote`, `longitud`, `latitud`, `finca_idfinca`"
          +"FROM `lote`"
          +"WHERE `idlote`=?");
          consulta.setInt(1, lote.getIdlote());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          lote.setIdlote(res.getInt("idlote"));
          lote.setDescripcionLote(res.getString("descripcionLote"));
          lote.setLongitud(res.getDouble("longitud"));
          lote.setLatitud(res.getDouble("latitud"));
           Finca finca = new Finca();
           finca.setIdfinca(res.getInt("finca_idfinca"));
           lote.setFinca(finca);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lote;
  }

    /**
     * Modifica un objeto Lote en la base de datos.
     * @param lote objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Lote lote) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `lote` SET`idlote`=?, `descripcionLote`=?, `longitud`=?, `latitud`=?, `finca_idfinca`=? WHERE `idlote`=? ");
          consulta.setInt(1, lote.getIdlote());
          consulta.setString(2, lote.getDescripcionLote());
          consulta.setDouble(3, lote.getLongitud());
          consulta.setDouble(4, lote.getLatitud());
          consulta.setInt(5, lote.getFinca().getIdfinca());
          consulta.setInt(6, lote.getIdlote());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Lote en la base de datos.
     * @param lote objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Lote lote) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `lote` WHERE `idlote`=?");
          consulta.setInt(1, lote.getIdlote());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Lote en la base de datos.
     * @return ArrayList<Lote> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Lote> listAll() throws NullPointerException{
      ArrayList<Lote> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlote`, `descripcionLote`, `longitud`, `latitud`, `finca_idfinca`"
          +"FROM `lote`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Lote lote= new Lote();
          lote.setIdlote(res.getInt("idlote"));
          lote.setDescripcionLote(res.getString("descripcionLote"));
          lote.setLongitud(res.getDouble("longitud"));
          lote.setLatitud(res.getDouble("latitud"));
           Finca finca = new Finca();
           finca.setIdfinca(res.getInt("finca_idfinca"));
           lote.setFinca(finca);

              lista.add(lote);
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