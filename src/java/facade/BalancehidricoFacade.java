/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ella no te quiere </3 mejor ponte a programar  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IBalancehidricoDao;

public class BalancehidricoFacade {

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
   * Crea un objeto Balancehidrico a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbalanceHidrico
   * @param descripcioBalanceHidricocol
   * @param fechabalanceHidrico
   * @param agroclimatologia
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idbalanceHidrico, String descripcioBalanceHidricocol, String fechabalanceHidrico, Agroclimatologia agroclimatologia){
      Balancehidrico balancehidrico = new Balancehidrico();
      balancehidrico.setIdbalanceHidrico(idbalanceHidrico); 
      balancehidrico.setDescripcioBalanceHidricocol(descripcioBalanceHidricocol); 
      balancehidrico.setFechabalanceHidrico(fechabalanceHidrico); 
      balancehidrico.setAgroclimatologia(agroclimatologia); 

     IBalancehidricoDao balancehidricoDao =new FactoryDao(getGestorDefault()).getBalancehidricoDao(getDataBaseDefault());
     int rtn = balancehidricoDao.insert(balancehidrico);
     balancehidricoDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Balancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbalanceHidrico
   * @return El objeto en base de datos o Null
   */
  public static Balancehidrico select(int idbalanceHidrico){
      Balancehidrico balancehidrico = new Balancehidrico();
      balancehidrico.setIdbalanceHidrico(idbalanceHidrico); 

     IBalancehidricoDao balancehidricoDao =new FactoryDao(getGestorDefault()).getBalancehidricoDao(getDataBaseDefault());
     Balancehidrico result=balancehidricoDao.select(balancehidrico);
     balancehidricoDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Balancehidrico  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbalanceHidrico
   * @param descripcioBalanceHidricocol
   * @param fechabalanceHidrico
   * @param agroclimatologia
   */
  public static void update(int idbalanceHidrico, String descripcioBalanceHidricocol, String fechabalanceHidrico, Agroclimatologia agroclimatologia){
      Balancehidrico balancehidrico = select(idbalanceHidrico);
      balancehidrico.setDescripcioBalanceHidricocol(descripcioBalanceHidricocol); 
      balancehidrico.setFechabalanceHidrico(fechabalanceHidrico); 
      balancehidrico.setAgroclimatologia(agroclimatologia); 

     IBalancehidricoDao balancehidricoDao =new FactoryDao(getGestorDefault()).getBalancehidricoDao(getDataBaseDefault());
     balancehidricoDao.update(balancehidrico);
     balancehidricoDao.close();
  }

  /**
   * Elimina un objeto Balancehidrico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbalanceHidrico
   */
  public static void delete(int idbalanceHidrico){
      Balancehidrico balancehidrico = new Balancehidrico();
      balancehidrico.setIdbalanceHidrico(idbalanceHidrico); 

     IBalancehidricoDao balancehidricoDao =new FactoryDao(getGestorDefault()).getBalancehidricoDao(getDataBaseDefault());
     balancehidricoDao.delete(balancehidrico);
     balancehidricoDao.close();
  }

  /**
   * Lista todos los objetos Balancehidrico de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Balancehidrico>  con los objetos en base de datos o Null
   */
  public static ArrayList<Balancehidrico> listAll(){
     IBalancehidricoDao balancehidricoDao =new FactoryDao(getGestorDefault()).getBalancehidricoDao(getDataBaseDefault());
     ArrayList<Balancehidrico> result=balancehidricoDao.listAll();
     balancehidricoDao.close();
      return result;
  }


}
//That`s all folks!