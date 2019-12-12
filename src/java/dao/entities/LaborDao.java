/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Has encontrado la frase #1024 ¡Felicidades! Ahora tu proyecto funcionará a la primera  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.ILaborDao;
import back.dto.*;
import java.util.ArrayList;

public class LaborDao implements ILaborDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public LaborDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Labor en la base de datos.
     * @param labor objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Labor labor) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `labor`( `idlabor`, `descripcionLabor`, `duracionLabor`, `miAgroempresa_idmiAgroempresa`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, labor.getIdlabor());
          consulta.setString(2, labor.getDescripcionLabor());
          consulta.setInt(3, labor.getDuracionLabor());
          consulta.setInt(4, labor.getMiagroempresa().getIdmiAgroempresa());
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
     * Busca un objeto Labor en la base de datos.
     * @param labor objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Labor select(Labor labor) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlabor`, `descripcionLabor`, `duracionLabor`, `miAgroempresa_idmiAgroempresa`"
          +"FROM `labor`"
          +"WHERE `idlabor`=?");
          consulta.setInt(1, labor.getIdlabor());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          labor.setIdlabor(res.getInt("idlabor"));
          labor.setDescripcionLabor(res.getString("descripcionLabor"));
          labor.setDuracionLabor(res.getInt("duracionLabor"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           labor.setMiagroempresa(miagroempresa);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return labor;
  }

    /**
     * Modifica un objeto Labor en la base de datos.
     * @param labor objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Labor labor) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `labor` SET`idlabor`=?, `descripcionLabor`=?, `duracionLabor`=?, `miAgroempresa_idmiAgroempresa`=? WHERE `idlabor`=? ");
          consulta.setInt(1, labor.getIdlabor());
          consulta.setString(2, labor.getDescripcionLabor());
          consulta.setInt(3, labor.getDuracionLabor());
          consulta.setInt(4, labor.getMiagroempresa().getIdmiAgroempresa());
          consulta.setInt(5, labor.getIdlabor());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Labor en la base de datos.
     * @param labor objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Labor labor) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `labor` WHERE `idlabor`=?");
          consulta.setInt(1, labor.getIdlabor());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Labor en la base de datos.
     * @return ArrayList<Labor> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Labor> listAll() throws NullPointerException{
      ArrayList<Labor> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idlabor`, `descripcionLabor`, `duracionLabor`, `miAgroempresa_idmiAgroempresa`"
          +"FROM `labor`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Labor labor= new Labor();
          labor.setIdlabor(res.getInt("idlabor"));
          labor.setDescripcionLabor(res.getString("descripcionLabor"));
          labor.setDuracionLabor(res.getInt("duracionLabor"));
           Miagroempresa miagroempresa = new Miagroempresa();
           miagroempresa.setIdmiAgroempresa(res.getInt("miAgroempresa_idmiAgroempresa"));
           labor.setMiagroempresa(miagroempresa);

              lista.add(labor);
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