/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Cansado de escribir bugs? tranquilo, los escribimos por ti  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMiagroempresaDao;
import back.dto.*;
import java.util.ArrayList;

public class MiagroempresaDao implements IMiagroempresaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MiagroempresaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Miagroempresa miagroempresa) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `miagroempresa`( `idmiAgroempresa`, `descipcionMiAgroempresa`, `lote_idlote`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, miagroempresa.getIdmiAgroempresa());
          consulta.setString(2, miagroempresa.getDescipcionMiAgroempresa());
          consulta.setInt(3, miagroempresa.getLote().getIdlote());
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
     * Busca un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Miagroempresa select(Miagroempresa miagroempresa) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmiAgroempresa`, `descipcionMiAgroempresa`, `lote_idlote`"
          +"FROM `miagroempresa`"
          +"WHERE `idmiAgroempresa`=?");
          consulta.setInt(1, miagroempresa.getIdmiAgroempresa());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          miagroempresa.setIdmiAgroempresa(res.getInt("idmiAgroempresa"));
          miagroempresa.setDescipcionMiAgroempresa(res.getString("descipcionMiAgroempresa"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           miagroempresa.setLote(lote);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return miagroempresa;
  }

    /**
     * Modifica un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Miagroempresa miagroempresa) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `miagroempresa` SET`idmiAgroempresa`=?, `descipcionMiAgroempresa`=?, `lote_idlote`=? WHERE `idmiAgroempresa`=? ");
          consulta.setInt(1, miagroempresa.getIdmiAgroempresa());
          consulta.setString(2, miagroempresa.getDescipcionMiAgroempresa());
          consulta.setInt(3, miagroempresa.getLote().getIdlote());
          consulta.setInt(4, miagroempresa.getIdmiAgroempresa());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Miagroempresa miagroempresa) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `miagroempresa` WHERE `idmiAgroempresa`=?");
          consulta.setInt(1, miagroempresa.getIdmiAgroempresa());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Miagroempresa en la base de datos.
     * @return ArrayList<Miagroempresa> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Miagroempresa> listAll() throws NullPointerException{
      ArrayList<Miagroempresa> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmiAgroempresa`, `descipcionMiAgroempresa`, `lote_idlote`"
          +"FROM `miagroempresa`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Miagroempresa miagroempresa= new Miagroempresa();
          miagroempresa.setIdmiAgroempresa(res.getInt("idmiAgroempresa"));
          miagroempresa.setDescipcionMiAgroempresa(res.getString("descipcionMiAgroempresa"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           miagroempresa.setLote(lote);

              lista.add(miagroempresa);
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