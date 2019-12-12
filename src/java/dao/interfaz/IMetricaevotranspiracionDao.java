/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Me ayudas con la tesis?  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Metricaevotranspiracion;

public interface IMetricaevotranspiracionDao {

    /**
     * Guarda un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException;
    /**
     * Modifica un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException;
    /**
     * Elimina un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException;
    /**
     * Busca un objeto Metricaevotranspiracion en la base de datos.
     * @param metricaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Metricaevotranspiracion select(Metricaevotranspiracion metricaevotranspiracion) throws NullPointerException;
    /**
     * Lista todos los objetos Metricaevotranspiracion en la base de datos.
     * @return ArrayList<Metricaevotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Metricaevotranspiracion> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!