/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.util.List;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public interface ISesionTutoriaDAO {
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada);

    public int registrarSesionTutoria(SesionTutoria sesionTutoria);

    public int registrarCierreDeReporte(SesionTutoria sesionTutoria);

    public int eliminarSesionTutoriaPorId(int idTutoria);
}



    