import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Clase que representa la ventana principal
class View extends JFrame {
    private final Controller controller;
    Color color = Color.cyan;
    public View(Controller controller) {
        this.controller = controller; // Guardar referencia al controlador
        JButton clearAllButton = new JButton();
        JTextField squateCounter = new JTextField();
        JPanel colorLabel = new JPanel();
        colorLabel.setBackground(color);

        clearAllButton.setText("Clear window");
        setTitle("Dibujo de Cuadrados");
        squateCounter.setText("Squares: 0");
        setFocusable(true);

        clearAllButton.addActionListener(e -> {
            controller.cleanSquareArray();
            squateCounter.setText("Squares :" + controller.getNumOfSquares());
            repaint();
        });
        add(colorLabel);
        add(clearAllButton);
        add(squateCounter);
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
                boolean relleno = (e.getButton() == MouseEvent.BUTTON3); // Si se hizo clic con el botón derecho
                controller.setColor(color);
                controller.addSquare(e.getX(), e.getY(), relleno); // Llama al controlador para agregar un cuadrado
                squateCounter.setText("Squares :" + controller.getNumOfSquares());
                repaint(); // Solicita repintar la ventana
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); // Limpia el panel antes de dibujar
        controller.drawSquare(g); // Pide al controlador que dibuje los cuadrados
    }
}