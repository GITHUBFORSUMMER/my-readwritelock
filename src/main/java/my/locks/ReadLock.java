package my.locks;

public class ReadLock implements Lock {

    private ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }


    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            while (readWriteLock.getWritingWriters() > 0 ||
                    (readWriteLock.getPreferWrite() && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getMUTEX().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notify();
        }
    }
}
