/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Te veeeeeooooo  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Balancehidrico;

public interface IBalancehidricoDao {

    /**
     * Guarda un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Balancehidrico balancehidrico) throws NullPointerException;
    /**
     * Modifica un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Balancehidrico balancehidrico) throws NullPointerException;
    /**
     * Elimina un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Balancehidrico balancehidrico) throws NullPointerException;
    /**
     * Busca un objeto Balancehidrico en la base de datos.
     * @param balancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Balancehidrico select(Balancehidrico balancehidrico) throws NullPointerException;
    /**
     * Lista todos los objetos Balancehidrico en la base de datos.
     * @return ArrayList<Balancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Balancehidrico> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!