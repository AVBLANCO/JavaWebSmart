/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ...con el mayor de los disgustos, el benévolo señor Arciniegas.  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Usuario_has_hojaruta;

public interface IUsuario_has_hojarutaDao {

    /**
     * Guarda un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Modifica un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Elimina un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Usuario_has_hojaruta select(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Lista todos los objetos Usuario_has_hojaruta en la base de datos.
     * @return ArrayList<Usuario_has_hojaruta> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Usuario_has_hojaruta> listAll() throws NullPointerException;
    /**
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return ArrayList<Usuario_has_hojaruta> Puede contener los objetos consultados o estar vacío
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Usuario_has_hojaruta> listByUsuario(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Busca un objeto Usuario_has_hojaruta en la base de datos.
     * @param usuario_has_hojaruta objeto con la(s) llave(s) primaria(s) para consultar
     * @return ArrayList<Usuario_has_hojaruta> Puede contener los objetos consultados o estar vacío
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Usuario_has_hojaruta> listByHojaruta(Usuario_has_hojaruta usuario_has_hojaruta) throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!