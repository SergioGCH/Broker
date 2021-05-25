import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
 
public class Cliente {
    private Cliente(){}
 
    public static void main(String[] args)
    {
        System.setProperty("java.security.policy", "./java.policy");
	if (System.getSecurityManager() == null) {
             System.setSecurityManager(new SecurityManager());
        }
        String animal;
        String direccionServidor;
        if (args.length == 2) {
            direccionServidor = args[0];
            animal = args[1];
        }else {
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduzca la dirección IP del broker: ");
            direccionServidor = lecturaTeclado.nextLine();
            System.out.print("Introduzca un animal: ");
            animal =  lecturaTeclado.nextLine();
        }
        //Si no se indica dirección de servidor, se asume "null" (localhost)
        if (direccionServidor.equals("")) {
            direccionServidor = null;
        }
 
        try {
            Servicio broker =(Servicio) Naming.lookup("//"+ direccionServidor + "/Broker520");
 
            System.out.println("Ejecutando servicio en broker...");
            String[] params = new String[]{ "Pato" }; 
            boolean resultado = broker.ejecutar_servicio("esAnimal", params);
            if (resultado) {
                System.out.println("El " + animal + " es animal según el servidor RMI");
            }
            else {
                System.out.println("El " + animal + " NO es animal según el servidor RMI");
            }
            System.out.println("Fin programa cliente RMI");
        } catch (Exception e) {
            System.out.println("Error en cliente RMI: " + e.getMessage());
        }
    }
}