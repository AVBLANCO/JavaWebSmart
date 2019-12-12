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
import back.dao.interfaz.IFincaDao;

public class FincaFacade {

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
   * Crea un objeto Finca a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfinca
   * @param descripcionFinca
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idfinca, String descripcionFinca){
      Finca finca = new Finca();
      finca.setIdfinca(idfinca); 
      finca.setDescripcionFinca(descripcionFinca); 

     IFincaDao fincaDao =new FactoryDao(getGestorDefault()).getFincaDao(getDataBaseDefault());
     int rtn = fincaDao.insert(finca);
     fincaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Finca de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfinca
   * @return El objeto en base de datos o Null
   */
  public static Finca select(int idfinca){
      Finca finca = new Finca();
      finca.setIdfinca(idfinca); 

     IFincaDao fincaDao =new FactoryDao(getGestorDefault()).getFincaDao(getDataBaseDefault());
     Finca result=fincaDao.select(finca);
     fincaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Finca  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfinca
   * @param descripcionFinca
   */
  public static void update(int idfinca, String descripcionFinca){
      Finca finca = select(idfinca);
      finca.setDescripcionFinca(descripcionFinca); 

     IFincaDao fincaDao =new FactoryDao(getGestorDefault()).getFincaDao(getDataBaseDefault());
     fincaDao.update(finca);
     fincaDao.close();
  }

  /**
   * Elimina un objeto Finca de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfinca
   */
  public static void delete(int idfinca){
      Finca finca = new Finca();
      finca.setIdfinca(idfinca); 

     IFincaDao fincaDao =new FactoryDao(getGestorDefault()).getFincaDao(getDataBaseDefault());
     fincaDao.delete(finca);
     fincaDao.close();
  }

  /**
   * Lista todos los objetos Finca de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Finca>  con los objetos en base de datos o Null
   */
  public static ArrayList<Finca> listAll(){
     IFincaDao fincaDao =new FactoryDao(getGestorDefault()).getFincaDao(getDataBaseDefault());
     ArrayList<Finca> result=fincaDao.listAll();
     fincaDao.close();
      return result;
  }


}
//That`s all folks!