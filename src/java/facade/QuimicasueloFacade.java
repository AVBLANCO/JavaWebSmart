/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La segunda regla de Anarchy es no hablar de Anarchy  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IQuimicasueloDao;

public class QuimicasueloFacade {

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
   * Crea un objeto Quimicasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idQuimicaSuelo
   * @param descripcionQuimica
   * @param suelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idQuimicaSuelo, String descripcionQuimica, Suelo suelo){
      Quimicasuelo quimicasuelo = new Quimicasuelo();
      quimicasuelo.setIdQuimicaSuelo(idQuimicaSuelo); 
      quimicasuelo.setDescripcionQuimica(descripcionQuimica); 
      quimicasuelo.setSuelo(suelo); 

     IQuimicasueloDao quimicasueloDao =new FactoryDao(getGestorDefault()).getQuimicasueloDao(getDataBaseDefault());
     int rtn = quimicasueloDao.insert(quimicasuelo);
     quimicasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Quimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idQuimicaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Quimicasuelo select(int idQuimicaSuelo){
      Quimicasuelo quimicasuelo = new Quimicasuelo();
      quimicasuelo.setIdQuimicaSuelo(idQuimicaSuelo); 

     IQuimicasueloDao quimicasueloDao =new FactoryDao(getGestorDefault()).getQuimicasueloDao(getDataBaseDefault());
     Quimicasuelo result=quimicasueloDao.select(quimicasuelo);
     quimicasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Quimicasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idQuimicaSuelo
   * @param descripcionQuimica
   * @param suelo
   */
  public static void update(int idQuimicaSuelo, String descripcionQuimica, Suelo suelo){
      Quimicasuelo quimicasuelo = select(idQuimicaSuelo);
      quimicasuelo.setDescripcionQuimica(descripcionQuimica); 
      quimicasuelo.setSuelo(suelo); 

     IQuimicasueloDao quimicasueloDao =new FactoryDao(getGestorDefault()).getQuimicasueloDao(getDataBaseDefault());
     quimicasueloDao.update(quimicasuelo);
     quimicasueloDao.close();
  }

  /**
   * Elimina un objeto Quimicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idQuimicaSuelo
   */
  public static void delete(int idQuimicaSuelo){
      Quimicasuelo quimicasuelo = new Quimicasuelo();
      quimicasuelo.setIdQuimicaSuelo(idQuimicaSuelo); 

     IQuimicasueloDao quimicasueloDao =new FactoryDao(getGestorDefault()).getQuimicasueloDao(getDataBaseDefault());
     quimicasueloDao.delete(quimicasuelo);
     quimicasueloDao.close();
  }

  /**
   * Lista todos los objetos Quimicasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Quimicasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Quimicasuelo> listAll(){
     IQuimicasueloDao quimicasueloDao =new FactoryDao(getGestorDefault()).getQuimicasueloDao(getDataBaseDefault());
     ArrayList<Quimicasuelo> result=quimicasueloDao.listAll();
     quimicasueloDao.close();
      return result;
  }


}
//That`s all folks!