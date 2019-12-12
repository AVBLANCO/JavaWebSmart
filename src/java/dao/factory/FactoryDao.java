/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    ¡¡Bienvenido al mundo del mañana!!  \\
package back.dao.factory;

import back.dao.conexion.Conexion;
import back.dao.entities.AgroclimatologiaDao;
import back.dao.entities.BalancehidricoDao;
import back.dao.entities.BiologiasueloDao;
import back.dao.entities.ConversionenergeticaDao;
import back.dao.entities.CostoDao;
import back.dao.entities.EscenarioDao;
import back.dao.entities.EvotranspiracionDao;
import back.dao.entities.FincaDao;
import back.dao.entities.FisicasueloDao;
import back.dao.entities.HistoricoDao;
import back.dao.entities.HojarutaDao;
import back.dao.entities.LaborDao;
import back.dao.entities.LecturabalancehidricoDao;
import back.dao.entities.LecturabiologiasueloDao;
import back.dao.entities.LecturaconversionenergeticaDao;
import back.dao.entities.LecturaevotranspiracionDao;
import back.dao.entities.LecturafisicasueloDao;
import back.dao.entities.LecturamanejointegradoenfermedadesDao;
import back.dao.entities.LecturamanejoplagaDao;
import back.dao.entities.LecturaquimicasueloDao;
import back.dao.entities.LoteDao;
import back.dao.entities.ManejointegradoenfermedadesDao;
import back.dao.entities.ManejointegradoplagasDao;
import back.dao.entities.MetaDao;
import back.dao.entities.MetricabalancehidricoDao;
import back.dao.entities.MetricabiologiasueloDao;
import back.dao.entities.MetricaconversionenergeticaDao;
import back.dao.entities.MetricaevotranspiracionDao;
import back.dao.entities.MetricamanejointegradoenfermedadesDao;
import back.dao.entities.MetricamanejoplagasDao;
import back.dao.entities.MetricaquimicasueloDao;
import back.dao.entities.MetricassueloDao;
import back.dao.entities.MiagroempresaDao;
import back.dao.entities.MipeDao;
import back.dao.entities.PersonaDao;
import back.dao.entities.ProyeccionDao;
import back.dao.entities.QuimicasueloDao;
import back.dao.entities.RolDao;
import back.dao.entities.SistemaDao;
import back.dao.entities.SueloDao;
import back.dao.entities.UsuarioDao;
import back.dao.entities.Usuario_has_hojarutaDao;

import back.dao.interfaz.*;

public class FactoryDao implements IFactoryDao{

public static final int NULL_GESTOR = -1;
public static final int MYSQL_FACTORY = 0;
public static final int POSTGRESQL_FACTORY = 1;
public static final int ORACLE_FACTORY = 2;
public static final int DERBY_FACTORY = 3;

private final Conexion conn;

