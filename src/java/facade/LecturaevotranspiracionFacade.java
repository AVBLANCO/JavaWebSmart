/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Y si mejor estudias comunicación?  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturaevotranspiracionDao;

public class LecturaevotranspiracionFacade {

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
   * Crea un objeto Lecturaevotranspiracion a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaEvotranspiracion
   * @param fechaLecturaEvotranspiracion
   * @param valorLecturaEvotranspiracion
   * @param metricaevotranspiracion
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaEvotranspiracion, String fechaLecturaEvotranspiracion, double valorLecturaEvotranspiracion, Metricaevotranspiracion metricaevotranspiracion){
      Lecturaevotranspiracion lecturaevotranspiracion = new Lecturaevotranspiracion();
      lecturaevotranspiracion.setIdlecturaEvotranspiracion(idlecturaEvotranspiracion); 
      lecturaevotranspiracion.setFechaLecturaEvotranspiracion(fechaLecturaEvotranspiracion); 
      lecturaevotranspiracion.setValorLecturaEvotranspiracion(valorLecturaEvotranspiracion); 
      lecturaevotranspiracion.setMetricaevotranspiracion(metricaevotranspiracion); 

     ILecturaevotranspiracionDao lecturaevotranspiracionDao =new FactoryDao(getGestorDefault()).getLecturaevotranspiracionDao(getDataBaseDefault());
     int rtn = lecturaevotranspiracionDao.insert(lecturaevotranspiracion);
     lecturaevotranspiracionDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturaevotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaEvotranspiracion
   * @return El objeto en base de datos o Null
   */
  public static Lecturaevotranspiracion select(int idlecturaEvotranspiracion){
      Lecturaevotranspiracion lecturaevotranspiracion = new Lecturaevotranspiracion();
      lecturaevotranspiracion.setIdlecturaEvotranspiracion(idlecturaEvotranspiracion); 

     ILecturaevotranspiracionDao lecturaevotranspiracionDao =new FactoryDao(getGestorDefault()).getLecturaevotranspiracionDao(getDataBaseDefault());
     Lecturaevotranspiracion result=lecturaevotranspiracionDao.select(lecturaevotranspiracion);
     lecturaevotranspiracionDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturaevotranspiracion  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaEvotranspiracion
   * @param fechaLecturaEvotranspiracion
   * @param valorLecturaEvotranspiracion
   * @param metricaevotranspiracion
   */
  public static void update(int idlecturaEvotranspiracion, String fechaLecturaEvotranspiracion, double valorLecturaEvotranspiracion, Metricaevotranspiracion metricaevotranspiracion){
      Lecturaevotranspiracion lecturaevotranspiracion = select(idlecturaEvotranspiracion);
      lecturaevotranspiracion.setFechaLecturaEvotranspiracion(fechaLecturaEvotranspiracion); 
      lecturaevotranspiracion.setValorLecturaEvotranspiracion(valorLecturaEvotranspiracion); 
      lecturaevotranspiracion.setMetricaevotranspiracion(metricaevotranspiracion); 

     ILecturaevotranspiracionDao lecturaevotranspiracionDao =new FactoryDao(getGestorDefault()).getLecturaevotranspiracionDao(getDataBaseDefault());
     lecturaevotranspiracionDao.update(lecturaevotranspiracion);
     lecturaevotranspiracionDao.close();
  }

  /**
   * Elimina un objeto Lecturaevotranspiracion de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaEvotranspiracion
   */
  public static void delete(int idlecturaEvotranspiracion){
      Lecturaevotranspiracion lecturaevotranspiracion = new Lecturaevotranspiracion();
      lecturaevotranspiracion.setIdlecturaEvotranspiracion(idlecturaEvotranspiracion); 

     ILecturaevotranspiracionDao lecturaevotranspiracionDao =new FactoryDao(getGestorDefault()).getLecturaevotranspiracionDao(getDataBaseDefault());
     lecturaevotranspiracionDao.delete(lecturaevotranspiracion);
     lecturaevotranspiracionDao.close();
  }

  /**
   * Lista todos los objetos Lecturaevotranspiracion de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturaevotranspiracion>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturaevotranspiracion> listAll(){
     ILecturaevotranspiracionDao lecturaevotranspiracionDao =new FactoryDao(getGestorDefault()).getLecturaevotranspiracionDao(getDataBaseDefault());
     ArrayList<Lecturaevotranspiracion> result=lecturaevotranspiracionDao.listAll();
     lecturaevotranspiracionDao.close();
      return result;
  }


}
//That`s all folks!