/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La noche está estrellada, y tiritan, azules, los astros, a lo lejos  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricamanejointegradoenfermedades;

public interface IMetricamanejointegradoenfermedadesDao {

    /**
     * Guarda un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Modifica un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Elimina un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Busca un objeto Metricamanejointegradoenfermedades en la base de datos.
     * @param metricamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricamanejointegradoenfermedades select(Metricamanejointegradoenfermedades metricamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Lista todos los objetos Metricamanejointegradoenfermedades en la base de datos.
     * @return ArrayList<Metricamanejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricamanejointegradoenfermedades> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!