package my.locks;


public interface Lock {

    /**
     * 加锁
     */
    void lock() throws InterruptedException ;

    /**
     * 释放锁
     */
    void unlock();
}
