/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
class Foro {
    
    private List <Usuarios> ListaUsuarios=new LinkedList<>();
    private List <SubForos> ListaSubForos=new LinkedList<>();
    
    public void Welcome(){
        
        System.out.println("Bienvenido al Foro");
        System.out.println("1.Iniciar sesion sin registro");
        System.out.println("2.Iniciar sesion registrado");
        System.out.println("3.Registrarse");
        Scanner Sc = new Scanner(System.in);
        
        int opcion = Sc.nextInt();
        
        switch (opcion) {
            
            case 1:
                System.out.println("Bienvenido ");
                
            break;
            
            case 2:
                System.out.println("Introduce tu correo");
                String correo=Sc.nextLine();
                System.out.println("Introduce tu contraseña");
                String contraseña=Sc.nextLine();
                System.out.println("Patata");
                
                
            
        }
        
        
        
        
        
    }
    
    
    
   
}
