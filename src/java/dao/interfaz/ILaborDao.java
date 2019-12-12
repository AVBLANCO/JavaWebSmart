/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    El gran hermano te vigila  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Labor;

public interface ILaborDao {

    /**
     * Guarda un objeto Labor en la base de datos.
     * @param labor objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Labor labor) throws NullPointerException;
    /**
     * Modifica un objeto Labor en la base de datos.
     * @param labor objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Labor labor) throws NullPointerException;
    /**
     * Elimina un objeto Labor en la base de datos.
     * @param labor objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Labor labor) throws NullPointerException;
    /**
     * Busca un objeto Labor en la base de datos.
     * @param labor objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Labor select(Labor labor) throws NullPointerException;
    /**
     * Lista todos los objetos Labor en la base de datos.
     * @return ArrayList<Labor> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Labor> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!