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
import back.dao.interfaz.ILecturabiologiasueloDao;

public class LecturabiologiasueloFacade {

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
   * Crea un objeto Lecturabiologiasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBiologiaSuelo
   * @param fechaLecturaBiologiaSuelo
   * @param valorLecturaBiologiaSuelocol
   * @param metricabiologiasuelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlecturaBiologiaSuelo, String fechaLecturaBiologiaSuelo, double valorLecturaBiologiaSuelocol, Metricabiologiasuelo metricabiologiasuelo){
      Lecturabiologiasuelo lecturabiologiasuelo = new Lecturabiologiasuelo();
      lecturabiologiasuelo.setIdlecturaBiologiaSuelo(idlecturaBiologiaSuelo); 
      lecturabiologiasuelo.setFechaLecturaBiologiaSuelo(fechaLecturaBiologiaSuelo); 
      lecturabiologiasuelo.setValorLecturaBiologiaSuelocol(valorLecturaBiologiaSuelocol); 
      lecturabiologiasuelo.setMetricabiologiasuelo(metricabiologiasuelo); 

     ILecturabiologiasueloDao lecturabiologiasueloDao =new FactoryDao(getGestorDefault()).getLecturabiologiasueloDao(getDataBaseDefault());
     int rtn = lecturabiologiasueloDao.insert(lecturabiologiasuelo);
     lecturabiologiasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lecturabiologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBiologiaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Lecturabiologiasuelo select(int idlecturaBiologiaSuelo){
      Lecturabiologiasuelo lecturabiologiasuelo = new Lecturabiologiasuelo();
      lecturabiologiasuelo.setIdlecturaBiologiaSuelo(idlecturaBiologiaSuelo); 

     ILecturabiologiasueloDao lecturabiologiasueloDao =new FactoryDao(getGestorDefault()).getLecturabiologiasueloDao(getDataBaseDefault());
     Lecturabiologiasuelo result=lecturabiologiasueloDao.select(lecturabiologiasuelo);
     lecturabiologiasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lecturabiologiasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBiologiaSuelo
   * @param fechaLecturaBiologiaSuelo
   * @param valorLecturaBiologiaSuelocol
   * @param metricabiologiasuelo
   */
  public static void update(int idlecturaBiologiaSuelo, String fechaLecturaBiologiaSuelo, double valorLecturaBiologiaSuelocol, Metricabiologiasuelo metricabiologiasuelo){
      Lecturabiologiasuelo lecturabiologiasuelo = select(idlecturaBiologiaSuelo);
      lecturabiologiasuelo.setFechaLecturaBiologiaSuelo(fechaLecturaBiologiaSuelo); 
      lecturabiologiasuelo.setValorLecturaBiologiaSuelocol(valorLecturaBiologiaSuelocol); 
      lecturabiologiasuelo.setMetricabiologiasuelo(metricabiologiasuelo); 

     ILecturabiologiasueloDao lecturabiologiasueloDao =new FactoryDao(getGestorDefault()).getLecturabiologiasueloDao(getDataBaseDefault());
     lecturabiologiasueloDao.update(lecturabiologiasuelo);
     lecturabiologiasueloDao.close();
  }

  /**
   * Elimina un objeto Lecturabiologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlecturaBiologiaSuelo
   */
  public static void delete(int idlecturaBiologiaSuelo){
      Lecturabiologiasuelo lecturabiologiasuelo = new Lecturabiologiasuelo();
      lecturabiologiasuelo.setIdlecturaBiologiaSuelo(idlecturaBiologiaSuelo); 

     ILecturabiologiasueloDao lecturabiologiasueloDao =new FactoryDao(getGestorDefault()).getLecturabiologiasueloDao(getDataBaseDefault());
     lecturabiologiasueloDao.delete(lecturabiologiasuelo);
     lecturabiologiasueloDao.close();
  }

  /**
   * Lista todos los objetos Lecturabiologiasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lecturabiologiasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lecturabiologiasuelo> listAll(){
     ILecturabiologiasueloDao lecturabiologiasueloDao =new FactoryDao(getGestorDefault()).getLecturabiologiasueloDao(getDataBaseDefault());
     ArrayList<Lecturabiologiasuelo> result=lecturabiologiasueloDao.listAll();
     lecturabiologiasueloDao.close();
      return result;
  }


}
//That`s all folks!