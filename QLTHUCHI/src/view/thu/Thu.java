package view.thu;

import Utils.Utils;
import com.formdev.flatlaf.FlatLightLaf;
import controller.ActionStoreController;
import controller.DanhMucThu;
import controller.LogController;
import controller.LogsController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import model.objects.ActionStore;
import model.objects.ActionStores;
import model.objects.LogO;
import model.objects.Logs;
import model.objects.LogsDB;
import model.objects.TypeO;
import view.calculator.Calculator;
import view.danhmuc.ThuJPanel;

/**
 *
 * @author LENOVO
 */
public class Thu extends javax.swing.JFrame {

    TypeController typeController;
    LogController logController;
    private int id_user;
    
    public Thu(int id_user) {
        this.id_user = id_user;
        FlatLightLaf.setup();
        initComponents();
        this.initValue();
        setDefaultThings();
        setPanelDanhMuc();
        
    }
    
    
    public void update_valueCalculator(double value){
        text_tienthu.setText(String.valueOf(value));
    }
    
    private void setDefaultThings(){
        dialog_dsThu.setSize(500,500);
        dialog_dsThu.setLocationRelativeTo(null);
        dialog_dsThu.setTitle("Danh sách thu");
        label_title.setHorizontalAlignment(JLabel.CENTER);
        
        button_save.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-pencil-64.png"));
        logController = new LogController();
        jDateChooser1.setDate(Calendar.getInstance().getTime());
        this.setLocationRelativeTo(null);
        button_calculator.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-calculator-64.png"));
        backActionBtn.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-24.png"));
        beforeDateBtn.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-24.png"));
        nextActionBtn.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-24.png"));
        nextDateBtn.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-24.png"));
    }
    
