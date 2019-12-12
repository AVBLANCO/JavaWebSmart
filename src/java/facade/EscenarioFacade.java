/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuando Gregorio Samsa se despertó una mañana después de un sueño intranquilo, se encontró sobre su cama convertido en un monstruoso insecto.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IEscenarioDao;

public class EscenarioFacade {

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
   * Crea un objeto Escenario a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idescenario
   * @param descripcionEscenario
   * @param proyeccion
   * @param valorEscenario
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idescenario, String descripcionEscenario, Proyeccion proyeccion, int valorEscenario){
      Escenario escenario = new Escenario();
      escenario.setIdescenario(idescenario); 
      escenario.setDescripcionEscenario(descripcionEscenario); 
      escenario.setProyeccion(proyeccion); 
      escenario.setValorEscenario(valorEscenario); 

     IEscenarioDao escenarioDao =new FactoryDao(getGestorDefault()).getEscenarioDao(getDataBaseDefault());
     int rtn = escenarioDao.insert(escenario);
     escenarioDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Escenario de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idescenario
   * @return El objeto en base de datos o Null
   */
  public static Escenario select(int idescenario){
      Escenario escenario = new Escenario();
      escenario.setIdescenario(idescenario); 

     IEscenarioDao escenarioDao =new FactoryDao(getGestorDefault()).getEscenarioDao(getDataBaseDefault());
     Escenario result=escenarioDao.select(escenario);
     escenarioDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Escenario  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idescenario
   * @param descripcionEscenario
   * @param proyeccion
   * @param valorEscenario
   */
  public static void update(int idescenario, String descripcionEscenario, Proyeccion proyeccion, int valorEscenario){
      Escenario escenario = select(idescenario);
      escenario.setDescripcionEscenario(descripcionEscenario); 
      escenario.setProyeccion(proyeccion); 
      escenario.setValorEscenario(valorEscenario); 

     IEscenarioDao escenarioDao =new FactoryDao(getGestorDefault()).getEscenarioDao(getDataBaseDefault());
     escenarioDao.update(escenario);
     escenarioDao.close();
  }

  /**
   * Elimina un objeto Escenario de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idescenario
   */
  public static void delete(int idescenario){
      Escenario escenario = new Escenario();
      escenario.setIdescenario(idescenario); 

     IEscenarioDao escenarioDao =new FactoryDao(getGestorDefault()).getEscenarioDao(getDataBaseDefault());
     escenarioDao.delete(escenario);
     escenarioDao.close();
  }

  /**
   * Lista todos los objetos Escenario de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Escenario>  con los objetos en base de datos o Null
   */
  public static ArrayList<Escenario> listAll(){
     IEscenarioDao escenarioDao =new FactoryDao(getGestorDefault()).getEscenarioDao(getDataBaseDefault());
     ArrayList<Escenario> result=escenarioDao.listAll();
     escenarioDao.close();
      return result;
  }


}
//That`s all folks!