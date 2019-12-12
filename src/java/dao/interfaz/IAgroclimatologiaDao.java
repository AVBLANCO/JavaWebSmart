/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    La vie est composé de combien de fois nous rions avant de mourir  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Agroclimatologia;

public interface IAgroclimatologiaDao {

    /**
     * Guarda un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Agroclimatologia agroclimatologia) throws NullPointerException;
    /**
     * Modifica un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Agroclimatologia agroclimatologia) throws NullPointerException;
    /**
     * Elimina un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Agroclimatologia agroclimatologia) throws NullPointerException;
    /**
     * Busca un objeto Agroclimatologia en la base de datos.
     * @param agroclimatologia objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Agroclimatologia select(Agroclimatologia agroclimatologia) throws NullPointerException;
    /**
     * Lista todos los objetos Agroclimatologia en la base de datos.
     * @return ArrayList<Agroclimatologia> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Agroclimatologia> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!