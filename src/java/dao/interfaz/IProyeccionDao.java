/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo.   \\

package back.dao.interfaz;
import java.util.ArrayList;
import back.dto.Proyeccion;

public interface IProyeccionDao {

    /**
     * Guarda un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public int insert(Proyeccion proyeccion) throws NullPointerException;
    /**
     * Modifica un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void update(Proyeccion proyeccion) throws NullPointerException;
    /**
     * Elimina un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public void delete(Proyeccion proyeccion) throws NullPointerException;
    /**
     * Busca un objeto Proyeccion en la base de datos.
     * @param proyeccion objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public Proyeccion select(Proyeccion proyeccion) throws NullPointerException;
    /**
     * Lista todos los objetos Proyeccion en la base de datos.
     * @return ArrayList<Proyeccion> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  public ArrayList<Proyeccion> listAll() throws NullPointerException;
    /**
     * Cierra la conexión actual a la base de datos
     */
  public void close();
}
//That`s all folks!