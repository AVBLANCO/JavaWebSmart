/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    404 Frase no encontrada  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Manejointegradoenfermedades;

public interface IManejointegradoenfermedadesDao {

    /**
     * Guarda un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException;
    /**
     * Modifica un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException;
    /**
     * Elimina un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException;
    /**
     * Busca un objeto Manejointegradoenfermedades en la base de datos.
     * @param manejointegradoenfermedades objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Manejointegradoenfermedades select(Manejointegradoenfermedades manejointegradoenfermedades) throws NullPointerException;
    /**
     * Lista todos los objetos Manejointegradoenfermedades en la base de datos.
     * @return ArrayList<Manejointegradoenfermedades> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Manejointegradoenfermedades> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!