public class Main {
    public static void main(String[] args) {
        int poolSize = 5;
        ConnectionPool connectionPool = new ConnectionPool(poolSize);

        // Create and start 10 threads to acquire and release connections
        for (int i = 0; i < 10; i++) {
            new Thread(new ConnectionTask(connectionPool)).start();
        }
    }
}

class ConnectionTask implements Runnable {
    private final ConnectionPool connectionPool;

    public ConnectionTask(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionPool.acquireConnection();
            System.out.println("Acquired connection with ID: " + connection.getId());
            connection.execute("SELECT * FROM users");

            Thread.sleep(1000);  // Simulate some work with the connection

            connectionPool.releaseConnection(connection);
            System.out.println("Released connection with ID: " + connection.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
