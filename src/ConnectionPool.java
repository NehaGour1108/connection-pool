import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ConnectionPool {
    private final BlockingQueue<Connection> pool;

    public ConnectionPool(int poolSize) {
        pool = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.add(new Connection());
        }
    }

    // Acquires a connection from the pool
    public Connection acquireConnection() throws InterruptedException {
        return pool.take();  // Blocking call, waits if no connection is available
    }

    // Releases a connection back to the pool
    public void releaseConnection(Connection connection) {
        try {
            pool.put(connection);  // Blocking call, waits if the queue is full
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted status
            System.out.println("Failed to release connection: " + e.getMessage());
        }
    }

    public int getAvailableConnections() {
        return pool.size();
    }
}