/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    No dejes el código del futuro en manos humanas  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IConversionenergeticaDao;

public class ConversionenergeticaFacade {

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
   * Crea un objeto Conversionenergetica a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idconversionEnergetica
   * @param descripcionConversionEnergetica
   * @param fechaConversionEnergetica
   * @param agroclimatologia
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idconversionEnergetica, String descripcionConversionEnergetica, String fechaConversionEnergetica, Agroclimatologia agroclimatologia){
      Conversionenergetica conversionenergetica = new Conversionenergetica();
      conversionenergetica.setIdconversionEnergetica(idconversionEnergetica); 
      conversionenergetica.setDescripcionConversionEnergetica(descripcionConversionEnergetica); 
      conversionenergetica.setFechaConversionEnergetica(fechaConversionEnergetica); 
      conversionenergetica.setAgroclimatologia(agroclimatologia); 

     IConversionenergeticaDao conversionenergeticaDao =new FactoryDao(getGestorDefault()).getConversionenergeticaDao(getDataBaseDefault());
     int rtn = conversionenergeticaDao.insert(conversionenergetica);
     conversionenergeticaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Conversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idconversionEnergetica
   * @return El objeto en base de datos o Null
   */
  public static Conversionenergetica select(int idconversionEnergetica){
      Conversionenergetica conversionenergetica = new Conversionenergetica();
      conversionenergetica.setIdconversionEnergetica(idconversionEnergetica); 

     IConversionenergeticaDao conversionenergeticaDao =new FactoryDao(getGestorDefault()).getConversionenergeticaDao(getDataBaseDefault());
     Conversionenergetica result=conversionenergeticaDao.select(conversionenergetica);
     conversionenergeticaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Conversionenergetica  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idconversionEnergetica
   * @param descripcionConversionEnergetica
   * @param fechaConversionEnergetica
   * @param agroclimatologia
   */
  public static void update(int idconversionEnergetica, String descripcionConversionEnergetica, String fechaConversionEnergetica, Agroclimatologia agroclimatologia){
      Conversionenergetica conversionenergetica = select(idconversionEnergetica);
      conversionenergetica.setDescripcionConversionEnergetica(descripcionConversionEnergetica); 
      conversionenergetica.setFechaConversionEnergetica(fechaConversionEnergetica); 
      conversionenergetica.setAgroclimatologia(agroclimatologia); 

     IConversionenergeticaDao conversionenergeticaDao =new FactoryDao(getGestorDefault()).getConversionenergeticaDao(getDataBaseDefault());
     conversionenergeticaDao.update(conversionenergetica);
     conversionenergeticaDao.close();
  }

  /**
   * Elimina un objeto Conversionenergetica de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idconversionEnergetica
   */
  public static void delete(int idconversionEnergetica){
      Conversionenergetica conversionenergetica = new Conversionenergetica();
      conversionenergetica.setIdconversionEnergetica(idconversionEnergetica); 

     IConversionenergeticaDao conversionenergeticaDao =new FactoryDao(getGestorDefault()).getConversionenergeticaDao(getDataBaseDefault());
     conversionenergeticaDao.delete(conversionenergetica);
     conversionenergeticaDao.close();
  }

  /**
   * Lista todos los objetos Conversionenergetica de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Conversionenergetica>  con los objetos en base de datos o Null
   */
  public static ArrayList<Conversionenergetica> listAll(){
     IConversionenergeticaDao conversionenergeticaDao =new FactoryDao(getGestorDefault()).getConversionenergeticaDao(getDataBaseDefault());
     ArrayList<Conversionenergetica> result=conversionenergeticaDao.listAll();
     conversionenergeticaDao.close();
      return result;
  }


}
//That`s all folks!