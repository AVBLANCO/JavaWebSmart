/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Yo <3 Cúcuta  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricabiologiasueloDao;

public class MetricabiologiasueloFacade {

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
   * Crea un objeto Metricabiologiasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBiologiaSuelo
   * @param descripcionMetricaBiologiaSuelo
   * @param biologiasuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaBiologiaSuelo, String descripcionMetricaBiologiaSuelo, Biologiasuelo biologiasuelo){
      Metricabiologiasuelo metricabiologiasuelo = new Metricabiologiasuelo();
      metricabiologiasuelo.setIdmetricaBiologiaSuelo(idmetricaBiologiaSuelo); 
      metricabiologiasuelo.setDescripcionMetricaBiologiaSuelo(descripcionMetricaBiologiaSuelo); 
      metricabiologiasuelo.setBiologiasuelo(biologiasuelo); 

     IMetricabiologiasueloDao metricabiologiasueloDao =new FactoryDao(getGestorDefault()).getMetricabiologiasueloDao(getDataBaseDefault());
     int rtn = metricabiologiasueloDao.insert(metricabiologiasuelo);
     metricabiologiasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricabiologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBiologiaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Metricabiologiasuelo select(int idmetricaBiologiaSuelo){
      Metricabiologiasuelo metricabiologiasuelo = new Metricabiologiasuelo();
      metricabiologiasuelo.setIdmetricaBiologiaSuelo(idmetricaBiologiaSuelo); 

     IMetricabiologiasueloDao metricabiologiasueloDao =new FactoryDao(getGestorDefault()).getMetricabiologiasueloDao(getDataBaseDefault());
     Metricabiologiasuelo result=metricabiologiasueloDao.select(metricabiologiasuelo);
     metricabiologiasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricabiologiasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBiologiaSuelo
   * @param descripcionMetricaBiologiaSuelo
   * @param biologiasuelo
   */
  public static void update(int idmetricaBiologiaSuelo, String descripcionMetricaBiologiaSuelo, Biologiasuelo biologiasuelo){
      Metricabiologiasuelo metricabiologiasuelo = select(idmetricaBiologiaSuelo);
      metricabiologiasuelo.setDescripcionMetricaBiologiaSuelo(descripcionMetricaBiologiaSuelo); 
      metricabiologiasuelo.setBiologiasuelo(biologiasuelo); 

     IMetricabiologiasueloDao metricabiologiasueloDao =new FactoryDao(getGestorDefault()).getMetricabiologiasueloDao(getDataBaseDefault());
     metricabiologiasueloDao.update(metricabiologiasuelo);
     metricabiologiasueloDao.close();
  }

  /**
   * Elimina un objeto Metricabiologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaBiologiaSuelo
   */
  public static void delete(int idmetricaBiologiaSuelo){
      Metricabiologiasuelo metricabiologiasuelo = new Metricabiologiasuelo();
      metricabiologiasuelo.setIdmetricaBiologiaSuelo(idmetricaBiologiaSuelo); 

     IMetricabiologiasueloDao metricabiologiasueloDao =new FactoryDao(getGestorDefault()).getMetricabiologiasueloDao(getDataBaseDefault());
     metricabiologiasueloDao.delete(metricabiologiasuelo);
     metricabiologiasueloDao.close();
  }

  /**
   * Lista todos los objetos Metricabiologiasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricabiologiasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricabiologiasuelo> listAll(){
     IMetricabiologiasueloDao metricabiologiasueloDao =new FactoryDao(getGestorDefault()).getMetricabiologiasueloDao(getDataBaseDefault());
     ArrayList<Metricabiologiasuelo> result=metricabiologiasueloDao.listAll();
     metricabiologiasueloDao.close();
      return result;
  }


}
//That`s all folks!