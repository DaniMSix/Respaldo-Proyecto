
package uv.fei.tutorias.bussinesslogic;

import java.sql.SQLException;
import java.util.List;
import uv.fei.tutorias.domain.Tutor;


public interface ITutorDAO {
 
    public int registrarTutor(Tutor tutor)throws SQLException;
    
    public List<Tutor> consultarTutorPorCuentaUv(String cuentaUVBuscada);
    
    

    
}
