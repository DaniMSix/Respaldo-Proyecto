package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public class SesionTutoriaDAO implements ISesionTutoriaDAO {
    
    final static Logger log = Logger.getLogger(TutorDAO.class);

    
    @Override
    public int registrarSesionTutoria(SesionTutoria sesionTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaTutoria = sesionTutoria.getFechaTutoria();
            String numTutoria = sesionTutoria.getNumTutoria();
            String query = "INSERT INTO tutorias (NumeroTutoria, FechaTutoria) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numTutoria);
            statement.setString(2, fechaTutoria);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int eliminarSesionTutoriaPorId(int idTutoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada) {
        ArrayList<SesionTutoria> tutores= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias WHERE NumeroTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, tutoriaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron sesiones de tutorias registradas");
            }else{
                String numTutoria;
                String fechaTutoria;
                do {
                    numTutoria = resultSet.getString("NumeroTutoria");
                    fechaTutoria = resultSet.getString("FechaTutoria");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    sesionTutoria.setNumTutoria(numTutoria);
                    sesionTutoria.setFechaTutoria(fechaTutoria);
                    tutores.add(sesionTutoria);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
            System.out.println("Código de Error: " + ex.getErrorCode() + "\n" +
                        "SLQState: " + ex.getSQLState() + "\n" +
                        "Mensaje: " + ex.getMessage() + "\n");
            Throwable t = ex.getCause();
                System.out.println("Causa: " + t + "\n");
        }
        return tutores;
    }

    @Override
    public int registrarCierreDeReporte(SesionTutoria sesionTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaCierreReportes = sesionTutoria.getFechaCierreReportes();
            String query = "INSERT INTO tutorias (FechaCierreReportes) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(3, fechaCierreReportes);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }
    
    
}
