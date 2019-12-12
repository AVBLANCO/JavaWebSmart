/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Por desgracia, mi epitafio será una frase insulsa y vacía  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ILoteDao;

public class LoteFacade {

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
   * Crea un objeto Lote a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlote
   * @param descripcionLote
   * @param longitud
   * @param latitud
   * @param finca
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idlote, String descripcionLote, double longitud, double latitud, Finca finca){
      Lote lote = new Lote();
      lote.setIdlote(idlote); 
      lote.setDescripcionLote(descripcionLote); 
      lote.setLongitud(longitud); 
      lote.setLatitud(latitud); 
      lote.setFinca(finca); 

     ILoteDao loteDao =new FactoryDao(getGestorDefault()).getLoteDao(getDataBaseDefault());
     int rtn = loteDao.insert(lote);
     loteDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Lote de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlote
   * @return El objeto en base de datos o Null
   */
  public static Lote select(int idlote){
      Lote lote = new Lote();
      lote.setIdlote(idlote); 

     ILoteDao loteDao =new FactoryDao(getGestorDefault()).getLoteDao(getDataBaseDefault());
     Lote result=loteDao.select(lote);
     loteDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Lote  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlote
   * @param descripcionLote
   * @param longitud
   * @param latitud
   * @param finca
   */
  public static void update(int idlote, String descripcionLote, double longitud, double latitud, Finca finca){
      Lote lote = select(idlote);
      lote.setDescripcionLote(descripcionLote); 
      lote.setLongitud(longitud); 
      lote.setLatitud(latitud); 
      lote.setFinca(finca); 

     ILoteDao loteDao =new FactoryDao(getGestorDefault()).getLoteDao(getDataBaseDefault());
     loteDao.update(lote);
     loteDao.close();
  }

  /**
   * Elimina un objeto Lote de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idlote
   */
  public static void delete(int idlote){
      Lote lote = new Lote();
      lote.setIdlote(idlote); 

     ILoteDao loteDao =new FactoryDao(getGestorDefault()).getLoteDao(getDataBaseDefault());
     loteDao.delete(lote);
     loteDao.close();
  }

  /**
   * Lista todos los objetos Lote de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Lote>  con los objetos en base de datos o Null
   */
  public static ArrayList<Lote> listAll(){
     ILoteDao loteDao =new FactoryDao(getGestorDefault()).getLoteDao(getDataBaseDefault());
     ArrayList<Lote> result=loteDao.listAll();
     loteDao.close();
      return result;
  }


}
//That`s all folks!