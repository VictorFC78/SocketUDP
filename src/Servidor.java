import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class Servidor {
    private static final int PUERTO =1500;
    public Servidor(){
        try {
            //publicamos el manejador del puerto mediente un DatagramSocket equivale al ServerSockect
            DatagramSocket datagramSocket=new DatagramSocket(PUERTO);
            //generamos el paquete a enviar mediante DatagramaPacket y el buffer de bytes
            byte[]buffer=new byte[100];
            int contador=0;
            String datosRecibidos;
            DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
            //nos ponemos a la espera de recibir los paqqutes, en este caso tres paquetes
            while(contador<3){
                //guardanos en le datagramapacket el paquete recibido mediante el datagramasocket
                datagramSocket.receive(datagramPacket);
                //transformamos los bytes recibidos en string
                datosRecibidos=new String(datagramPacket.getData(),0, datagramPacket.getLength());
                System.out.println(datosRecibidos);
                contador++;
            }
            datagramSocket.close();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        Servidor servidor=new Servidor();
    }
}
