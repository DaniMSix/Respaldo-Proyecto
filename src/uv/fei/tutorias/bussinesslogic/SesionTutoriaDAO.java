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


public class SesionTutoriaDAO implements ISesionTutoriaDAO {
    
    final static Logger log = Logger.getLogger(SesionTutoriaDAO.class);

    
    @Override
    public int registrarSesionTutoria(SesionTutoria sesionTutoria) throws SQLException{
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
    public int actualizarFechasDeSesionTutoria(SesionTutoria sesionTutoria, int idPeriodo, String numTutoria) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaTutoria = sesionTutoria.getFechaTutoria();
            String query = "UPDATE tutorias SET FechaTutoria = ? WHERE tutorias.IdPeriodo = ? AND tutorias.NumeroTutoria = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fechaTutoria);
            statement.setInt(2, idPeriodo);
            statement.setString(3, numTutoria);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasActualizadas;
    }

    @Override
    public int registrarFechaDeCierreDeReporte(SesionTutoria sesionTutoria, int idPeriodo, String numTutoria) throws SQLException{
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaCierreReporte = sesionTutoria.getFechaCierreReportes();
            String query = "UPDATE tutorias SET FechaCierreReportes = ? WHERE tutorias.IdPeriodo = ? AND tutorias.NumeroTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,fechaCierreReporte);
            statement.setInt(2,idPeriodo);
            statement.setString(3, numTutoria);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    
    
}

