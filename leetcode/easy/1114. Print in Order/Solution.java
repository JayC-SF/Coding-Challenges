import java.util.concurrent.*;

class Foo {
    // already acquired
    private Semaphore releaseSecond = new Semaphore(0);
    private Semaphore releaseThird = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        releaseSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        releaseSecond.acquire();
        printSecond.run();
        releaseThird.release();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        releaseThird.acquire();
        printThird.run();
    }
}