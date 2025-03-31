class Numbers extends Thread {    //EXTENDING THREAD CLASS
    public void run() {
        synchronized (this) {       //SYNCHRONIZED METHOD
            No();
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            System.out.println(Thread.currentThread().getPriority());
            
        }
    }

    void No() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Number is: " + i);
                Thread.sleep(1000);      //SLEEP METHOD
            } catch (InterruptedException e) {
                System.out.println("EXCEPTION OCCURRED");
            }
        }

        int i = 0;
        synchronized (this) {
            while (i < 4) {
                try {
                    if (i < 3) {
                        System.out.println("Number is: " + i);
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                this.notify();
                i++;
            }
        }
    }
}

class Square extends Thread {      //EXTENDING THREAD CLASS
    public void run() {
        synchronized (this) {
            Square1();
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
System.out.println(Thread.currentThread().getPriority());

        }
    }

    void Square1() {
        for (int i = 0; i < 5; i++) {
            int a = i * i;
            System.out.println("SQUARE IS: " + a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EXCEPTION OCCURRED");
            }
        }
    }
}

class Cube implements Runnable {              //RUNNABLE INTERFACE
    public void run() {
        Cube1();
    }

    void Cube1() {
        for (int i = 0; i < 5; i++) {
            int a = i * i * i;
            System.out.println("CUBE IS: " + a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EXCEPTION OCCURRED");
            }
        }
    }
}

public class ThreadingAssig01 {            //MAIN CLASS
    public static void main(String[] args) {
        
        Numbers n = new Numbers();                 //CREATING OBJECTS
        Square s = new Square();
        Cube c = new Cube();
        Thread t = new Thread(c);
        
        n.setName("sanskruti-thread1");
        System.out.println("Numbers Thread Name: " + n.getName());     //will show the name of thread (number)
        System.out.println("Square Thread Name: " + s.getName());
        
        
      
   
        n.start();
        System.out.println("IS number thread is Alive " + n.isAlive());   //will print true
        s.start();
        t.start();

       
       /*  s.setPriority(Thread.NORM_PRIORITY);              //IT HAS PRIORITY-5
        t.setPriority(Thread.MIN_PRIORITY);               //IT HAS PRIORITY-0
        n.setPriority(Thread.MAX_PRIORITY);                //IT HAS PRIORITY-10
        

        System.out.println("Numbers Thread Priority: " + n.getPriority());
        System.out.println("Square Thread Priority: " + s.getPriority());
        System.out.println("Cube Thread Priority: " + t.getPriority());

         */
        try{
            n.join();                 //WAIT FOR THE NUMBER THREAD TO FINISH
        }catch(InterruptedException r){
            System.out.println(r);
        }
        System.out.println("IS number thread is Alive " + n.isAlive());
        System.out.println("THREADS EXECUTED");
    }
}
