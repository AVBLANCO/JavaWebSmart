/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Caminante no hay camino, se hace camino al andar  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IFisicasueloDao;

public class FisicasueloFacade {

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
   * Crea un objeto Fisicasuelo a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfisicaSuelo
   * @param decscricionfisicaSuelo
   * @param suelo
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idfisicaSuelo, String decscricionfisicaSuelo, Suelo suelo){
      Fisicasuelo fisicasuelo = new Fisicasuelo();
      fisicasuelo.setIdfisicaSuelo(idfisicaSuelo); 
      fisicasuelo.setDecscricionfisicaSuelo(decscricionfisicaSuelo); 
      fisicasuelo.setSuelo(suelo); 

     IFisicasueloDao fisicasueloDao =new FactoryDao(getGestorDefault()).getFisicasueloDao(getDataBaseDefault());
     int rtn = fisicasueloDao.insert(fisicasuelo);
     fisicasueloDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Fisicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfisicaSuelo
   * @return El objeto en base de datos o Null
   */
  public static Fisicasuelo select(int idfisicaSuelo){
      Fisicasuelo fisicasuelo = new Fisicasuelo();
      fisicasuelo.setIdfisicaSuelo(idfisicaSuelo); 

     IFisicasueloDao fisicasueloDao =new FactoryDao(getGestorDefault()).getFisicasueloDao(getDataBaseDefault());
     Fisicasuelo result=fisicasueloDao.select(fisicasuelo);
     fisicasueloDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Fisicasuelo  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfisicaSuelo
   * @param decscricionfisicaSuelo
   * @param suelo
   */
  public static void update(int idfisicaSuelo, String decscricionfisicaSuelo, Suelo suelo){
      Fisicasuelo fisicasuelo = select(idfisicaSuelo);
      fisicasuelo.setDecscricionfisicaSuelo(decscricionfisicaSuelo); 
      fisicasuelo.setSuelo(suelo); 

     IFisicasueloDao fisicasueloDao =new FactoryDao(getGestorDefault()).getFisicasueloDao(getDataBaseDefault());
     fisicasueloDao.update(fisicasuelo);
     fisicasueloDao.close();
  }

  /**
   * Elimina un objeto Fisicasuelo de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idfisicaSuelo
   */
  public static void delete(int idfisicaSuelo){
      Fisicasuelo fisicasuelo = new Fisicasuelo();
      fisicasuelo.setIdfisicaSuelo(idfisicaSuelo); 

     IFisicasueloDao fisicasueloDao =new FactoryDao(getGestorDefault()).getFisicasueloDao(getDataBaseDefault());
     fisicasueloDao.delete(fisicasuelo);
     fisicasueloDao.close();
  }

  /**
   * Lista todos los objetos Fisicasuelo de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Fisicasuelo>  con los objetos en base de datos o Null
   */
  public static ArrayList<Fisicasuelo> listAll(){
     IFisicasueloDao fisicasueloDao =new FactoryDao(getGestorDefault()).getFisicasueloDao(getDataBaseDefault());
     ArrayList<Fisicasuelo> result=fisicasueloDao.listAll();
     fisicasueloDao.close();
      return result;
  }


}
//That`s all folks!