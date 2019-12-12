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
import back.dao.interfaz.IMetricaquimicasueloDao;

public class MetricaquimicasueloFacade {

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
   * Crea un objeto Metricaquimicasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaQuimicaSuelo
   * @param descripcionMetricaQuimicaSuelocol
   * @param quimicasuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricaQuimicaSuelo, String descripcionMetricaQuimicaSuelocol, Quimicasuelo quimicasuelo){
      Metricaquimicasuelo metricaquimicasuelo = new Metricaquimicasuelo();
      metricaquimicasuelo.setIdmetricaQuimicaSuelo(idmetricaQuimicaSuelo); 
      metricaquimicasuelo.setDescripcionMetricaQuimicaSuelocol(descripcionMetricaQuimicaSuelocol); 
      metricaquimicasuelo.setQuimicasuelo(quimicasuelo); 

     IMetricaquimicasueloDao metricaquimicasueloDao =new FactoryDao(getGestorDefault()).getMetricaquimicasueloDao(getDataBaseDefault());
     int rtn = metricaquimicasueloDao.insert(metricaquimicasuelo);
     metricaquimicasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricaquimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaQuimicaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Metricaquimicasuelo select(int idmetricaQuimicaSuelo){
      Metricaquimicasuelo metricaquimicasuelo = new Metricaquimicasuelo();
      metricaquimicasuelo.setIdmetricaQuimicaSuelo(idmetricaQuimicaSuelo); 

     IMetricaquimicasueloDao metricaquimicasueloDao =new FactoryDao(getGestorDefault()).getMetricaquimicasueloDao(getDataBaseDefault());
     Metricaquimicasuelo result=metricaquimicasueloDao.select(metricaquimicasuelo);
     metricaquimicasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricaquimicasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaQuimicaSuelo
   * @param descripcionMetricaQuimicaSuelocol
   * @param quimicasuelo
   */
  public static void update(int idmetricaQuimicaSuelo, String descripcionMetricaQuimicaSuelocol, Quimicasuelo quimicasuelo){
      Metricaquimicasuelo metricaquimicasuelo = select(idmetricaQuimicaSuelo);
      metricaquimicasuelo.setDescripcionMetricaQuimicaSuelocol(descripcionMetricaQuimicaSuelocol); 
      metricaquimicasuelo.setQuimicasuelo(quimicasuelo); 

     IMetricaquimicasueloDao metricaquimicasueloDao =new FactoryDao(getGestorDefault()).getMetricaquimicasueloDao(getDataBaseDefault());
     metricaquimicasueloDao.update(metricaquimicasuelo);
     metricaquimicasueloDao.close();
  }

  /**
   * Elimina un objeto Metricaquimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricaQuimicaSuelo
   */
  public static void delete(int idmetricaQuimicaSuelo){
      Metricaquimicasuelo metricaquimicasuelo = new Metricaquimicasuelo();
      metricaquimicasuelo.setIdmetricaQuimicaSuelo(idmetricaQuimicaSuelo); 

     IMetricaquimicasueloDao metricaquimicasueloDao =new FactoryDao(getGestorDefault()).getMetricaquimicasueloDao(getDataBaseDefault());
     metricaquimicasueloDao.delete(metricaquimicasuelo);
     metricaquimicasueloDao.close();
  }

  /**
   * Lista todos los objetos Metricaquimicasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricaquimicasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricaquimicasuelo> listAll(){
     IMetricaquimicasueloDao metricaquimicasueloDao =new FactoryDao(getGestorDefault()).getMetricaquimicasueloDao(getDataBaseDefault());
     ArrayList<Metricaquimicasuelo> result=metricaquimicasueloDao.listAll();
     metricaquimicasueloDao.close();
      return result;
  }


}
//That`s all folks!