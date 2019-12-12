/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La primera regla de Anarchy es no hablar de Anarchy  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricabalancehidrico;

public interface IMetricabalancehidricoDao {

    /**
     * Guarda un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricabalancehidrico metricabalancehidrico) throws NullPointerException;
    /**
     * Modifica un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricabalancehidrico metricabalancehidrico) throws NullPointerException;
    /**
     * Elimina un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricabalancehidrico metricabalancehidrico) throws NullPointerException;
    /**
     * Busca un objeto Metricabalancehidrico en la base de datos.
     * @param metricabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricabalancehidrico select(Metricabalancehidrico metricabalancehidrico) throws NullPointerException;
    /**
     * Lista todos los objetos Metricabalancehidrico en la base de datos.
     * @return ArrayList<Metricabalancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricabalancehidrico> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!