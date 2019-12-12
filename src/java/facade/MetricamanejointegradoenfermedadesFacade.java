/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Vaya! ¡Al fin harás algo mejor que una calculadora!  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricamanejointegradoenfermedadesDao;

public class MetricamanejointegradoenfermedadesFacade {

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
   * Crea un objeto Metricamanejointegradoenfermedades a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoIntegradoEnfermedades
   * @param descricionMetricaManejoIntegradoEnfermedades
   * @param manejointegradoenfermedades
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaManejoIntegradoEnfermedades, String descricionMetricaManejoIntegradoEnfermedades, Manejointegradoenfermedades manejointegradoenfermedades){
      Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = new Metricamanejointegradoenfermedades();
      metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(idmetricaManejoIntegradoEnfermedades); 
      metricamanejointegradoenfermedades.setDescricionMetricaManejoIntegradoEnfermedades(descricionMetricaManejoIntegradoEnfermedades); 
      metricamanejointegradoenfermedades.setManejointegradoenfermedades(manejointegradoenfermedades); 

     IMetricamanejointegradoenfermedadesDao metricamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getMetricamanejointegradoenfermedadesDao(getDataBaseDefault());
     int rtn = metricamanejointegradoenfermedadesDao.insert(metricamanejointegradoenfermedades);
     metricamanejointegradoenfermedadesDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricamanejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoIntegradoEnfermedades
   * @return El objeto en base de datos o Null
   */
  public static Metricamanejointegradoenfermedades select(int idmetricaManejoIntegradoEnfermedades){
      Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = new Metricamanejointegradoenfermedades();
      metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(idmetricaManejoIntegradoEnfermedades); 

     IMetricamanejointegradoenfermedadesDao metricamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getMetricamanejointegradoenfermedadesDao(getDataBaseDefault());
     Metricamanejointegradoenfermedades result=metricamanejointegradoenfermedadesDao.select(metricamanejointegradoenfermedades);
     metricamanejointegradoenfermedadesDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricamanejointegradoenfermedades  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoIntegradoEnfermedades
   * @param descricionMetricaManejoIntegradoEnfermedades
   * @param manejointegradoenfermedades
   */
  public static void update(int idmetricaManejoIntegradoEnfermedades, String descricionMetricaManejoIntegradoEnfermedades, Manejointegradoenfermedades manejointegradoenfermedades){
      Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = select(idmetricaManejoIntegradoEnfermedades);
      metricamanejointegradoenfermedades.setDescricionMetricaManejoIntegradoEnfermedades(descricionMetricaManejoIntegradoEnfermedades); 
      metricamanejointegradoenfermedades.setManejointegradoenfermedades(manejointegradoenfermedades); 

     IMetricamanejointegradoenfermedadesDao metricamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getMetricamanejointegradoenfermedadesDao(getDataBaseDefault());
     metricamanejointegradoenfermedadesDao.update(metricamanejointegradoenfermedades);
     metricamanejointegradoenfermedadesDao.close();
  }

  /**
   * Elimina un objeto Metricamanejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoIntegradoEnfermedades
   */
  public static void delete(int idmetricaManejoIntegradoEnfermedades){
      Metricamanejointegradoenfermedades metricamanejointegradoenfermedades = new Metricamanejointegradoenfermedades();
      metricamanejointegradoenfermedades.setIdmetricaManejoIntegradoEnfermedades(idmetricaManejoIntegradoEnfermedades); 

     IMetricamanejointegradoenfermedadesDao metricamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getMetricamanejointegradoenfermedadesDao(getDataBaseDefault());
     metricamanejointegradoenfermedadesDao.delete(metricamanejointegradoenfermedades);
     metricamanejointegradoenfermedadesDao.close();
  }

  /**
   * Lista todos los objetos Metricamanejointegradoenfermedades de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricamanejointegradoenfermedades>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricamanejointegradoenfermedades> listAll(){
     IMetricamanejointegradoenfermedadesDao metricamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getMetricamanejointegradoenfermedadesDao(getDataBaseDefault());
     ArrayList<Metricamanejointegradoenfermedades> result=metricamanejointegradoenfermedadesDao.listAll();
     metricamanejointegradoenfermedadesDao.close();
      return result;
  }


}
//That`s all folks!