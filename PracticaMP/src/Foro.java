package practica.mp2;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
class Foro {

    private List <SubForo> ListaSubForos= new LinkedList<>();
    private List <Usuarios> ListaUsuarios = new LinkedList<>();


    public void Welcome(){

        System.out.println("Bienvenido al foro");
        System.out.println("Que deseas hacer");
        System.out.println("1.Iniciar Sesion sin registro");
        System.out.println("2.Iniciar Sesion registrado");
        System.out.println("3.Registrarse");

        Scanner Sc = new Scanner(System.in);
        Scanner Sc2 = new Scanner(System.in);
        Scanner Sc3 = new Scanner(System.in);
        int opcion = Sc.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Introduce un nick");
                String Nick = Sc2.nextLine();
            break;
            case 2:
                System.out.println("Introduce tu correo");
                String nombre = Sc2.nextLine();
                System.out.println("Intoduce tu contraseña");
                String contraseña= Sc3.nextLine();

            break;

        }
        System.out.println("Hola que tal");
        System.out.println("Fetch");
        System.out.println("Este comentario es si funciona todo bien");
        System.out.println("comentario de Miriam");
    }




}
