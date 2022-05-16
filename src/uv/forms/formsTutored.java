package uv.forms;

import uv.fei.tutorias.domain.Tutorado;
import java.util.Scanner;

public class formsTutored {

    public Tutorado registerTutored(){
        Scanner scaner = new Scanner(System.in);
        Tutorado tutoradoRegistrado = new Tutorado();
        System.out.println("Registrar tutorado ");
        System.out.printf("Matricula del tutorado: ");
        String matricula = scaner.next();tutoradoRegistrado.setMatricula(matricula);
        System.out.printf("Nombre: ");
        String bombre = scaner.next(); tutoradoRegistrado.setNombre(bombre);
        System.out.printf("Apellido Paterno: ");
        String apellidoPaterno = scaner.next();  tutoradoRegistrado.setApellidoPaterno(apellidoPaterno);
        System.out.printf("Apellido Materno: ");
        String apellidoMaterno = scaner.next();  tutoradoRegistrado.setApellidoMaterno(apellidoMaterno);
        System.out.printf("Correo: ");
        String correo = scaner.next();  tutoradoRegistrado.setCorreo(correo);
        return tutoradoRegistrado;
    }

    public Tutorado modifyTutored(){
        Scanner scaner = new Scanner(System.in);
        Tutorado tutoradoModificado = new Tutorado();
        System.out.println("Modficar tutorado ");
        System.out.printf("Matricula del tutorado: ");
        String matricula = scaner.next();tutoradoModificado.setMatricula(matricula);
        System.out.printf("Nombre: ");
        String bombre = scaner.next(); tutoradoModificado.setNombre(bombre);
        System.out.printf("Apellido Paterno: ");
        String apellidoPaterno = scaner.next();  tutoradoModificado.setApellidoPaterno(apellidoPaterno);
        System.out.printf("Apellido Materno: ");
        String apellidoMaterno = scaner.next();  tutoradoModificado.setApellidoMaterno(apellidoMaterno);
        System.out.printf("Correo: ");
        String correo = scaner.next();  tutoradoModificado.setCorreo(correo);
        return tutoradoModificado;
    }
        
    public String deletEnrollment (){
        Scanner scaner = new Scanner(System.in);
        System.out.println("Eliminar tutorado ");
        System.out.println("Matricula de tutorado a eliminar ");
        String enrollment = scaner.next();
        return enrollment;
    }
       
    

}
