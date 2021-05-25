import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Broker extends ServicioImplementor{
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "./java.policy");
        System.setSecurityManager(new SecurityManager());
         try {
            System.out.println("Creando objeto servicio");
            ServicioImplementor servicio = new ServicioImplementor();
            System.out.println("Creando referencia a objecto remoto");
            Naming.rebind("//155.210.154.192/Broker520", servicio);
            System.out.println("El broker se ha registrado");
        } catch (Exception e) {
            System.out.println("Error en Broker: " + e.getMessage());
        }
    }
}
