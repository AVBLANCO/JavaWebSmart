/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ahora con 25% menos groserías  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Hojaruta;

public interface IHojarutaDao {

    /**
     * Guarda un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Hojaruta hojaruta) throws NullPointerException;
    /**
     * Modifica un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Hojaruta hojaruta) throws NullPointerException;
    /**
     * Elimina un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Hojaruta hojaruta) throws NullPointerException;
    /**
     * Busca un objeto Hojaruta en la base de datos.
     * @param hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Hojaruta select(Hojaruta hojaruta) throws NullPointerException;
    /**
     * Lista todos los objetos Hojaruta en la base de datos.
     * @return ArrayList<Hojaruta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Hojaruta> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!