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
		//Inicializar las variables privadas
	}
	@Override
	public void registrar_servidor(String nombre_servidor, String host_remoto_IP_puerto) 
		throws RemoteException {
	if(nombre_servidor.contains("ServidorA")){
	    this.hostServidorA = host_remoto_IP_puerto;
	    this.nombreServidorA = nombre_servidor;
	}else if(nombre_servidor.contains("ServidorB")){
	    this.hostServidorB = host_remoto_IP_puerto;
	    this.nombreServidorA = nombre_servidor;
	}
	try {
	    System.out.println("Registrando"+nombre_servidor+"--"+host_remoto_IP_puerto);
		if(nombre_servidor.contains("ServidorA")){
	    		servidorA = (Animal) Naming.lookup("//" + host_remoto_IP_puerto + "/" + nombre_servidor);
	    		} else {
	    			servidorB = (ContadorDeLetras) Naming.lookup("//" + host_remoto_IP_puerto + "/" + nombre_servidor);
	    		}
	} catch (NotBoundException ex) {
	    Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
	} catch (MalformedURLException ex) {
	    Logger.getLogger(ServicioImplementor.class.getName()).log(Level.SEVERE, null, ex);
	}
	System.out.println(nombre_servidor +" registrado en el broker con IP "+host_remoto_IP_puerto);
	}

	@Override
	public int ejecutar_servicio(String nom_servicio, String[] parametros_servicio) 
	throws RemoteException, AccessException {

	if(nom_servicio.equals("esAnimal")){
	    System.out.println("empieza servico esAnimal");

	    boolean resultado = servidorA.esAnimal(parametros_servicio[0]);
	    if (resultado) {
		System.out.println("El " + parametros_servicio[0] + " es animal según el servidor RMI");
		return 1;
	    }
	    else {
		System.out.println("El " + parametros_servicio[0] + " NO es animal según el servidor RMI");
		return 0;
	    }
	} else if (nom_servicio.equals("cuentaLetras")){
		System.out.println("empieza servico cuentaLetras");
	    	int resultado = servidorB.cuentaLetras(parametros_servicio[0]);
		System.out.println("\"" + parametros_servicio[0] +  "\" contiene " + resultado + " letras según el servidor RMI");
		return resultado;
	}
	return -1;
	}
}
