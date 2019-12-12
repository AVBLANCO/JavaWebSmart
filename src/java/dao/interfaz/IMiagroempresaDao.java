/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Yo tengo un sueño. El sueño de que mis hijos vivan en un mundo con un único lenguaje de programación.  \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Miagroempresa;

public interface IMiagroempresaDao {

    /**
     * Guarda un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Miagroempresa miagroempresa) throws NullPointerException;
    /**
     * Modifica un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Miagroempresa miagroempresa) throws NullPointerException;
    /**
     * Elimina un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Miagroempresa miagroempresa) throws NullPointerException;
    /**
     * Busca un objeto Miagroempresa en la base de datos.
     * @param miagroempresa objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Miagroempresa select(Miagroempresa miagroempresa) throws NullPointerException;
    /**
     * Lista todos los objetos Miagroempresa en la base de datos.
     * @return ArrayList<Miagroempresa> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Miagroempresa> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!