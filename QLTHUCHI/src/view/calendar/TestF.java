package view.calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.chi.renders;
public class TestF {
    private static Map<String, JFrame> frameMap = new HashMap<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("No Header Frame Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the frame undecorated to remove the header
            frame.setUndecorated(true);

            // Create two JPanels with text and background colors
            JPanel panel1 = createPanel("Panel 1", Color.RED);
            JPanel panel2 = createPanel("Panel 2", Color.BLUE);

            // Create a layout manager for the frame
            frame.setLayout(new GridLayout(2, 1));

            // Add the panels to the frame
            frame.add(panel1);
            frame.add(panel2);

            // Set the size of the frame
            frame.setSize(new Dimension(300, 200));

            // Center the frame on the screen
            frame.setLocationRelativeTo(null);

            // Make the frame visible
            frame.setVisible(true);

            // Map the string "frame" to the JFrame
            KeyStroke keyStroke = KeyStroke.getKeyStroke("control shift C");
            mapFrame("frame", frame);
            // Assign shortcut Ctrl + N to the frame
            assignShortcut(frame, panel1, KeyEvent.VK_N, "frame");
        });
        
    }

    private static void mapFrame(String frameName, JFrame frame) {
        frameMap.put(frameName, frame);
    }

    private static void assignShortcut(JFrame frame, JPanel testPanel, int keyCode, String actionCommand) {
        InputMap inputMap = ((JComponent) frame.getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(keyCode, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), actionCommand);

        ActionMap actionMap = ((JComponent) frame.getContentPane()).getActionMap();
        actionMap.put(actionCommand, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your action when Ctrl + N is pressed
                JOptionPane.showMessageDialog(frame, "Ctrl + N pressed!");

                // Dispose the JFrame mapped with the "frame" string
                JFrame mappedFrame = frameMap.get(actionCommand);
                if (mappedFrame != null) {
                    // Add a new JPanel to the current JFrame
        Vector<Vector<Object>> data = new Vector<>();

        // Vector 1
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        data.add(vector1);

        // Vector 2
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        data.add(vector2);

        // Vector 3
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector3);
                    JPanel newPanel = createPanel("New Panel", Color.GREEN);
                    mappedFrame.add(newPanel);
                    JTextField t = new JTextField();
                    t.setText("A");
                    testPanel.add(t);
                    DefaultTableModel model = new DefaultTableModel(data, new Vector<>(Arrays.asList("Column 1", "Column 2", "Column 3", "C4", "C5")));
                    JTable table = new JTable(model);
                    createStripedRowTable();
                    Object[][] datas = new Object[3][5]; // Giả sử bạn muốn mảng có 3 dòng và 5 cột

        // Gán giá trị cho mảng
                    datas[0] = new Object[]{1, 2, 3, "Hello", "World"};
                    datas[1] = new Object[]{4, 5, 6, "Java", "Programming"};
                    datas[2] = new Object[]{7, 8, 9, "OpenAI", "GPT-3.5"};
                    // Validate and repaint the JFrame to reflect changes
                    mappedFrame.validate();
                    mappedFrame.repaint();
                }
            }
        });
    }

    private static JPanel createPanel(String text, Color backgroundColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a JLabel with the specified text
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Set the background color of the panel
        panel.setBackground(backgroundColor);

        // Add the label to the panel
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
    private static void createStripedRowTable() {
        // Dữ liệu mẫu
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector1);
        data.add(vector2);
        data.add(vector3);
//


                
                
        // Tạo bảng và mô hình
        DefaultTableModel model = new DefaultTableModel(data, new Vector<>(Arrays.asList("Column 1", "Column 2", "Column 3")));
        JTable table = new JTable(model);

        // Loại bỏ border bên trong
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        // Thiết lập hiệu ứng đổi màu khi di chuột qua
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                table.clearSelection();
            }
        });

        table.addMouseMotionListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                table.clearSelection();
                if (row >= 0 && row < table.getRowCount()) {
                    table.addRowSelectionInterval(row, row);
                }
            }
        });

        // Thiết lập màu xen kẽ cho các dòng
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    // Chọn màu xen kẽ cho các dòng
                    if (row % 2 == 0) {
                        rendererComponent.setBackground(new Color(240, 240, 240));
                    } else {
                        rendererComponent.setBackground(Color.WHITE);
                    }
                }

                return rendererComponent;
            }
        });

        // Tạo cửa sổ và thêm bảng vào đó
        JFrame frame = new JFrame("Striped Row Table");
        frame.setUndecorated(true);
        
        JPanel nm = new PanelBorder();
        nm.setLayout(null);
        JPanel n = new JPanel();
        n.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        nm.add(n);
        frame.add(nm, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
