package uv.fei.tutorias.bussinesslogic;

import java.sql.SQLException;
import java.util.List;
import uv.fei.tutorias.domain.Periodo;


public interface IPeriodoDAO {
    
    public List<Periodo> consultarPeriodoTodosLosPeriodos();
    
    public List<Periodo> consultarPeriodoFechaInicio();
    
    public List<Periodo> consultarPeriodoPorId(int idPeriodoBuscado);
    
    public int registrarPeriodo(Periodo periodo);

    public int eliminarPeriodoId(int idPeriodo);

    public int actualizarPeriodo(Periodo periodo);
    
    public int buscarFechasDelPeriodo(String fechaInicio, String fechaFin);
    
    public boolean comprobarSiExistePeriodo(String fechaInicio, String fechaFin);
    
    public Periodo consultarPeriodoActivo() throws SQLException;
}
