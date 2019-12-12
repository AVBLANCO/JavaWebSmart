/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    NEVERMORE  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IManejointegradoenfermedadesDao;
import back.dto.*;
import java.util.ArrayList;

public class ManejointegradoenfermedadesDao implements IManejointegradoenfermedadesDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public ManejointegradoenfermedadesDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `manejointegradoenfermedades`( `idmanejoIntegradoEnfermedades`, `descripcioManejoIntegradoEnfermedades`, `mipe_idmipe`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, manejointegradoenfermedades.getIdmanejoIntegradoEnfermedades());
          consulta.setString(2, manejointegradoenfermedades.getDescripcioManejoIntegradoEnfermedades());
          consulta.setInt(3, manejointegradoenfermedades.getMipe().getIdmipe());
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
     * Busca un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Manejointegradoenfermedades select(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmanejoIntegradoEnfermedades`, `descripcioManejoIntegradoEnfermedades`, `mipe_idmipe`"
          +"FROM `manejointegradoenfermedades`"
          +"WHERE `idmanejoIntegradoEnfermedades`=?");
          consulta.setInt(1, manejointegradoenfermedades.getIdmanejoIntegradoEnfermedades());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(res.getInt("idmanejoIntegradoEnfermedades"));
          manejointegradoenfermedades.setDescripcioManejoIntegradoEnfermedades(res.getString("descripcioManejoIntegradoEnfermedades"));
           Mipe mipe = new Mipe();
           mipe.setIdmipe(res.getInt("mipe_idmipe"));
           manejointegradoenfermedades.setMipe(mipe);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return manejointegradoenfermedades;
  }

    /**
     * Modifica un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `manejointegradoenfermedades` SET`idmanejoIntegradoEnfermedades`=?, `descripcioManejoIntegradoEnfermedades`=?, `mipe_idmipe`=? WHERE `idmanejoIntegradoEnfermedades`=? ");
          consulta.setInt(1, manejointegradoenfermedades.getIdmanejoIntegradoEnfermedades());
          consulta.setString(2, manejointegradoenfermedades.getDescripcioManejoIntegradoEnfermedades());
          consulta.setInt(3, manejointegradoenfermedades.getMipe().getIdmipe());
          consulta.setInt(4, manejointegradoenfermedades.getIdmanejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `manejointegradoenfermedades` WHERE `idmanejoIntegradoEnfermedades`=?");
          consulta.setInt(1, manejointegradoenfermedades.getIdmanejoIntegradoEnfermedades());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Manejointegradoenfermedades en la base de datos.
     * @return ArrayList<Manejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Manejointegradoenfermedades> listAll() throws NullPointerException{
      ArrayList<Manejointegradoenfermedades> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmanejoIntegradoEnfermedades`, `descripcioManejoIntegradoEnfermedades`, `mipe_idmipe`"
          +"FROM `manejointegradoenfermedades`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Manejointegradoenfermedades manejointegradoenfermedades= new Manejointegradoenfermedades();
          manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(res.getInt("idmanejoIntegradoEnfermedades"));
          manejointegradoenfermedades.setDescripcioManejoIntegradoEnfermedades(res.getString("descripcioManejoIntegradoEnfermedades"));
           Mipe mipe = new Mipe();
           mipe.setIdmipe(res.getInt("mipe_idmipe"));
           manejointegradoenfermedades.setMipe(mipe);

              lista.add(manejointegradoenfermedades);
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