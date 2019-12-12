/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Oh gloria de las glorias, oh divino testamento de la eterna majestad de la creación de dios  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMipeDao;

public class MipeFacade {

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
   * Crea un objeto Mipe a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmipe
   * @param decripcionMipe
   * @param fechaMipe
   * @param lote
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmipe, String decripcionMipe, String fechaMipe, Lote lote){
      Mipe mipe = new Mipe();
      mipe.setIdmipe(idmipe); 
      mipe.setDecripcionMipe(decripcionMipe); 
      mipe.setFechaMipe(fechaMipe); 
      mipe.setLote(lote); 

     IMipeDao mipeDao =new FactoryDao(getGestorDefault()).getMipeDao(getDataBaseDefault());
     int rtn = mipeDao.insert(mipe);
     mipeDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Mipe de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmipe
   * @return El objeto en base de datos o Null
   */
  public static Mipe select(int idmipe){
      Mipe mipe = new Mipe();
      mipe.setIdmipe(idmipe); 

     IMipeDao mipeDao =new FactoryDao(getGestorDefault()).getMipeDao(getDataBaseDefault());
     Mipe result=mipeDao.select(mipe);
     mipeDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Mipe  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmipe
   * @param decripcionMipe
   * @param fechaMipe
   * @param lote
   */
  public static void update(int idmipe, String decripcionMipe, String fechaMipe, Lote lote){
      Mipe mipe = select(idmipe);
      mipe.setDecripcionMipe(decripcionMipe); 
      mipe.setFechaMipe(fechaMipe); 
      mipe.setLote(lote); 

     IMipeDao mipeDao =new FactoryDao(getGestorDefault()).getMipeDao(getDataBaseDefault());
     mipeDao.update(mipe);
     mipeDao.close();
  }

  /**
   * Elimina un objeto Mipe de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmipe
   */
  public static void delete(int idmipe){
      Mipe mipe = new Mipe();
      mipe.setIdmipe(idmipe); 

     IMipeDao mipeDao =new FactoryDao(getGestorDefault()).getMipeDao(getDataBaseDefault());
     mipeDao.delete(mipe);
     mipeDao.close();
  }

  /**
   * Lista todos los objetos Mipe de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Mipe>  con los objetos en base de datos o Null
   */
  public static ArrayList<Mipe> listAll(){
     IMipeDao mipeDao =new FactoryDao(getGestorDefault()).getMipeDao(getDataBaseDefault());
     ArrayList<Mipe> result=mipeDao.listAll();
     mipeDao.close();
      return result;
  }


}
//That`s all folks!