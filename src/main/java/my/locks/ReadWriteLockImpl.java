package my.locks;

class ReadWriteLockImpl implements ReadWriteLock {

    private final Object MUTEX = new Object();

    private int writingWrites = 0;

    private int waitingWrites = 0;

    private int readingReaders = 0;

    private boolean preferWrite;


    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }


    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    void incrementWritingWriters() {
        this.writingWrites++;
    }

    void incrementWaitingWriters() {
        this.waitingWrites++;
    }

    void incrementReadingReaders() {
        this.readingReaders++;
    }


    void decrementWritingWriters() {
        this.writingWrites--;
    }

    void decrementWaitingWriters() {
        this.waitingWrites--;
    }

    void decrementReadingReaders() {
        this.readingReaders--;
    }

    @Override
    public int getWritingWriters() {
        return this.writingWrites;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWrites;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    Object getMUTEX() {
        return this.MUTEX;
    }

    boolean getPreferWrite() {
        return this.preferWrite;
    }

    void changePrefer(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }
}