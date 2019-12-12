/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo.   \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricaevotranspiracionDao;

public class MetricaevotranspiracionFacade {

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
   * Crea un objeto Metricaevotranspiracion a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaEvotranspiracion
   * @param descripcionMetricaEvotranspiracion
   * @param evotranspiracion
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaEvotranspiracion, String descripcionMetricaEvotranspiracion, Evotranspiracion evotranspiracion){
      Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
      metricaevotranspiracion.setIdmetricaEvotranspiracion(idmetricaEvotranspiracion); 
      metricaevotranspiracion.setDescripcionMetricaEvotranspiracion(descripcionMetricaEvotranspiracion); 
      metricaevotranspiracion.setEvotranspiracion(evotranspiracion); 

     IMetricaevotranspiracionDao metricaevotranspiracionDao =new FactoryDao(getGestorDefault()).getMetricaevotranspiracionDao(getDataBaseDefault());
     int rtn = metricaevotranspiracionDao.insert(metricaevotranspiracion);
     metricaevotranspiracionDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricaevotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaEvotranspiracion
   * @return El objeto en base de datos o Null
   */
  public static Metricaevotranspiracion select(int idmetricaEvotranspiracion){
      Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
      metricaevotranspiracion.setIdmetricaEvotranspiracion(idmetricaEvotranspiracion); 

     IMetricaevotranspiracionDao metricaevotranspiracionDao =new FactoryDao(getGestorDefault()).getMetricaevotranspiracionDao(getDataBaseDefault());
     Metricaevotranspiracion result=metricaevotranspiracionDao.select(metricaevotranspiracion);
     metricaevotranspiracionDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricaevotranspiracion  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaEvotranspiracion
   * @param descripcionMetricaEvotranspiracion
   * @param evotranspiracion
   */
  public static void update(int idmetricaEvotranspiracion, String descripcionMetricaEvotranspiracion, Evotranspiracion evotranspiracion){
      Metricaevotranspiracion metricaevotranspiracion = select(idmetricaEvotranspiracion);
      metricaevotranspiracion.setDescripcionMetricaEvotranspiracion(descripcionMetricaEvotranspiracion); 
      metricaevotranspiracion.setEvotranspiracion(evotranspiracion); 

     IMetricaevotranspiracionDao metricaevotranspiracionDao =new FactoryDao(getGestorDefault()).getMetricaevotranspiracionDao(getDataBaseDefault());
     metricaevotranspiracionDao.update(metricaevotranspiracion);
     metricaevotranspiracionDao.close();
  }

  /**
   * Elimina un objeto Metricaevotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaEvotranspiracion
   */
  public static void delete(int idmetricaEvotranspiracion){
      Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
      metricaevotranspiracion.setIdmetricaEvotranspiracion(idmetricaEvotranspiracion); 

     IMetricaevotranspiracionDao metricaevotranspiracionDao =new FactoryDao(getGestorDefault()).getMetricaevotranspiracionDao(getDataBaseDefault());
     metricaevotranspiracionDao.delete(metricaevotranspiracion);
     metricaevotranspiracionDao.close();
  }

  /**
   * Lista todos los objetos Metricaevotranspiracion de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricaevotranspiracion>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricaevotranspiracion> listAll(){
     IMetricaevotranspiracionDao metricaevotranspiracionDao =new FactoryDao(getGestorDefault()).getMetricaevotranspiracionDao(getDataBaseDefault());
     ArrayList<Metricaevotranspiracion> result=metricaevotranspiracionDao.listAll();
     metricaevotranspiracionDao.close();
      return result;
  }


}
//That`s all folks!