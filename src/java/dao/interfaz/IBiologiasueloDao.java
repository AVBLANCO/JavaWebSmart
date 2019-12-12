/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La segunda regla de Anarchy es no hablar de Anarchy  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Biologiasuelo;

public interface IBiologiasueloDao {

    /**
     * Guarda un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Biologiasuelo biologiasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Biologiasuelo biologiasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Biologiasuelo biologiasuelo) throws NullPointerException;
    /**
     * Busca un objeto Biologiasuelo en la base de datos.
     * @param biologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Biologiasuelo select(Biologiasuelo biologiasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Biologiasuelo en la base de datos.
     * @return ArrayList<Biologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Biologiasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!