/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Traigo una pizza para ¿y se la creyó?  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricaconversionenergetica;

public interface IMetricaconversionenergeticaDao {

    /**
     * Guarda un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException;
    /**
     * Modifica un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException;
    /**
     * Elimina un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException;
    /**
     * Busca un objeto Metricaconversionenergetica en la base de datos.
     * @param metricaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricaconversionenergetica select(Metricaconversionenergetica metricaconversionenergetica) throws NullPointerException;
    /**
     * Lista todos los objetos Metricaconversionenergetica en la base de datos.
     * @return ArrayList<Metricaconversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricaconversionenergetica> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!