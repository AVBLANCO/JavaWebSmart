/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    El coronel necesitó setenta y cinco años -los setenta y cinco años de su vida, minuto a minuto- para llegar a ese instante. Se sintió puro, explícito, invencible, en el momento de responder:  \\

package back.dao.entities;
import java.sql.*;
import back.dao.interfaz.IPersonaDao;
import back.dto.*;
import java.util.ArrayList;

public class PersonaDao implements IPersonaDao{

private Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada consulta.
     */
    public PersonaDao(Connection conexion) {
            this.cn =conexion;
    }

    /**
     * Guarda un objeto Persona en la base de datos.
     * @param persona objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public int insert(Persona persona) throws NullPointerException{
      int last_inserted_id =-1;
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "INSERT INTO `persona`( `idpersona`, `nombrePersona`, `cedulaPersona`, `correoPersona`, `fechaNacimientoPersona`, `genero`)"
          +"VALUES (?,?,?,?,?,?),Statement.RETURN_GENERATED_KEYS");
          consulta.setInt(1, persona.getIdpersona());
          consulta.setString(2, persona.getNombrePersona());
          consulta.setString(3, persona.getCedulaPersona());
          consulta.setString(4, persona.getCorreoPersona());
          consulta.setString(5, persona.getFechaNacimientoPersona());
          consulta.setString(6, persona.getGenero());
          consulta.executeUpdate();
          ResultSet rs = consulta.getGeneratedKeys();
          if(rs.next()){
              last_inserted_id = rs.getInt(1);
          }
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      return last_inserted_id;
  }

    /**
     * Busca un objeto Persona en la base de datos.
     * @param persona objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public Persona select(Persona persona) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idpersona`, `nombrePersona`, `cedulaPersona`, `correoPersona`, `fechaNacimientoPersona`, `genero`"
          +"FROM `persona`"
          +"WHERE `idpersona`=?");
          consulta.setInt(1, persona.getIdpersona());

          ResultSet res = consulta.executeQuery();
          while(res.next()){
          persona.setIdpersona(res.getInt("idpersona"));
          persona.setNombrePersona(res.getString("nombrePersona"));
          persona.setCedulaPersona(res.getString("cedulaPersona"));
          persona.setCorreoPersona(res.getString("correoPersona"));
          persona.setFechaNacimientoPersona(res.getString("fechaNacimientoPersona"));
          persona.setGenero(res.getString("genero"));

          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return persona;
  }

    /**
     * Modifica un objeto Persona en la base de datos.
     * @param persona objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void update(Persona persona) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "UPDATE `persona` SET`idpersona`=?, `nombrePersona`=?, `cedulaPersona`=?, `correoPersona`=?, `fechaNacimientoPersona`=?, `genero`=? WHERE `idpersona`=? ");
          consulta.setInt(1, persona.getIdpersona());
          consulta.setString(2, persona.getNombrePersona());
          consulta.setString(3, persona.getCedulaPersona());
          consulta.setString(4, persona.getCorreoPersona());
          consulta.setString(5, persona.getFechaNacimientoPersona());
          consulta.setString(6, persona.getGenero());
          consulta.setInt(7, persona.getIdpersona());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Elimina un objeto Persona en la base de datos.
     * @param persona objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public void delete(Persona persona) throws NullPointerException{
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "DELETE FROM `persona` WHERE `idpersona`=?");
          consulta.setInt(1, persona.getIdpersona());

          consulta.executeUpdate();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

    /**
     * Lista todos los objetos Persona en la base de datos.
     * @return ArrayList<Persona> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves foraneas son null
     */
  @Override
  public ArrayList<Persona> listAll() throws NullPointerException{
      ArrayList<Persona> lista = new ArrayList();
      try {
          PreparedStatement consulta = cn.prepareStatement(
          "SELECT `idpersona`, `nombrePersona`, `cedulaPersona`, `correoPersona`, `fechaNacimientoPersona`, `genero`"
          +"FROM `persona`"
          +"WHERE 1");
          ResultSet res = consulta.executeQuery();
          while(res.next()){
              Persona persona= new Persona();
          persona.setIdpersona(res.getInt("idpersona"));
          persona.setNombrePersona(res.getString("nombrePersona"));
          persona.setCedulaPersona(res.getString("cedulaPersona"));
          persona.setCorreoPersona(res.getString("correoPersona"));
          persona.setFechaNacimientoPersona(res.getString("fechaNacimientoPersona"));
          persona.setGenero(res.getString("genero"));

              lista.add(persona);
          }
          res.close();
          consulta.close();
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          return null;
      }
      return lista;
  }

    /**
     * Cierra la conexión actual a la base de datos
     */
  @Override
  public void close(){
      try {
        cn.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
  }
}
//That`s all folks!