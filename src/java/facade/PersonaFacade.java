/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Damos paso a la anarquía...  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IPersonaDao;

public class PersonaFacade {

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
   * Crea un objeto Persona a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idpersona
   * @param nombrePersona
   * @param cedulaPersona
   * @param correoPersona
   * @param fechaNacimientoPersona
   * @param genero
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idpersona, String nombrePersona, String cedulaPersona, String correoPersona, String fechaNacimientoPersona, String genero){
      Persona persona = new Persona();
      persona.setIdpersona(idpersona); 
      persona.setNombrePersona(nombrePersona); 
      persona.setCedulaPersona(cedulaPersona); 
      persona.setCorreoPersona(correoPersona); 
      persona.setFechaNacimientoPersona(fechaNacimientoPersona); 
      persona.setGenero(genero); 

     IPersonaDao personaDao =new FactoryDao(getGestorDefault()).getPersonaDao(getDataBaseDefault());
     int rtn = personaDao.insert(persona);
     personaDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Persona de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idpersona
   * @return El objeto en base de datos o Null
   */
  public static Persona select(int idpersona){
      Persona persona = new Persona();
      persona.setIdpersona(idpersona); 

     IPersonaDao personaDao =new FactoryDao(getGestorDefault()).getPersonaDao(getDataBaseDefault());
     Persona result=personaDao.select(persona);
     personaDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Persona  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idpersona
   * @param nombrePersona
   * @param cedulaPersona
   * @param correoPersona
   * @param fechaNacimientoPersona
   * @param genero
   */
  public static void update(int idpersona, String nombrePersona, String cedulaPersona, String correoPersona, String fechaNacimientoPersona, String genero){
      Persona persona = select(idpersona);
      persona.setNombrePersona(nombrePersona); 
      persona.setCedulaPersona(cedulaPersona); 
      persona.setCorreoPersona(correoPersona); 
      persona.setFechaNacimientoPersona(fechaNacimientoPersona); 
      persona.setGenero(genero); 

     IPersonaDao personaDao =new FactoryDao(getGestorDefault()).getPersonaDao(getDataBaseDefault());
     personaDao.update(persona);
     personaDao.close();
  }

  /**
   * Elimina un objeto Persona de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idpersona
   */
  public static void delete(int idpersona){
      Persona persona = new Persona();
      persona.setIdpersona(idpersona); 

     IPersonaDao personaDao =new FactoryDao(getGestorDefault()).getPersonaDao(getDataBaseDefault());
     personaDao.delete(persona);
     personaDao.close();
  }

  /**
   * Lista todos los objetos Persona de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Persona>  con los objetos en base de datos o Null
   */
  public static ArrayList<Persona> listAll(){
     IPersonaDao personaDao =new FactoryDao(getGestorDefault()).getPersonaDao(getDataBaseDefault());
     ArrayList<Persona> result=personaDao.listAll();
     personaDao.close();
      return result;
  }


}
//That`s all folks!