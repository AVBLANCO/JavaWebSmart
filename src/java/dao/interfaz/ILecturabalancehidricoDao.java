/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Nuestra empresa cuenta con una división sólo para las frases. Disfrútalas  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturabalancehidrico;

public interface ILecturabalancehidricoDao {

    /**
     * Guarda un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException;
    /**
     * Modifica un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException;
    /**
     * Elimina un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException;
    /**
     * Busca un objeto Lecturabalancehidrico en la base de datos.
     * @param lecturabalancehidrico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturabalancehidrico select(Lecturabalancehidrico lecturabalancehidrico) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturabalancehidrico en la base de datos.
     * @return ArrayList<Lecturabalancehidrico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturabalancehidrico> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!