/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Tu alma nos pertenece... Salve Mr. Arciniegas  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricassuelo;

public interface IMetricassueloDao {

    /**
     * Guarda un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricassuelo metricassuelo) throws NullPointerException;
    /**
     * Modifica un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricassuelo metricassuelo) throws NullPointerException;
    /**
     * Elimina un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricassuelo metricassuelo) throws NullPointerException;
    /**
     * Busca un objeto Metricassuelo en la base de datos.
     * @param metricassuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricassuelo select(Metricassuelo metricassuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Metricassuelo en la base de datos.
     * @return ArrayList<Metricassuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricassuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!