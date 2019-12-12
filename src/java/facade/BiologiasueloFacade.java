/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Alza el puño y ven! ¡En la hoguera hay de beber!  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IBiologiasueloDao;

public class BiologiasueloFacade {

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
   * Crea un objeto Biologiasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbiologiaSuelo
   * @param biologiaSuelo
   * @param suelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idbiologiaSuelo, String biologiaSuelo, Suelo suelo){
      Biologiasuelo biologiasuelo = new Biologiasuelo();
      biologiasuelo.setIdbiologiaSuelo(idbiologiaSuelo); 
      biologiasuelo.setBiologiaSuelo(biologiaSuelo); 
      biologiasuelo.setSuelo(suelo); 

     IBiologiasueloDao biologiasueloDao =new FactoryDao(getGestorDefault()).getBiologiasueloDao(getDataBaseDefault());
     int rtn = biologiasueloDao.insert(biologiasuelo);
     biologiasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Biologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbiologiaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Biologiasuelo select(int idbiologiaSuelo){
      Biologiasuelo biologiasuelo = new Biologiasuelo();
      biologiasuelo.setIdbiologiaSuelo(idbiologiaSuelo); 

     IBiologiasueloDao biologiasueloDao =new FactoryDao(getGestorDefault()).getBiologiasueloDao(getDataBaseDefault());
     Biologiasuelo result=biologiasueloDao.select(biologiasuelo);
     biologiasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Biologiasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbiologiaSuelo
   * @param biologiaSuelo
   * @param suelo
   */
  public static void update(int idbiologiaSuelo, String biologiaSuelo, Suelo suelo){
      Biologiasuelo biologiasuelo = select(idbiologiaSuelo);
      biologiasuelo.setBiologiaSuelo(biologiaSuelo); 
      biologiasuelo.setSuelo(suelo); 

     IBiologiasueloDao biologiasueloDao =new FactoryDao(getGestorDefault()).getBiologiasueloDao(getDataBaseDefault());
     biologiasueloDao.update(biologiasuelo);
     biologiasueloDao.close();
  }

  /**
   * Elimina un objeto Biologiasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idbiologiaSuelo
   */
  public static void delete(int idbiologiaSuelo){
      Biologiasuelo biologiasuelo = new Biologiasuelo();
      biologiasuelo.setIdbiologiaSuelo(idbiologiaSuelo); 

     IBiologiasueloDao biologiasueloDao =new FactoryDao(getGestorDefault()).getBiologiasueloDao(getDataBaseDefault());
     biologiasueloDao.delete(biologiasuelo);
     biologiasueloDao.close();
  }

  /**
   * Lista todos los objetos Biologiasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Biologiasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Biologiasuelo> listAll(){
     IBiologiasueloDao biologiasueloDao =new FactoryDao(getGestorDefault()).getBiologiasueloDao(getDataBaseDefault());
     ArrayList<Biologiasuelo> result=biologiasueloDao.listAll();
     biologiasueloDao.close();
      return result;
  }


}
//That`s all folks!