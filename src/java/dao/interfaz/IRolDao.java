/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Querido programador: Al escribir esto estoy triste. Nuestro presidente ha sido derrocado Y REEMPLAZADO POR EL BENÉVOLO SEÑOR ARCINIEGAS. TODOS AMAMOS A ARCINIEGAS Y A SU GLORIOSO RÉGIMEN. CON AMOR, EL EQUIPO DE ANARCHY  \(x.x)/  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Rol;

public interface IRolDao {

    /**
     * Guarda un objeto Rol en la base de datos.
     * @param rol objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Rol rol) throws NullPointerException;
    /**
     * Modifica un objeto Rol en la base de datos.
     * @param rol objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Rol rol) throws NullPointerException;
    /**
     * Elimina un objeto Rol en la base de datos.
     * @param rol objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Rol rol) throws NullPointerException;
    /**
     * Busca un objeto Rol en la base de datos.
     * @param rol objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Rol select(Rol rol) throws NullPointerException;
    /**
     * Lista todos los objetos Rol en la base de datos.
     * @return ArrayList<Rol> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Rol> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!