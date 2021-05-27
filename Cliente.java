/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
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
	    String palabra;
	    int digito;
		String nombreBroker = "Broker520";
		//Obtener entradas
	    if (args.length == 4) {
	        hostBroker = args[0];
	        animal = args[1];
	        palabra = args[2];
	        digito = Integer.parseInt(args[3]);
	    }else {
	        Scanner lecturaTeclado = new Scanner(System.in);
	        System.out.print("Introduzca la dirección IP del broker: ");
	        hostBroker = lecturaTeclado.nextLine();
	        System.out.print("Introduzca un animal: ");
	        animal =  lecturaTeclado.nextLine();
	        System.out.print("Introduzca una palabra: ");
	        palabra =  lecturaTeclado.nextLine();
	        System.out.print("Introduzca un digito: ");
	        digito =  lecturaTeclado.nextInt();
	    }
	    
	    try {
	    	//Buscar el Broker
	        Servicio broker =(Servicio) Naming.lookup("//"+ hostBroker + "/"+nombreBroker);
	        System.out.println("Ejecutando servicio en broker...");
	        //Invocaciones remotas
	        String[] params = new String[]{ animal }; 
	        String resultado = broker.ejecutar_servicio("esAnimal", params);
	       	System.out.println("\"" + animal + "\" "+ resultado + " un animal ");
	       	params = new String[] {};
	        resultado = broker.ejecutar_servicio("obtenerUnAnimal", params);
	       	System.out.println("Se ha obtenido un animal: " + resultado);
	       	params = new String[] {palabra};
	        resultado = broker.ejecutar_servicio("cuentaLetras", params);
	        System.out.println("\"" + palabra +  "\" contiene " + resultado + " letras ");
	        params = new String[] {palabra, Integer.toString(digito)};
	        resultado = broker.ejecutar_servicio("cuentaDigito", params);
			System.out.println("\"" + palabra +  "\" contiene " + resultado + " " + digito + "'s ");
	        System.out.println("Fin programa cliente RMI");
	    } catch (Exception e) {
	        System.out.println("Error en cliente RMI: " + e.getMessage());
	    }
		}
}
