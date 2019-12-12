/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Trabajo individual singifica ganancia individual  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturabiologiasuelo;

public interface ILecturabiologiasueloDao {

    /**
     * Guarda un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException;
    /**
     * Busca un objeto Lecturabiologiasuelo en la base de datos.
     * @param lecturabiologiasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturabiologiasuelo select(Lecturabiologiasuelo lecturabiologiasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturabiologiasuelo en la base de datos.
     * @return ArrayList<Lecturabiologiasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturabiologiasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!