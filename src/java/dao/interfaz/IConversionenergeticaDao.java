/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Y pensar que Anarchy está hecho en código espagueti...  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Conversionenergetica;

public interface IConversionenergeticaDao {

    /**
     * Guarda un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Conversionenergetica conversionenergetica) throws NullPointerException;
    /**
     * Modifica un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Conversionenergetica conversionenergetica) throws NullPointerException;
    /**
     * Elimina un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Conversionenergetica conversionenergetica) throws NullPointerException;
    /**
     * Busca un objeto Conversionenergetica en la base de datos.
     * @param conversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Conversionenergetica select(Conversionenergetica conversionenergetica) throws NullPointerException;
    /**
     * Lista todos los objetos Conversionenergetica en la base de datos.
     * @return ArrayList<Conversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Conversionenergetica> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!