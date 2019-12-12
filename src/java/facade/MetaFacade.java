/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La primera regla del proyecto es no hacer preguntas  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMetaDao;

public class MetaFacade {

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
   * Crea un objeto Meta a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmeta
   * @param descripcionMeta
   * @param valorMeta
   * @param proyeccion
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmeta, String descripcionMeta, double valorMeta, Proyeccion proyeccion){
      Meta meta = new Meta();
      meta.setIdmeta(idmeta); 
      meta.setDescripcionMeta(descripcionMeta); 
      meta.setValorMeta(valorMeta); 
      meta.setProyeccion(proyeccion); 

     IMetaDao metaDao =new FactoryDao(getGestorDefault()).getMetaDao(getDataBaseDefault());
     int rtn = metaDao.insert(meta);
     metaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Meta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmeta
   * @return El objeto en base de datos o Null
   */
  public static Meta select(int idmeta){
      Meta meta = new Meta();
      meta.setIdmeta(idmeta); 

     IMetaDao metaDao =new FactoryDao(getGestorDefault()).getMetaDao(getDataBaseDefault());
     Meta result=metaDao.select(meta);
     metaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Meta  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmeta
   * @param descripcionMeta
   * @param valorMeta
   * @param proyeccion
   */
  public static void update(int idmeta, String descripcionMeta, double valorMeta, Proyeccion proyeccion){
      Meta meta = select(idmeta);
      meta.setDescripcionMeta(descripcionMeta); 
      meta.setValorMeta(valorMeta); 
      meta.setProyeccion(proyeccion); 

     IMetaDao metaDao =new FactoryDao(getGestorDefault()).getMetaDao(getDataBaseDefault());
     metaDao.update(meta);
     metaDao.close();
  }

  /**
   * Elimina un objeto Meta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmeta
   */
  public static void delete(int idmeta){
      Meta meta = new Meta();
      meta.setIdmeta(idmeta); 

     IMetaDao metaDao =new FactoryDao(getGestorDefault()).getMetaDao(getDataBaseDefault());
     metaDao.delete(meta);
     metaDao.close();
  }

  /**
   * Lista todos los objetos Meta de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Meta>  con los objetos en base de datos o Null
   */
  public static ArrayList<Meta> listAll(){
     IMetaDao metaDao =new FactoryDao(getGestorDefault()).getMetaDao(getDataBaseDefault());
     ArrayList<Meta> result=metaDao.listAll();
     metaDao.close();
      return result;
  }


}
//That`s all folks!