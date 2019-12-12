/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Recuerda, cuando enciendas la molotov, debes arrojarla  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturamanejoplaga;

public interface ILecturamanejoplagaDao {

    /**
     * Guarda un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException;
    /**
     * Modifica un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException;
    /**
     * Elimina un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException;
    /**
     * Busca un objeto Lecturamanejoplaga en la base de datos.
     * @param lecturamanejoplaga objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturamanejoplaga select(Lecturamanejoplaga lecturamanejoplaga) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturamanejoplaga en la base de datos.
     * @return ArrayList<Lecturamanejoplaga> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturamanejoplaga> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!