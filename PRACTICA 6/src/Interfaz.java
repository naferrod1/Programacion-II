import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Interfaz extends JFrame {
    private Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
    private JTextArea estadoArea = new JTextArea(15, 50);
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Interfaz() {
        super("Sistema de Gestión Bibliotecaria");
        configurarVentana();
        initComponents();
        setVisible(true);
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(220, 220, 220));
        tabbedPane.addTab("Registro", panelRegistro());
        tabbedPane.addTab("Préstamos", panelPrestamos());
        tabbedPane.addTab("Devoluciones", panelDevoluciones());

        estadoArea.setEditable(false);
        estadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        estadoArea.setBackground(new Color(255, 255, 230));

        add(tabbedPane, BorderLayout.CENTER);
        add(new JScrollPane(estadoArea), BorderLayout.SOUTH);

        actualizarEstado();
    }

    // ====================== Paneles ======================

    private JPanel panelRegistro() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));

        panel.add(panelRegistroLibros());
        panel.add(panelRegistroEstudiantes());
        return panel;
    }

    private JPanel panelRegistroLibros() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registro de Libros"));
        panel.setBackground(new Color(245, 245, 245));

        JTextField txtTitulo = crearCampoTexto();
        JTextField txtAutor = crearCampoTexto();
        JTextField txtStock = crearCampoTexto();
        JButton btnRegistrarLibro = crearBoton("Registrar Libro");

        panel.add(new JLabel(" Título:"));
        panel.add(txtTitulo);
        panel.add(new JLabel(" Autor:"));
        panel.add(txtAutor);
        panel.add(new JLabel(" Stock:"));
        panel.add(txtStock);
        panel.add(btnRegistrarLibro);

        btnRegistrarLibro.addActionListener(e -> registrarLibro(
                txtTitulo.getText(),
                txtAutor.getText(),
                txtStock.getText()
        ));

        return panel;
    }

    private JPanel panelRegistroEstudiantes() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registro de Estudiantes"));
        panel.setBackground(new Color(230, 230, 230));

        JTextField txtCodigo = crearCampoTexto();
        JTextField txtNombre = crearCampoTexto();
        JButton btnRegistrarEstudiante = crearBoton("Registrar Estudiante");

        panel.add(new JLabel(" Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel(" Nombre:"));
        panel.add(txtNombre);
        panel.add(btnRegistrarEstudiante);

        btnRegistrarEstudiante.addActionListener(e -> registrarEstudiante(
                txtCodigo.getText(),
                txtNombre.getText()
        ));

        return panel;
    }

    private JPanel panelPrestamos() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));

        JButton btnPrestamo = crearBoton("Realizar Préstamo");
        panel.add(new JLabel("Para realizar un préstamo, presione el botón:"));
        panel.add(btnPrestamo);

        btnPrestamo.addActionListener(e -> mostrarDialogoPrestamo());

        return panel;
    }

    private JPanel panelDevoluciones() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));

        JButton btnDevolucion = crearBoton("Registrar Devolución");
        panel.add(new JLabel("Para registrar una devolución, presione el botón:"));
        panel.add(btnDevolucion);

        btnDevolucion.addActionListener(e -> mostrarDialogoDevolucion());

        return panel;
    }

    // ====================== Utilidades ======================

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setBackground(Color.WHITE);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return campo;
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(220, 220, 220));
        boton.setForeground(new Color(60, 60, 60));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                BorderFactory.createEmptyBorder(5, 20, 5, 20)
        ));
        boton.setFocusPainted(false);
        return boton;
    }

    // ====================== Lógica ======================

    private void registrarLibro(String titulo, String autor, String stock) {
        try {
            biblioteca.agregarLibro(new Libro(titulo, autor, Integer.parseInt(stock)));
            actualizarEstado();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en formato numérico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarEstudiante(String codigo, String nombre) {
        if(codigo.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        biblioteca.registrarEstudiante(new Estudiante(codigo, nombre));
        actualizarEstado();
    }

    // ====================== Diálogos ======================

    private void mostrarDialogoPrestamo() {
        JDialog dialogo = new JDialog(this, "Registrar Préstamo", true);
        dialogo.setSize(500, 300);
        dialogo.setLayout(new BorderLayout(10,10));

        JPanel panelContenido = new JPanel(new GridLayout(3,2,10,10));
        panelContenido.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JComboBox<Libro> comboLibros = new JComboBox<>();
        biblioteca.getLibrosDisponibles().forEach(comboLibros::addItem);

        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>();
        biblioteca.getEstudiantesRegistrados().forEach(comboEstudiantes::addItem);

        JTextField txtCantidad = crearCampoTexto();

        panelContenido.add(new JLabel("Libro:"));
        panelContenido.add(comboLibros);
        panelContenido.add(new JLabel("Estudiante:"));
        panelContenido.add(comboEstudiantes);
        panelContenido.add(new JLabel("Cantidad:"));
        panelContenido.add(txtCantidad);

        JButton btnRegistrar = crearBoton("Registrar Préstamo");
        btnRegistrar.addActionListener(e -> {
            try {
                Libro libro = (Libro) comboLibros.getSelectedItem();
                Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
                int cantidad = Integer.parseInt(txtCantidad.getText());

                biblioteca.realizarPrestamo(estudiante, libro, cantidad);
                actualizarEstado();
                dialogo.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialogo, "Cantidad inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnRegistrar);

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(panelBoton, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoDevolucion() {
        JDialog dialogo = new JDialog(this, "Registrar Devolución", true);
        dialogo.setSize(500, 250);
        dialogo.setLayout(new BorderLayout(10,10));

        JPanel panelContenido = new JPanel(new GridLayout(2,2,10,10));
        panelContenido.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JComboBox<Prestamo> comboPrestamos = new JComboBox<>();
        biblioteca.getPrestamosActivos().forEach(comboPrestamos::addItem);

        panelContenido.add(new JLabel("Préstamo Activo:"));
        panelContenido.add(comboPrestamos);

        JButton btnDevolver = crearBoton("Registrar Devolución");
        btnDevolver.addActionListener(e -> {
            Prestamo prestamo = (Prestamo) comboPrestamos.getSelectedItem();
            biblioteca.registrarDevolucion(prestamo);
            actualizarEstado();
            dialogo.dispose();
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnDevolver);

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(panelBoton, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    // ====================== Actualizar estado ======================

    private void actualizarEstado() {
        estadoArea.setText("");

        estadoArea.append("=== LIBROS (Ordenados por Título) ===\n");
        biblioteca.getLibrosDisponibles().stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(l -> estadoArea.append(
                        String.format("· %-25s | Autor: %-20s | Stock: %3d\n",
                                l.getTitulo(), l.getAutor(), l.getStock())
                ));

        estadoArea.append("\n=== ESTUDIANTES ===\n");
        biblioteca.getEstudiantesRegistrados().forEach(e ->
                estadoArea.append(String.format("· %-10s | %-30s\n", e.getCodigo(), e.getNombre()))
        );

        estadoArea.append("\n=== PRÉSTAMOS ===\n");
        biblioteca.getPrestamosActivos().forEach(p ->
                estadoArea.append(String.format("· %-12s | %-20s | %2d unidades | %s\n",
                        p.getEstudiante().getCodigo(),
                        p.getLibro().getTitulo(),
                        p.getCantidad(),
                        p.getFechaPrestamo().format(dateFormatter)))
        );
    }

    // ====================== Main ======================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}
