/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Vine a Comala porque me dijeron que acá vivía mi padre, un tal Pedro Páramo.  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Costo;

public interface ICostoDao {

    /**
     * Guarda un objeto Costo en la base de datos.
     * @param costo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Costo costo) throws NullPointerException;
    /**
     * Modifica un objeto Costo en la base de datos.
     * @param costo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Costo costo) throws NullPointerException;
    /**
     * Elimina un objeto Costo en la base de datos.
     * @param costo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Costo costo) throws NullPointerException;
    /**
     * Busca un objeto Costo en la base de datos.
     * @param costo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Costo select(Costo costo) throws NullPointerException;
    /**
     * Lista todos los objetos Costo en la base de datos.
     * @return ArrayList<Costo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Costo> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!