/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ahora tú puedes ser el tipo con el látigo  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IHojarutaDao;
import back.dto.*;
import java.util.ArrayList;

public class HojarutaDao implements IHojarutaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public HojarutaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Hojaruta hojaruta) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `hojaruta`( `idhojaRuta`, `fechaHojaRuta`, `costo_idcosto`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, hojaruta.getIdhojaRuta());
          consulta.setString(2, hojaruta.getFechaHojaRuta());
          consulta.setInt(3, hojaruta.getCosto().getIdcosto());
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
     * Busca un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Hojaruta select(Hojaruta hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idhojaRuta`, `fechaHojaRuta`, `costo_idcosto`"
          +"FROM `hojaruta`"
          +"WHERE `idhojaRuta`=?");
          consulta.setInt(1, hojaruta.getIdhojaRuta());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          hojaruta.setIdhojaRuta(res.getInt("idhojaRuta"));
          hojaruta.setFechaHojaRuta(res.getString("fechaHojaRuta"));
           Costo costo = new Costo();
           costo.setIdcosto(res.getInt("costo_idcosto"));
           hojaruta.setCosto(costo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return hojaruta;
  }

    /**
     * Modifica un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Hojaruta hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `hojaruta` SET`idhojaRuta`=?, `fechaHojaRuta`=?, `costo_idcosto`=? WHERE `idhojaRuta`=? ");
          consulta.setInt(1, hojaruta.getIdhojaRuta());
          consulta.setString(2, hojaruta.getFechaHojaRuta());
          consulta.setInt(3, hojaruta.getCosto().getIdcosto());
          consulta.setInt(4, hojaruta.getIdhojaRuta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Hojaruta hojaruta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `hojaruta` WHERE `idhojaRuta`=?");
          consulta.setInt(1, hojaruta.getIdhojaRuta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Hojaruta en la base de datos.
     * @return ArrayList<Hojaruta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Hojaruta> listAll() throws NullPointerException{
      ArrayList<Hojaruta> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idhojaRuta`, `fechaHojaRuta`, `costo_idcosto`"
          +"FROM `hojaruta`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Hojaruta hojaruta= new Hojaruta();
          hojaruta.setIdhojaRuta(res.getInt("idhojaRuta"));
          hojaruta.setFechaHojaRuta(res.getString("fechaHojaRuta"));
           Costo costo = new Costo();
           costo.setIdcosto(res.getInt("costo_idcosto"));
           hojaruta.setCosto(costo);

              lista.add(hojaruta);
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