/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¿Sabías que hay una vida afuera de tu cuarto?  \\

package back.dao.conexion;

import back.dao.factory.FactoryDao;
import back.dao.interfaz.IConexion;
import java.sql.*;
import java.io.*;

public class Conexion implements IConexion{

   private Connection cnx = null;
private String className="NULL_GESTOR";
   private String jdbc="NULL_GESTOR";
   
    public Conexion(int gestor) {
        switch (gestor){
            case FactoryDao.MYSQL_FACTORY:{
                this.className="com.mysql.jdbc.Driver";
                this.jdbc="jdbc:mysql:";
                break;
            }
            case FactoryDao.POSTGRESQL_FACTORY:{
                this.className="org.postgresql.Driver";
                this.jdbc="jdbc:postgresql:";
                break;
            }
            case FactoryDao.ORACLE_FACTORY:{
                this.className="oracle.jdbc.driver.OracleDriver";
                this.jdbc="jdbc:oracle:";
                break;
            }
            case FactoryDao.DERBY_FACTORY:{
                this.className="org.apache.derby.jdbc.ClientDriver";
                this.jdbc="jdbc:derby:";
                break;
            }
        }
    }

    /**     
     * Crea una conexiÃ³n si no se ha establecido antes; en caso contrario, devuelve la ya existente
     * Toma los parÃ¡metros de conexiÃ³n de la clase Properties y usa el driver mysql.jdbc para establecer una conexiÃ³n. 
     * @return ConexiÃ³n a base de datos mySql
     * @param dbName Nombre de la base de datos que se desea conectar     */
@Override
   public Connection obtener(String dbName){
      if (cnx == null) {
         try {
            Class.forName(this.className);
             String[] array=this.leerProperties(dbName);
            cnx = DriverManager.getConnection(this.jdbc+"//"+array[0]+"/"+dbName, array[1], array[2]);
         } catch (SQLException ex) {
            System.out.println(ex);
         } catch (ClassNotFoundException ex) {
            System.out.println(ex);
         }
      }
      return cnx;
   }

     /**
     * Cierra la conexiÃ³n a la base de datos
     * @throws SQLException
     */
@Override
   public void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }

     /**
     * Busca los parÃ¡metros de conexiÃ³n de la base de datos seleccionada
     * @param bdName Nombre de la base de datos a conectar
     * @return array String[0]=Host, String[1]=username, String[2]=password 
     * @throws SQLException
     */
   private String[] leerProperties(String bdName){
       String SEP=System.getProperty("file.separator");
       File root=new File("");
       File f=new File(root.getAbsolutePath()+SEP+"src"+SEP+"back"+SEP+"dao"+SEP+"properties"+SEP+"Properties.ini");
       String[] array = new String[3];
       Boolean encontrado=false;
       try{
       BufferedReader br=new BufferedReader(new FileReader(f.getAbsolutePath()));
       String linea=br.readLine();
       while(linea!=null){    
         if(linea.startsWith(";") || (linea.trim().isEmpty())){
             linea= br.readLine(); 
             continue;
         }
         if(!encontrado){
             if(linea.contains("["+bdName+"]")){
                 encontrado=true;
                 linea= br.readLine(); 
             }
         }else{
             if(linea.contains(";")){
                     linea=linea.substring(0,linea.indexOf(";"));
                 }
             if(linea.contains("host=")){
                 linea=linea.trim();
                 linea=linea.replace("host=","");
                 array[0]=linea;
             }else if(linea.contains("username=")){
                 linea=linea.trim();
                 linea=linea.replace("username=","");
                 array[1]=linea;
             }else if(linea.contains("password=")){
                 linea=linea.trim();
                 linea=linea.replace("password=","");
                 array[2]=linea;
             }
             linea= br.readLine();          }        }
         } catch (FileNotFoundException ex) {
            System.out.println("Archivo properties.ini no encontrado");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Archivo properties.ini no pudo ser leido");
            ex.printStackTrace();
        }
       return array;
   }

}
//That`s all folks!