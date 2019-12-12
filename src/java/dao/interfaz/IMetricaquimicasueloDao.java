/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Quédate con quien te quiera por tu back-end, no por tu front-end  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricaquimicasuelo;

public interface IMetricaquimicasueloDao {

    /**
     * Guarda un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException;
    /**
     * Busca un objeto Metricaquimicasuelo en la base de datos.
     * @param metricaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricaquimicasuelo select(Metricaquimicasuelo metricaquimicasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Metricaquimicasuelo en la base de datos.
     * @return ArrayList<Metricaquimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricaquimicasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!