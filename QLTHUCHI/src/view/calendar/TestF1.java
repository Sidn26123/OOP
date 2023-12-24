package view.calendar;

import charts.chart.BarChart.ModelChart;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TestF1 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("No Header Frame Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the frame undecorated to remove the header
            frame.setUndecorated(true);
            // Create a layout manager for the frame

            // Set the size of the frame
            frame.setSize(new Dimension(300, 200));

            // Center the frame on the screen
                        JPanel p1 = new JPanel();
            p1.setBackground(Color.DARK_GRAY);
                                    JPanel p2 = new JPanel();
            p1.setBackground(Color.DARK_GRAY);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridLayout(1, 1));

            // Make the frame visible
            frame.setVisible(true);

            // Map the string "frame" to the JFrame
            KeyStroke ctrlNKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
            KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
            JLabel a = new JLabel("as");


            // Assign shortcut Ctrl + N to the frame
            frame.getRootPane().getInputMap().put(ctrlNKeyStroke, "ctrlN");
            frame.getRootPane().getActionMap().put("ctrlN", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gọi hàm tương ứng với Ctrl + N ở đây
                    handleCtrlN(frame);
                }
            });
            addCtrlX(frame);
                    Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector1);
        data.add(vector2);
        data.add(vector3);
//        JTable a = view.chi.renders.renderTransactionTableWithFrame(data);
        charts.chart.BarChart.Chart chart = new charts.chart.BarChart.Chart();
//        JTable a = Utils.EnchaneTable.enchanedTable(datas, new String[]{"id", "d", "d", "d", "d"}, new boolean[]{false, false, true, true, true});
        chart.addLegend("Income", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80,89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90,150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460,900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750,700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300,150}));
        chart.addData(new Object[]{"Junes", 190.0,280.0,81.0,200.0});
//        n.add(chart);
        frame.add(chart);
                chart.start();
        frame.validate();
        frame.repaint();
            // Assign shortcut Ctrl + X to the frame
//            frame.getRootPane().getInputMap().put(ctrlXKeyStroke, "ctrlX");
//            frame.getRootPane().getActionMap().put("ctrlX", new AbstractAction() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Gọi hàm tương ứng với Ctrl + X ở đây
//                    handleCtrlX(frame);
//                    frame.setBackground(Color.BLACK);                }
//            });
        });
    }

    // Hàm xử lý khi nhấn Ctrl + N
    private static void handleCtrlN(JFrame frame) {
        JLabel l = new JLabel();
        l.setText("sdasdasd");
        JPanel n = new JPanel();
        frame.getContentPane().setBackground(Color.BLUE);
//        Object[][] datas = new Object[][]{
//            {1, 2, 3, "Hello", "World"},
//            {4, 5, 6, "Java", "Programming"},
//            {7, 8, 9, "OpenAI", "GPT-3.5"}
//        };
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector1);
        data.add(vector2);
        data.add(vector3);
//        JTable a = view.chi.renders.renderTransactionTableWithFrame(data);
        charts.chart.BarChart.Chart chart = new charts.chart.BarChart.Chart();
//        JTable a = Utils.EnchaneTable.enchanedTable(datas, new String[]{"id", "d", "d", "d", "d"}, new boolean[]{false, false, true, true, true});
        chart.addLegend("Income", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80,89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90,150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460,900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750,700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300,150}));
        chart.addData(new Object[]{"Junes", 190.0,280.0,81.0,200.0});
//        n.add(chart);
        frame.add(chart);
                chart.start();

        createStripedRowTable();
        
        frame.validate();
        
        frame.repaint();
    }

    // Hàm xử lý khi nhấn Ctrl + X
    private static void handleCtrlX(JFrame frame) {
        frame.dispose();
    }
    private static void addCtrlX(JFrame frame){
        KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
            frame.getRootPane().getInputMap().put(ctrlXKeyStroke, "ctrlX");
            frame.getRootPane().getActionMap().put("ctrlX", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gọi hàm tương ứng với Ctrl + X ở đây
                    handleCtrlX(frame);
                    frame.setBackground(Color.BLACK);                }
            });
    }
//    private static void addCtrlX(JTable frame){
//        KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
//            frame.getRootPane().getInputMap().put(ctrlXKeyStroke, "ctrlX");
//            frame.getRootPane().getActionMap().put("ctrlX", new AbstractAction() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Gọi hàm tương ứng với Ctrl + X ở đây
////                    handleCtrlX(frame);
//                    frame.
//            });
//    }
    private static void createStripedRowTable() {
//        // Dữ liệu mẫu
        view.render.enhanceTable renderTable = new view.render.enhanceTable();
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector1);
        data.add(vector2);
        data.add(vector3);
