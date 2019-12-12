/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Y si mejor estudias comunicación?  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Quimicasuelo;

public interface IQuimicasueloDao {

    /**
     * Guarda un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Quimicasuelo quimicasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Quimicasuelo quimicasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Quimicasuelo quimicasuelo) throws NullPointerException;
    /**
     * Busca un objeto Quimicasuelo en la base de datos.
     * @param quimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Quimicasuelo select(Quimicasuelo quimicasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Quimicasuelo en la base de datos.
     * @return ArrayList<Quimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Quimicasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!