/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Me arreglas mi impresora?  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetricassueloDao;

public class MetricassueloFacade {

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
   * Crea un objeto Metricassuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricasSuelo
   * @param descripcioMetricasSuelo
   * @param fisicasuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmetricasSuelo, String descripcioMetricasSuelo, Fisicasuelo fisicasuelo){
      Metricassuelo metricassuelo = new Metricassuelo();
      metricassuelo.setIdmetricasSuelo(idmetricasSuelo); 
      metricassuelo.setDescripcioMetricasSuelo(descripcioMetricasSuelo); 
      metricassuelo.setFisicasuelo(fisicasuelo); 

     IMetricassueloDao metricassueloDao =new FactoryDao(getGestorDefault()).getMetricassueloDao(getDataBaseDefault());
     int rtn = metricassueloDao.insert(metricassuelo);
     metricassueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Metricassuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricasSuelo
   * @return El objeto en base de datos o Null
   */
  public static Metricassuelo select(int idmetricasSuelo){
      Metricassuelo metricassuelo = new Metricassuelo();
      metricassuelo.setIdmetricasSuelo(idmetricasSuelo); 

     IMetricassueloDao metricassueloDao =new FactoryDao(getGestorDefault()).getMetricassueloDao(getDataBaseDefault());
     Metricassuelo result=metricassueloDao.select(metricassuelo);
     metricassueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Metricassuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricasSuelo
   * @param descripcioMetricasSuelo
   * @param fisicasuelo
   */
  public static void update(int idmetricasSuelo, String descripcioMetricasSuelo, Fisicasuelo fisicasuelo){
      Metricassuelo metricassuelo = select(idmetricasSuelo);
      metricassuelo.setDescripcioMetricasSuelo(descripcioMetricasSuelo); 
      metricassuelo.setFisicasuelo(fisicasuelo); 

     IMetricassueloDao metricassueloDao =new FactoryDao(getGestorDefault()).getMetricassueloDao(getDataBaseDefault());
     metricassueloDao.update(metricassuelo);
     metricassueloDao.close();
  }

  /**
   * Elimina un objeto Metricassuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmetricasSuelo
   */
  public static void delete(int idmetricasSuelo){
      Metricassuelo metricassuelo = new Metricassuelo();
      metricassuelo.setIdmetricasSuelo(idmetricasSuelo); 

     IMetricassueloDao metricassueloDao =new FactoryDao(getGestorDefault()).getMetricassueloDao(getDataBaseDefault());
     metricassueloDao.delete(metricassuelo);
     metricassueloDao.close();
  }

  /**
   * Lista todos los objetos Metricassuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Metricassuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Metricassuelo> listAll(){
     IMetricassueloDao metricassueloDao =new FactoryDao(getGestorDefault()).getMetricassueloDao(getDataBaseDefault());
     ArrayList<Metricassuelo> result=metricassueloDao.listAll();
     metricassueloDao.close();
      return result;
  }


}
//That`s all folks!