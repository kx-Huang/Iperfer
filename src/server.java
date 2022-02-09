import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;

public class server {
  private int port;

  server(int port) {
    this.port = port;
  }

  void launch() {
    // test related vaiables
    long startTime = 0;
    long currentTime = 0;
    long byteReceived = 0;
    long currentByteReceived = 0;
    double dataRate = 0.0;
    byte kilobyteData[] = new byte[1000];

    try {
      // launch as server and get input stream
      ServerSocket serverSocket = new ServerSocket(port);
      Socket socket = serverSocket.accept();
      InputStream in = socket.getInputStream();

      // keep receiving data until disconnected
      startTime = System.currentTimeMillis();
      while ((currentByteReceived = in.read(kilobyteData)) != -1)
        byteReceived += currentByteReceived;
      currentTime = System.currentTimeMillis();

      // close socket
      socket.close();
      serverSocket.close();

    } catch (Exception e) {
      System.err.printf("Error: launch fail as server listening port %d\n", port);
      System.exit(-1);
    }

    // calculate and print bytes sent and data rate
    dataRate = (byteReceived * 8 * 0.001) / (currentTime - startTime);
    System.out.printf("received=%d KB rate=%.3f Mbps\n", byteReceived * 0.001, dataRate);
  }
}
