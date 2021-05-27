/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.Remote;

public interface Servicio extends Remote {
	//API para los servidores
    void registrar_servidor(String nombre_servidor,String host_remoto_IP_puerto) throws java.rmi.RemoteException;  
    //API para los clientes
    String ejecutar_servicio(String nom_servicio, String[] parametros_servicio) throws java.rmi.RemoteException;
}
