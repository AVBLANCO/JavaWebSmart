/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Estadistas informan que una linea de código equivale a un sorbo de café  \\

package back.facade;
import back.dao.factory.FactoryDao;
import back.dto.*;
import java.util.ArrayList;
import back.dao.interfaz.IHistoricoDao;

public class HistoricoFacade {

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
   * Crea un objeto Historico a partir de sus parámetros y lo guarda en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhistorico
   * @param descripcionHistorico
   * @param miagroempresa
   * @param valorHistorico
   * @return lastInsertId Devuelve el último id insertado en el caso que la llave primaria sea autoincremental
   */
  public static int insert(int idhistorico, String descripcionHistorico, Miagroempresa miagroempresa, double valorHistorico){
      Historico historico = new Historico();
      historico.setIdhistorico(idhistorico); 
      historico.setDescripcionHistorico(descripcionHistorico); 
      historico.setMiagroempresa(miagroempresa); 
      historico.setValorHistorico(valorHistorico); 

     IHistoricoDao historicoDao =new FactoryDao(getGestorDefault()).getHistoricoDao(getDataBaseDefault());
     int rtn = historicoDao.insert(historico);
     historicoDao.close();
      return rtn;
  }

  /**
   * Selecciona un objeto Historico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhistorico
   * @return El objeto en base de datos o Null
   */
  public static Historico select(int idhistorico){
      Historico historico = new Historico();
      historico.setIdhistorico(idhistorico); 

     IHistoricoDao historicoDao =new FactoryDao(getGestorDefault()).getHistoricoDao(getDataBaseDefault());
     Historico result=historicoDao.select(historico);
     historicoDao.close();
      return result;
  }

  /**
   * Modifica los atributos de un objeto Historico  ya existente en base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhistorico
   * @param descripcionHistorico
   * @param miagroempresa
   * @param valorHistorico
   */
  public static void update(int idhistorico, String descripcionHistorico, Miagroempresa miagroempresa, double valorHistorico){
      Historico historico = select(idhistorico);
      historico.setDescripcionHistorico(descripcionHistorico); 
      historico.setMiagroempresa(miagroempresa); 
      historico.setValorHistorico(valorHistorico); 

     IHistoricoDao historicoDao =new FactoryDao(getGestorDefault()).getHistoricoDao(getDataBaseDefault());
     historicoDao.update(historico);
     historicoDao.close();
  }

  /**
   * Elimina un objeto Historico de la base de datos a partir de su(s) llave(s) primaria(s).
   * Puede recibir NullPointerException desde los métodos del Dao
   * @param idhistorico
   */
  public static void delete(int idhistorico){
      Historico historico = new Historico();
      historico.setIdhistorico(idhistorico); 

     IHistoricoDao historicoDao =new FactoryDao(getGestorDefault()).getHistoricoDao(getDataBaseDefault());
     historicoDao.delete(historico);
     historicoDao.close();
  }

  /**
   * Lista todos los objetos Historico de la base de datos.
   * Puede recibir NullPointerException desde los métodos del Dao
   * @return result ArrayList<Historico>  con los objetos en base de datos o Null
   */
  public static ArrayList<Historico> listAll(){
     IHistoricoDao historicoDao =new FactoryDao(getGestorDefault()).getHistoricoDao(getDataBaseDefault());
     ArrayList<Historico> result=historicoDao.listAll();
     historicoDao.close();
      return result;
  }


}
//That`s all folks!