/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ya están los patrones implementados, ahora sí viene lo chido...  \\
package back.dao.interfaz;

public interface IFactoryDao {
	
     /**
     * Devuelve una instancia de AgroclimatologiaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de AgroclimatologiaDao
     */
     public IAgroclimatologiaDao getAgroclimatologiaDao(String dbName);
     /**
     * Devuelve una instancia de BalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de BalancehidricoDao
     */
     public IBalancehidricoDao getBalancehidricoDao(String dbName);
     /**
     * Devuelve una instancia de BiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de BiologiasueloDao
     */
     public IBiologiasueloDao getBiologiasueloDao(String dbName);
     /**
     * Devuelve una instancia de ConversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ConversionenergeticaDao
     */
     public IConversionenergeticaDao getConversionenergeticaDao(String dbName);
     /**
     * Devuelve una instancia de CostoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de CostoDao
     */
     public ICostoDao getCostoDao(String dbName);
     /**
     * Devuelve una instancia de EscenarioDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de EscenarioDao
     */
     public IEscenarioDao getEscenarioDao(String dbName);
     /**
     * Devuelve una instancia de EvotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de EvotranspiracionDao
     */
     public IEvotranspiracionDao getEvotranspiracionDao(String dbName);
     /**
     * Devuelve una instancia de FincaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de FincaDao
     */
     public IFincaDao getFincaDao(String dbName);
     /**
     * Devuelve una instancia de FisicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de FisicasueloDao
     */
     public IFisicasueloDao getFisicasueloDao(String dbName);
     /**
     * Devuelve una instancia de HistoricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de HistoricoDao
     */
     public IHistoricoDao getHistoricoDao(String dbName);
     /**
     * Devuelve una instancia de HojarutaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de HojarutaDao
     */
     public IHojarutaDao getHojarutaDao(String dbName);
     /**
     * Devuelve una instancia de LaborDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LaborDao
     */
     public ILaborDao getLaborDao(String dbName);
     /**
     * Devuelve una instancia de LecturabalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturabalancehidricoDao
     */
     public ILecturabalancehidricoDao getLecturabalancehidricoDao(String dbName);
     /**
     * Devuelve una instancia de LecturabiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturabiologiasueloDao
     */
     public ILecturabiologiasueloDao getLecturabiologiasueloDao(String dbName);
     /**
     * Devuelve una instancia de LecturaconversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaconversionenergeticaDao
     */
     public ILecturaconversionenergeticaDao getLecturaconversionenergeticaDao(String dbName);
     /**
     * Devuelve una instancia de LecturaevotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaevotranspiracionDao
     */
     public ILecturaevotranspiracionDao getLecturaevotranspiracionDao(String dbName);
     /**
     * Devuelve una instancia de LecturafisicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturafisicasueloDao
     */
     public ILecturafisicasueloDao getLecturafisicasueloDao(String dbName);
     /**
     * Devuelve una instancia de LecturamanejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturamanejointegradoenfermedadesDao
     */
     public ILecturamanejointegradoenfermedadesDao getLecturamanejointegradoenfermedadesDao(String dbName);
     /**
     * Devuelve una instancia de LecturamanejoplagaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturamanejoplagaDao
     */
     public ILecturamanejoplagaDao getLecturamanejoplagaDao(String dbName);
     /**
     * Devuelve una instancia de LecturaquimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LecturaquimicasueloDao
     */
     public ILecturaquimicasueloDao getLecturaquimicasueloDao(String dbName);
     /**
     * Devuelve una instancia de LoteDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de LoteDao
     */
     public ILoteDao getLoteDao(String dbName);
     /**
     * Devuelve una instancia de ManejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ManejointegradoenfermedadesDao
     */
     public IManejointegradoenfermedadesDao getManejointegradoenfermedadesDao(String dbName);
     /**
     * Devuelve una instancia de ManejointegradoplagasDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ManejointegradoplagasDao
     */
     public IManejointegradoplagasDao getManejointegradoplagasDao(String dbName);
     /**
     * Devuelve una instancia de MetaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetaDao
     */
     public IMetaDao getMetaDao(String dbName);
     /**
     * Devuelve una instancia de MetricabalancehidricoDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricabalancehidricoDao
     */
     public IMetricabalancehidricoDao getMetricabalancehidricoDao(String dbName);
     /**
     * Devuelve una instancia de MetricabiologiasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricabiologiasueloDao
     */
     public IMetricabiologiasueloDao getMetricabiologiasueloDao(String dbName);
     /**
     * Devuelve una instancia de MetricaconversionenergeticaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaconversionenergeticaDao
     */
     public IMetricaconversionenergeticaDao getMetricaconversionenergeticaDao(String dbName);
     /**
     * Devuelve una instancia de MetricaevotranspiracionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaevotranspiracionDao
     */
     public IMetricaevotranspiracionDao getMetricaevotranspiracionDao(String dbName);
     /**
     * Devuelve una instancia de MetricamanejointegradoenfermedadesDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricamanejointegradoenfermedadesDao
     */
     public IMetricamanejointegradoenfermedadesDao getMetricamanejointegradoenfermedadesDao(String dbName);
     /**
     * Devuelve una instancia de MetricamanejoplagasDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricamanejoplagasDao
     */
     public IMetricamanejoplagasDao getMetricamanejoplagasDao(String dbName);
     /**
     * Devuelve una instancia de MetricaquimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricaquimicasueloDao
     */
     public IMetricaquimicasueloDao getMetricaquimicasueloDao(String dbName);
     /**
     * Devuelve una instancia de MetricassueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MetricassueloDao
     */
     public IMetricassueloDao getMetricassueloDao(String dbName);
     /**
     * Devuelve una instancia de MiagroempresaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MiagroempresaDao
     */
     public IMiagroempresaDao getMiagroempresaDao(String dbName);
     /**
     * Devuelve una instancia de MipeDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de MipeDao
     */
     public IMipeDao getMipeDao(String dbName);
     /**
     * Devuelve una instancia de PersonaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de PersonaDao
     */
     public IPersonaDao getPersonaDao(String dbName);
     /**
     * Devuelve una instancia de ProyeccionDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de ProyeccionDao
     */
     public IProyeccionDao getProyeccionDao(String dbName);
     /**
     * Devuelve una instancia de QuimicasueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de QuimicasueloDao
     */
     public IQuimicasueloDao getQuimicasueloDao(String dbName);
     /**
     * Devuelve una instancia de RolDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de RolDao
     */
     public IRolDao getRolDao(String dbName);
     /**
     * Devuelve una instancia de SistemaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de SistemaDao
     */
     public ISistemaDao getSistemaDao(String dbName);
     /**
     * Devuelve una instancia de SueloDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de SueloDao
     */
     public ISueloDao getSueloDao(String dbName);
     /**
     * Devuelve una instancia de UsuarioDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de UsuarioDao
     */
     public IUsuarioDao getUsuarioDao(String dbName);
     /**
     * Devuelve una instancia de Usuario_has_hojarutaDao que depende del gestor de base de datos
     * @param dbName Nombre o identificador de la base de datos a conectar
     * @return instancia de Usuario_has_hojarutaDao
     */
     public IUsuario_has_hojarutaDao getUsuario_has_hojarutaDao(String dbName);

}
//That`s all folks!