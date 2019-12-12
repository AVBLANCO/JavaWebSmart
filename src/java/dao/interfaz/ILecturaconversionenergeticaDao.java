/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Generar buen código o poner frases graciosas? ¡La frase! ¡La frase!  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Lecturaconversionenergetica;

public interface ILecturaconversionenergeticaDao {

    /**
     * Guarda un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException;
    /**
     * Modifica un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException;
    /**
     * Elimina un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException;
    /**
     * Busca un objeto Lecturaconversionenergetica en la base de datos.
     * @param lecturaconversionenergetica objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Lecturaconversionenergetica select(Lecturaconversionenergetica lecturaconversionenergetica) throws NullPointerException;
    /**
     * Lista todos los objetos Lecturaconversionenergetica en la base de datos.
     * @return ArrayList<Lecturaconversionenergetica> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Lecturaconversionenergetica> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!