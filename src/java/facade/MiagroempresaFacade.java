/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Puedes sugerirnos frases nuevas, se nos están acabando ( u.u)  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IMiagroempresaDao;

public class MiagroempresaFacade {

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
   * Crea un objeto Miagroempresa a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmiAgroempresa
   * @param descipcionMiAgroempresa
   * @param lote
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idmiAgroempresa, String descipcionMiAgroempresa, Lote lote){
      Miagroempresa miagroempresa = new Miagroempresa();
      miagroempresa.setIdmiAgroempresa(idmiAgroempresa); 
      miagroempresa.setDescipcionMiAgroempresa(descipcionMiAgroempresa); 
      miagroempresa.setLote(lote); 

     IMiagroempresaDao miagroempresaDao =new FactoryDao(getGestorDefault()).getMiagroempresaDao(getDataBaseDefault());
     int rtn = miagroempresaDao.insert(miagroempresa);
     miagroempresaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Miagroempresa de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmiAgroempresa
   * @return El objeto en base de datos o Null
   */
  public static Miagroempresa select(int idmiAgroempresa){
      Miagroempresa miagroempresa = new Miagroempresa();
      miagroempresa.setIdmiAgroempresa(idmiAgroempresa); 

     IMiagroempresaDao miagroempresaDao =new FactoryDao(getGestorDefault()).getMiagroempresaDao(getDataBaseDefault());
     Miagroempresa result=miagroempresaDao.select(miagroempresa);
     miagroempresaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Miagroempresa  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmiAgroempresa
   * @param descipcionMiAgroempresa
   * @param lote
   */
  public static void update(int idmiAgroempresa, String descipcionMiAgroempresa, Lote lote){
      Miagroempresa miagroempresa = select(idmiAgroempresa);
      miagroempresa.setDescipcionMiAgroempresa(descipcionMiAgroempresa); 
      miagroempresa.setLote(lote); 

     IMiagroempresaDao miagroempresaDao =new FactoryDao(getGestorDefault()).getMiagroempresaDao(getDataBaseDefault());
     miagroempresaDao.update(miagroempresa);
     miagroempresaDao.close();
  }

  /**
   * Elimina un objeto Miagroempresa de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idmiAgroempresa
   */
  public static void delete(int idmiAgroempresa){
      Miagroempresa miagroempresa = new Miagroempresa();
      miagroempresa.setIdmiAgroempresa(idmiAgroempresa); 

     IMiagroempresaDao miagroempresaDao =new FactoryDao(getGestorDefault()).getMiagroempresaDao(getDataBaseDefault());
     miagroempresaDao.delete(miagroempresa);
     miagroempresaDao.close();
  }

  /**
   * Lista todos los objetos Miagroempresa de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Miagroempresa>  con los objetos en base de datos o Null
   */
  public static ArrayList<Miagroempresa> listAll(){
     IMiagroempresaDao miagroempresaDao =new FactoryDao(getGestorDefault()).getMiagroempresaDao(getDataBaseDefault());
     ArrayList<Miagroempresa> result=miagroempresaDao.listAll();
     miagroempresaDao.close();
      return result;
  }


}
//That`s all folks!