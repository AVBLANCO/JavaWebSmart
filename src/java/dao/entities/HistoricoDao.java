/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Te veeeeeooooo  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IHistoricoDao;
import back.dto.*;
import java.util.ArrayList;

public class HistoricoDao implements IHistoricoDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public HistoricoDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Historico en la base de datos.
     * @param historico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Historico historico) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `historico`( `idhistorico`, `descripcionHistorico`, `miAgroempresa_idmiAgroempresa`, `valorHistorico`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, historico.getIdhistorico());
          consulta.setString(2, historico.getDescripcionHistorico());
          consulta.setInt(3, historico.getMiagroempresa().getIdmiAgroempresa());
          consulta.setDouble(4, historico.getValorHistorico());
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
     * Busca un objeto Historico en la base de datos.
     * @param historico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Historico select(Historico historico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idhistorico`, `descripcionHistorico`, `miAgroempresa_idmiAgroempresa`, `valorHistorico`"
          +"FROM `historico`"
          +"WHERE `idhistorico`=?");
          consulta.setInt(1, historico.getIdhistorico());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          historico.setIdhistorico(res.getInt("idhistorico"));
          historico.setDescripcionHistorico(res.getString("descripcionHistorico"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           historico.setMiagroempresa(miagroempresa);
          historico.setValorHistorico(res.getDouble("valorHistorico"));

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return historico;
  }

    /**
     * Modifica un objeto Historico en la base de datos.
     * @param historico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Historico historico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `historico` SET`idhistorico`=?, `descripcionHistorico`=?, `miAgroempresa_idmiAgroempresa`=?, `valorHistorico`=? WHERE `idhistorico`=? ");
          consulta.setInt(1, historico.getIdhistorico());
          consulta.setString(2, historico.getDescripcionHistorico());
          consulta.setInt(3, historico.getMiagroempresa().getIdmiAgroempresa());
          consulta.setDouble(4, historico.getValorHistorico());
          consulta.setInt(5, historico.getIdhistorico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Historico en la base de datos.
     * @param historico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Historico historico) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `historico` WHERE `idhistorico`=?");
          consulta.setInt(1, historico.getIdhistorico());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Historico en la base de datos.
     * @return ArrayList<Historico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Historico> listAll() throws NullPointerException{
      ArrayList<Historico> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idhistorico`, `descripcionHistorico`, `miAgroempresa_idmiAgroempresa`, `valorHistorico`"
          +"FROM `historico`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Historico historico= new Historico();
          historico.setIdhistorico(res.getInt("idhistorico"));
          historico.setDescripcionHistorico(res.getString("descripcionHistorico"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           historico.setMiagroempresa(miagroempresa);
          historico.setValorHistorico(res.getDouble("valorHistorico"));

              lista.add(historico);
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