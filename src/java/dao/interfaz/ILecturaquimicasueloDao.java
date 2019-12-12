/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Era más fácil crear un framework que aprender a usar uno existente  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturaquimicasuelo;

public interface ILecturaquimicasueloDao {

    /**
     * Guarda un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException;
    /**
     * Busca un objeto Lecturaquimicasuelo en la base de datos.
     * @param lecturaquimicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturaquimicasuelo select(Lecturaquimicasuelo lecturaquimicasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturaquimicasuelo en la base de datos.
     * @return ArrayList<Lecturaquimicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturaquimicasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!