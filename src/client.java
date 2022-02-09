import java.net.Socket;
import java.io.OutputStream;

public class client {

  private String hostname;
  private int port;
  private long duration;

  client(String hostname, int port, long time) {
    this.hostname = hostname;
    this.port = port;
    this.duration = time;
  }

  void launch() {
    // test related variables
    long startTime = 0;
    long currentTime = 0;
    long kilobyteSent = 0;
    double dataRate = 0.0;
    byte kilobyteData[] = new byte[1000];

    try {
      // connect with server and get output stream
      Socket socket = new Socket(hostname, port);
      OutputStream out = socket.getOutputStream();

      // keep sending data in specified time interval
      startTime = System.currentTimeMillis();
      while (currentTime - startTime < (duration * 1000)) {
        currentTime = System.currentTimeMillis();
        out.write(kilobyteData);
        out.flush();
        kilobyteSent++;
      }

      // close socket
      socket.close();

    } catch (Exception e) {
      System.err.printf("Error: connection fail with server %s port %d\n", hostname, port);
      System.exit(-1);
    }

    // calculate and print bytes sent and data rate
    dataRate = (kilobyteSent * 8) / (currentTime - startTime);
    System.out.printf("sent=%d KB rate=%.3f Mbps\n", kilobyteSent, dataRate);
  }
}
