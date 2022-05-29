package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Tutor;
import org.apache.log4j.Logger;


public class TutorDAO implements ITutorDAO{
    
    final static Logger log = Logger.getLogger(TutorDAO.class);

    @Override
    public int registrarTutor(Tutor tutor) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String cuentaUv = tutor.getCuentaUV();
            String contrasena = tutor.getPassword();
            String nombre = tutor.getNombre();
            String apellidoPaterno = tutor.getApellidoPaterno();
            String apellidoMaterno = tutor.getApellidoMaterno();
            String correo = tutor.getCorreo();
            String query = "INSERT INTO usuarios (cuentauv, contrasena, Nombre, ApellidoPaterno, ApellidoMaterno, correo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cuentaUv);
            statement.setString(2, contrasena);
            statement.setString(3, nombre);
            statement.setString(4, apellidoPaterno);
            statement.setString(5, apellidoMaterno);
            statement.setString(6, correo);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public List<Tutor> consultarTutorPorCuentaUv(String cuentaUVBuscada) {
        ArrayList<Tutor> tutores= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM usuarios WHERE cuentauv = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentaUVBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron cuentasUV");
            }else{
                String cuentaUV;
                String contrasena;
                String nombre;
                String apellidoMaterno;
                String apellidoPaterno;
                String correo;
                do {
                    cuentaUV = resultSet.getString("cuentauv");
                    contrasena = resultSet.getString("contrasena");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    correo = resultSet.getString("Correo");
                    Tutor tutor = new Tutor();
                    tutor.setCuentaUV(cuentaUV);
                    tutor.setPassword(contrasena);
                    tutor.setNombre(nombre);
                    tutor.setApellidoPaterno(apellidoPaterno);
                    tutor.setApellidoMaterno(apellidoMaterno);
                    tutor.setCorreo(correo);
                    tutores.add(tutor);
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

}
