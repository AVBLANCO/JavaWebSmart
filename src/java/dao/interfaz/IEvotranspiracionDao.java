/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ...Y como plato principal: ¡Código espagueti!  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Evotranspiracion;

public interface IEvotranspiracionDao {

    /**
     * Guarda un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Evotranspiracion evotranspiracion) throws NullPointerException;
    /**
     * Modifica un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Evotranspiracion evotranspiracion) throws NullPointerException;
    /**
     * Elimina un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Evotranspiracion evotranspiracion) throws NullPointerException;
    /**
     * Busca un objeto Evotranspiracion en la base de datos.
     * @param evotranspiracion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Evotranspiracion select(Evotranspiracion evotranspiracion) throws NullPointerException;
    /**
     * Lista todos los objetos Evotranspiracion en la base de datos.
     * @return ArrayList<Evotranspiracion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Evotranspiracion> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!