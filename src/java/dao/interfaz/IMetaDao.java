/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Vine a Comala porque me dijeron que acá vivía mi padre, un tal Pedro Páramo.  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Meta;

public interface IMetaDao {

    /**
     * Guarda un objeto Meta en la base de datos.
     * @param meta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Meta meta) throws NullPointerException;
    /**
     * Modifica un objeto Meta en la base de datos.
     * @param meta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Meta meta) throws NullPointerException;
    /**
     * Elimina un objeto Meta en la base de datos.
     * @param meta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Meta meta) throws NullPointerException;
    /**
     * Busca un objeto Meta en la base de datos.
     * @param meta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Meta select(Meta meta) throws NullPointerException;
    /**
     * Lista todos los objetos Meta en la base de datos.
     * @return ArrayList<Meta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Meta> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!