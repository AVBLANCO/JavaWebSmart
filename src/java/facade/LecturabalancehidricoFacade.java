/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando Gregorio Samsa se despertó una mañana después de un sueño intranquilo, se encontró sobre su cama convertido en un monstruoso insecto.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturabalancehidricoDao;

public class LecturabalancehidricoFacade {

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
   * Crea un objeto Lecturabalancehidrico a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBalanceHidrico
   * @param fechaLecturaBalanceHidrico
   * @param valorLecturaBalanceHidrico
   * @param metricabalancehidrico
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaBalanceHidrico, String fechaLecturaBalanceHidrico, double valorLecturaBalanceHidrico, Metricabalancehidrico metricabalancehidrico){
      Lecturabalancehidrico lecturabalancehidrico = new Lecturabalancehidrico();
      lecturabalancehidrico.setIdlecturaBalanceHidrico(idlecturaBalanceHidrico); 
      lecturabalancehidrico.setFechaLecturaBalanceHidrico(fechaLecturaBalanceHidrico); 
      lecturabalancehidrico.setValorLecturaBalanceHidrico(valorLecturaBalanceHidrico); 
      lecturabalancehidrico.setMetricabalancehidrico(metricabalancehidrico); 

     ILecturabalancehidricoDao lecturabalancehidricoDao =new FactoryDao(getGestorDefault()).getLecturabalancehidricoDao(getDataBaseDefault());
     int rtn = lecturabalancehidricoDao.insert(lecturabalancehidrico);
     lecturabalancehidricoDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturabalancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBalanceHidrico
   * @return El objeto en base de datos o Null
   */
  public static Lecturabalancehidrico select(int idlecturaBalanceHidrico){
      Lecturabalancehidrico lecturabalancehidrico = new Lecturabalancehidrico();
      lecturabalancehidrico.setIdlecturaBalanceHidrico(idlecturaBalanceHidrico); 

     ILecturabalancehidricoDao lecturabalancehidricoDao =new FactoryDao(getGestorDefault()).getLecturabalancehidricoDao(getDataBaseDefault());
     Lecturabalancehidrico result=lecturabalancehidricoDao.select(lecturabalancehidrico);
     lecturabalancehidricoDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturabalancehidrico  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBalanceHidrico
   * @param fechaLecturaBalanceHidrico
   * @param valorLecturaBalanceHidrico
   * @param metricabalancehidrico
   */
  public static void update(int idlecturaBalanceHidrico, String fechaLecturaBalanceHidrico, double valorLecturaBalanceHidrico, Metricabalancehidrico metricabalancehidrico){
      Lecturabalancehidrico lecturabalancehidrico = select(idlecturaBalanceHidrico);
      lecturabalancehidrico.setFechaLecturaBalanceHidrico(fechaLecturaBalanceHidrico); 
      lecturabalancehidrico.setValorLecturaBalanceHidrico(valorLecturaBalanceHidrico); 
      lecturabalancehidrico.setMetricabalancehidrico(metricabalancehidrico); 

     ILecturabalancehidricoDao lecturabalancehidricoDao =new FactoryDao(getGestorDefault()).getLecturabalancehidricoDao(getDataBaseDefault());
     lecturabalancehidricoDao.update(lecturabalancehidrico);
     lecturabalancehidricoDao.close();
  }

  /**
   * Elimina un objeto Lecturabalancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBalanceHidrico
   */
  public static void delete(int idlecturaBalanceHidrico){
      Lecturabalancehidrico lecturabalancehidrico = new Lecturabalancehidrico();
      lecturabalancehidrico.setIdlecturaBalanceHidrico(idlecturaBalanceHidrico); 

     ILecturabalancehidricoDao lecturabalancehidricoDao =new FactoryDao(getGestorDefault()).getLecturabalancehidricoDao(getDataBaseDefault());
     lecturabalancehidricoDao.delete(lecturabalancehidrico);
     lecturabalancehidricoDao.close();
  }

  /**
   * Lista todos los objetos Lecturabalancehidrico de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturabalancehidrico>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturabalancehidrico> listAll(){
     ILecturabalancehidricoDao lecturabalancehidricoDao =new FactoryDao(getGestorDefault()).getLecturabalancehidricoDao(getDataBaseDefault());
     ArrayList<Lecturabalancehidrico> result=lecturabalancehidricoDao.listAll();
     lecturabalancehidricoDao.close();
      return result;
  }


}
//That`s all folks!