/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La primera regla del proyecto es no hacer preguntas  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricabalancehidricoDao;

public class MetricabalancehidricoFacade {

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
   * Crea un objeto Metricabalancehidrico a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBalanceHidrico
   * @param descripcionMetricaBalanceHidrico
   * @param balancehidrico
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaBalanceHidrico, String descripcionMetricaBalanceHidrico, Balancehidrico balancehidrico){
      Metricabalancehidrico metricabalancehidrico = new Metricabalancehidrico();
      metricabalancehidrico.setIdmetricaBalanceHidrico(idmetricaBalanceHidrico); 
      metricabalancehidrico.setDescripcionMetricaBalanceHidrico(descripcionMetricaBalanceHidrico); 
      metricabalancehidrico.setBalancehidrico(balancehidrico); 

     IMetricabalancehidricoDao metricabalancehidricoDao =new FactoryDao(getGestorDefault()).getMetricabalancehidricoDao(getDataBaseDefault());
     int rtn = metricabalancehidricoDao.insert(metricabalancehidrico);
     metricabalancehidricoDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricabalancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBalanceHidrico
   * @return El objeto en base de datos o Null
   */
  public static Metricabalancehidrico select(int idmetricaBalanceHidrico){
      Metricabalancehidrico metricabalancehidrico = new Metricabalancehidrico();
      metricabalancehidrico.setIdmetricaBalanceHidrico(idmetricaBalanceHidrico); 

     IMetricabalancehidricoDao metricabalancehidricoDao =new FactoryDao(getGestorDefault()).getMetricabalancehidricoDao(getDataBaseDefault());
     Metricabalancehidrico result=metricabalancehidricoDao.select(metricabalancehidrico);
     metricabalancehidricoDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricabalancehidrico  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBalanceHidrico
   * @param descripcionMetricaBalanceHidrico
   * @param balancehidrico
   */
  public static void update(int idmetricaBalanceHidrico, String descripcionMetricaBalanceHidrico, Balancehidrico balancehidrico){
      Metricabalancehidrico metricabalancehidrico = select(idmetricaBalanceHidrico);
      metricabalancehidrico.setDescripcionMetricaBalanceHidrico(descripcionMetricaBalanceHidrico); 
      metricabalancehidrico.setBalancehidrico(balancehidrico); 

     IMetricabalancehidricoDao metricabalancehidricoDao =new FactoryDao(getGestorDefault()).getMetricabalancehidricoDao(getDataBaseDefault());
     metricabalancehidricoDao.update(metricabalancehidrico);
     metricabalancehidricoDao.close();
  }

  /**
   * Elimina un objeto Metricabalancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBalanceHidrico
   */
  public static void delete(int idmetricaBalanceHidrico){
      Metricabalancehidrico metricabalancehidrico = new Metricabalancehidrico();
      metricabalancehidrico.setIdmetricaBalanceHidrico(idmetricaBalanceHidrico); 

     IMetricabalancehidricoDao metricabalancehidricoDao =new FactoryDao(getGestorDefault()).getMetricabalancehidricoDao(getDataBaseDefault());
     metricabalancehidricoDao.delete(metricabalancehidrico);
     metricabalancehidricoDao.close();
  }

  /**
   * Lista todos los objetos Metricabalancehidrico de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricabalancehidrico>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricabalancehidrico> listAll(){
     IMetricabalancehidricoDao metricabalancehidricoDao =new FactoryDao(getGestorDefault()).getMetricabalancehidricoDao(getDataBaseDefault());
     ArrayList<Metricabalancehidrico> result=metricabalancehidricoDao.listAll();
     metricabalancehidricoDao.close();
      return result;
  }


}
//That`s all folks!