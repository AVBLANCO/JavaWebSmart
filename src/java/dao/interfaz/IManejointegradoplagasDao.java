/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Antes que me hubiera apasionado por mujer alguna, jugué mi corazón al azar y me lo ganó la Violencia.  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Manejointegradoplagas;

public interface IManejointegradoplagasDao {

    /**
     * Guarda un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Manejointegradoplagas manejointegradoplagas) throws NullPointerException;
    /**
     * Modifica un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Manejointegradoplagas manejointegradoplagas) throws NullPointerException;
    /**
     * Elimina un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Manejointegradoplagas manejointegradoplagas) throws NullPointerException;
    /**
     * Busca un objeto Manejointegradoplagas en la base de datos.
     * @param manejointegradoplagas objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Manejointegradoplagas select(Manejointegradoplagas manejointegradoplagas) throws NullPointerException;
    /**
     * Lista todos los objetos Manejointegradoplagas en la base de datos.
     * @return ArrayList<Manejointegradoplagas> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Manejointegradoplagas> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!