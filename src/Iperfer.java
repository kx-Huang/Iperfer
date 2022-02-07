public class Iperfer {
  /*
   * command line argument parser
   * client mode: java Iperfer -c -h <server hostname> -p <server port> -t <time>
   * server mode: java Iperfer -s -p <listen port>
   */
  public static void main(String[] args) {
    // parser indicator
    boolean mode_client = false;
    boolean mode_server = false;
    boolean mode_missing = true;
    boolean valid_hostname = false;
    boolean valid_port = false;
    boolean valid_time = false;

    // data field
    String hostname = "";
    int port = 0;
    long time = 0;

    // check client or server mode
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-c")) {
        // Error: missing or additional arguments
        if (args.length != 7) {
          System.err.println("Error: missing or additional arguments");
          System.exit(-1);
        }
        mode_client = true;
        mode_missing = false;
      }
      if (args[i].equals("-s")) {
        // Error: missing or additional arguments
        if (args.length != 3) {
          System.err.println("Error: missing or additional arguments");
          System.exit(-1);
        }
        mode_server = true;
        mode_missing = false;
      }
    }
    // Error: missing or additional arguments
    if (mode_missing) {
      System.err.println("Error: missing or additional arguments");
      System.exit(-1);
    }

    // parse argument
    for (int i = 0; i < args.length; i++) {
      // server hostname
      if (args[i].equals("-h")) {
        // Error: invalid arguments for server mode
        if (mode_server) {
          System.err.println("Error: invalid arguments for server mode");
          System.exit(-1);
        }
        // Error: missing server hostname
        if (i == args.length - 1) {
          System.err.println("Error: missing server hostname");
          System.exit(-1);
        }
        hostname = args[++i];
        // Error: missing server hostname
        if (hostname.startsWith("-")) {
          System.err.println("Error: missing server hostname");
          System.exit(-1);
        }
        valid_hostname = true;
      }
      // port number
      if (args[i].equals("-p")) {
        // Error: missing port number parameter
        if (i == args.length - 1) {
          System.err.println("Error: missing port number parameter");
          System.exit(-1);
        }
        try {
          port = Integer.parseInt(args[++i]);
        } catch (NumberFormatException e) {
          // Error: port number is not integer
          System.err.println("Error: port number must be an integer");
          System.exit(-1);
        }
        // Error: invalid port range
        if (port < 1024 || port > 65535) {
          System.err.println("Error: port number must be in the range 1024 to 65535");
          System.exit(-1);
        }
        valid_port = true;
      }
      // time
      if (args[i].equals("-t")) {
        // Error: invalid arguments for server mode
        if (mode_server) {
          System.err.println("Error: invalid arguments for server mode");
          System.exit(-1);
        }
        // Error: missing time parameter
        if (i == args.length - 1) {
          System.err.println("Error: missing time parameter");
          System.exit(-1);
        }
        try {
          time = Integer.parseInt(args[++i]);
        } catch (NumberFormatException e) {
          // Error: time is not integer
          System.err.println("Error: time must be an integer");
          System.exit(-1);
        }
        valid_time = true;
      }
    }

    // argument integrity check
    if ((mode_client && (!valid_hostname || !valid_port || !valid_time)) || (mode_server && !valid_port)) {
      System.err.println("Error: missing or additional arguments");
      System.exit(-1);
    }
    // client mode
    if (mode_client) {
      client client = new client(hostname, port, time);
      client.launch();
    }
    // server mode
    if (mode_server) {
      server server = new server(port);
      server.launch();
    }
  }
}