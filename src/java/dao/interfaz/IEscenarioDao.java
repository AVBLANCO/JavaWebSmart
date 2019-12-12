/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Más delgado  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Escenario;

public interface IEscenarioDao {

    /**
     * Guarda un objeto Escenario en la base de datos.
     * @param escenario objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Escenario escenario) throws NullPointerException;
    /**
     * Modifica un objeto Escenario en la base de datos.
     * @param escenario objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Escenario escenario) throws NullPointerException;
    /**
     * Elimina un objeto Escenario en la base de datos.
     * @param escenario objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Escenario escenario) throws NullPointerException;
    /**
     * Busca un objeto Escenario en la base de datos.
     * @param escenario objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Escenario select(Escenario escenario) throws NullPointerException;
    /**
     * Lista todos los objetos Escenario en la base de datos.
     * @return ArrayList<Escenario> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Escenario> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!