    private void setPanelDanhMuc(){
        
        
        
        typeController = new TypeController();
        List<TypeO> types = typeController.getAllTypeExpenses(id_user);
        int length = types.size();
        int rows = (int)length/3 + 1;
        panel_danhmuc.setLayout(new GridLayout(rows,3));
        
        for(TypeO type:types){
            ImageIcon icon;
            JToggleButton toggleButton;
            if(!(type.getIcon_Path() == null)){
                icon = new ImageIcon(type.getIcon_Path());
                toggleButton = new JToggleButton(type.getName_Type(), icon);
            }
            else{
                toggleButton = new JToggleButton(type.getName_Type());
            }
            
            toggleButton.setFont(new Font("Times New Roman",Font.PLAIN, 16));
            toggleButton.setActionCommand(String.valueOf(type.getID_Type()));
            toggleButton.setForeground(new Color(333333));
            
            toggleButton.setBackground(new Color(255, 230, 230));
            toggleButton.setMaximumSize(new java.awt.Dimension(50, 50));
            toggleButton.setMinimumSize(new java.awt.Dimension(10, 10));
            toggleButton.setPreferredSize(new Dimension(50,50));
            panel_danhmuc.add(toggleButton);
            buttonGroup1.add(toggleButton);
            
        }
    }
    
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialog_dsThu = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        detailsLogFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        timeType = new javax.swing.JComboBox<>();
        transactionScrollPane = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        totalOfTypeInDay = new javax.swing.JLabel();
        totalInDayValue = new javax.swing.JLabel();
        deleteAllBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        curDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panel_title = new javax.swing.JPanel();
        nextActionBtn = new javax.swing.JButton();
        backActionBtn = new javax.swing.JButton();
        beforeDateBtn = new javax.swing.JButton();
        nextDateBtn = new javax.swing.JButton();
        label_title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        text_ghichu = new javax.swing.JTextField();
        text_tienthu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();
        button_calculator = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_danhmuc = new javax.swing.JPanel();
        button_chinhsua1 = new javax.swing.JButton();
        button_danh_sach_thu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialog_dsThu.setModal(true);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Xóa");

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Tất cả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout dialog_dsThuLayout = new javax.swing.GroupLayout(dialog_dsThu.getContentPane());
        dialog_dsThu.getContentPane().setLayout(dialog_dsThuLayout);
        dialog_dsThuLayout.setHorizontalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        dialog_dsThuLayout.setVerticalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_dsThuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(745, 400));

        timeType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng" }));
        timeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTypeActionPerformed(evt);
            }
        });

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mục", "Số tiền", "Ghi chú", "Thời gian", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionTableMouseClicked(evt);
            }
        });
        transactionScrollPane.setViewportView(transactionTable);

        totalOfTypeInDay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalOfTypeInDay.setText("Tổng:");

        totalInDayValue.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalInDayValue.setText("0");

        deleteAllBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteAllBtn.setText("Xóa");
        deleteAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Lọc theo:");

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        curDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        curDate.setText("Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(curDate))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        panel_title.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        nextActionBtn.setBorder(null);
        nextActionBtn.setMaximumSize(new java.awt.Dimension(24, 24));
        nextActionBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        nextActionBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        nextActionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionBtnActionPerformed(evt);
            }
        });

        backActionBtn.setBorder(null);
        backActionBtn.setMaximumSize(new java.awt.Dimension(24, 24));
        backActionBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        backActionBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        backActionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionBtnActionPerformed(evt);
            }
        });

        beforeDateBtn.setBorder(null);
        beforeDateBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        beforeDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeDateBtnActionPerformed(evt);
            }
        });

        nextDateBtn.setBorder(null);
        nextDateBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        nextDateBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        nextDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextDateBtnActionPerformed(evt);
            }
        });

        label_title.setBackground(new java.awt.Color(255, 255, 255));
        label_title.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 255, 255));
        label_title.setText("Danh Sách Thu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(backActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nextActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(759, 759, 759)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(335, 335, 335)
                                        .addComponent(beforeDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(timeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(totalOfTypeInDay)
                                .addGap(47, 47, 47)
                                .addComponent(totalInDayValue))
                            .addComponent(deleteAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteAllBtn)
                            .addComponent(beforeDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(timeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transactionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalInDayValue)
                    .addComponent(totalOfTypeInDay))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout detailsLogFrameLayout = new javax.swing.GroupLayout(detailsLogFrame.getContentPane());
        detailsLogFrame.getContentPane().setLayout(detailsLogFrameLayout);
        detailsLogFrameLayout.setHorizontalGroup(
            detailsLogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLogFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE))
        );
        detailsLogFrameLayout.setVerticalGroup(
            detailsLogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLogFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ngày");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ghi chú");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Tiền thu");

        jDateChooser1.setBackground(new java.awt.Color(245, 177, 109));
        jDateChooser1.setForeground(new java.awt.Color(255, 0, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Danh mục");

        text_ghichu.setBackground(new java.awt.Color(245, 177, 109));
        text_ghichu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_ghichu.setForeground(new java.awt.Color(102, 102, 102));
        text_ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_ghichuActionPerformed(evt);
            }
        });

        text_tienthu.setBackground(new java.awt.Color(245, 177, 109));
        text_tienthu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_tienthu.setForeground(new java.awt.Color(51, 51, 51));
        text_tienthu.setText("0");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("đ");

        button_save.setBackground(new java.awt.Color(242, 242, 242));
        button_save.setForeground(new java.awt.Color(255, 102, 0));
        button_save.setBorder(null);
        button_save.setPreferredSize(new java.awt.Dimension(64, 64));
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_calculator.setBackground(new java.awt.Color(242, 242, 242));
        button_calculator.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_calculator.setBorder(null);
        button_calculator.setMaximumSize(new java.awt.Dimension(64, 64));
        button_calculator.setMinimumSize(new java.awt.Dimension(64, 64));
        button_calculator.setPreferredSize(new java.awt.Dimension(64, 64));
        button_calculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_calculatorActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(625, 111));

        button_chinhsua1.setBackground(new java.awt.Color(242, 86, 29));
        button_chinhsua1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_chinhsua1.setForeground(new java.awt.Color(255, 255, 255));
        button_chinhsua1.setText("Chỉnh sửa");
        button_chinhsua1.setBorder(null);
        button_chinhsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chinhsua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_danhmucLayout = new javax.swing.GroupLayout(panel_danhmuc);
        panel_danhmuc.setLayout(panel_danhmucLayout);
        panel_danhmucLayout.setHorizontalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_chinhsua1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_danhmucLayout.setVerticalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_danhmucLayout.createSequentialGroup()
                .addComponent(button_chinhsua1)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panel_danhmuc);

        button_danh_sach_thu.setBackground(new java.awt.Color(51, 255, 255));
        button_danh_sach_thu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        button_danh_sach_thu.setForeground(new java.awt.Color(255, 255, 255));
        button_danh_sach_thu.setText("Danh sách thu");
        button_danh_sach_thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_danh_sach_thuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Thu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_danh_sach_thu)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1))
                            .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(button_danh_sach_thu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_chinhsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chinhsua1ActionPerformed

        ThuJPanel thuJPanel = new ThuJPanel(id_user);
        JFrame newFrame = new JFrame("Chỉnh sửa");
        newFrame.getContentPane().add(thuJPanel);
        newFrame.setSize(330, 150);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Gọi phương thức để xử lý lại request hoặc làm mới trang
                DanhMucThu.updateDanhMucThuPanel(id_user, panel_danhmuc, buttonGroup1, button_chinhsua1);
            }
        });
        newFrame.setVisible(true);
    }//GEN-LAST:event_button_chinhsua1ActionPerformed

    private void text_ghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ghichuActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        
        int choice_addLog = JOptionPane.showConfirmDialog(Thu.this, "Bạn có chắc muốn thêm vào không!", "Thông báo",JOptionPane.YES_NO_OPTION);
        if(choice_addLog == JOptionPane.YES_OPTION){
            Date date = jDateChooser1.getDate();
        
            if(date == null){
                JOptionPane.showMessageDialog(Thu.this, "Vui lòng nhập đúng định dạng ngày!","Thông báo", JOptionPane.OK_OPTION);
                return;
            }

            String ghichu = text_ghichu.getText();

            int tienthu = 0;
            try {
                tienthu = Integer.parseInt(String.valueOf(text_tienthu.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Thu.this, "Vụi lòng nhập đúng số tiền!", "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            String id_Type = "";

            for (Enumeration<AbstractButton> buttons = buttonGroup1.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    id_Type = button.getActionCommand();
                    break;
                }
            }
            if(id_Type.equals("")){
                JOptionPane.showMessageDialog(Thu.this, "Vui lòng chọn một danh mục!","Thông báo", JOptionPane.OK_OPTION);
                return;
            }
            LogO log = new LogO();
            
            log.setUser_ID(id_user);
            log.setID_Type(Integer.parseInt(id_Type));
            log.setNote(ghichu);
            log.setPrice(tienthu);
            log.setDateString(Utils.converDateToString(date, "dd/MM/yyyy"));
            try {
                logController.addLog(log);
                JOptionPane.showMessageDialog(Thu.this, "Thành Công","Thông báo", JOptionPane.OK_OPTION);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(Thu.this, "Thất bại","Thông báo", JOptionPane.OK_OPTION);
            }
        }
        
        
        
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_calculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_calculatorActionPerformed
        Calculator calculator = new Calculator(this);
        calculator.setVisible(true);
        
    }//GEN-LAST:event_button_calculatorActionPerformed

    private void button_danh_sach_thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_danh_sach_thuActionPerformed
//        dialog_dsThu.setVisible(true);
//        showDetailsLogFrame();
        detailsLogFrame.setSize(850, 450);
        detailsLogFrame.setVisible(true);
        detailsLogFrame.setLocationRelativeTo(null);
        detailsLogFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Gọi hàm khi frame đóng
                actionStoreController.saveHistory();
            }
        });
        this.logsController.filter(conditionsForFilter, conditionsForSort);
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);
        Object[][] tableData = logsController.logDataToTable(rowLogTableStructure);
        for (Object[] item : tableData) {
            model.addRow(item);
        }
    }//GEN-LAST:event_button_danh_sach_thuActionPerformed

    private void timeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTypeActionPerformed
        if (this.timeType.getSelectedItem() == "NgÃ y"){
            this.curTypeOfTime = "d";
            this.conditionsForFilter.removeAllElements();
            this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "from"});
            this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "to"});
        }
        else if (this.timeType.getSelectedItem() == "Tuáº§n"){
            this.curTypeOfTime = "w";
        }
        else if (this.timeType.getSelectedItem() == "ThÃ¡ng"){
            this.curTypeOfTime = "m";
            this.conditionsForFilter.removeAllElements();
            this.conditionsForFilter.add(new Object[]{"date", Utils.getFirstDateInCurMonth(), "from"});
            this.conditionsForFilter.add(new Object[]{"date", Utils.getLastDateInCurMonth(), "to"});
        }
        this.logsController.filter(conditionsForFilter, conditionsForSort);
        this.fillTransactionTable();
    }//GEN-LAST:event_timeTypeActionPerformed

    private void nextDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextDateBtnActionPerformed
        this.curDateValue = Utils.getDateFormattedWithOffset(curDateValue, "d", 1);
        this.curDate.setText(this.curDateValue);
        LogsDB log =  new LogsDB();
        this.conditionsForFilter.removeAllElements();
        this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "from"});
        this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "to"});
        this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        logsController.filter(conditionsForFilter, conditionsForSort);
        this.fillTransactionTable();
        // this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        // this.updateData();
    }//GEN-LAST:event_nextDateBtnActionPerformed

    private void beforeDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeDateBtnActionPerformed
        LogsDB log = new LogsDB();
        this.curDateValue = Utils.getDateFormattedWithOffset(curDateValue, "d", -1);
        this.curDate.setText(this.curDateValue);
        this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        this.conditionsForFilter.removeAllElements();
        this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "from"});
        this.conditionsForFilter.add(new Object[]{"date", this.curDate.getText(), "to"});
        // this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        logsController.filter(conditionsForFilter, conditionsForSort);
        this.fillTransactionTable();
        // this.updateData();
    }//GEN-LAST:event_beforeDateBtnActionPerformed

    private void backActionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionBtnActionPerformed
        
        this.backupContextActionTransactionTable("back");
        
    }//GEN-LAST:event_backActionBtnActionPerformed

    private void nextActionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionBtnActionPerformed

        this.backupContextActionTransactionTable("next");
        
    }//GEN-LAST:event_nextActionBtnActionPerformed

    private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        int row = transactionTable.getSelectedRow();
        int id = (int)model.getValueAt(row, 0);
        System.out.println(model.getValueAt(row, 2));
        double a = 0;
        try {
            a = Double.parseDouble(String.valueOf(model.getValueAt(row, 2)));
//            a = (int) model.getValueAt(row, 2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.changeList.add(id);
        this.logsController.updateDataRow(id, (String)model.getValueAt(row, 3), a);
        if (this.contextBeforeAction.size() == 0){
            this.contextBeforeAction.add(new Object[]{model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 3), model.getValueAt(row, 4), row});
        }
        else if ((int)this.contextBeforeAction.get(0)[0] == (int)model.getValueAt(row, 0)){
            int tmpRow = row;
            //Nếu 2 ptu khác nhau:
            //Tạo 1 hàm check 2 ptu cùng object type
            if (this.contextBeforeAction.get(0)[1] != model.getValueAt(row, 1) || this.contextBeforeAction.get(0)[2] != model.getValueAt(row, 2) || this.contextBeforeAction.get(0)[3] != model.getValueAt(row, 3) || this.contextBeforeAction.get(0)[4] != model.getValueAt(row, 4)){

                row = (int)this.contextBeforeAction.get(0)[5];
                Object[] tmp = this.contextBeforeAction.get(0);
                // this.actionStore.add(new Object[]{tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], "update", row});
                // this.actionStore.add(new Object[]{model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 3), model.getValueAt(row, 4), "update", row});
                // this.indexOfActionStore+=2;
            }
            row = tmpRow;
            this.contextBeforeAction.clear();
            this.contextBeforeAction.add(new Object[]{model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 3), model.getValueAt(row, 4), row});
        }
        this.logsController.updateData();
    }//GEN-LAST:event_transactionTableMouseClicked

    private void deleteAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllBtnActionPerformed
                //lap hang
        Vector<Integer> idList = new Vector<Integer>();
        int idex = this.actionStoreController.getActionStore().getSize();
        try{
            for (int i  =0; i < transactionTable.getRowCount(); i++){
                // Chọn các hàng được chọn
                if (transactionTable.getValueAt(i, 5) != null && (boolean)transactionTable.getValueAt(i, 5) == true){
                    int id = (int)transactionTable.getValueAt(i, 0);
                    //Lấy index trong table
                    int indexInTable = 0;
                    for (int j = 0; j < transactionTable.getRowCount(); j++){
                        if (id == (int)transactionTable.getValueAt(j, 0)){
                            indexInTable = j;
                            break;
                        }
                    }
                    idList.add(id);
                    ActionStore actionStoreItem = new ActionStore(this.logsController.getLogs().getLog(id), "delete", idex, indexInTable);
                    this.actionStoreController.addActionStore(actionStoreItem);
                    // this.actionStoreController.getActionStore().decreaseIndexOfActionStore();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        LogsDB logs = new LogsDB();
        logs.deleteDatas(idList);
        logsController.filter(conditionsForFilter, conditionsForSort);
        // this.logsController.setLogs(logs.getData(this.curDate.getText(), this.curIdOfItemInCategory));
        this.fillTransactionTable();
        // this.logsController.setLogs(logs.getData(this.curDate.getText(), this.curIdOfItemInCategory));
        this.fillTransactionTable();
        
    }//GEN-LAST:event_deleteAllBtnActionPerformed

    public void updateData(){
        LogsDB log = new LogsDB();
        Object[][] te = log.getData(this.curDate.getText(), this.curIdOfItemInCategory);
        Vector<Object[]> data = new Vector<Object[]>();
        int rowCount = transactionTable.getRowCount();
        for (int i =0; i< this.changeList.size(); i++){
            for (int j =0; j < rowCount; j++){
                if (changeList.get(i) == (int)transactionTable.getValueAt(j, 0)){
                    data.add(new Object[]{transactionTable.getValueAt(j, 0), transactionTable.getValueAt(j, 1),transactionTable.getValueAt(j, 2), transactionTable.getValueAt(j, 3), transactionTable.getValueAt(j, 4)});
                    break;
                }
                
            }
        }
        this.changeList.clear(); // clear change list
 
        log.updateData(data);
        this.fillTransactionTable();
    }
    private void backupContextActionTransactionTable(String action){
        if (action == "back"){
            this.logsController.setLogs(this.actionStoreController.backupPreviousAction(this.logsController.getLogs()));

        }
        else if (action == "next"){
            this.logsController.setLogs(this.actionStoreController.backupNextAction(this.logsController.getLogs()));

        }
        this.fillTransactionTable();

    }
    
    private void fillTransactionTable(){
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);
        Object[][] tableData = logsController.logDataToTable(rowLogTableStructure);
        for (Object[] item : tableData) {
            model.addRow(item);
        }
    }  
    
    private void initValue(){
        this.curIdOfMode = 0;
        this.curDateValue = Utils.getCurrentDateFormatted();
        this.curDate.setText(this.curDateValue);
        this.conditionsForFilter = new Vector<Object[]>();
        // this.conditionsForFilter.add(new Object[]{"date", "'2023-12-01'", "from"});
        // this.conditionsForFilter.add(new Object[]{"date", "'2023-12-02'", "to"});
        
        //Thêm điều kiện ngày hôm nay
        this.conditionsForFilter.add(new Object[]{"date",Utils.getCurrentDateFormatted(), "from"});
        this.conditionsForFilter.add(new Object[]{"date",Utils.getCurrentDateFormatted(), "to"});

        this.conditionsForSort = new Vector<Object[]>();
        this.logData = new LogO();
        LogsDB log = new LogsDB();
        // for (Object[] item : log.getData(this.curDate.getText(), this.curIdOfItemInCategory)){
        //     LogO tran = new LogO((int)item[0], (int)item[1], (int)item[2], (String)item[3], (String)item[4]);
        //     this.logs.addLog(tran);
        // }; 
        // this.logs = new Logs(log.getDataV(curDateValue, this.curIdOfMode));
        this.logsController = new LogsController();
        
        this.logsController.filter(conditionsForFilter, conditionsForSort);

        this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), curIdOfMode));
        
        this.curIdOfItemInCategory = (int)log.getFirstItemInCateWithTypeSum("1/12/2023", curIdOfMode)[1];
        
        this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        
        this.changeList = new Vector<Integer>();

        this.actionStore = new ActionStores();

        this.actionStoreController = new ActionStoreController(this.actionStore);
        // this.indexOfActionStore = -1;

        // this.conditionsForSort.add(new Object[]{"date", "ASC"});
        // this.conditionsForSort.add(new Object[]{"amount", "DESC"});

        this.contextBeforeAction = new Vector<Object[]>();
        // System.out.println(log.getFirstItemInCateWithTypeSum("1/12/2023", 1)[0]);
    }
