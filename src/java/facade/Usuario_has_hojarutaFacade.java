/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Yo <3 Cúcuta  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IUsuario_has_hojarutaDao;

public class Usuario_has_hojarutaFacade {

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
   * Crea un objeto Usuario_has_hojaruta a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param usuario
   * @param hojaruta
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(Usuario usuario, Hojaruta hojaruta){
      Usuario_has_hojaruta usuario_has_hojaruta = new Usuario_has_hojaruta();
      usuario_has_hojaruta.setUsuario(usuario); 
      usuario_has_hojaruta.setHojaruta(hojaruta); 

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     int rtn = usuario_has_hojarutaDao.insert(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Usuario_has_hojaruta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param usuario
   * @param hojaruta
   * @return El objeto en base de datos o Null
   */
  public static Usuario_has_hojaruta select(Usuario usuario, Hojaruta hojaruta){
      Usuario_has_hojaruta usuario_has_hojaruta = new Usuario_has_hojaruta();
      usuario_has_hojaruta.setUsuario(usuario); 
      usuario_has_hojaruta.setHojaruta(hojaruta); 

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     Usuario_has_hojaruta result=usuario_has_hojarutaDao.select(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Usuario_has_hojaruta  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param usuario
   * @param hojaruta
   */
  public static void update(Usuario usuario, Hojaruta hojaruta){
      Usuario_has_hojaruta usuario_has_hojaruta = select(usuario, hojaruta);

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     usuario_has_hojarutaDao.update(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
  }

  /**
   * Elimina un objeto Usuario_has_hojaruta de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param usuario
   * @param hojaruta
   */
  public static void delete(Usuario usuario, Hojaruta hojaruta){
      Usuario_has_hojaruta usuario_has_hojaruta = new Usuario_has_hojaruta();
      usuario_has_hojaruta.setUsuario(usuario); 
      usuario_has_hojaruta.setHojaruta(hojaruta); 

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     usuario_has_hojarutaDao.delete(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
  }

  /**
   * Lista todos los objetos Usuario_has_hojaruta de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Usuario_has_hojaruta>  con los objetos en base de datos o Null
   */
  public static ArrayList<Usuario_has_hojaruta> listAll(){
     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     ArrayList<Usuario_has_hojaruta> result=usuario_has_hojarutaDao.listAll();
     usuario_has_hojarutaDao.close();
      return result;
  }

  /**
   * Lista todos los objetos Usuario_has_hojaruta de la base de datos a partir de usuario.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param usuario
   * @return result ArrayList<Usuario_has_hojaruta>  con los objetos en base de datos o Null
   */
  public static ArrayList<Usuario_has_hojaruta> listByUsuario(Usuario usuario){
      Usuario_has_hojaruta usuario_has_hojaruta = new Usuario_has_hojaruta();
      usuario_has_hojaruta.setUsuario(usuario); 

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     ArrayList<Usuario_has_hojaruta> result=usuario_has_hojarutaDao.listByUsuario(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
      return result;
  }

  /**
   * Lista todos los objetos Usuario_has_hojaruta de la base de datos a partir de hojaruta.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param hojaruta
   * @return result ArrayList<Usuario_has_hojaruta>  con los objetos en base de datos o Null
   */
  public static ArrayList<Usuario_has_hojaruta> listByHojaruta(Hojaruta hojaruta){
      Usuario_has_hojaruta usuario_has_hojaruta = new Usuario_has_hojaruta();
      usuario_has_hojaruta.setHojaruta(hojaruta); 

     IUsuario_has_hojarutaDao usuario_has_hojarutaDao =new FactoryDao(getGestorDefault()).getUsuario_has_hojarutaDao(getDataBaseDefault());
     ArrayList<Usuario_has_hojaruta> result=usuario_has_hojarutaDao.listByHojaruta(usuario_has_hojaruta);
     usuario_has_hojarutaDao.close();
      return result;
  }


}
//That`s all folks!