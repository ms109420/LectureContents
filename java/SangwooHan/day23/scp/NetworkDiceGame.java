import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetworkDiceGame {
    int myDice;
    int targetDice;

    ServerSocket servSock;
    Socket sock;

    final String SERVER_IP = "192.168.30.141";
    final int PORT = 33333;

    public NetworkDiceGame () {
        myDice = (int)(Math.random() * 6 + 1);
        targetDice = 0;
    }

    public void createServer () throws IOException {
        servSock = new ServerSocket(PORT);

        System.out.println("Server: Listening - " + PORT);
    }

    public void createClient () throws IOException {
        sock = new Socket(SERVER_IP, PORT);
    }
}

class GameResultThread extends NetworkDiceGame implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (targetDice != 0) {
                if (myDice > targetDice) {
                    System.out.println("나의 승리");
                } else if (myDice < targetDice) {
                    System.out.println("상대편의 승리");
                } else {
                    System.out.println("무승부");
                }
            }

            targetDice = 0;
        }
    }
}

class GameSendThread implements Runnable {

    int dice;
    Scanner scan;
    Socket sock;

    public GameSendThread (Socket sock, int dice) {
        scan = new Scanner(System.in);

        this.dice = dice;
        this.sock = sock;
    }

    @Override
    public void run() {

        OutputStream out = null;
        PrintWriter writer;

        while (true) {
            System.out.print("게임을 진행하시겠습니까(y/n) ? ");
            String str = scan.nextLine();

            if (str.equals("y")) {
                try {
                    out = sock.getOutputStream();
                    writer = new PrintWriter(out, true);
                    writer.println(dice);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class GameRecvThread implements Runnable {
    int targetDice;
    int myDice;

    Socket sock;

    public GameRecvThread (Socket sock, int myDice) {
        this.sock = sock;
        this.myDice = myDice;
    }

    @Override
    public void run() {
        InputStream in;
        BufferedReader reader;

        while (true) {
            if (sock != null) {
                try {
                    in = sock.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    targetDice = Integer.parseInt(reader.readLine());
                    System.out.println("msg: " + targetDice);

                    if (targetDice != 0) {
                        if (myDice > targetDice) {
                            System.out.println("나의 승리");
                        } else if (myDice < targetDice) {
                            System.out.println("상대편의 승리");
                        } else {
                            System.out.println("무승부");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class GameStartProcess extends NetworkDiceGame {
    Thread sender;
    Thread receiver;

    public GameStartProcess () {
        super();

        sender = new Thread(new GameSendThread(sock, myDice));
        receiver = new Thread(new GameRecvThread(sock, myDice));
    }

    public void startGame () throws IOException {
        sock = servSock.accept();
        System.out.println("[" + sock.getInetAddress() + "] client connected");
    }

    public void startThread () {
        sender.start();
        receiver.start();
    }
}