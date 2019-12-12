/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Si crees que las mujeres son difíciles, no conoces Anarchy  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IEvotranspiracionDao;

public class EvotranspiracionFacade {

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
   * Crea un objeto Evotranspiracion a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idevotranspiracion
   * @param descripcionEvotranspiracion
   * @param fechaEvotranspiracion
   * @param agroclimatologia
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idevotranspiracion, String descripcionEvotranspiracion, String fechaEvotranspiracion, Agroclimatologia agroclimatologia){
      Evotranspiracion evotranspiracion = new Evotranspiracion();
      evotranspiracion.setIdevotranspiracion(idevotranspiracion); 
      evotranspiracion.setDescripcionEvotranspiracion(descripcionEvotranspiracion); 
      evotranspiracion.setFechaEvotranspiracion(fechaEvotranspiracion); 
      evotranspiracion.setAgroclimatologia(agroclimatologia); 

     IEvotranspiracionDao evotranspiracionDao =new FactoryDao(getGestorDefault()).getEvotranspiracionDao(getDataBaseDefault());
     int rtn = evotranspiracionDao.insert(evotranspiracion);
     evotranspiracionDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Evotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idevotranspiracion
   * @return El objeto en base de datos o Null
   */
  public static Evotranspiracion select(int idevotranspiracion){
      Evotranspiracion evotranspiracion = new Evotranspiracion();
      evotranspiracion.setIdevotranspiracion(idevotranspiracion); 

     IEvotranspiracionDao evotranspiracionDao =new FactoryDao(getGestorDefault()).getEvotranspiracionDao(getDataBaseDefault());
     Evotranspiracion result=evotranspiracionDao.select(evotranspiracion);
     evotranspiracionDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Evotranspiracion  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idevotranspiracion
   * @param descripcionEvotranspiracion
   * @param fechaEvotranspiracion
   * @param agroclimatologia
   */
  public static void update(int idevotranspiracion, String descripcionEvotranspiracion, String fechaEvotranspiracion, Agroclimatologia agroclimatologia){
      Evotranspiracion evotranspiracion = select(idevotranspiracion);
      evotranspiracion.setDescripcionEvotranspiracion(descripcionEvotranspiracion); 
      evotranspiracion.setFechaEvotranspiracion(fechaEvotranspiracion); 
      evotranspiracion.setAgroclimatologia(agroclimatologia); 

     IEvotranspiracionDao evotranspiracionDao =new FactoryDao(getGestorDefault()).getEvotranspiracionDao(getDataBaseDefault());
     evotranspiracionDao.update(evotranspiracion);
     evotranspiracionDao.close();
  }

  /**
   * Elimina un objeto Evotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idevotranspiracion
   */
  public static void delete(int idevotranspiracion){
      Evotranspiracion evotranspiracion = new Evotranspiracion();
      evotranspiracion.setIdevotranspiracion(idevotranspiracion); 

     IEvotranspiracionDao evotranspiracionDao =new FactoryDao(getGestorDefault()).getEvotranspiracionDao(getDataBaseDefault());
     evotranspiracionDao.delete(evotranspiracion);
     evotranspiracionDao.close();
  }

  /**
   * Lista todos los objetos Evotranspiracion de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Evotranspiracion>  con los objetos en base de datos o Null
   */
  public static ArrayList<Evotranspiracion> listAll(){
     IEvotranspiracionDao evotranspiracionDao =new FactoryDao(getGestorDefault()).getEvotranspiracionDao(getDataBaseDefault());
     ArrayList<Evotranspiracion> result=evotranspiracionDao.listAll();
     evotranspiracionDao.close();
      return result;
  }


}
//That`s all folks!