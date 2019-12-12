/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ojitos de luz de luna  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IAgroclimatologiaDao;

public class AgroclimatologiaFacade {

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
   * Crea un objeto Agroclimatologia a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idagroclimatologia
   * @param descripcionAgroclimatologia
   * @param fechaAgroclimatologia
   * @param lote
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idagroclimatologia, String descripcionAgroclimatologia, String fechaAgroclimatologia, Lote lote){
      Agroclimatologia agroclimatologia = new Agroclimatologia();
      agroclimatologia.setIdagroclimatologia(idagroclimatologia); 
      agroclimatologia.setDescripcionAgroclimatologia(descripcionAgroclimatologia); 
      agroclimatologia.setFechaAgroclimatologia(fechaAgroclimatologia); 
      agroclimatologia.setLote(lote); 

     IAgroclimatologiaDao agroclimatologiaDao =new FactoryDao(getGestorDefault()).getAgroclimatologiaDao(getDataBaseDefault());
     int rtn = agroclimatologiaDao.insert(agroclimatologia);
     agroclimatologiaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Agroclimatologia de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idagroclimatologia
   * @return El objeto en base de datos o Null
   */
  public static Agroclimatologia select(int idagroclimatologia){
      Agroclimatologia agroclimatologia = new Agroclimatologia();
      agroclimatologia.setIdagroclimatologia(idagroclimatologia); 

     IAgroclimatologiaDao agroclimatologiaDao =new FactoryDao(getGestorDefault()).getAgroclimatologiaDao(getDataBaseDefault());
     Agroclimatologia result=agroclimatologiaDao.select(agroclimatologia);
     agroclimatologiaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Agroclimatologia  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idagroclimatologia
   * @param descripcionAgroclimatologia
   * @param fechaAgroclimatologia
   * @param lote
   */
  public static void update(int idagroclimatologia, String descripcionAgroclimatologia, String fechaAgroclimatologia, Lote lote){
      Agroclimatologia agroclimatologia = select(idagroclimatologia);
      agroclimatologia.setDescripcionAgroclimatologia(descripcionAgroclimatologia); 
      agroclimatologia.setFechaAgroclimatologia(fechaAgroclimatologia); 
      agroclimatologia.setLote(lote); 

     IAgroclimatologiaDao agroclimatologiaDao =new FactoryDao(getGestorDefault()).getAgroclimatologiaDao(getDataBaseDefault());
     agroclimatologiaDao.update(agroclimatologia);
     agroclimatologiaDao.close();
  }

  /**
   * Elimina un objeto Agroclimatologia de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idagroclimatologia
   */
  public static void delete(int idagroclimatologia){
      Agroclimatologia agroclimatologia = new Agroclimatologia();
      agroclimatologia.setIdagroclimatologia(idagroclimatologia); 

     IAgroclimatologiaDao agroclimatologiaDao =new FactoryDao(getGestorDefault()).getAgroclimatologiaDao(getDataBaseDefault());
     agroclimatologiaDao.delete(agroclimatologia);
     agroclimatologiaDao.close();
  }

  /**
   * Lista todos los objetos Agroclimatologia de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Agroclimatologia>  con los objetos en base de datos o Null
   */
  public static ArrayList<Agroclimatologia> listAll(){
     IAgroclimatologiaDao agroclimatologiaDao =new FactoryDao(getGestorDefault()).getAgroclimatologiaDao(getDataBaseDefault());
     ArrayList<Agroclimatologia> result=agroclimatologiaDao.listAll();
     agroclimatologiaDao.close();
      return result;
  }


}
//That`s all folks!