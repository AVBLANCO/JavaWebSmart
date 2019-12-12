/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En esto paso mis sábados en la noche ( ¬.¬)  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IEvotranspiracionDao;
import back.dto.*;
import java.util.ArrayList;

public class EvotranspiracionDao implements IEvotranspiracionDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public EvotranspiracionDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Evotranspiracion evotranspiracion) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `evotranspiracion`( `idevotranspiracion`, `descripcionEvotranspiracion`, `fechaEvotranspiracion`, `agroclimatologia_idagroclimatologia`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, evotranspiracion.getIdevotranspiracion());
          consulta.setString(2, evotranspiracion.getDescripcionEvotranspiracion());
          consulta.setString(3, evotranspiracion.getFechaEvotranspiracion());
          consulta.setInt(4, evotranspiracion.getAgroclimatologia().getIdagroclimatologia());
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
     * Busca un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Evotranspiracion select(Evotranspiracion evotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idevotranspiracion`, `descripcionEvotranspiracion`, `fechaEvotranspiracion`, `agroclimatologia_idagroclimatologia`"
          +"FROM `evotranspiracion`"
          +"WHERE `idevotranspiracion`=?");
          consulta.setInt(1, evotranspiracion.getIdevotranspiracion());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          evotranspiracion.setIdevotranspiracion(res.getInt("idevotranspiracion"));
          evotranspiracion.setDescripcionEvotranspiracion(res.getString("descripcionEvotranspiracion"));
          evotranspiracion.setFechaEvotranspiracion(res.getString("fechaEvotranspiracion"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           evotranspiracion.setAgroclimatologia(agroclimatologia);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return evotranspiracion;
  }

    /**
     * Modifica un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Evotranspiracion evotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `evotranspiracion` SET`idevotranspiracion`=?, `descripcionEvotranspiracion`=?, `fechaEvotranspiracion`=?, `agroclimatologia_idagroclimatologia`=? WHERE `idevotranspiracion`=? ");
          consulta.setInt(1, evotranspiracion.getIdevotranspiracion());
          consulta.setString(2, evotranspiracion.getDescripcionEvotranspiracion());
          consulta.setString(3, evotranspiracion.getFechaEvotranspiracion());
          consulta.setInt(4, evotranspiracion.getAgroclimatologia().getIdagroclimatologia());
          consulta.setInt(5, evotranspiracion.getIdevotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Evotranspiracion evotranspiracion) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `evotranspiracion` WHERE `idevotranspiracion`=?");
          consulta.setInt(1, evotranspiracion.getIdevotranspiracion());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Evotranspiracion en la base de datos.
     * @return ArrayList<Evotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Evotranspiracion> listAll() throws NullPointerException{
      ArrayList<Evotranspiracion> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idevotranspiracion`, `descripcionEvotranspiracion`, `fechaEvotranspiracion`, `agroclimatologia_idagroclimatologia`"
          +"FROM `evotranspiracion`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Evotranspiracion evotranspiracion= new Evotranspiracion();
          evotranspiracion.setIdevotranspiracion(res.getInt("idevotranspiracion"));
          evotranspiracion.setDescripcionEvotranspiracion(res.getString("descripcionEvotranspiracion"));
          evotranspiracion.setFechaEvotranspiracion(res.getString("fechaEvotranspiracion"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           evotranspiracion.setAgroclimatologia(agroclimatologia);

              lista.add(evotranspiracion);
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