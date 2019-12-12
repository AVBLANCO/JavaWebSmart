/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Bastará decir que soy Juan Pablo Castel, el pintor que mató a María Iribarne...  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IConversionenergeticaDao;
import back.dto.*;
import java.util.ArrayList;

public class ConversionenergeticaDao implements IConversionenergeticaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public ConversionenergeticaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Conversionenergetica conversionenergetica) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `conversionenergetica`( `idconversionEnergetica`, `descripcionConversionEnergetica`, `fechaConversionEnergetica`, `agroclimatologia_idagroclimatologia`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, conversionenergetica.getIdconversionEnergetica());
          consulta.setString(2, conversionenergetica.getDescripcionConversionEnergetica());
          consulta.setString(3, conversionenergetica.getFechaConversionEnergetica());
          consulta.setInt(4, conversionenergetica.getAgroclimatologia().getIdagroclimatologia());
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
     * Busca un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Conversionenergetica select(Conversionenergetica conversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idconversionEnergetica`, `descripcionConversionEnergetica`, `fechaConversionEnergetica`, `agroclimatologia_idagroclimatologia`"
          +"FROM `conversionenergetica`"
          +"WHERE `idconversionEnergetica`=?");
          consulta.setInt(1, conversionenergetica.getIdconversionEnergetica());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          conversionenergetica.setIdconversionEnergetica(res.getInt("idconversionEnergetica"));
          conversionenergetica.setDescripcionConversionEnergetica(res.getString("descripcionConversionEnergetica"));
          conversionenergetica.setFechaConversionEnergetica(res.getString("fechaConversionEnergetica"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           conversionenergetica.setAgroclimatologia(agroclimatologia);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return conversionenergetica;
  }

    /**
     * Modifica un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Conversionenergetica conversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `conversionenergetica` SET`idconversionEnergetica`=?, `descripcionConversionEnergetica`=?, `fechaConversionEnergetica`=?, `agroclimatologia_idagroclimatologia`=? WHERE `idconversionEnergetica`=? ");
          consulta.setInt(1, conversionenergetica.getIdconversionEnergetica());
          consulta.setString(2, conversionenergetica.getDescripcionConversionEnergetica());
          consulta.setString(3, conversionenergetica.getFechaConversionEnergetica());
          consulta.setInt(4, conversionenergetica.getAgroclimatologia().getIdagroclimatologia());
          consulta.setInt(5, conversionenergetica.getIdconversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Conversionenergetica conversionenergetica) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `conversionenergetica` WHERE `idconversionEnergetica`=?");
          consulta.setInt(1, conversionenergetica.getIdconversionEnergetica());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Conversionenergetica en la base de datos.
     * @return ArrayList<Conversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Conversionenergetica> listAll() throws NullPointerException{
      ArrayList<Conversionenergetica> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idconversionEnergetica`, `descripcionConversionEnergetica`, `fechaConversionEnergetica`, `agroclimatologia_idagroclimatologia`"
          +"FROM `conversionenergetica`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Conversionenergetica conversionenergetica= new Conversionenergetica();
          conversionenergetica.setIdconversionEnergetica(res.getInt("idconversionEnergetica"));
          conversionenergetica.setDescripcionConversionEnergetica(res.getString("descripcionConversionEnergetica"));
          conversionenergetica.setFechaConversionEnergetica(res.getString("fechaConversionEnergetica"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           conversionenergetica.setAgroclimatologia(agroclimatologia);

              lista.add(conversionenergetica);
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