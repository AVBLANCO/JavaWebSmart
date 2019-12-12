/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Generar buen código o poner frases graciosas? ¡La frase! ¡La frase!  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.ISistemaDao;

public class SistemaFacade {

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
   * Crea un objeto Sistema a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsistema
   * @param descripcion
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idsistema, String descripcion){
      Sistema sistema = new Sistema();
      sistema.setIdsistema(idsistema); 
      sistema.setDescripcion(descripcion); 

     ISistemaDao sistemaDao =new FactoryDao(getGestorDefault()).getSistemaDao(getDataBaseDefault());
     int rtn = sistemaDao.insert(sistema);
     sistemaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Sistema de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsistema
   * @return El objeto en base de datos o Null
   */
  public static Sistema select(int idsistema){
      Sistema sistema = new Sistema();
      sistema.setIdsistema(idsistema); 

     ISistemaDao sistemaDao =new FactoryDao(getGestorDefault()).getSistemaDao(getDataBaseDefault());
     Sistema result=sistemaDao.select(sistema);
     sistemaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Sistema  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsistema
   * @param descripcion
   */
  public static void update(int idsistema, String descripcion){
      Sistema sistema = select(idsistema);
      sistema.setDescripcion(descripcion); 

     ISistemaDao sistemaDao =new FactoryDao(getGestorDefault()).getSistemaDao(getDataBaseDefault());
     sistemaDao.update(sistema);
     sistemaDao.close();
  }

  /**
   * Elimina un objeto Sistema de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idsistema
   */
  public static void delete(int idsistema){
      Sistema sistema = new Sistema();
      sistema.setIdsistema(idsistema); 

     ISistemaDao sistemaDao =new FactoryDao(getGestorDefault()).getSistemaDao(getDataBaseDefault());
     sistemaDao.delete(sistema);
     sistemaDao.close();
  }

  /**
   * Lista todos los objetos Sistema de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Sistema>  con los objetos en base de datos o Null
   */
  public static ArrayList<Sistema> listAll(){
     ISistemaDao sistemaDao =new FactoryDao(getGestorDefault()).getSistemaDao(getDataBaseDefault());
     ArrayList<Sistema> result=sistemaDao.listAll();
     sistemaDao.close();
      return result;
  }


}
//That`s all folks!