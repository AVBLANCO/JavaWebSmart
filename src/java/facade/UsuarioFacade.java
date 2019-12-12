/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Tenemos trabajos que odiamos para comprar cosas que no necesitamos.  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IUsuarioDao;

public class UsuarioFacade {

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
   * Crea un objeto Usuario a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idusuario
   * @param nombreUsuario
   * @param passwordUsuario
   * @param persona
   * @param finca
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idusuario, String nombreUsuario, String passwordUsuario, Persona persona, Finca finca){
      Usuario usuario = new Usuario();
      usuario.setIdusuario(idusuario); 
      usuario.setNombreUsuario(nombreUsuario); 
      usuario.setPasswordUsuario(passwordUsuario); 
      usuario.setPersona(persona); 
      usuario.setFinca(finca); 

     IUsuarioDao usuarioDao =new FactoryDao(getGestorDefault()).getUsuarioDao(getDataBaseDefault());
     int rtn = usuarioDao.insert(usuario);
     usuarioDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Usuario de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idusuario
   * @return El objeto en base de datos o Null
   */
  public static Usuario select(int idusuario){
      Usuario usuario = new Usuario();
      usuario.setIdusuario(idusuario); 

     IUsuarioDao usuarioDao =new FactoryDao(getGestorDefault()).getUsuarioDao(getDataBaseDefault());
     Usuario result=usuarioDao.select(usuario);
     usuarioDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Usuario  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idusuario
   * @param nombreUsuario
   * @param passwordUsuario
   * @param persona
   * @param finca
   */
  public static void update(int idusuario, String nombreUsuario, String passwordUsuario, Persona persona, Finca finca){
      Usuario usuario = select(idusuario);
      usuario.setNombreUsuario(nombreUsuario); 
      usuario.setPasswordUsuario(passwordUsuario); 
      usuario.setPersona(persona); 
      usuario.setFinca(finca); 

     IUsuarioDao usuarioDao =new FactoryDao(getGestorDefault()).getUsuarioDao(getDataBaseDefault());
     usuarioDao.update(usuario);
     usuarioDao.close();
  }

  /**
   * Elimina un objeto Usuario de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idusuario
   */
  public static void delete(int idusuario){
      Usuario usuario = new Usuario();
      usuario.setIdusuario(idusuario); 

     IUsuarioDao usuarioDao =new FactoryDao(getGestorDefault()).getUsuarioDao(getDataBaseDefault());
     usuarioDao.delete(usuario);
     usuarioDao.close();
  }

  /**
   * Lista todos los objetos Usuario de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Usuario>  con los objetos en base de datos o Null
   */
  public static ArrayList<Usuario> listAll(){
     IUsuarioDao usuarioDao =new FactoryDao(getGestorDefault()).getUsuarioDao(getDataBaseDefault());
     ArrayList<Usuario> result=usuarioDao.listAll();
     usuarioDao.close();
      return result;
  }


}
//That`s all folks!