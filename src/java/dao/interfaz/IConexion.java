/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ...Y como plato principal: ¡Código espagueti!  \\
package back.dao.interfaz;

import java.sql.*;

public interface IConexion {

    /**     
     * Crea una conexiÃ³n si no se ha establecido antes; en caso contrario, devuelve la ya existente
     * @return ConexiÃ³n a base de datos dependiente del gestor en uso
     * @param dbName Nombre de la base de datos que se desea conectar.     */
     public Connection obtener(String dbName);
     /**
     * Cierra la conexiÃ³n a la base de datos
     * @throws SQLException
     */
     public void cerrar() throws SQLException ;

}
//That`s all folks!