/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La vie est composé de combien de fois nous rions avant de mourir  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricaconversionenergeticaDao;

public class MetricaconversionenergeticaFacade {

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
   * Crea un objeto Metricaconversionenergetica a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaConversionEnergetica
   * @param desripcionMetricaConversionEnergetica
   * @param conversionenergetica
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaConversionEnergetica, String desripcionMetricaConversionEnergetica, Conversionenergetica conversionenergetica){
      Metricaconversionenergetica metricaconversionenergetica = new Metricaconversionenergetica();
      metricaconversionenergetica.setIdmetricaConversionEnergetica(idmetricaConversionEnergetica); 
      metricaconversionenergetica.setDesripcionMetricaConversionEnergetica(desripcionMetricaConversionEnergetica); 
      metricaconversionenergetica.setConversionenergetica(conversionenergetica); 

     IMetricaconversionenergeticaDao metricaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getMetricaconversionenergeticaDao(getDataBaseDefault());
     int rtn = metricaconversionenergeticaDao.insert(metricaconversionenergetica);
     metricaconversionenergeticaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricaconversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaConversionEnergetica
   * @return El objeto en base de datos o Null
   */
  public static Metricaconversionenergetica select(int idmetricaConversionEnergetica){
      Metricaconversionenergetica metricaconversionenergetica = new Metricaconversionenergetica();
      metricaconversionenergetica.setIdmetricaConversionEnergetica(idmetricaConversionEnergetica); 

     IMetricaconversionenergeticaDao metricaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getMetricaconversionenergeticaDao(getDataBaseDefault());
     Metricaconversionenergetica result=metricaconversionenergeticaDao.select(metricaconversionenergetica);
     metricaconversionenergeticaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricaconversionenergetica  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaConversionEnergetica
   * @param desripcionMetricaConversionEnergetica
   * @param conversionenergetica
   */
  public static void update(int idmetricaConversionEnergetica, String desripcionMetricaConversionEnergetica, Conversionenergetica conversionenergetica){
      Metricaconversionenergetica metricaconversionenergetica = select(idmetricaConversionEnergetica);
      metricaconversionenergetica.setDesripcionMetricaConversionEnergetica(desripcionMetricaConversionEnergetica); 
      metricaconversionenergetica.setConversionenergetica(conversionenergetica); 

     IMetricaconversionenergeticaDao metricaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getMetricaconversionenergeticaDao(getDataBaseDefault());
     metricaconversionenergeticaDao.update(metricaconversionenergetica);
     metricaconversionenergeticaDao.close();
  }

  /**
   * Elimina un objeto Metricaconversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaConversionEnergetica
   */
  public static void delete(int idmetricaConversionEnergetica){
      Metricaconversionenergetica metricaconversionenergetica = new Metricaconversionenergetica();
      metricaconversionenergetica.setIdmetricaConversionEnergetica(idmetricaConversionEnergetica); 

     IMetricaconversionenergeticaDao metricaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getMetricaconversionenergeticaDao(getDataBaseDefault());
     metricaconversionenergeticaDao.delete(metricaconversionenergetica);
     metricaconversionenergeticaDao.close();
  }

  /**
   * Lista todos los objetos Metricaconversionenergetica de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricaconversionenergetica>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricaconversionenergetica> listAll(){
     IMetricaconversionenergeticaDao metricaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getMetricaconversionenergeticaDao(getDataBaseDefault());
     ArrayList<Metricaconversionenergetica> result=metricaconversionenergeticaDao.listAll();
     metricaconversionenergeticaDao.close();
      return result;
  }


}
//That`s all folks!