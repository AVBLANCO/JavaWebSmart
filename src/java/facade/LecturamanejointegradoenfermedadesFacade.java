/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ojitos de luz de luna  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturamanejointegradoenfermedadesDao;

public class LecturamanejointegradoenfermedadesFacade {

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
   * Crea un objeto Lecturamanejointegradoenfermedades a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoIntegradoEnfermedades
   * @param fechaLecturaManejoIntegradoEnfermedadescol
   * @param valorLecturaManejoIntegradoEnfermedades
   * @param metricamanejointegradoenfermedades
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaManejoIntegradoEnfermedades, String fechaLecturaManejoIntegradoEnfermedadescol, double valorLecturaManejoIntegradoEnfermedades, Metricamanejointegradoenfermedades metricamanejointegradoenfermedades){
      Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades = new Lecturamanejointegradoenfermedades();
      lecturamanejointegradoenfermedades.setIdlecturaManejoIntegradoEnfermedades(idlecturaManejoIntegradoEnfermedades); 
      lecturamanejointegradoenfermedades.setFechaLecturaManejoIntegradoEnfermedadescol(fechaLecturaManejoIntegradoEnfermedadescol); 
      lecturamanejointegradoenfermedades.setValorLecturaManejoIntegradoEnfermedades(valorLecturaManejoIntegradoEnfermedades); 
      lecturamanejointegradoenfermedades.setMetricamanejointegradoenfermedades(metricamanejointegradoenfermedades); 

     ILecturamanejointegradoenfermedadesDao lecturamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getLecturamanejointegradoenfermedadesDao(getDataBaseDefault());
     int rtn = lecturamanejointegradoenfermedadesDao.insert(lecturamanejointegradoenfermedades);
     lecturamanejointegradoenfermedadesDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturamanejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoIntegradoEnfermedades
   * @return El objeto en base de datos o Null
   */
  public static Lecturamanejointegradoenfermedades select(int idlecturaManejoIntegradoEnfermedades){
      Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades = new Lecturamanejointegradoenfermedades();
      lecturamanejointegradoenfermedades.setIdlecturaManejoIntegradoEnfermedades(idlecturaManejoIntegradoEnfermedades); 

     ILecturamanejointegradoenfermedadesDao lecturamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getLecturamanejointegradoenfermedadesDao(getDataBaseDefault());
     Lecturamanejointegradoenfermedades result=lecturamanejointegradoenfermedadesDao.select(lecturamanejointegradoenfermedades);
     lecturamanejointegradoenfermedadesDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturamanejointegradoenfermedades  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoIntegradoEnfermedades
   * @param fechaLecturaManejoIntegradoEnfermedadescol
   * @param valorLecturaManejoIntegradoEnfermedades
   * @param metricamanejointegradoenfermedades
   */
  public static void update(int idlecturaManejoIntegradoEnfermedades, String fechaLecturaManejoIntegradoEnfermedadescol, double valorLecturaManejoIntegradoEnfermedades, Metricamanejointegradoenfermedades metricamanejointegradoenfermedades){
      Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades = select(idlecturaManejoIntegradoEnfermedades);
      lecturamanejointegradoenfermedades.setFechaLecturaManejoIntegradoEnfermedadescol(fechaLecturaManejoIntegradoEnfermedadescol); 
      lecturamanejointegradoenfermedades.setValorLecturaManejoIntegradoEnfermedades(valorLecturaManejoIntegradoEnfermedades); 
      lecturamanejointegradoenfermedades.setMetricamanejointegradoenfermedades(metricamanejointegradoenfermedades); 

     ILecturamanejointegradoenfermedadesDao lecturamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getLecturamanejointegradoenfermedadesDao(getDataBaseDefault());
     lecturamanejointegradoenfermedadesDao.update(lecturamanejointegradoenfermedades);
     lecturamanejointegradoenfermedadesDao.close();
  }

  /**
   * Elimina un objeto Lecturamanejointegradoenfermedades de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoIntegradoEnfermedades
   */
  public static void delete(int idlecturaManejoIntegradoEnfermedades){
      Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades = new Lecturamanejointegradoenfermedades();
      lecturamanejointegradoenfermedades.setIdlecturaManejoIntegradoEnfermedades(idlecturaManejoIntegradoEnfermedades); 

     ILecturamanejointegradoenfermedadesDao lecturamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getLecturamanejointegradoenfermedadesDao(getDataBaseDefault());
     lecturamanejointegradoenfermedadesDao.delete(lecturamanejointegradoenfermedades);
     lecturamanejointegradoenfermedadesDao.close();
  }

  /**
   * Lista todos los objetos Lecturamanejointegradoenfermedades de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturamanejointegradoenfermedades>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturamanejointegradoenfermedades> listAll(){
     ILecturamanejointegradoenfermedadesDao lecturamanejointegradoenfermedadesDao =new FactoryDao(getGestorDefault()).getLecturamanejointegradoenfermedadesDao(getDataBaseDefault());
     ArrayList<Lecturamanejointegradoenfermedades> result=lecturamanejointegradoenfermedadesDao.listAll();
     lecturamanejointegradoenfermedadesDao.close();
      return result;
  }


}
//That`s all folks!