    public FactoryDao(int gestor) {
        this.conn=new Conexion(gestor);
    }
     /**
     * Devuelve una instancia de AgroclimatologiaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de AgroclimatologiaDao
     */
     @Override
     public IAgroclimatologiaDao getAgroclimatologiaDao(String dbName){
         return new AgroclimatologiaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de BalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de BalancehidricoDao
     */
     @Override
     public IBalancehidricoDao getBalancehidricoDao(String dbName){
         return new BalancehidricoDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de BiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de BiologiasueloDao
     */
     @Override
     public IBiologiasueloDao getBiologiasueloDao(String dbName){
         return new BiologiasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de ConversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ConversionenergeticaDao
     */
     @Override
     public IConversionenergeticaDao getConversionenergeticaDao(String dbName){
         return new ConversionenergeticaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de CostoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de CostoDao
     */
     @Override
     public ICostoDao getCostoDao(String dbName){
         return new CostoDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de EscenarioDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de EscenarioDao
     */
     @Override
     public IEscenarioDao getEscenarioDao(String dbName){
         return new EscenarioDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de EvotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de EvotranspiracionDao
     */
     @Override
     public IEvotranspiracionDao getEvotranspiracionDao(String dbName){
         return new EvotranspiracionDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de FincaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de FincaDao
     */
     @Override
     public IFincaDao getFincaDao(String dbName){
         return new FincaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de FisicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de FisicasueloDao
     */
     @Override
     public IFisicasueloDao getFisicasueloDao(String dbName){
         return new FisicasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de HistoricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de HistoricoDao
     */
     @Override
     public IHistoricoDao getHistoricoDao(String dbName){
         return new HistoricoDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de HojarutaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de HojarutaDao
     */
     @Override
     public IHojarutaDao getHojarutaDao(String dbName){
         return new HojarutaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LaborDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LaborDao
     */
     @Override
     public ILaborDao getLaborDao(String dbName){
         return new LaborDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturabalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturabalancehidricoDao
     */
     @Override
     public ILecturabalancehidricoDao getLecturabalancehidricoDao(String dbName){
         return new LecturabalancehidricoDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturabiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturabiologiasueloDao
     */
     @Override
     public ILecturabiologiasueloDao getLecturabiologiasueloDao(String dbName){
         return new LecturabiologiasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturaconversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaconversionenergeticaDao
     */
     @Override
     public ILecturaconversionenergeticaDao getLecturaconversionenergeticaDao(String dbName){
         return new LecturaconversionenergeticaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturaevotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaevotranspiracionDao
     */
     @Override
     public ILecturaevotranspiracionDao getLecturaevotranspiracionDao(String dbName){
         return new LecturaevotranspiracionDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturafisicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturafisicasueloDao
     */
     @Override
     public ILecturafisicasueloDao getLecturafisicasueloDao(String dbName){
         return new LecturafisicasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturamanejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturamanejointegradoenfermedadesDao
     */
     @Override
     public ILecturamanejointegradoenfermedadesDao getLecturamanejointegradoenfermedadesDao(String dbName){
         return new LecturamanejointegradoenfermedadesDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturamanejoplagaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturamanejoplagaDao
     */
     @Override
     public ILecturamanejoplagaDao getLecturamanejoplagaDao(String dbName){
         return new LecturamanejoplagaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LecturaquimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaquimicasueloDao
     */
     @Override
     public ILecturaquimicasueloDao getLecturaquimicasueloDao(String dbName){
         return new LecturaquimicasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de LoteDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LoteDao
     */
     @Override
     public ILoteDao getLoteDao(String dbName){
         return new LoteDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de ManejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ManejointegradoenfermedadesDao
     */
     @Override
     public IManejointegradoenfermedadesDao getManejointegradoenfermedadesDao(String dbName){
         return new ManejointegradoenfermedadesDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de ManejointegradoplagasDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ManejointegradoplagasDao
     */
     @Override
     public IManejointegradoplagasDao getManejointegradoplagasDao(String dbName){
         return new ManejointegradoplagasDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetaDao
     */
     @Override
     public IMetaDao getMetaDao(String dbName){
         return new MetaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricabalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricabalancehidricoDao
     */
     @Override
     public IMetricabalancehidricoDao getMetricabalancehidricoDao(String dbName){
         return new MetricabalancehidricoDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricabiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricabiologiasueloDao
     */
     @Override
     public IMetricabiologiasueloDao getMetricabiologiasueloDao(String dbName){
         return new MetricabiologiasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricaconversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaconversionenergeticaDao
     */
     @Override
     public IMetricaconversionenergeticaDao getMetricaconversionenergeticaDao(String dbName){
         return new MetricaconversionenergeticaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricaevotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaevotranspiracionDao
     */
     @Override
     public IMetricaevotranspiracionDao getMetricaevotranspiracionDao(String dbName){
         return new MetricaevotranspiracionDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricamanejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricamanejointegradoenfermedadesDao
     */
     @Override
     public IMetricamanejointegradoenfermedadesDao getMetricamanejointegradoenfermedadesDao(String dbName){
         return new MetricamanejointegradoenfermedadesDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricamanejoplagasDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricamanejoplagasDao
     */
     @Override
     public IMetricamanejoplagasDao getMetricamanejoplagasDao(String dbName){
         return new MetricamanejoplagasDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricaquimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaquimicasueloDao
     */
     @Override
     public IMetricaquimicasueloDao getMetricaquimicasueloDao(String dbName){
         return new MetricaquimicasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MetricassueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricassueloDao
     */
     @Override
     public IMetricassueloDao getMetricassueloDao(String dbName){
         return new MetricassueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MiagroempresaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MiagroempresaDao
     */
     @Override
     public IMiagroempresaDao getMiagroempresaDao(String dbName){
         return new MiagroempresaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de MipeDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MipeDao
     */
     @Override
     public IMipeDao getMipeDao(String dbName){
         return new MipeDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de PersonaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de PersonaDao
     */
     @Override
     public IPersonaDao getPersonaDao(String dbName){
         return new PersonaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de ProyeccionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ProyeccionDao
     */
     @Override
     public IProyeccionDao getProyeccionDao(String dbName){
         return new ProyeccionDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de QuimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de QuimicasueloDao
     */
     @Override
     public IQuimicasueloDao getQuimicasueloDao(String dbName){
         return new QuimicasueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de RolDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de RolDao
     */
     @Override
     public IRolDao getRolDao(String dbName){
         return new RolDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de SistemaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de SistemaDao
     */
     @Override
     public ISistemaDao getSistemaDao(String dbName){
         return new SistemaDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de SueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de SueloDao
     */
     @Override
     public ISueloDao getSueloDao(String dbName){
         return new SueloDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de UsuarioDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de UsuarioDao
     */
     @Override
     public IUsuarioDao getUsuarioDao(String dbName){
         return new UsuarioDao(this.conn.obtener(dbName));
     }
     /**
     * Devuelve una instancia de Usuario_has_hojarutaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de Usuario_has_hojarutaDao
     */
     @Override
     public IUsuario_has_hojarutaDao getUsuario_has_hojarutaDao(String dbName){
         return new Usuario_has_hojarutaDao(this.conn.obtener(dbName));
     }

}
//That`s all folks!