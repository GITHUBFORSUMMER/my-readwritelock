package my.locks;

public interface ReadWriteLock {

    //读锁
    Lock readLock();

    //写锁
    Lock writeLock();

    //获取正在执行写操作的线程数
    int getWritingWriters();

    //获取正在等待获取写入锁的线程数
    int getWaitingWriters();


    //获取正在等待获取读取锁的线程数
    int getReadingReaders();


    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWrite) {
        return new ReadWriteLockImpl(preferWrite);
    }



}
