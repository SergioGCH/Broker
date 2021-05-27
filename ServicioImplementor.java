/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;

public class ServicioImplementor extends UnicastRemoteObject implements Servicio {

	Animal servidorA;
	ContadorDeLetras servidorB;
	String nombreServidorA;
	String nombreServidorB;
	String hostServidorA;
	String hostServidorB;

	public ServicioImplementor() throws RemoteException
	{
		super();//Llama al constructor de UnicastRemoteObject
	}
	
	//API para los servidores
	@Override
	public void registrar_servidor(String nombre_servidor, String host_remoto_IP_puerto) 
			throws RemoteException {
		System.out.println("Registrando"+nombre_servidor+" situado en "+host_remoto_IP_puerto);
		try {
			if(nombre_servidor.contains("ServidorA")){
				this.hostServidorA = host_remoto_IP_puerto;
				this.nombreServidorA = nombre_servidor;
				this.servidorA = (Animal) Naming.lookup("//" + host_remoto_IP_puerto + "/" + nombre_servidor);
			} else if (nombre_servidor.contains("ServidorB")){
				this.hostServidorB = host_remoto_IP_puerto;
				this.nombreServidorA = nombre_servidor;
				this.servidorB = (ContadorDeLetras) Naming.lookup("//" + host_remoto_IP_puerto + "/" + nombre_servidor);
			}
		} catch (NotBoundException ex) {
			Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MalformedURLException ex) {
			Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(nombre_servidor +" registrado en el broker con IP "+host_remoto_IP_puerto);
	}
	
    //API para los clientes
	@Override
	public String ejecutar_servicio(String nom_servicio, String[] parametros_servicio) 
	throws RemoteException, AccessException {
		if(nom_servicio.equals("esAnimal")){
			System.out.println("empieza servicio esAnimal");
			boolean resultado = servidorA.esAnimal(parametros_servicio[0]);
			if (resultado) {
				System.out.println("El " + parametros_servicio[0] + " es animal");
				return "es";
			}
			else {
				System.out.println("El " + parametros_servicio[0] + " NO es animal");
				return "NO es";
			}
		} else if (nom_servicio.equals("obtenerUnAnimal")){
			System.out.println("empieza servicio obtenerAnimal");
			String resultado = servidorA.obtenerUnAnimal();
			System.out.println("Se ha obtenido un animal:" + resultado);
			return resultado;
		}else if (nom_servicio.equals("cuentaLetras")){
			System.out.println("empieza servicio cuentaLetras");
				int resultado = servidorB.cuentaLetras(parametros_servicio[0]);
			System.out.println("\"" + parametros_servicio[0] +  "\" contiene " + resultado + " letras ");
			return Integer.toString(resultado);
		} else if (nom_servicio.equals("cuentaDigito")){
			System.out.println("empieza servicio cuentaDigito");
			int resultado = servidorB.cuentaDigito(parametros_servicio[0], Integer.parseInt(parametros_servicio[1]));
			System.out.println("\"" + parametros_servicio[0] +  "\" contiene " + resultado + parametros_servicio[1] + "'s ");
			return Integer.toString(resultado);
		}
			return "error";
	}
}
