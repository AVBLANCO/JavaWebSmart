/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Me arreglas mi impresora?  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Sistema;

public interface ISistemaDao {

    /**
     * Guarda un objeto Sistema en la base de datos.
     * @param sistema objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Sistema sistema) throws NullPointerException;
    /**
     * Modifica un objeto Sistema en la base de datos.
     * @param sistema objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Sistema sistema) throws NullPointerException;
    /**
     * Elimina un objeto Sistema en la base de datos.
     * @param sistema objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Sistema sistema) throws NullPointerException;
    /**
     * Busca un objeto Sistema en la base de datos.
     * @param sistema objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Sistema select(Sistema sistema) throws NullPointerException;
    /**
     * Lista todos los objetos Sistema en la base de datos.
     * @return ArrayList<Sistema> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Sistema> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!