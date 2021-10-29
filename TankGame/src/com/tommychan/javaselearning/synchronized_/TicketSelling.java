package com.tommychan.javaselearning.synchronized_;

public class TicketSelling {
    public static void main(String[] args) {
        Sell sell = new Sell();

       new Thread(sell).start();
       new Thread(sell).start();
       new Thread(sell).start();

    }
}

class Sell implements Runnable{

    private static int ticketNum = 50;

    public static void sellTicket(){
        if (ticketNum <= 0){
            return;
        }
        synchronized (Sell.class){
            System.out.println(Thread.currentThread().getName()+" Available Ticket : " + --ticketNum);
        }
    }

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0){
                System.out.println("Tickets sold out");
                break;
            }
            sellTicket();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
