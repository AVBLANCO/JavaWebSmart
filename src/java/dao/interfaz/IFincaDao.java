/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Cuenta la leyenda que si gritas 'Soy programador' las nenas caerán a tus pies  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Finca;

public interface IFincaDao {

    /**
     * Guarda un objeto Finca en la base de datos.
     * @param finca objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Finca finca) throws NullPointerException;
    /**
     * Modifica un objeto Finca en la base de datos.
     * @param finca objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Finca finca) throws NullPointerException;
    /**
     * Elimina un objeto Finca en la base de datos.
     * @param finca objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Finca finca) throws NullPointerException;
    /**
     * Busca un objeto Finca en la base de datos.
     * @param finca objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Finca select(Finca finca) throws NullPointerException;
    /**
     * Lista todos los objetos Finca en la base de datos.
     * @return ArrayList<Finca> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Finca> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!