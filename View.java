import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Clase que representa la ventana principal
class View extends JFrame {
    private final Controller controller;
    private Color color = Color.cyan;
    private final JTextField figureCounter = new JTextField();
    private boolean moveFigureOption;
    private boolean deleteFigureOption;
    private Figure figure;
    private final JComboBox<String> figureSelector;


    public View(Controller controller) {
        this.controller = controller; // Guardar referencia al controlador
        moveFigureOption = false;
        deleteFigureOption = false;

        JButton selectColorBtn = new JButton("Select color");


        JButton clearAllButton = new JButton("Clear window");
        JButton reorganizeSquaresButton = new JButton("Reorganize figures");
        JPanel colorLabel = new JPanel();
        JButton moveFigureButton = new JButton("Move figure");
        JButton deleteFigureButton = new JButton("Delete figure");
        JTextField statusField = new JTextField("No selected");
        figureSelector = new JComboBox<>(new String[]{"Square", "Circle", "Rectangle", "Oval", "Triangle"});

        colorLabel.setBackground(color);

        selectColorBtn.addActionListener(_ -> {
            color = JColorChooser.showDialog(this, "Select a color", color);
            colorLabel.setBackground(color);
        });

        setTitle("Figure drawing");
        figureCounter.setText("Figures: 0");
        setFocusable(true);

        clearAllButton.addActionListener(_ -> {
            controller.cleanSquareArray();
            figureCounter.setText("Figure:" + controller.getNumOfFigures());
            repaint();
        });

        reorganizeSquaresButton.addActionListener(_ ->{
            controller.reorganizeSquares(getHeight(), getWidth());
            repaint();
        });

        moveFigureButton.addActionListener(_ -> {
            moveFigureOption = !moveFigureOption;
            statusField.setText(moveFigureOption ? "Please select a square": "Selection disabled");
        });//Alternar la opción de mover figura

        deleteFigureButton.addActionListener(_ -> {
            deleteFigureOption = !deleteFigureOption;
            statusField.setText(deleteFigureOption ? "Please select a square": "Selection disabled");
        });//Alternar la opción de borrar figura



        add(colorLabel);
        add(selectColorBtn);
        add(clearAllButton);
        add(figureCounter);
        add(reorganizeSquaresButton);
        add(moveFigureButton);
        add(deleteFigureButton);
        add(statusField);
        add(figureSelector);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        setSize(600, 600);

        // Agregar KeyBindings
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

// Definir las teclas y las acciones
        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveSquareUp");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveSquareDown");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveSquareLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveSquareRight");

// Asociar las acciones a las teclas
        actionMap.put("moveSquareUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveFigureOption && figure != null) {
                    // Implementa la lógica para mover el cuadrado hacia arriba
                    statusField.setText("Moving up");
                        figure.setY(figure.getY() > 4? (figure.getY() - 5) : 0);
                    repaint();
                }
            }
        });

        actionMap.put("moveSquareDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveFigureOption && figure != null) {
                    // Implementa la lógica para mover el cuadrado hacia abajo
                    statusField.setText("Moving down");
                        figure.setY(figure.getY() < 595? (figure.getY() + 5) : 600);
                    repaint();
                }
            }
        });

        actionMap.put("moveSquareLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveFigureOption && figure != null) {
                    // Implementa la lógica para mover el cuadrado hacia abajo
                    statusField.setText("Moving left");
                    figure.setX(figure.getX() > 5? (figure.getX() - 5) : 0);
                    repaint();
                }
            }
        });

        actionMap.put("moveSquareRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveFigureOption && figure != null) {
                    // Implementa la lógica para mover el cuadrado hacia abajo
                    statusField.setText("Moving right");
                    figure.setX(figure.getX() < 595? (figure.getX() + 5) : 600);
                    repaint();
                }
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(moveFigureOption || deleteFigureOption){
                    figure = controller.getFigureAt(e.getX(), e.getY());
                    if(figure != null){
                        statusField.setText("Figure selected");
                        if(deleteFigureOption){
                            controller.deleteFigure(figure);
                        }
                    }
                }else{
                    boolean filled = (e.getButton() != MouseEvent.BUTTON3); // Si se hizo clic con el botón derecho
                    controller.setColor(color);
                    controller.addFigure((String) figureSelector.getSelectedItem(), e.getX(), e.getY(), filled); // Llama al controlador para agregar un cuadrado
                }
                repaint(); // Solicita repintar la ventana
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); // Limpia el panel antes de dibujar
        controller.drawSquare(g); // Pide al controlador que dibuje los cuadrados
        figureCounter.setText("Figures:" + controller.getNumOfFigures());
    }
}