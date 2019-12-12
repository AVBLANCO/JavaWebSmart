/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Has escuchado hablar del grandioso señor Arciniegas?  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Mipe;

public interface IMipeDao {

    /**
     * Guarda un objeto Mipe en la base de datos.
     * @param mipe objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Mipe mipe) throws NullPointerException;
    /**
     * Modifica un objeto Mipe en la base de datos.
     * @param mipe objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Mipe mipe) throws NullPointerException;
    /**
     * Elimina un objeto Mipe en la base de datos.
     * @param mipe objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Mipe mipe) throws NullPointerException;
    /**
     * Busca un objeto Mipe en la base de datos.
     * @param mipe objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Mipe select(Mipe mipe) throws NullPointerException;
    /**
     * Lista todos los objetos Mipe en la base de datos.
     * @return ArrayList<Mipe> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Mipe> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!