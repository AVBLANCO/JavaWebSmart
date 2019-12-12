/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Tenemos trabajos que odiamos para comprar cosas que no necesitamos.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILecturafisicasueloDao;

public class LecturafisicasueloFacade {

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
   * Crea un objeto Lecturafisicasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaFisicaSuelo
   * @param fechaLecturaFisicaSuelo
   * @param valorLecturaFisicaSuelo
   * @param metricassuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaFisicaSuelo, String fechaLecturaFisicaSuelo, double valorLecturaFisicaSuelo, Metricassuelo metricassuelo){
      Lecturafisicasuelo lecturafisicasuelo = new Lecturafisicasuelo();
      lecturafisicasuelo.setIdlecturaFisicaSuelo(idlecturaFisicaSuelo); 
      lecturafisicasuelo.setFechaLecturaFisicaSuelo(fechaLecturaFisicaSuelo); 
      lecturafisicasuelo.setValorLecturaFisicaSuelo(valorLecturaFisicaSuelo); 
      lecturafisicasuelo.setMetricassuelo(metricassuelo); 

     ILecturafisicasueloDao lecturafisicasueloDao =new FactoryDao(getGestorDefault()).getLecturafisicasueloDao(getDataBaseDefault());
     int rtn = lecturafisicasueloDao.insert(lecturafisicasuelo);
     lecturafisicasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturafisicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaFisicaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Lecturafisicasuelo select(int idlecturaFisicaSuelo){
      Lecturafisicasuelo lecturafisicasuelo = new Lecturafisicasuelo();
      lecturafisicasuelo.setIdlecturaFisicaSuelo(idlecturaFisicaSuelo); 

     ILecturafisicasueloDao lecturafisicasueloDao =new FactoryDao(getGestorDefault()).getLecturafisicasueloDao(getDataBaseDefault());
     Lecturafisicasuelo result=lecturafisicasueloDao.select(lecturafisicasuelo);
     lecturafisicasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturafisicasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaFisicaSuelo
   * @param fechaLecturaFisicaSuelo
   * @param valorLecturaFisicaSuelo
   * @param metricassuelo
   */
  public static void update(int idlecturaFisicaSuelo, String fechaLecturaFisicaSuelo, double valorLecturaFisicaSuelo, Metricassuelo metricassuelo){
      Lecturafisicasuelo lecturafisicasuelo = select(idlecturaFisicaSuelo);
      lecturafisicasuelo.setFechaLecturaFisicaSuelo(fechaLecturaFisicaSuelo); 
      lecturafisicasuelo.setValorLecturaFisicaSuelo(valorLecturaFisicaSuelo); 
      lecturafisicasuelo.setMetricassuelo(metricassuelo); 

     ILecturafisicasueloDao lecturafisicasueloDao =new FactoryDao(getGestorDefault()).getLecturafisicasueloDao(getDataBaseDefault());
     lecturafisicasueloDao.update(lecturafisicasuelo);
     lecturafisicasueloDao.close();
  }

  /**
   * Elimina un objeto Lecturafisicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaFisicaSuelo
   */
  public static void delete(int idlecturaFisicaSuelo){
      Lecturafisicasuelo lecturafisicasuelo = new Lecturafisicasuelo();
      lecturafisicasuelo.setIdlecturaFisicaSuelo(idlecturaFisicaSuelo); 

     ILecturafisicasueloDao lecturafisicasueloDao =new FactoryDao(getGestorDefault()).getLecturafisicasueloDao(getDataBaseDefault());
     lecturafisicasueloDao.delete(lecturafisicasuelo);
     lecturafisicasueloDao.close();
  }

  /**
   * Lista todos los objetos Lecturafisicasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturafisicasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturafisicasuelo> listAll(){
     ILecturafisicasueloDao lecturafisicasueloDao =new FactoryDao(getGestorDefault()).getLecturafisicasueloDao(getDataBaseDefault());
     ArrayList<Lecturafisicasuelo> result=lecturafisicasueloDao.listAll();
     lecturafisicasueloDao.close();
      return result;
  }


}
//That`s all folks!