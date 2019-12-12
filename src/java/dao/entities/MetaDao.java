/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Generar buen código o poner frases graciosas? ¡La frase! ¡La frase!  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IMetaDao;
import back.dto.*;
import java.util.ArrayList;

public class MetaDao implements IMetaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public MetaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Meta en la base de datos.
     * @param meta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Meta meta) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `meta`( `idmeta`, `descripcionMeta`, `valorMeta`, `proyeccion_idproyeccion`)"
          +"VALUES (?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, meta.getIdmeta());
          consulta.setString(2, meta.getDescripcionMeta());
          consulta.setDouble(3, meta.getValorMeta());
          consulta.setInt(4, meta.getProyeccion().getIdproyeccion());
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
     * Busca un objeto Meta en la base de datos.
     * @param meta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Meta select(Meta meta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmeta`, `descripcionMeta`, `valorMeta`, `proyeccion_idproyeccion`"
          +"FROM `meta`"
          +"WHERE `idmeta`=?");
          consulta.setInt(1, meta.getIdmeta());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          meta.setIdmeta(res.getInt("idmeta"));
          meta.setDescripcionMeta(res.getString("descripcionMeta"));
          meta.setValorMeta(res.getDouble("valorMeta"));
           Proyeccion proyeccion = new Proyeccion();
           proyeccion.setIdproyeccion(res.getInt("proyeccion_idproyeccion"));
           meta.setProyeccion(proyeccion);

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return meta;
  }

    /**
     * Modifica un objeto Meta en la base de datos.
     * @param meta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Meta meta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `meta` SET`idmeta`=?, `descripcionMeta`=?, `valorMeta`=?, `proyeccion_idproyeccion`=? WHERE `idmeta`=? ");
          consulta.setInt(1, meta.getIdmeta());
          consulta.setString(2, meta.getDescripcionMeta());
          consulta.setDouble(3, meta.getValorMeta());
          consulta.setInt(4, meta.getProyeccion().getIdproyeccion());
          consulta.setInt(5, meta.getIdmeta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Meta en la base de datos.
     * @param meta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Meta meta) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `meta` WHERE `idmeta`=?");
          consulta.setInt(1, meta.getIdmeta());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Meta en la base de datos.
     * @return ArrayList<Meta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Meta> listAll() throws NullPointerException{
      ArrayList<Meta> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idmeta`, `descripcionMeta`, `valorMeta`, `proyeccion_idproyeccion`"
          +"FROM `meta`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Meta meta= new Meta();
          meta.setIdmeta(res.getInt("idmeta"));
          meta.setDescripcionMeta(res.getString("descripcionMeta"));
          meta.setValorMeta(res.getDouble("valorMeta"));
           Proyeccion proyeccion = new Proyeccion();
           proyeccion.setIdproyeccion(res.getInt("proyeccion_idproyeccion"));
           meta.setProyeccion(proyeccion);

              lista.add(meta);
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