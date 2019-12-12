/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ella no te quiere </3 mejor ponte a programar  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricamanejoplagas;

public interface IMetricamanejoplagasDao {

    /**
     * Guarda un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricamanejoplagas metricamanejoplagas) throws NullPointerException;
    /**
     * Modifica un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricamanejoplagas metricamanejoplagas) throws NullPointerException;
    /**
     * Elimina un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricamanejoplagas metricamanejoplagas) throws NullPointerException;
    /**
     * Busca un objeto Metricamanejoplagas en la base de datos.
     * @param metricamanejoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricamanejoplagas select(Metricamanejoplagas metricamanejoplagas) throws NullPointerException;
    /**
     * Lista todos los objetos Metricamanejoplagas en la base de datos.
     * @return ArrayList<Metricamanejoplagas> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricamanejoplagas> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!