class Connection {
    private static int counter = 0;
    private final int id;

    public Connection() {
        this.id = ++counter;
        System.out.println("id value"+ this.id + "counter" + counter);
    }

    public void execute(String query) {
        System.out.println("Executing query on connection " + id + ": " + query);
    }

    public int getId() {
        return id;
    }
}
