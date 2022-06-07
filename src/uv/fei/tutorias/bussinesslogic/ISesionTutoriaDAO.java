package uv.fei.tutorias.bussinesslogic;

import java.sql.SQLException;
import java.util.List;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public interface ISesionTutoriaDAO {
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada);

    public int registrarSesionTutoria(SesionTutoria sesionTutoria);

    public int registrarFechaDeCierreDeReporte(SesionTutoria sesionTutoria, int idTutoria);
    
    public int buscarPeriodoPorId(String fechaInicio, String fechaFin);
    
    public List<SesionTutoria> consultarTutoriaPorId(int idTutoriaBuscada);
    
    public int actualizarFechasDeSesionTutoria(SesionTutoria sesionTutoria) throws SQLException;
}



    