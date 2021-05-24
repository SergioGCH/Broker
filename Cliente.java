import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
 
public class Cliente {
    private Cliente(){}
 
    public static void main(String[] args)
    {
        String animal;
        String direccionServidor;
        if (args.length == 2) {
            direccionServidor = args[0];
            animal = args[1];
        }else {
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduzca la dirección IP o DNS del broker: ");
            direccionServidor = lecturaTeclado.nextLine();
            System.out.print("Introduzca un animal: ");
            animal =  lecturaTeclado.nextLine();
        }
        //Si no se indica dirección de servidor, se asume "null" (localhost)
        if (direccionServidor.equals("")) {
            direccionServidor = null;
        }
 
        try {
            //Obteniendo registro de rmiregistry
            System.out.println("Obteniendo registro de rmiregistry...");
            Registry registry = LocateRegistry.getRegistry(direccionServidor);
 
            //Buscando el objeto RMI remoto
            System.out.println("Buscando objeto RMI animal y creando stub...");
            Animal stub = (Animal) registry.lookup("animal");
            System.out.println("Objeto animal remoto encontrado...");
 
            System.out.println();
            System.out.println("Ejecutando método remoto RMI esAnimal en servidor...");
            boolean resultado = stub.esAnimal(animal);
            if (resultado) {
                System.out.println("El número " + animal + " es animal según el servidor RMI");
            }
            else {
                System.out.println("El número " + animal + " NO es animal según el servidor RMI");
            }
 
            System.out.println();
            System.out.println("Fin programa cliente RMI");
        } catch (Exception e) {
            System.out.println("Error en cliente RMI: " + e.getMessage());
        }
    }
}