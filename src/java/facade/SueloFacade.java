/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La gente siempre me pregunta si conozco a Tyler Durden.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ISueloDao;

public class SueloFacade {

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
   * Crea un objeto Suelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsuelo
   * @param decripcionSuelo
   * @param fechaSuelo
   * @param lote
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idsuelo, String decripcionSuelo, String fechaSuelo, Lote lote){
      Suelo suelo = new Suelo();
      suelo.setIdsuelo(idsuelo); 
      suelo.setDecripcionSuelo(decripcionSuelo); 
      suelo.setFechaSuelo(fechaSuelo); 
      suelo.setLote(lote); 

     ISueloDao sueloDao =new FactoryDao(getGestorDefault()).getSueloDao(getDataBaseDefault());
     int rtn = sueloDao.insert(suelo);
     sueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Suelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsuelo
   * @return El objeto en base de datos o Null
   */
  public static Suelo select(int idsuelo){
      Suelo suelo = new Suelo();
      suelo.setIdsuelo(idsuelo); 

     ISueloDao sueloDao =new FactoryDao(getGestorDefault()).getSueloDao(getDataBaseDefault());
     Suelo result=sueloDao.select(suelo);
     sueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Suelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsuelo
   * @param decripcionSuelo
   * @param fechaSuelo
   * @param lote
   */
  public static void update(int idsuelo, String decripcionSuelo, String fechaSuelo, Lote lote){
      Suelo suelo = select(idsuelo);
      suelo.setDecripcionSuelo(decripcionSuelo); 
      suelo.setFechaSuelo(fechaSuelo); 
      suelo.setLote(lote); 

     ISueloDao sueloDao =new FactoryDao(getGestorDefault()).getSueloDao(getDataBaseDefault());
     sueloDao.update(suelo);
     sueloDao.close();
  }

  /**
   * Elimina un objeto Suelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsuelo
   */
  public static void delete(int idsuelo){
      Suelo suelo = new Suelo();
      suelo.setIdsuelo(idsuelo); 

     ISueloDao sueloDao =new FactoryDao(getGestorDefault()).getSueloDao(getDataBaseDefault());
     sueloDao.delete(suelo);
     sueloDao.close();
  }

  /**
   * Lista todos los objetos Suelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Suelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Suelo> listAll(){
     ISueloDao sueloDao =new FactoryDao(getGestorDefault()).getSueloDao(getDataBaseDefault());
     ArrayList<Suelo> result=sueloDao.listAll();
     sueloDao.close();
      return result;
  }


}
//That`s all folks!