/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    El coronel necesitó setenta y cinco años -los setenta y cinco años de su vida, minuto a minuto- para llegar a ese instante. Se sintió puro, explícito, invencible, en el momento de responder:  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturaquimicasueloDao;

public class LecturaquimicasueloFacade {

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
   * Crea un objeto Lecturaquimicasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaQuimicaSuelo
   * @param fechaLecturaQuimicaSuelo
   * @param valorLecturaQuimicaSuelo
   * @param metricaquimicasuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaQuimicaSuelo, String fechaLecturaQuimicaSuelo, double valorLecturaQuimicaSuelo, Metricaquimicasuelo metricaquimicasuelo){
      Lecturaquimicasuelo lecturaquimicasuelo = new Lecturaquimicasuelo();
      lecturaquimicasuelo.setIdlecturaQuimicaSuelo(idlecturaQuimicaSuelo); 
      lecturaquimicasuelo.setFechaLecturaQuimicaSuelo(fechaLecturaQuimicaSuelo); 
      lecturaquimicasuelo.setValorLecturaQuimicaSuelo(valorLecturaQuimicaSuelo); 
      lecturaquimicasuelo.setMetricaquimicasuelo(metricaquimicasuelo); 

     ILecturaquimicasueloDao lecturaquimicasueloDao =new FactoryDao(getGestorDefault()).getLecturaquimicasueloDao(getDataBaseDefault());
     int rtn = lecturaquimicasueloDao.insert(lecturaquimicasuelo);
     lecturaquimicasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturaquimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaQuimicaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Lecturaquimicasuelo select(int idlecturaQuimicaSuelo){
      Lecturaquimicasuelo lecturaquimicasuelo = new Lecturaquimicasuelo();
      lecturaquimicasuelo.setIdlecturaQuimicaSuelo(idlecturaQuimicaSuelo); 

     ILecturaquimicasueloDao lecturaquimicasueloDao =new FactoryDao(getGestorDefault()).getLecturaquimicasueloDao(getDataBaseDefault());
     Lecturaquimicasuelo result=lecturaquimicasueloDao.select(lecturaquimicasuelo);
     lecturaquimicasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturaquimicasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaQuimicaSuelo
   * @param fechaLecturaQuimicaSuelo
   * @param valorLecturaQuimicaSuelo
   * @param metricaquimicasuelo
   */
  public static void update(int idlecturaQuimicaSuelo, String fechaLecturaQuimicaSuelo, double valorLecturaQuimicaSuelo, Metricaquimicasuelo metricaquimicasuelo){
      Lecturaquimicasuelo lecturaquimicasuelo = select(idlecturaQuimicaSuelo);
      lecturaquimicasuelo.setFechaLecturaQuimicaSuelo(fechaLecturaQuimicaSuelo); 
      lecturaquimicasuelo.setValorLecturaQuimicaSuelo(valorLecturaQuimicaSuelo); 
      lecturaquimicasuelo.setMetricaquimicasuelo(metricaquimicasuelo); 

     ILecturaquimicasueloDao lecturaquimicasueloDao =new FactoryDao(getGestorDefault()).getLecturaquimicasueloDao(getDataBaseDefault());
     lecturaquimicasueloDao.update(lecturaquimicasuelo);
     lecturaquimicasueloDao.close();
  }

  /**
   * Elimina un objeto Lecturaquimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaQuimicaSuelo
   */
  public static void delete(int idlecturaQuimicaSuelo){
      Lecturaquimicasuelo lecturaquimicasuelo = new Lecturaquimicasuelo();
      lecturaquimicasuelo.setIdlecturaQuimicaSuelo(idlecturaQuimicaSuelo); 

     ILecturaquimicasueloDao lecturaquimicasueloDao =new FactoryDao(getGestorDefault()).getLecturaquimicasueloDao(getDataBaseDefault());
     lecturaquimicasueloDao.delete(lecturaquimicasuelo);
     lecturaquimicasueloDao.close();
  }

  /**
   * Lista todos los objetos Lecturaquimicasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturaquimicasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturaquimicasuelo> listAll(){
     ILecturaquimicasueloDao lecturaquimicasueloDao =new FactoryDao(getGestorDefault()).getLecturaquimicasueloDao(getDataBaseDefault());
     ArrayList<Lecturaquimicasuelo> result=lecturaquimicasueloDao.listAll();
     lecturaquimicasueloDao.close();
      return result;
  }


}
//That`s all folks!