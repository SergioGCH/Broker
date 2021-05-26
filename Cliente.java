import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
 
public class Cliente {
    private Cliente(){}
 
    public static void main(String[] args)
    {
	//Fijar el directorio donde se encuentra el java.policy
        System.setProperty("java.security.policy", "./java.policy");
	if (System.getSecurityManager() == null) {
	//Crear administrador de seguridad
             System.setSecurityManager(new SecurityManager());
        }
        String animal;
        String hostBroker;
	String nombreBroker = "Broker520";
        if (args.length == 2) {
            hostBroker = args[0];
            animal = args[1];
        }else {
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduzca la dirección IP del broker: ");
            hostBroker = lecturaTeclado.nextLine();
            System.out.print("Introduzca un animal: ");
            animal =  lecturaTeclado.nextLine();
        }
        //Si no se indica dirección de servidor, se asume "null" (localhost)
        if (hostBroker.equals("")) {
            hostBroker = null;
        }
 
        try {
            Servicio broker =(Servicio) Naming.lookup("//"+ hostBroker + "/"+nombreBroker);
 
            System.out.println("Ejecutando servicio en broker...");
            String[] params = new String[]{ animal }; 
            int resultado = broker.ejecutar_servicio("esAnimal", params);
            if (resultado==1) {
                System.out.println("El " + animal + " es animal según el servidor RMI");
            }
            else {
                System.out.println("El " + animal + " NO es animal según el servidor RMI");
            }

            resultado = broker.ejecutar_servicio("cuentaLetras", params);
            System.out.println("\"" + animal +  "\" contiene " + resultado + " letras según el servidor RMI");
            
            System.out.println("Fin programa cliente RMI");
        } catch (Exception e) {
            System.out.println("Error en cliente RMI: " + e.getMessage());
        }
    }
}
