/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    En lo que a mí respecta, señor Dix, lo imprevisto no existe  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lote;

public interface ILoteDao {

    /**
     * Guarda un objeto Lote en la base de datos.
     * @param lote objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lote lote) throws NullPointerException;
    /**
     * Modifica un objeto Lote en la base de datos.
     * @param lote objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lote lote) throws NullPointerException;
    /**
     * Elimina un objeto Lote en la base de datos.
     * @param lote objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lote lote) throws NullPointerException;
    /**
     * Busca un objeto Lote en la base de datos.
     * @param lote objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lote select(Lote lote) throws NullPointerException;
    /**
     * Lista todos los objetos Lote en la base de datos.
     * @return ArrayList<Lote> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lote> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!