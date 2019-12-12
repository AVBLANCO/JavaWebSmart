/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Quédate con quien te quiera por tu back-end, no por tu front-end  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturamanejointegradoenfermedades;

public interface ILecturamanejointegradoenfermedadesDao {

    /**
     * Guarda un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Modifica un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Elimina un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Busca un objeto Lecturamanejointegradoenfermedades en la base de datos.
     * @param lecturamanejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturamanejointegradoenfermedades select(Lecturamanejointegradoenfermedades lecturamanejointegradoenfermedades) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturamanejointegradoenfermedades en la base de datos.
     * @return ArrayList<Lecturamanejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturamanejointegradoenfermedades> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!