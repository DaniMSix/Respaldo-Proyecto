package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import static uv.fei.tutorias.bussinesslogic.HorarioDAO.log;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public class SesionTutoriaDAO implements ISesionTutoriaDAO {
    
    final static Logger log = Logger.getLogger(SesionTutoriaDAO.class);

    
    @Override
    public int registrarSesionTutoria(SesionTutoria sesionTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaTutoria = sesionTutoria.getFechaTutoria();
            String numTutoria = sesionTutoria.getNumTutoria();
            int idPeriodo = sesionTutoria.getIdPeriodo();
            String query = "INSERT INTO tutorias (NumeroTutoria, FechaTutoria, IdPeriodo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numTutoria);
            statement.setString(2, fechaTutoria);
            statement.setInt(3, idPeriodo);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    

    @Override
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada) {
        ArrayList<SesionTutoria> sesiones= new ArrayList<>();
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
                    sesiones.add(sesionTutoria);
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
        return sesiones;
    }

    @Override
    public int registrarFechaDeCierreDeReporte(SesionTutoria sesionTutoria, int idTutoria) {

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            
            String numeroTutoria = sesionTutoria.getNumTutoria();
            String fechaCierreReporte = sesionTutoria.getFechaCierreReportes();
            String query = "INSERT INTO tutorias (NumeroTutoria,FechaCierreReportes) VALUES (?,?) WHERE IdTutoria = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idTutoria);
            statement.setString(1, numeroTutoria);
            statement.setString(2, fechaCierreReporte);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public List<SesionTutoria> consultarTutoriaPorId(int idTutoriaBuscada) {
        ArrayList<SesionTutoria> sesiones= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias WHERE IdTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idTutoriaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron sesiones de tutorias registradas");
            }else{
                //int idSesionTutoria;
                String fechaCierreReportes;
                do {
                    //idSesionTutoria = resultSet.getInt("IdTutoria");
                    fechaCierreReportes = resultSet.getString("FechaCierreReportes");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    //sesionTutoria.setIdSesionTutoria(idSesionTutoria);
                    sesionTutoria.setFechaCierreReportes(fechaCierreReportes);
                    sesiones.add(sesionTutoria);
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
        return sesiones;
    }

    @Override
    public int buscarPeriodoPorId(String fechaInicio, String fechaFin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizarFechasDeSesionTutoria(SesionTutoria sesionTutoria) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String numeroTutoria = sesionTutoria.getNumTutoria();
            String fechaCierreReporte = sesionTutoria.getFechaCierreReportes();
            String query =
                    ("UPDATE tutorias SET NumeroTutoria = ?, FechaTutoria = ? WHERE IdTutoria = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numeroTutoria);
            statement.setString(2, fechaCierreReporte);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasActualizadas;
    }

    
    
}

