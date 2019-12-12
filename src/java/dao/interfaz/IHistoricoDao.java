/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Podrías agradecernos con unos cuantos billetes _/(n.n)\_  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Historico;

public interface IHistoricoDao {

    /**
     * Guarda un objeto Historico en la base de datos.
     * @param historico objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Historico historico) throws NullPointerException;
    /**
     * Modifica un objeto Historico en la base de datos.
     * @param historico objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Historico historico) throws NullPointerException;
    /**
     * Elimina un objeto Historico en la base de datos.
     * @param historico objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Historico historico) throws NullPointerException;
    /**
     * Busca un objeto Historico en la base de datos.
     * @param historico objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Historico select(Historico historico) throws NullPointerException;
    /**
     * Lista todos los objetos Historico en la base de datos.
     * @return ArrayList<Historico> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Historico> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!