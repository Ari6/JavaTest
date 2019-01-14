package Singleton;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    //added
    private static ChocolateBoiler cb;
    //end added

    //Changed from public to private
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    //added
    /*
     * To use this as multi thread, you need to deal with multi thread.
     * 1. adding synchronized to getInstance(). This is expensive.
     * 2. move to an eagerly created instance rather than a lazily created one.
     *      private static ChocolateBoiler cb = new ChocolateBoiler();
     *      public static ChocolateBoiler getInstance() { return cb }
     * 3. Do not deal with it if it is not critical to your app.
     * 4. Use "double-checked locking' to reduce the use of synchronization.
     *  first check to see if an instance is created, then if not, synchronize.
     *      private volatile static ChocolateBoiler cb;
     *      public static ChocolateBuilder getInstance() {
     *          if(cb == null ) {
     *              synchronized (ChocolateBuilder.class) {
     *                  if(cb == null ) {
     *                      cb = new ChocolateBuilder();
     *                  }
     *              }
     *          }
     *          return cb;
     *      }
     *
     */
    public ChocolateBoiler getInstance() {
        if(cb == null) {
            cb = new ChocolateBoiler();
        }
        return cb;
    }
    //end added
    public void fill() {
        if(isEmpty()) {
            empty = false;
            boiled = false;
        }
    }
    public void drain() {
        if(!isEmpty() && isBoiled()) {
            empty = true;
        }
    }
    public void boil() {
        if(!isEmpty() && !isBoiled()){
            boiled = true;
        }
    }
    public boolean isEmpty() {
        return empty;
    }
    public boolean isBoiled() {
        return boiled;
    }
}
