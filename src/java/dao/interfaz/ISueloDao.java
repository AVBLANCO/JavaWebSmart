/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ojos de perro azul  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Suelo;

public interface ISueloDao {

    /**
     * Guarda un objeto Suelo en la base de datos.
     * @param suelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Suelo suelo) throws NullPointerException;
    /**
     * Modifica un objeto Suelo en la base de datos.
     * @param suelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Suelo suelo) throws NullPointerException;
    /**
     * Elimina un objeto Suelo en la base de datos.
     * @param suelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Suelo suelo) throws NullPointerException;
    /**
     * Busca un objeto Suelo en la base de datos.
     * @param suelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Suelo select(Suelo suelo) throws NullPointerException;
    /**
     * Lista todos los objetos Suelo en la base de datos.
     * @return ArrayList<Suelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Suelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!