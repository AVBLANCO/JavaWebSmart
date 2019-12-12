/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo.   \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IManejointegradoplagasDao;
import back.dto.*;
import java.util.ArrayList;

public class ManejointegradoplagasDao implements IManejointegradoplagasDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public ManejointegradoplagasDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Manejointegradoplagas manejointegradoplagas) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `manejointegradoplagas`( `idmanejoIntegradoPlagas`, `descricionManejoIntegradoPlagas`, `mipe_idmipe`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, manejointegradoplagas.getIdmanejoIntegradoPlagas());
          consulta.setString(2, manejointegradoplagas.getDescricionManejoIntegradoPlagas());
          consulta.setInt(3, manejointegradoplagas.getMipe().getIdmipe());
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
     * Busca un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Manejointegradoplagas select(Manejointegradoplagas manejointegradoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmanejoIntegradoPlagas`, `descricionManejoIntegradoPlagas`, `mipe_idmipe`"
          +"FROM `manejointegradoplagas`"
          +"WHERE `idmanejoIntegradoPlagas`=?");
          consulta.setInt(1, manejointegradoplagas.getIdmanejoIntegradoPlagas());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          manejointegradoplagas.setIdmanejoIntegradoPlagas(res.getInt("idmanejoIntegradoPlagas"));
          manejointegradoplagas.setDescricionManejoIntegradoPlagas(res.getString("descricionManejoIntegradoPlagas"));
           Mipe mipe = new Mipe();
           mipe.setIdmipe(res.getInt("mipe_idmipe"));
           manejointegradoplagas.setMipe(mipe);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return manejointegradoplagas;
  }

    /**
     * Modifica un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Manejointegradoplagas manejointegradoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `manejointegradoplagas` SET`idmanejoIntegradoPlagas`=?, `descricionManejoIntegradoPlagas`=?, `mipe_idmipe`=? WHERE `idmanejoIntegradoPlagas`=? ");
          consulta.setInt(1, manejointegradoplagas.getIdmanejoIntegradoPlagas());
          consulta.setString(2, manejointegradoplagas.getDescricionManejoIntegradoPlagas());
          consulta.setInt(3, manejointegradoplagas.getMipe().getIdmipe());
          consulta.setInt(4, manejointegradoplagas.getIdmanejoIntegradoPlagas());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Manejointegradoplagas manejointegradoplagas) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `manejointegradoplagas` WHERE `idmanejoIntegradoPlagas`=?");
          consulta.setInt(1, manejointegradoplagas.getIdmanejoIntegradoPlagas());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Manejointegradoplagas en la base de datos.
     * @return ArrayList<Manejointegradoplagas> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Manejointegradoplagas> listAll() throws NullPointerException{
      ArrayList<Manejointegradoplagas> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmanejoIntegradoPlagas`, `descricionManejoIntegradoPlagas`, `mipe_idmipe`"
          +"FROM `manejointegradoplagas`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Manejointegradoplagas manejointegradoplagas= new Manejointegradoplagas();
          manejointegradoplagas.setIdmanejoIntegradoPlagas(res.getInt("idmanejoIntegradoPlagas"));
          manejointegradoplagas.setDescricionManejoIntegradoPlagas(res.getString("descricionManejoIntegradoPlagas"));
           Mipe mipe = new Mipe();
           mipe.setIdmipe(res.getInt("mipe_idmipe"));
           manejointegradoplagas.setMipe(mipe);

              lista.add(manejointegradoplagas);
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