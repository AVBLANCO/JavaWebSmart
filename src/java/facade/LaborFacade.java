/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Le he dedicado más tiempo a las frases que al software interno  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILaborDao;

public class LaborFacade {

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
   * Crea un objeto Labor a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlabor
   * @param descripcionLabor
   * @param duracionLabor
   * @param miagroempresa
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlabor, String descripcionLabor, int duracionLabor, Miagroempresa miagroempresa){
      Labor labor = new Labor();
      labor.setIdlabor(idlabor); 
      labor.setDescripcionLabor(descripcionLabor); 
      labor.setDuracionLabor(duracionLabor); 
      labor.setMiagroempresa(miagroempresa); 

     ILaborDao laborDao =new FactoryDao(getGestorDefault()).getLaborDao(getDataBaseDefault());
     int rtn = laborDao.insert(labor);
     laborDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Labor de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlabor
   * @return El objeto en base de datos o Null
   */
  public static Labor select(int idlabor){
      Labor labor = new Labor();
      labor.setIdlabor(idlabor); 

     ILaborDao laborDao =new FactoryDao(getGestorDefault()).getLaborDao(getDataBaseDefault());
     Labor result=laborDao.select(labor);
     laborDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Labor  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlabor
   * @param descripcionLabor
   * @param duracionLabor
   * @param miagroempresa
   */
  public static void update(int idlabor, String descripcionLabor, int duracionLabor, Miagroempresa miagroempresa){
      Labor labor = select(idlabor);
      labor.setDescripcionLabor(descripcionLabor); 
      labor.setDuracionLabor(duracionLabor); 
      labor.setMiagroempresa(miagroempresa); 

     ILaborDao laborDao =new FactoryDao(getGestorDefault()).getLaborDao(getDataBaseDefault());
     laborDao.update(labor);
     laborDao.close();
  }

  /**
   * Elimina un objeto Labor de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlabor
   */
  public static void delete(int idlabor){
      Labor labor = new Labor();
      labor.setIdlabor(idlabor); 

     ILaborDao laborDao =new FactoryDao(getGestorDefault()).getLaborDao(getDataBaseDefault());
     laborDao.delete(labor);
     laborDao.close();
  }

  /**
   * Lista todos los objetos Labor de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Labor>  con los objetos en base de datos o Null
   */
  public static ArrayList<Labor> listAll(){
     ILaborDao laborDao =new FactoryDao(getGestorDefault()).getLaborDao(getDataBaseDefault());
     ArrayList<Labor> result=laborDao.listAll();
     laborDao.close();
      return result;
  }


}
//That`s all folks!