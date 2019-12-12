/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Hey ¿cómo se llama tu café internet?  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IManejointegradoplagasDao;

public class ManejointegradoplagasFacade {

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
   * Crea un objeto Manejointegradoplagas a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoPlagas
   * @param descricionManejoIntegradoPlagas
   * @param mipe
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmanejoIntegradoPlagas, String descricionManejoIntegradoPlagas, Mipe mipe){
      Manejointegradoplagas manejointegradoplagas = new Manejointegradoplagas();
      manejointegradoplagas.setIdmanejoIntegradoPlagas(idmanejoIntegradoPlagas); 
      manejointegradoplagas.setDescricionManejoIntegradoPlagas(descricionManejoIntegradoPlagas); 
      manejointegradoplagas.setMipe(mipe); 

     IManejointegradoplagasDao manejointegradoplagasDao =new FactoryDao(getGestorDefault()).getManejointegradoplagasDao(getDataBaseDefault());
     int rtn = manejointegradoplagasDao.insert(manejointegradoplagas);
     manejointegradoplagasDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Manejointegradoplagas de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoPlagas
   * @return El objeto en base de datos o Null
   */
  public static Manejointegradoplagas select(int idmanejoIntegradoPlagas){
      Manejointegradoplagas manejointegradoplagas = new Manejointegradoplagas();
      manejointegradoplagas.setIdmanejoIntegradoPlagas(idmanejoIntegradoPlagas); 

     IManejointegradoplagasDao manejointegradoplagasDao =new FactoryDao(getGestorDefault()).getManejointegradoplagasDao(getDataBaseDefault());
     Manejointegradoplagas result=manejointegradoplagasDao.select(manejointegradoplagas);
     manejointegradoplagasDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Manejointegradoplagas  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoPlagas
   * @param descricionManejoIntegradoPlagas
   * @param mipe
   */
  public static void update(int idmanejoIntegradoPlagas, String descricionManejoIntegradoPlagas, Mipe mipe){
      Manejointegradoplagas manejointegradoplagas = select(idmanejoIntegradoPlagas);
      manejointegradoplagas.setDescricionManejoIntegradoPlagas(descricionManejoIntegradoPlagas); 
      manejointegradoplagas.setMipe(mipe); 

     IManejointegradoplagasDao manejointegradoplagasDao =new FactoryDao(getGestorDefault()).getManejointegradoplagasDao(getDataBaseDefault());
     manejointegradoplagasDao.update(manejointegradoplagas);
     manejointegradoplagasDao.close();
  }

  /**
   * Elimina un objeto Manejointegradoplagas de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoPlagas
   */
  public static void delete(int idmanejoIntegradoPlagas){
      Manejointegradoplagas manejointegradoplagas = new Manejointegradoplagas();
      manejointegradoplagas.setIdmanejoIntegradoPlagas(idmanejoIntegradoPlagas); 

     IManejointegradoplagasDao manejointegradoplagasDao =new FactoryDao(getGestorDefault()).getManejointegradoplagasDao(getDataBaseDefault());
     manejointegradoplagasDao.delete(manejointegradoplagas);
     manejointegradoplagasDao.close();
  }

  /**
   * Lista todos los objetos Manejointegradoplagas de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Manejointegradoplagas>  con los objetos en base de datos o Null
   */
  public static ArrayList<Manejointegradoplagas> listAll(){
     IManejointegradoplagasDao manejointegradoplagasDao =new FactoryDao(getGestorDefault()).getManejointegradoplagasDao(getDataBaseDefault());
     ArrayList<Manejointegradoplagas> result=manejointegradoplagasDao.listAll();
     manejointegradoplagasDao.close();
      return result;
  }


}
//That`s all folks!