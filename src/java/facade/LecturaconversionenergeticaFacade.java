/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Hecho en sólo 6 días  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturaconversionenergeticaDao;

public class LecturaconversionenergeticaFacade {

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
   * Crea un objeto Lecturaconversionenergetica a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaConversionEnergetica
   * @param fechaLecturaConversionEnergetica
   * @param valorLecturaConversionEnergeticacol
   * @param metricaconversionenergetica
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaConversionEnergetica, String fechaLecturaConversionEnergetica, double valorLecturaConversionEnergeticacol, Metricaconversionenergetica metricaconversionenergetica){
      Lecturaconversionenergetica lecturaconversionenergetica = new Lecturaconversionenergetica();
      lecturaconversionenergetica.setIdlecturaConversionEnergetica(idlecturaConversionEnergetica); 
      lecturaconversionenergetica.setFechaLecturaConversionEnergetica(fechaLecturaConversionEnergetica); 
      lecturaconversionenergetica.setValorLecturaConversionEnergeticacol(valorLecturaConversionEnergeticacol); 
      lecturaconversionenergetica.setMetricaconversionenergetica(metricaconversionenergetica); 

     ILecturaconversionenergeticaDao lecturaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getLecturaconversionenergeticaDao(getDataBaseDefault());
     int rtn = lecturaconversionenergeticaDao.insert(lecturaconversionenergetica);
     lecturaconversionenergeticaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturaconversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaConversionEnergetica
   * @return El objeto en base de datos o Null
   */
  public static Lecturaconversionenergetica select(int idlecturaConversionEnergetica){
      Lecturaconversionenergetica lecturaconversionenergetica = new Lecturaconversionenergetica();
      lecturaconversionenergetica.setIdlecturaConversionEnergetica(idlecturaConversionEnergetica); 

     ILecturaconversionenergeticaDao lecturaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getLecturaconversionenergeticaDao(getDataBaseDefault());
     Lecturaconversionenergetica result=lecturaconversionenergeticaDao.select(lecturaconversionenergetica);
     lecturaconversionenergeticaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturaconversionenergetica  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaConversionEnergetica
   * @param fechaLecturaConversionEnergetica
   * @param valorLecturaConversionEnergeticacol
   * @param metricaconversionenergetica
   */
  public static void update(int idlecturaConversionEnergetica, String fechaLecturaConversionEnergetica, double valorLecturaConversionEnergeticacol, Metricaconversionenergetica metricaconversionenergetica){
      Lecturaconversionenergetica lecturaconversionenergetica = select(idlecturaConversionEnergetica);
      lecturaconversionenergetica.setFechaLecturaConversionEnergetica(fechaLecturaConversionEnergetica); 
      lecturaconversionenergetica.setValorLecturaConversionEnergeticacol(valorLecturaConversionEnergeticacol); 
      lecturaconversionenergetica.setMetricaconversionenergetica(metricaconversionenergetica); 

     ILecturaconversionenergeticaDao lecturaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getLecturaconversionenergeticaDao(getDataBaseDefault());
     lecturaconversionenergeticaDao.update(lecturaconversionenergetica);
     lecturaconversionenergeticaDao.close();
  }

  /**
   * Elimina un objeto Lecturaconversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaConversionEnergetica
   */
  public static void delete(int idlecturaConversionEnergetica){
      Lecturaconversionenergetica lecturaconversionenergetica = new Lecturaconversionenergetica();
      lecturaconversionenergetica.setIdlecturaConversionEnergetica(idlecturaConversionEnergetica); 

     ILecturaconversionenergeticaDao lecturaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getLecturaconversionenergeticaDao(getDataBaseDefault());
     lecturaconversionenergeticaDao.delete(lecturaconversionenergetica);
     lecturaconversionenergeticaDao.close();
  }

  /**
   * Lista todos los objetos Lecturaconversionenergetica de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturaconversionenergetica>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturaconversionenergetica> listAll(){
     ILecturaconversionenergeticaDao lecturaconversionenergeticaDao =new FactoryDao(getGestorDefault()).getLecturaconversionenergeticaDao(getDataBaseDefault());
     ArrayList<Lecturaconversionenergetica> result=lecturaconversionenergeticaDao.listAll();
     lecturaconversionenergeticaDao.close();
      return result;
  }


}
//That`s all folks!