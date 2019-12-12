/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡¡Bienvenido al mundo del mañana!!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ICostoDao;
import back.dto.*;
import java.util.ArrayList;

public class CostoDao implements ICostoDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public CostoDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Costo en la base de datos.
     * @param costo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Costo costo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `costo`( `idcosto`, `descripcionCosto`, `valorCosto`, `miAgroempresa_idmiAgroempresa`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, costo.getIdcosto());
          consulta.setString(2, costo.getDescripcionCosto());
          consulta.setDouble(3, costo.getValorCosto());
          consulta.setInt(4, costo.getMiagroempresa().getIdmiAgroempresa());
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
     * Busca un objeto Costo en la base de datos.
     * @param costo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Costo select(Costo costo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idcosto`, `descripcionCosto`, `valorCosto`, `miAgroempresa_idmiAgroempresa`"
          +"FROM `costo`"
          +"WHERE `idcosto`=?");
          consulta.setInt(1, costo.getIdcosto());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          costo.setIdcosto(res.getInt("idcosto"));
          costo.setDescripcionCosto(res.getString("descripcionCosto"));
          costo.setValorCosto(res.getDouble("valorCosto"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           costo.setMiagroempresa(miagroempresa);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return costo;
  }

    /**
     * Modifica un objeto Costo en la base de datos.
     * @param costo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Costo costo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `costo` SET`idcosto`=?, `descripcionCosto`=?, `valorCosto`=?, `miAgroempresa_idmiAgroempresa`=? WHERE `idcosto`=? ");
          consulta.setInt(1, costo.getIdcosto());
          consulta.setString(2, costo.getDescripcionCosto());
          consulta.setDouble(3, costo.getValorCosto());
          consulta.setInt(4, costo.getMiagroempresa().getIdmiAgroempresa());
          consulta.setInt(5, costo.getIdcosto());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Costo en la base de datos.
     * @param costo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Costo costo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `costo` WHERE `idcosto`=?");
          consulta.setInt(1, costo.getIdcosto());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Costo en la base de datos.
     * @return ArrayList<Costo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Costo> listAll() throws NullPointerException{
      ArrayList<Costo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idcosto`, `descripcionCosto`, `valorCosto`, `miAgroempresa_idmiAgroempresa`"
          +"FROM `costo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Costo costo= new Costo();
          costo.setIdcosto(res.getInt("idcosto"));
          costo.setDescripcionCosto(res.getString("descripcionCosto"));
          costo.setValorCosto(res.getDouble("valorCosto"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           costo.setMiagroempresa(miagroempresa);

              lista.add(costo);
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