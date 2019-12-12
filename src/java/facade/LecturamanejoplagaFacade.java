/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Yo <3 Cúcuta  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturamanejoplagaDao;

public class LecturamanejoplagaFacade {

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
   * Crea un objeto Lecturamanejoplaga a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoPlaga
   * @param valorLecturaManejoPlagacol
   * @param fechaLecturaManejoPlaga
   * @param metricamanejoplagas
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaManejoPlaga, double valorLecturaManejoPlagacol, String fechaLecturaManejoPlaga, Metricamanejoplagas metricamanejoplagas){
      Lecturamanejoplaga lecturamanejoplaga = new Lecturamanejoplaga();
      lecturamanejoplaga.setIdlecturaManejoPlaga(idlecturaManejoPlaga); 
      lecturamanejoplaga.setValorLecturaManejoPlagacol(valorLecturaManejoPlagacol); 
      lecturamanejoplaga.setFechaLecturaManejoPlaga(fechaLecturaManejoPlaga); 
      lecturamanejoplaga.setMetricamanejoplagas(metricamanejoplagas); 

     ILecturamanejoplagaDao lecturamanejoplagaDao =new FactoryDao(getGestorDefault()).getLecturamanejoplagaDao(getDataBaseDefault());
     int rtn = lecturamanejoplagaDao.insert(lecturamanejoplaga);
     lecturamanejoplagaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturamanejoplaga de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoPlaga
   * @return El objeto en base de datos o Null
   */
  public static Lecturamanejoplaga select(int idlecturaManejoPlaga){
      Lecturamanejoplaga lecturamanejoplaga = new Lecturamanejoplaga();
      lecturamanejoplaga.setIdlecturaManejoPlaga(idlecturaManejoPlaga); 

     ILecturamanejoplagaDao lecturamanejoplagaDao =new FactoryDao(getGestorDefault()).getLecturamanejoplagaDao(getDataBaseDefault());
     Lecturamanejoplaga result=lecturamanejoplagaDao.select(lecturamanejoplaga);
     lecturamanejoplagaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturamanejoplaga  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoPlaga
   * @param valorLecturaManejoPlagacol
   * @param fechaLecturaManejoPlaga
   * @param metricamanejoplagas
   */
  public static void update(int idlecturaManejoPlaga, double valorLecturaManejoPlagacol, String fechaLecturaManejoPlaga, Metricamanejoplagas metricamanejoplagas){
      Lecturamanejoplaga lecturamanejoplaga = select(idlecturaManejoPlaga);
      lecturamanejoplaga.setValorLecturaManejoPlagacol(valorLecturaManejoPlagacol); 
      lecturamanejoplaga.setFechaLecturaManejoPlaga(fechaLecturaManejoPlaga); 
      lecturamanejoplaga.setMetricamanejoplagas(metricamanejoplagas); 

     ILecturamanejoplagaDao lecturamanejoplagaDao =new FactoryDao(getGestorDefault()).getLecturamanejoplagaDao(getDataBaseDefault());
     lecturamanejoplagaDao.update(lecturamanejoplaga);
     lecturamanejoplagaDao.close();
  }

  /**
   * Elimina un objeto Lecturamanejoplaga de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaManejoPlaga
   */
  public static void delete(int idlecturaManejoPlaga){
      Lecturamanejoplaga lecturamanejoplaga = new Lecturamanejoplaga();
      lecturamanejoplaga.setIdlecturaManejoPlaga(idlecturaManejoPlaga); 

     ILecturamanejoplagaDao lecturamanejoplagaDao =new FactoryDao(getGestorDefault()).getLecturamanejoplagaDao(getDataBaseDefault());
     lecturamanejoplagaDao.delete(lecturamanejoplaga);
     lecturamanejoplagaDao.close();
  }

  /**
   * Lista todos los objetos Lecturamanejoplaga de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturamanejoplaga>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturamanejoplaga> listAll(){
     ILecturamanejoplagaDao lecturamanejoplagaDao =new FactoryDao(getGestorDefault()).getLecturamanejoplagaDao(getDataBaseDefault());
     ArrayList<Lecturamanejoplaga> result=lecturamanejoplagaDao.listAll();
     lecturamanejoplagaDao.close();
      return result;
  }


}
//That`s all folks!