//
//        // Tạo bảng và mô hình
//        DefaultTableModel model = new DefaultTableModel(data, new Vector<>(Arrays.asList("Column 1", "Column 2", "Column 3"))) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                // Chỉnh sửa tính chất có thể chỉnh sửa của các cột
//                return column == 2; // Chỉ cột thứ 3 (index 2) có thể chỉnh sửa
//            }
//        };
//        JTable table = new JTable(model);
//
//        // Loại bỏ border bên trong
//        table.setShowGrid(false);
//        table.setIntercellSpacing(new Dimension(0, 0));
//
//        // Thiết lập hiệu ứng đổi màu khi di chuột qua
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseExited(MouseEvent evt) {
//                table.clearSelection();
//            }
//        });
//
//        table.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent evt) {
//                int row = table.rowAtPoint(evt.getPoint());
//                table.clearSelection();
//                if (row >= 0 && row < table.getRowCount()) {
//                    table.addRowSelectionInterval(row, row);
//                }
//            }
//        });
//
//        // Thiết lập màu xen kẽ cho các dòng
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//                
//                
//                if (!isSelected) {
//                    // Chọn màu xen kẽ cho các dòng
//                    if (row % 2 == 0) {
//                        rendererComponent.setBackground(new Color(240, 240, 240));
//                    } else {
//                        rendererComponent.setBackground(Color.WHITE);
//                    }
//                }
//
//                return rendererComponent;
//            }
//        });
//        JTableHeader tableHeader = table.getTableHeader();
//
//        // Lấy TableColumnModel từ JTableHeader
//        TableColumnModel columnModel = tableHeader.getColumnModel();
//
//        // Lấy số lượng cột
//        int columnCount = columnModel.getColumnCount();
//
//        // Lấy từng TableColumn cụ thể
//        for (int i = 0; i < columnCount; i++) {
//            TableColumn column = columnModel.getColumn(i);
////            tableHeader.getColumnModel().getColumn(i).addMouseListener()
//
//        }
//        JTableHeader tableHeader1 = table.getTableHeader();
//        tableHeader1.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                int column = tableHeader1.columnAtPoint(e.getPoint());
//                if (column != -1 && column != flagIndex) {
//                    System.out.println(column + " " + flagIndex);
//                    tableHeader1.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
//                    if (flagIndex != -1){
//                        tableHeader1.getColumnModel().getColumn(flagIndex).setHeaderRenderer(new CustomHeaderRendererBack());
//                    }
//                    tableHeader1.repaint();
//                    flagIndex = column;
//
//                }
//            }
//            
////            @Override
////            public void mouseEntered(MouseEvent e) {
////                int column = tableHeader1.columnAtPoint(e.getPoint());
////                if (column != -1) {
////                    String columnName = table.getColumnName(column);
////                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
////                    tableHeader.repaint();
////                }
////            }
////            
//            @Override
//            public void mouseExited(MouseEvent e) {
//                int column = tableHeader1.columnAtPoint(e.getPoint());
////                if (column != -1) {
////                    String columnName = table.getColumnName(column);
////                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
////                    tableHeader.repaint();
////                }
//                System.out.println("a" + column);
//                for (int i =0 ; i< columnCount; i++){
//                    tableHeader1.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
////                    tableHeader.repaint()
//                }
//                tableHeader1.repaint();
//            }
//        });
//
//        // Thêm sự kiện chuột để lấy cell header hiện tại
//        tableHeader1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                int column = tableHeader1.columnAtPoint(e.getPoint());
//                if (column != -1) {
//                    
//                    String columnName = table.getColumnName(column);
//                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
//                    tableHeader.repaint();
//                    
//                }
//            }
//            
//            @Override
//            public void mouseExited(MouseEvent e) {
//                int column = tableHeader1.columnAtPoint(e.getPoint());
//                if (column != -1) {
//                    String columnName = table.getColumnName(column);
//                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
//                    tableHeader.repaint();
//                }
//            }
//            
////    @Override
////    public void mouseMoved(MouseEvent e) {
//////        int column = tableHeader.columnAtPoint(e.getPoint());
//////        if (column != -1) {
////            // Xử lý khi chuột di chuyển trên ô header
////            System.out.println("Mouse moved over header cell: ");
//////        }
////    }
//        });
////        
//        // Đặt ActionListener cho cột khi click vào header
////        table.getTableHeader().addMouseListener(new MouseAdapter() {
////            @Override
////            public void mouseEntered(MouseEvent e) {
////                table.getTableHeader().setBackground(Color.YELLOW);
////            }
////
////            @Override
////            public void mouseExited(MouseEvent e) {
////                table.getTableHeader().setBackground(UIManager.getColor("TableHeader.background"));
////            }
////        });
//
//        // Tạo cửa sổ và thêm bảng vào đó
//        table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JTable table = renderTable.renderTransactionTableWithFrame(data);
//        JTable table = Utils.
        JFrame frame = new JFrame("Striped Row Table");
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(500, 300);
        handleCtrlX(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private static void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.YELLOW);
            return headerComponent;
        }
    }
        private static class CustomHeaderRendererBack extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.LIGHT_GRAY);
            return headerComponent;
        }
    }
        private static int flagIndex = -1;
}
