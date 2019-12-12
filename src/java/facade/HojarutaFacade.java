/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ojos de perro azul  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IHojarutaDao;

public class HojarutaFacade {

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
   * Crea un objeto Hojaruta a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhojaRuta
   * @param fechaHojaRuta
   * @param costo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idhojaRuta, String fechaHojaRuta, Costo costo){
      Hojaruta hojaruta = new Hojaruta();
      hojaruta.setIdhojaRuta(idhojaRuta); 
      hojaruta.setFechaHojaRuta(fechaHojaRuta); 
      hojaruta.setCosto(costo); 

     IHojarutaDao hojarutaDao =new FactoryDao(getGestorDefault()).getHojarutaDao(getDataBaseDefault());
     int rtn = hojarutaDao.insert(hojaruta);
     hojarutaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Hojaruta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhojaRuta
   * @return El objeto en base de datos o Null
   */
  public static Hojaruta select(int idhojaRuta){
      Hojaruta hojaruta = new Hojaruta();
      hojaruta.setIdhojaRuta(idhojaRuta); 

     IHojarutaDao hojarutaDao =new FactoryDao(getGestorDefault()).getHojarutaDao(getDataBaseDefault());
     Hojaruta result=hojarutaDao.select(hojaruta);
     hojarutaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Hojaruta  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhojaRuta
   * @param fechaHojaRuta
   * @param costo
   */
  public static void update(int idhojaRuta, String fechaHojaRuta, Costo costo){
      Hojaruta hojaruta = select(idhojaRuta);
      hojaruta.setFechaHojaRuta(fechaHojaRuta); 
      hojaruta.setCosto(costo); 

     IHojarutaDao hojarutaDao =new FactoryDao(getGestorDefault()).getHojarutaDao(getDataBaseDefault());
     hojarutaDao.update(hojaruta);
     hojarutaDao.close();
  }

  /**
   * Elimina un objeto Hojaruta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhojaRuta
   */
  public static void delete(int idhojaRuta){
      Hojaruta hojaruta = new Hojaruta();
      hojaruta.setIdhojaRuta(idhojaRuta); 

     IHojarutaDao hojarutaDao =new FactoryDao(getGestorDefault()).getHojarutaDao(getDataBaseDefault());
     hojarutaDao.delete(hojaruta);
     hojarutaDao.close();
  }

  /**
   * Lista todos los objetos Hojaruta de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Hojaruta>  con los objetos en base de datos o Null
   */
  public static ArrayList<Hojaruta> listAll(){
     IHojarutaDao hojarutaDao =new FactoryDao(getGestorDefault()).getHojarutaDao(getDataBaseDefault());
     ArrayList<Hojaruta> result=hojarutaDao.listAll();
     hojarutaDao.close();
      return result;
  }


}
//That`s all folks!