import java.rmi.Remote;

public interface Servicio extends Remote {
    void registrar_servidor(String nombre_servidor,String host_remoto_IP_puerto) throws java.rmi.RemoteException;     
    boolean ejecutar_servicio(String nom_servicio, String[] parametros_servicio) throws java.rmi.RemoteException;
}
