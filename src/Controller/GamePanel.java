package Controller;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable
{
    private final int WIDTH = 450;
    private final int HEIGHT = 450;
    private final int DIMENSION = 15;

    private Thread thread;
    private boolean running = false;
    private GameController snake;
    private GameController apple;
    private KeyManager keyManager;
    private Collision collision;
    private int score = 0;

    public GamePanel ()
    {
        snake = new SnakeController(DIMENSION);
        apple = new AppleController(WIDTH, HEIGHT, DIMENSION);
        keyManager = new KeyManager((SnakeController) snake, DIMENSION);
        collision = new Collision(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(keyManager);
    }

    public synchronized void start ()
    {
        if (running)
            return;

        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop ()
    {
        if (!running)
            return;


        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update ()
    {
        snake.update();

        if (collision.collectApple(((SnakeController) snake).getSnake().get(0), ((AppleController) apple).getApple()))
        {
            apple.update();
            ((SnakeController) snake).snakeGrowing(keyManager.isLeft(), keyManager.isRight(), keyManager.isUp(), keyManager.isDown());
            score++;
        }

        collision.collideWithWalls((SnakeController) snake);
    }

    private void render ()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);



        snake.draw(g);
        apple.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 20);

        g.dispose();
        bs.show();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run ()
    {
        int fps = 15;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1)
            {
                update();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000)
            {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public int getWIDTH()
    {
        return WIDTH;
    }

    public int getHEIGHT()
    {
        return HEIGHT;
    }
}
