/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Tranquilo, yo tampoco entiendo cómo funciona mi código  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IManejointegradoenfermedadesDao;

public class ManejointegradoenfermedadesFacade {

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
   * Crea un objeto Manejointegradoenfermedades a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoEnfermedades
   * @param descripcioManejoIntegradoEnfermedades
   * @param mipe
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmanejoIntegradoEnfermedades, String descripcioManejoIntegradoEnfermedades, Mipe mipe){
      Manejointegradoenfermedades manejointegradoenfermedades = new Manejointegradoenfermedades();
      manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(idmanejoIntegradoEnfermedades); 
      manejointegradoenfermedades.setDescripcioManejoIntegradoEnfermedades(descripcioManejoIntegradoEnfermedades); 
      manejointegradoenfermedades.setMipe(mipe); 

     IManejointegradoenfermedadesDao manejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getManejointegradoenfermedadesDao(getDataBaseDefault());
     int rtn = manejointegradoenfermedadesDao.insert(manejointegradoenfermedades);
     manejointegradoenfermedadesDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Manejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoEnfermedades
   * @return El objeto en base de datos o Null
   */
  public static Manejointegradoenfermedades select(int idmanejoIntegradoEnfermedades){
      Manejointegradoenfermedades manejointegradoenfermedades = new Manejointegradoenfermedades();
      manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(idmanejoIntegradoEnfermedades); 

     IManejointegradoenfermedadesDao manejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getManejointegradoenfermedadesDao(getDataBaseDefault());
     Manejointegradoenfermedades result=manejointegradoenfermedadesDao.select(manejointegradoenfermedades);
     manejointegradoenfermedadesDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Manejointegradoenfermedades  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoEnfermedades
   * @param descripcioManejoIntegradoEnfermedades
   * @param mipe
   */
  public static void update(int idmanejoIntegradoEnfermedades, String descripcioManejoIntegradoEnfermedades, Mipe mipe){
      Manejointegradoenfermedades manejointegradoenfermedades = select(idmanejoIntegradoEnfermedades);
      manejointegradoenfermedades.setDescripcioManejoIntegradoEnfermedades(descripcioManejoIntegradoEnfermedades); 
      manejointegradoenfermedades.setMipe(mipe); 

     IManejointegradoenfermedadesDao manejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getManejointegradoenfermedadesDao(getDataBaseDefault());
     manejointegradoenfermedadesDao.update(manejointegradoenfermedades);
     manejointegradoenfermedadesDao.close();
  }

  /**
   * Elimina un objeto Manejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmanejoIntegradoEnfermedades
   */
  public static void delete(int idmanejoIntegradoEnfermedades){
      Manejointegradoenfermedades manejointegradoenfermedades = new Manejointegradoenfermedades();
      manejointegradoenfermedades.setIdmanejoIntegradoEnfermedades(idmanejoIntegradoEnfermedades); 

     IManejointegradoenfermedadesDao manejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getManejointegradoenfermedadesDao(getDataBaseDefault());
     manejointegradoenfermedadesDao.delete(manejointegradoenfermedades);
     manejointegradoenfermedadesDao.close();
  }

  /**
   * Lista todos los objetos Manejointegradoenfermedades de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Manejointegradoenfermedades>  con los objetos en base de datos o Null
   */
  public static ArrayList<Manejointegradoenfermedades> listAll(){
     IManejointegradoenfermedadesDao manejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getManejointegradoenfermedadesDao(getDataBaseDefault());
     ArrayList<Manejointegradoenfermedades> result=manejointegradoenfermedadesDao.listAll();
     manejointegradoenfermedadesDao.close();
      return result;
  }


}
//That`s all folks!