//    private void showDetailsLogFrame(){
//        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//            },
//            new String [] {
//                "ID", "Má»¥c", "Sá»‘ tiá»�n","Ghi chú", "Thời gian", "Chọn"
//            }
//        ) {
//            boolean[] canEdit = new boolean [] {
//                false, false, true, true, false, true
//            };
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                // Ä�áº·t kiá»ƒu dá»¯ liá»‡u cá»§a cá»™t kiá»ƒu boolean lÃ  Boolean
//                return columnIndex == 5 ? Boolean.class : super.getColumnClass(columnIndex);
//            }
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit [columnIndex];
//            }
//        });
//        transactionTableWrapper.setViewportView(transactionTable);
//        
//        
//        detailsLogFrame.setVisible(true);
//        detailsLogFrame.setSize(400, 400);
//        detailsLogFrame.setLocationRelativeTo(null);
//        detailsLogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        detailsLogFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                // Gọi phương thức để xử lý lại request hoặc làm mới trang
//                // DanhMucThu.updateDanhMucThuPanel(id_user, panel_danhmuc, buttonGroup1, button_chinhsua1);
//            }
//        });
//    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thu(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backActionBtn;
    private javax.swing.JButton beforeDateBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_calculator;
    private javax.swing.JButton button_chinhsua1;
    private javax.swing.JButton button_danh_sach_thu;
    private javax.swing.JButton button_save;
    private javax.swing.JLabel curDate;
    private javax.swing.JButton deleteAllBtn;
    private javax.swing.JFrame detailsLogFrame;
    private javax.swing.JDialog dialog_dsThu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_title;
    private javax.swing.JButton nextActionBtn;
    private javax.swing.JButton nextDateBtn;
    private javax.swing.JPanel panel_danhmuc;
    private javax.swing.JPanel panel_title;
    private javax.swing.JTextField text_ghichu;
    private javax.swing.JTextField text_tienthu;
    private javax.swing.JComboBox<String> timeType;
    private javax.swing.JLabel totalInDayValue;
    private javax.swing.JLabel totalOfTypeInDay;
    private javax.swing.JScrollPane transactionScrollPane;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
    private int curIdOfItemInCategory; //id của item trong category
    private int curIdOfMode; //Thu chi
    private String curDateValue; //Ngày hiêện tại
    private String curTypeOfTime;
    private LogsDB logsDB = new LogsDB();
    private Vector<Integer> changeList;
    private Vector<Object[]> conditionsForFilter;
    private Vector<Object[]> conditionsForSort;
    private Vector<Object[]> contextBeforeAction;
    private ActionStores actionStore;
    private ActionStore actionStoreItem;
    private LogO logData;
    private ActionStoreController actionStoreController;
    // private Logs logs;
    private Logs logs;
    private LogsController logsController;
    private String[] rowLogTableStructure = new String[]{"id", "idOfItemInCategory", "price", "note", "date"};


}
