import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServicioImplementor  implements Servicio{
    Animal servidorA;
    ContadorDeLetras servidorB;
    String nombreServidorA;
    String nombreServidorB;
    String hostServidorA;
    String hostServidorB;
    @Override
    public void registrar_servidor(String nombre_servidor, String host_remoto_IP_puerto) throws RemoteException {
        if(nombre_servidor.equals("servidorA")){
            this.hostServidorA = host_remoto_IP_puerto;
            this.nombreServidorA = nombre_servidor;
        }else if(nombre_servidor.equals("servidorB")){
            this.hostServidorB = host_remoto_IP_puerto;
            this.nombreServidorA = nombre_servidor;
        }
        try {
            Naming.lookup("//" + host_remoto_IP_puerto + "/" + nombre_servidor);
        } catch (NotBoundException ex) {
            Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre_servidor +" registrado en el broker con IP "+host_remoto_IP_puerto);
    }

    @Override
    public boolean ejecutar_servicio(String nom_servicio, String[] parametros_servicio) throws RemoteException, AccessException {
        
        if(nom_servicio.equals("esAnimal")){
            System.out.println("Aquí llego");

            boolean resultado = servidorA.esAnimal(parametros_servicio[0]);
            if (resultado) {
                System.out.println("El " + parametros_servicio[0] + " es animal según el servidor RMI");
                return true;
            }
            else {
                System.out.println("El " + parametros_servicio[0] + " NO es animal según el servidor RMI");
            }
        }
        return false;
    }
}
