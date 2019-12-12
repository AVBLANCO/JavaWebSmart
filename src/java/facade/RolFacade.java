/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En un lugar de La Mancha, de cuyo nombre no quiero acordarme...  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IRolDao;

public class RolFacade {

  /**
   * Para su comodidad, defina aquí el gestor de conexión predilecto para esta entidad
   * @return idGestor Devuelve el identificador del gestor de conexión
   */
  private static int getGestorDefault(){
      return GlobalController.DEFAULT_GESTOR;
  }
  /**
   * Para su comodidad, defina aquí el nombre de base de datos predilecto para esta entidad
   * @return dbName Devuelve el nombre de la base de datos a emplear
   */
  private static String getDataBaseDefault(){
      return GlobalController.DEFAULT_DBNAME;
  }
  /**
   * Crea un objeto Rol a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idrol
   * @param descripcion
   * @param usuario
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idrol, String descripcion, Usuario usuario){
      Rol rol = new Rol();
      rol.setIdrol(idrol); 
      rol.setDescripcion(descripcion); 
      rol.setUsuario(usuario); 

     IRolDao rolDao =new FactoryDao(getGestorDefault()).getRolDao(getDataBaseDefault());
     int rtn = rolDao.insert(rol);
     rolDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Rol de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idrol
   * @return El objeto en base de datos o Null
   */
  public static Rol select(int idrol){
      Rol rol = new Rol();
      rol.setIdrol(idrol); 

     IRolDao rolDao =new FactoryDao(getGestorDefault()).getRolDao(getDataBaseDefault());
     Rol result=rolDao.select(rol);
     rolDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Rol  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idrol
   * @param descripcion
   * @param usuario
   */
  public static void update(int idrol, String descripcion, Usuario usuario){
      Rol rol = select(idrol);
      rol.setDescripcion(descripcion); 
      rol.setUsuario(usuario); 

     IRolDao rolDao =new FactoryDao(getGestorDefault()).getRolDao(getDataBaseDefault());
     rolDao.update(rol);
     rolDao.close();
  }

  /**
   * Elimina un objeto Rol de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idrol
   */
  public static void delete(int idrol){
      Rol rol = new Rol();
      rol.setIdrol(idrol); 

     IRolDao rolDao =new FactoryDao(getGestorDefault()).getRolDao(getDataBaseDefault());
     rolDao.delete(rol);
     rolDao.close();
  }

  /**
   * Lista todos los objetos Rol de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Rol>  con los objetos en base de datos o Null
   */
  public static ArrayList<Rol> listAll(){
     IRolDao rolDao =new FactoryDao(getGestorDefault()).getRolDao(getDataBaseDefault());
     ArrayList<Rol> result=rolDao.listAll();
     rolDao.close();
      return result;
  }


}
//That`s all folks!