public class client {

    private String hostname;
    private int port;
    private long time;

    client(String hostname, int port, long time) {
        this.hostname = hostname;
        this.port = port;
        this.time = time;
    }

    void launch() {
        System.out.println("client launched!");
    }
}
