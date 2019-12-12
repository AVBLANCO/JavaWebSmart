/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Dispongo de doce horas de adelanto, puedo de decárselas a ella  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IProyeccionDao;
import back.dto.*;
import java.util.ArrayList;

public class ProyeccionDao implements IProyeccionDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public ProyeccionDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Proyeccion proyeccion) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `proyeccion`( `idproyeccion`, `descripcionProyeccion`, `fechaProyeccion`, `lote_idlote`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, proyeccion.getIdproyeccion());
          consulta.setString(2, proyeccion.getDescripcionProyeccion());
          consulta.setString(3, proyeccion.getFechaProyeccion());
          consulta.setInt(4, proyeccion.getLote().getIdlote());
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
     * Busca un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Proyeccion select(Proyeccion proyeccion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idproyeccion`, `descripcionProyeccion`, `fechaProyeccion`, `lote_idlote`"
          +"FROM `proyeccion`"
          +"WHERE `idproyeccion`=?");
          consulta.setInt(1, proyeccion.getIdproyeccion());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          proyeccion.setIdproyeccion(res.getInt("idproyeccion"));
          proyeccion.setDescripcionProyeccion(res.getString("descripcionProyeccion"));
          proyeccion.setFechaProyeccion(res.getString("fechaProyeccion"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           proyeccion.setLote(lote);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return proyeccion;
  }

    /**
     * Modifica un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Proyeccion proyeccion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `proyeccion` SET`idproyeccion`=?, `descripcionProyeccion`=?, `fechaProyeccion`=?, `lote_idlote`=? WHERE `idproyeccion`=? ");
          consulta.setInt(1, proyeccion.getIdproyeccion());
          consulta.setString(2, proyeccion.getDescripcionProyeccion());
          consulta.setString(3, proyeccion.getFechaProyeccion());
          consulta.setInt(4, proyeccion.getLote().getIdlote());
          consulta.setInt(5, proyeccion.getIdproyeccion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Proyeccion proyeccion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `proyeccion` WHERE `idproyeccion`=?");
          consulta.setInt(1, proyeccion.getIdproyeccion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Proyeccion en la base de datos.
     * @return ArrayList<Proyeccion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Proyeccion> listAll() throws NullPointerException{
      ArrayList<Proyeccion> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idproyeccion`, `descripcionProyeccion`, `fechaProyeccion`, `lote_idlote`"
          +"FROM `proyeccion`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Proyeccion proyeccion= new Proyeccion();
          proyeccion.setIdproyeccion(res.getInt("idproyeccion"));
          proyeccion.setDescripcionProyeccion(res.getString("descripcionProyeccion"));
          proyeccion.setFechaProyeccion(res.getString("fechaProyeccion"));
           Lote lote = new Lote();
           lote.setIdlote(res.getInt("lote_idlote"));
           proyeccion.setLote(lote);

              lista.add(proyeccion);
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