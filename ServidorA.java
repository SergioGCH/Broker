import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorA extends AnimalImplementor{

    public ServidorA(){
        
    }
    public static void main(String[] args) {
         try {
            System.out.println("Preparando servidor RMI...");
            // Instanciamos la clase implementada
            AnimalImplementor animal = new AnimalImplementor();
            
            System.out.println("Creando referencia a objecto remoto");
            Naming.rebind("//155.210.154.191/ServidorA520", animal);
            System.out.println("Buscando broker");
            Servicio servicio = (Servicio) Naming.lookup("//155.210.154.192/Broker720");
            System.out.println("Registrando servidor");
            servicio.registrar_servidor("ServidorA520", "155.210.154.191");
            System.out.println("El servidorA se ha registrado");
        } catch (Exception e) {
            System.out.println("Error en Servidor: " + e.getMessage());
        }
    }
    
}
