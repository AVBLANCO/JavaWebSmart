/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Para entender la recursividad, primero debes entender la recursividad  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IQuimicasueloDao;
import back.dto.*;
import java.util.ArrayList;

public class QuimicasueloDao implements IQuimicasueloDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public QuimicasueloDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Quimicasuelo quimicasuelo) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `quimicasuelo`( `idQuimicaSuelo`, `descripcionQuimica`, `suelo_idsuelo`)"
          +"VALUES (?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, quimicasuelo.getIdQuimicaSuelo());
          consulta.setString(2, quimicasuelo.getDescripcionQuimica());
          consulta.setInt(3, quimicasuelo.getSuelo().getIdsuelo());
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
     * Busca un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Quimicasuelo select(Quimicasuelo quimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idQuimicaSuelo`, `descripcionQuimica`, `suelo_idsuelo`"
          +"FROM `quimicasuelo`"
          +"WHERE `idQuimicaSuelo`=?");
          consulta.setInt(1, quimicasuelo.getIdQuimicaSuelo());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          quimicasuelo.setIdQuimicaSuelo(res.getInt("idQuimicaSuelo"));
          quimicasuelo.setDescripcionQuimica(res.getString("descripcionQuimica"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           quimicasuelo.setSuelo(suelo);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return quimicasuelo;
  }

    /**
     * Modifica un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Quimicasuelo quimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `quimicasuelo` SET`idQuimicaSuelo`=?, `descripcionQuimica`=?, `suelo_idsuelo`=? WHERE `idQuimicaSuelo`=? ");
          consulta.setInt(1, quimicasuelo.getIdQuimicaSuelo());
          consulta.setString(2, quimicasuelo.getDescripcionQuimica());
          consulta.setInt(3, quimicasuelo.getSuelo().getIdsuelo());
          consulta.setInt(4, quimicasuelo.getIdQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Quimicasuelo quimicasuelo) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `quimicasuelo` WHERE `idQuimicaSuelo`=?");
          consulta.setInt(1, quimicasuelo.getIdQuimicaSuelo());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Quimicasuelo en la base de datos.
     * @return ArrayList<Quimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Quimicasuelo> listAll() throws NullPointerException{
      ArrayList<Quimicasuelo> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idQuimicaSuelo`, `descripcionQuimica`, `suelo_idsuelo`"
          +"FROM `quimicasuelo`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Quimicasuelo quimicasuelo= new Quimicasuelo();
          quimicasuelo.setIdQuimicaSuelo(res.getInt("idQuimicaSuelo"));
          quimicasuelo.setDescripcionQuimica(res.getString("descripcionQuimica"));
           Suelo suelo = new Suelo();
           suelo.setIdsuelo(res.getInt("suelo_idsuelo"));
           quimicasuelo.setSuelo(suelo);

              lista.add(quimicasuelo);
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