import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Clase que representa la ventana principal
class View extends JFrame {
    private final Controller controller;
    private Color color = Color.cyan;
    private final JTextField squareCounter = new JTextField();


    public View(Controller controller) {
        this.controller = controller; // Guardar referencia al controlador
        JButton clearAllButton = new JButton("Clear window");
        JButton reorganizeSquaresButton = new JButton("Reorganize squares");
        JPanel colorLabel = new JPanel();

        colorLabel.setBackground(color);


        setTitle("Square drawing");
        squareCounter.setText("Squares: 0");
        setFocusable(true);

        clearAllButton.addActionListener(e -> {
            controller.cleanSquareArray();
            squareCounter.setText("Squares:" + controller.getNumOfSquares());
            repaint();
        });

        reorganizeSquaresButton.addActionListener(e->{
            controller.reorganizeSquares(600, 600);
            repaint();
        });

        add(colorLabel);
        add(clearAllButton);
        add(squareCounter);
        add(reorganizeSquaresButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        setSize(600, 600);

        // Agregar el KeyListener
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_R: // Tecla 'R'
                        color = Color.RED;
                        break;
                    case KeyEvent.VK_G: // Tecla 'G'
                        color = Color.GREEN;
                        break;
                    case KeyEvent.VK_B: // Tecla 'B'
                        color = Color.BLUE;
                        break;
                    case KeyEvent.VK_Y: // Tecla 'Y'
                        color = Color.YELLOW;
                        break;
                }
                colorLabel.setBackground(color);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!controller.deleteSquare(e.getX(), e.getY())){
                    boolean relleno = (e.getButton() == MouseEvent.BUTTON3); // Si se hizo clic con el botón derecho
                    controller.setColor(color);
                    controller.addSquare(e.getX(), e.getY(), relleno); // Llama al controlador para agregar un cuadrado
                }
                repaint(); // Solicita repintar la ventana
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); // Limpia el panel antes de dibujar
        controller.drawSquare(g); // Pide al controlador que dibuje los cuadrados
        squareCounter.setText("Squares:" + controller.getNumOfSquares());
    }
}