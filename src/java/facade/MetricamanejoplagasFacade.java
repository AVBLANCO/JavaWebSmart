/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Únicamente cuando se pierde todo somos libres para actuar.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricamanejoplagasDao;

public class MetricamanejoplagasFacade {

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
   * Crea un objeto Metricamanejoplagas a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoPlagas
   * @param descripcionMetricaManejoPlagas
   * @param manejointegradoplagas
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaManejoPlagas, String descripcionMetricaManejoPlagas, Manejointegradoplagas manejointegradoplagas){
      Metricamanejoplagas metricamanejoplagas = new Metricamanejoplagas();
      metricamanejoplagas.setIdmetricaManejoPlagas(idmetricaManejoPlagas); 
      metricamanejoplagas.setDescripcionMetricaManejoPlagas(descripcionMetricaManejoPlagas); 
      metricamanejoplagas.setManejointegradoplagas(manejointegradoplagas); 

     IMetricamanejoplagasDao metricamanejoplagasDao =new FactoryDao(getGestorDefault()).getMetricamanejoplagasDao(getDataBaseDefault());
     int rtn = metricamanejoplagasDao.insert(metricamanejoplagas);
     metricamanejoplagasDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricamanejoplagas de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoPlagas
   * @return El objeto en base de datos o Null
   */
  public static Metricamanejoplagas select(int idmetricaManejoPlagas){
      Metricamanejoplagas metricamanejoplagas = new Metricamanejoplagas();
      metricamanejoplagas.setIdmetricaManejoPlagas(idmetricaManejoPlagas); 

     IMetricamanejoplagasDao metricamanejoplagasDao =new FactoryDao(getGestorDefault()).getMetricamanejoplagasDao(getDataBaseDefault());
     Metricamanejoplagas result=metricamanejoplagasDao.select(metricamanejoplagas);
     metricamanejoplagasDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricamanejoplagas  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoPlagas
   * @param descripcionMetricaManejoPlagas
   * @param manejointegradoplagas
   */
  public static void update(int idmetricaManejoPlagas, String descripcionMetricaManejoPlagas, Manejointegradoplagas manejointegradoplagas){
      Metricamanejoplagas metricamanejoplagas = select(idmetricaManejoPlagas);
      metricamanejoplagas.setDescripcionMetricaManejoPlagas(descripcionMetricaManejoPlagas); 
      metricamanejoplagas.setManejointegradoplagas(manejointegradoplagas); 

     IMetricamanejoplagasDao metricamanejoplagasDao =new FactoryDao(getGestorDefault()).getMetricamanejoplagasDao(getDataBaseDefault());
     metricamanejoplagasDao.update(metricamanejoplagas);
     metricamanejoplagasDao.close();
  }

  /**
   * Elimina un objeto Metricamanejoplagas de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaManejoPlagas
   */
  public static void delete(int idmetricaManejoPlagas){
      Metricamanejoplagas metricamanejoplagas = new Metricamanejoplagas();
      metricamanejoplagas.setIdmetricaManejoPlagas(idmetricaManejoPlagas); 

     IMetricamanejoplagasDao metricamanejoplagasDao =new FactoryDao(getGestorDefault()).getMetricamanejoplagasDao(getDataBaseDefault());
     metricamanejoplagasDao.delete(metricamanejoplagas);
     metricamanejoplagasDao.close();
  }

  /**
   * Lista todos los objetos Metricamanejoplagas de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricamanejoplagas>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricamanejoplagas> listAll(){
     IMetricamanejoplagasDao metricamanejoplagasDao =new FactoryDao(getGestorDefault()).getMetricamanejoplagasDao(getDataBaseDefault());
     ArrayList<Metricamanejoplagas> result=metricamanejoplagasDao.listAll();
     metricamanejoplagasDao.close();
      return result;
  }


}
//That`s all folks!