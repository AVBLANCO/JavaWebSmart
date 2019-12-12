/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Todos los animales son iguales, pero algunos animales son más iguales que otros  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturafisicasuelo;

public interface ILecturafisicasueloDao {

    /**
     * Guarda un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException;
    /**
     * Busca un objeto Lecturafisicasuelo en la base de datos.
     * @param lecturafisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturafisicasuelo select(Lecturafisicasuelo lecturafisicasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturafisicasuelo en la base de datos.
     * @return ArrayList<Lecturafisicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturafisicasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!