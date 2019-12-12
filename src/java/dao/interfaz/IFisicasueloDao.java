/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡Me han encontrado! ¡No sé cómo pero me han encontrado!  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Fisicasuelo;

public interface IFisicasueloDao {

    /**
     * Guarda un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Fisicasuelo fisicasuelo) throws NullPointerException;
    /**
     * Modifica un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Fisicasuelo fisicasuelo) throws NullPointerException;
    /**
     * Elimina un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Fisicasuelo fisicasuelo) throws NullPointerException;
    /**
     * Busca un objeto Fisicasuelo en la base de datos.
     * @param fisicasuelo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Fisicasuelo select(Fisicasuelo fisicasuelo) throws NullPointerException;
    /**
     * Lista todos los objetos Fisicasuelo en la base de datos.
     * @return ArrayList<Fisicasuelo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Fisicasuelo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!