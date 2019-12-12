/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Muerte a todos los humanos!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IBalancehidricoDao;
import back.dto.*;
import java.util.ArrayList;

public class BalancehidricoDao implements IBalancehidricoDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public BalancehidricoDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Balancehidrico balancehidrico) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `balancehidrico`( `idbalanceHidrico`, `descripcioBalanceHidricocol`, `fechabalanceHidrico`, `agroclimatologia_idagroclimatologia`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, balancehidrico.getIdbalanceHidrico());
          consulta.setString(2, balancehidrico.getDescripcioBalanceHidricocol());
          consulta.setString(3, balancehidrico.getFechabalanceHidrico());
          consulta.setInt(4, balancehidrico.getAgroclimatologia().getIdagroclimatologia());
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
     * Busca un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Balancehidrico select(Balancehidrico balancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idbalanceHidrico`, `descripcioBalanceHidricocol`, `fechabalanceHidrico`, `agroclimatologia_idagroclimatologia`"
          +"FROM `balancehidrico`"
          +"WHERE `idbalanceHidrico`=?");
          consulta.setInt(1, balancehidrico.getIdbalanceHidrico());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          balancehidrico.setIdbalanceHidrico(res.getInt("idbalanceHidrico"));
          balancehidrico.setDescripcioBalanceHidricocol(res.getString("descripcioBalanceHidricocol"));
          balancehidrico.setFechabalanceHidrico(res.getString("fechabalanceHidrico"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           balancehidrico.setAgroclimatologia(agroclimatologia);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return balancehidrico;
  }

    /**
     * Modifica un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Balancehidrico balancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `balancehidrico` SET`idbalanceHidrico`=?, `descripcioBalanceHidricocol`=?, `fechabalanceHidrico`=?, `agroclimatologia_idagroclimatologia`=? WHERE `idbalanceHidrico`=? ");
          consulta.setInt(1, balancehidrico.getIdbalanceHidrico());
          consulta.setString(2, balancehidrico.getDescripcioBalanceHidricocol());
          consulta.setString(3, balancehidrico.getFechabalanceHidrico());
          consulta.setInt(4, balancehidrico.getAgroclimatologia().getIdagroclimatologia());
          consulta.setInt(5, balancehidrico.getIdbalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Balancehidrico balancehidrico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `balancehidrico` WHERE `idbalanceHidrico`=?");
          consulta.setInt(1, balancehidrico.getIdbalanceHidrico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Balancehidrico en la base de datos.
     * @return ArrayList<Balancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Balancehidrico> listAll() throws NullPointerException{
      ArrayList<Balancehidrico> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idbalanceHidrico`, `descripcioBalanceHidricocol`, `fechabalanceHidrico`, `agroclimatologia_idagroclimatologia`"
          +"FROM `balancehidrico`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Balancehidrico balancehidrico= new Balancehidrico();
          balancehidrico.setIdbalanceHidrico(res.getInt("idbalanceHidrico"));
          balancehidrico.setDescripcioBalanceHidricocol(res.getString("descripcioBalanceHidricocol"));
          balancehidrico.setFechabalanceHidrico(res.getString("fechabalanceHidrico"));
           Agroclimatologia agroclimatologia = new Agroclimatologia();
           agroclimatologia.setIdagroclimatologia(res.getInt("agroclimatologia_idagroclimatologia"));
           balancehidrico.setAgroclimatologia(agroclimatologia);

              lista.add(balancehidrico);
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