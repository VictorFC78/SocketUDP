import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    private static final int PUERTO=1500;
    private static final String HOST="localhost";

    public Cliente(){
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            //creamos el paquete a enviar
            String texto="Soy un cliente enviando datos";
            byte[] mensaje=new byte[1000];//creamos el buffer de bytes
            mensaje=texto.getBytes();//transformamos el texto en bytes
            DatagramPacket datagramPacket=new DatagramPacket(mensaje,mensaje.length, InetAddress.getByName(HOST),PUERTO);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        Cliente cliente=new Cliente();
    }
}
