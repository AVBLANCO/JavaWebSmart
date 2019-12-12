/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Les traigo amor  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IProyeccionDao;

public class ProyeccionFacade {

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
   * Crea un objeto Proyeccion a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idproyeccion
   * @param descripcionProyeccion
   * @param fechaProyeccion
   * @param lote
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idproyeccion, String descripcionProyeccion, String fechaProyeccion, Lote lote){
      Proyeccion proyeccion = new Proyeccion();
      proyeccion.setIdproyeccion(idproyeccion); 
      proyeccion.setDescripcionProyeccion(descripcionProyeccion); 
      proyeccion.setFechaProyeccion(fechaProyeccion); 
      proyeccion.setLote(lote); 

     IProyeccionDao proyeccionDao =new FactoryDao(getGestorDefault()).getProyeccionDao(getDataBaseDefault());
     int rtn = proyeccionDao.insert(proyeccion);
     proyeccionDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Proyeccion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idproyeccion
   * @return El objeto en base de datos o Null
   */
  public static Proyeccion select(int idproyeccion){
      Proyeccion proyeccion = new Proyeccion();
      proyeccion.setIdproyeccion(idproyeccion); 

     IProyeccionDao proyeccionDao =new FactoryDao(getGestorDefault()).getProyeccionDao(getDataBaseDefault());
     Proyeccion result=proyeccionDao.select(proyeccion);
     proyeccionDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Proyeccion  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idproyeccion
   * @param descripcionProyeccion
   * @param fechaProyeccion
   * @param lote
   */
  public static void update(int idproyeccion, String descripcionProyeccion, String fechaProyeccion, Lote lote){
      Proyeccion proyeccion = select(idproyeccion);
      proyeccion.setDescripcionProyeccion(descripcionProyeccion); 
      proyeccion.setFechaProyeccion(fechaProyeccion); 
      proyeccion.setLote(lote); 

     IProyeccionDao proyeccionDao =new FactoryDao(getGestorDefault()).getProyeccionDao(getDataBaseDefault());
     proyeccionDao.update(proyeccion);
     proyeccionDao.close();
  }

  /**
   * Elimina un objeto Proyeccion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idproyeccion
   */
  public static void delete(int idproyeccion){
      Proyeccion proyeccion = new Proyeccion();
      proyeccion.setIdproyeccion(idproyeccion); 

     IProyeccionDao proyeccionDao =new FactoryDao(getGestorDefault()).getProyeccionDao(getDataBaseDefault());
     proyeccionDao.delete(proyeccion);
     proyeccionDao.close();
  }

  /**
   * Lista todos los objetos Proyeccion de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Proyeccion>  con los objetos en base de datos o Null
   */
  public static ArrayList<Proyeccion> listAll(){
     IProyeccionDao proyeccionDao =new FactoryDao(getGestorDefault()).getProyeccionDao(getDataBaseDefault());
     ArrayList<Proyeccion> result=proyeccionDao.listAll();
     proyeccionDao.close();
      return result;
  }


}
//That`s all folks!