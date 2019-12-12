/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Vva 'l doro  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ICostoDao;

public class CostoFacade {

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
   * Crea un objeto Costo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idcosto
   * @param descripcionCosto
   * @param valorCosto
   * @param miagroempresa
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idcosto, String descripcionCosto, double valorCosto, Miagroempresa miagroempresa){
      Costo costo = new Costo();
      costo.setIdcosto(idcosto); 
      costo.setDescripcionCosto(descripcionCosto); 
      costo.setValorCosto(valorCosto); 
      costo.setMiagroempresa(miagroempresa); 

     ICostoDao costoDao =new FactoryDao(getGestorDefault()).getCostoDao(getDataBaseDefault());
     int rtn = costoDao.insert(costo);
     costoDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Costo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idcosto
   * @return El objeto en base de datos o Null
   */
  public static Costo select(int idcosto){
      Costo costo = new Costo();
      costo.setIdcosto(idcosto); 

     ICostoDao costoDao =new FactoryDao(getGestorDefault()).getCostoDao(getDataBaseDefault());
     Costo result=costoDao.select(costo);
     costoDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Costo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idcosto
   * @param descripcionCosto
   * @param valorCosto
   * @param miagroempresa
   */
  public static void update(int idcosto, String descripcionCosto, double valorCosto, Miagroempresa miagroempresa){
      Costo costo = select(idcosto);
      costo.setDescripcionCosto(descripcionCosto); 
      costo.setValorCosto(valorCosto); 
      costo.setMiagroempresa(miagroempresa); 

     ICostoDao costoDao =new FactoryDao(getGestorDefault()).getCostoDao(getDataBaseDefault());
     costoDao.update(costo);
     costoDao.close();
  }

  /**
   * Elimina un objeto Costo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idcosto
   */
  public static void delete(int idcosto){
      Costo costo = new Costo();
      costo.setIdcosto(idcosto); 

     ICostoDao costoDao =new FactoryDao(getGestorDefault()).getCostoDao(getDataBaseDefault());
     costoDao.delete(costo);
     costoDao.close();
  }

  /**
   * Lista todos los objetos Costo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Costo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Costo> listAll(){
     ICostoDao costoDao =new FactoryDao(getGestorDefault()).getCostoDao(getDataBaseDefault());
     ArrayList<Costo> result=costoDao.listAll();
     costoDao.close();
      return result;
  }


}
//That`s all folks!