/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    No te olvides de quitar mis comentarios  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricabiologiasuelo;

public interface IMetricabiologiasueloDao {

    /**
     * Guarda un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException;
    /**
     * Busca un objeto Metricabiologiasuelo en la base de datos.
     * @param metricabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricabiologiasuelo select(Metricabiologiasuelo metricabiologiasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Metricabiologiasuelo en la base de datos.
     * @return ArrayList<Metricabiologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricabiologiasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!