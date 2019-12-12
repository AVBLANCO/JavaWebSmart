/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡¡Bienvenido al mundo del mañana!!  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturaevotranspiracion;

public interface ILecturaevotranspiracionDao {

    /**
     * Guarda un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException;
    /**
     * Modifica un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException;
    /**
     * Elimina un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException;
    /**
     * Busca un objeto Lecturaevotranspiracion en la base de datos.
     * @param lecturaevotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturaevotranspiracion select(Lecturaevotranspiracion lecturaevotranspiracion) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturaevotranspiracion en la base de datos.
     * @return ArrayList<Lecturaevotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturaevotranspiracion> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!