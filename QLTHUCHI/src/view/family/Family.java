
package view.family;

import LoginSignup.Model.User;
import controller.FamilyController;
import controller.LogController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import main.MainBoard;
import model.objects.LogO;


public class Family extends javax.swing.JFrame {
    
    private int id_user;
    private MainBoard mainBoard;
    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModelPrice = new DefaultTableModel();
    TypeController typeController = new TypeController();
    LogController logController = new LogController();
    public List<List<String>> UserChoce = new ArrayList<>();
    FamilyController familyController = new FamilyController();

    public Family(int id_user, MainBoard mainBoard) {
        this.id_user = id_user;
        this.mainBoard = mainBoard;
        Calendar c = Calendar.getInstance();
        initComponents();
        initTable();
        initTablePrice();
        fillTable(c);
        setingUITable();
        setDefault();
        setRemoveMember();
        
    }
    
    private void setDefault(){
        int id_group = familyController.getID_Group(id_user);
        label_name_group.setText(familyController.getNameGroup(id_group));
        label_name_group.setHorizontalAlignment(JLabel.CENTER);
        
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-24.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-24.png"));
        button_more.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-more-28.png"));
        Calendar c = Calendar.getInstance();
        setTextLabelDate(c);
        label_date.setHorizontalAlignment(JLabel.CENTER);
       
        if(!familyController.is_HostGroupUser(id_user, id_group)){
            menu_uy_quyen.setVisible(false);
            menu_add_member.setVisible(false);
            menu_remove_member.setVisible(false);
        }
        setLsMember();
        setUyQuyen();
        sum_price_per_month();
    }
    
    private void setRemoveMember(){
        List<User> members = familyController.getUsersGroup(id_user);
        for(User member: members){
            JMenuItem menuItem = new JMenuItem(new AbstractAction(member.getName()) {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_member_func(member);
            }
            });
            if(member.getID() != id_user){
                menu_remove_member.add(menuItem);
            }
        }
    }
    
    private void setLsMember(){
        List<User> members = familyController.getUsersGroup(id_user);
        for(User member: members){
            String name = member.getName();
            if(familyController.is_HostGroupUser(member.getID(), familyController.getID_Group(id_user))){
                name += " (Host)";
            }
            if(member.getID() == id_user){
                name += " (Bạn)";
            }
            JMenuItem menuItem = new JMenuItem(new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            });
            menu_lsMember.add(menuItem);
        }
    }
    private void setUyQuyen(){
        List<User> members = familyController.getUsersGroup(id_user);
        for(User member: members){
            JMenuItem menuItem = new JMenuItem(new AbstractAction(member.getName()) {
            @Override
            public void actionPerformed(ActionEvent e) {
                uy_quyen_member_func(member);
            }
            });
            if(member.getID() != id_user){
                menu_uy_quyen.add(menuItem);
            }
        }
    }
    
    private void delete_member_func(User user){
        int is_outGroup = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa người này ra khỏi nhóm?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(is_outGroup == JOptionPane.YES_OPTION){
            familyController.setOutGroup(user.getID());
            mainBoard.appear_panel_family();
        }
    }
    
    private void uy_quyen_member_func(User user){
        int is_outGroup = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đưa người này làm trưởng nhóm?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(is_outGroup == JOptionPane.YES_OPTION){
            familyController.setID_Host(user.getID(), familyController.getID_Group(id_user));
            mainBoard.appear_panel_family();
        }
    }
    
    public void setTextLabelDate(Calendar c){
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int end_month = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(month) + "/" + String.valueOf(year) +" "
                + "(01/" + String.valueOf(month) + " - "
                +  String.valueOf(end_month) + "/" + String.valueOf(month)
                + ")";
        label_date.setText(date);
    }
    
    private Calendar getMonthYear(){
        String[] date = (String.valueOf(label_date.getText()).split(" "))[0].split("/");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Integer.parseInt(date[0])-1);
        c.set(Calendar.YEAR, Integer.parseInt(date[1]));    
        return c;
    }
    
    private Calendar getPreviousMonth() {
        Calendar calendar = getMonthYear();
        
        if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        } else {
            calendar.roll(Calendar.MONTH, false);
        }

        return calendar;
    }
    private Calendar getNextMonth() {
        Calendar calendar = getMonthYear();

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        } else {
            calendar.roll(Calendar.MONTH, true);
        }

        return calendar;
    }
    
    
    
    private void setingUITable(){
        TableColumn column1 = table_chi.getColumnModel().getColumn(0);
        column1.setPreferredWidth(120);
        TableColumn column2 = table_chi.getColumnModel().getColumn(1);
        column2.setPreferredWidth(250);
        TableColumn column3 = table_chi.getColumnModel().getColumn(2);
        column3.setPreferredWidth(90);
        TableColumn column4 = table_chi.getColumnModel().getColumn(3);
        column4.setPreferredWidth(50);
        TableColumn column5 = table_chi.getColumnModel().getColumn(4);
        column5.setPreferredWidth(50);
        TableColumn column6 = table_chi.getColumnModel().getColumn(5);
        column6.setPreferredWidth(50);
        table_chi.setGridColor(new Color(0xFFFF33));
    }

    private void initTable() {
        String[] header = new String[]{"Người tạo", "Người chi", "Tên", "Loại", "Ngày", "Số tiền"};
        tblModel.setColumnIdentifiers(header);
        table_chi.setModel(tblModel);
        table_chi.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }
    
    public void initTablePrice(){
        tblModelPrice.setRowCount(0);
        List<User> userGroup = familyController.getUsersGroup(id_user);
        List<String> header = new ArrayList<>();
        header.add("");
        for(User user: userGroup){
            header.add(user.getName());
        }
        tblModelPrice.setColumnIdentifiers( header.toArray());
        table_tongket.setModel(tblModelPrice);
        table_tongket.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 14));
        for(User user: userGroup){
            tblModelPrice.addRow(new String[]{user.getName(),"0","0","0","0"});
        }
        tblModelPrice.fireTableDataChanged();
    }
    
    public void fillTable(Calendar c) {
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        List<LogO> LogsGroup = logController.getLogGroup(familyController.getID_Group(id_user), month, year);
        tblModel.setRowCount(0);
        for (LogO log : LogsGroup) {
            User user = logController.getInfoUserById_log(log.getID());
            tblModel.addRow(new String[]{user.getName(),getNguoiKhac(log.getID()),
                log.getNote(), typeController.findTypeByID_Type(log.getID_Type()).getName_Type(),
                log.getDateString(), String.valueOf(log.getPrice())});
        }
        tblModel.fireTableDataChanged();
    }
    
    public void fillTablePrice(Calendar c){
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        List<User> userGroup = familyController.getUsersGroup(id_user);
        Map<Integer, Map<Integer, Double>> price_per_member = familyController.getPriceMemberGroup(id_user, month, year);
        setCorrectPrice(price_per_member, userGroup);
        tblModelPrice.setRowCount(0);
        for(User user: userGroup){
            List<User> userGroup1 = userGroup;
            List<String> row_tmp = new ArrayList<>();
            row_tmp.add(user.getName());
            Map<Integer, Double> row = price_per_member.get(user.getID());
            for(User user1: userGroup1){
                String tmpString = String.format("%.2f", row.get(user1.getID()));
                row_tmp.add(tmpString);
            }
            tblModelPrice.addRow(row_tmp.toArray());
        }
    }
    
    private void setCorrectPrice(Map<Integer, Map<Integer, Double>> price_per_member, List<User> userGroup){
        for(User user: userGroup){
            for(User user1: userGroup){
                double member1 = price_per_member.get(user.getID()).get(user1.getID());
                double member2 = price_per_member.get(user1.getID()).get(user.getID());
                if(member1 > member2){
                    price_per_member.get(user.getID()).put(user1.getID(), member1-member2);
                    price_per_member.get(user1.getID()).put(user.getID(),0.0);
                }
                else{
                    price_per_member.get(user.getID()).put(user1.getID(), 0.0);
                    price_per_member.get(user1.getID()).put(user.getID(),member2-member1);
                }
            }
        }
    }
    
    private String getNguoiKhac(int id_log){
        String name_usersChoice = "<html>";
        int cnt = 1;
        List<List<String>> ls_user_choice = familyController.getUserChoice(id_log);
        for(List<String> user_choice: ls_user_choice){
            if(ls_user_choice.size() == 1){
                name_usersChoice += user_choice.get(1);
            }
            else if(ls_user_choice.size() == cnt){
                name_usersChoice += user_choice.get(1);
            }
            else{
                if(cnt % 2 == 0){
                    name_usersChoice += user_choice.get(1) + "<br>";
                }
                else{
                    name_usersChoice += user_choice.get(1) + ", ";
                }
                
                cnt++;
            }
        }
        return name_usersChoice + "</html>";
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu_more = new javax.swing.JPopupMenu();
        menu_outGroup = new javax.swing.JMenuItem();
        menu_lsMember = new javax.swing.JMenu();
        menu_uy_quyen = new javax.swing.JMenu();
        menu_add_member = new javax.swing.JMenuItem();
        menu_remove_member = new javax.swing.JMenu();
        dialog_addMember = new javax.swing.JDialog();
        text_input_addMember = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        button_add_member = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_name_group = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_chi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        label_sum = new javax.swing.JLabel();
        button_tongket = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_tongket = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        button_add = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_date = new javax.swing.JLabel();
        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();
        button_more = new javax.swing.JButton();

        popupMenu_more.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        popupMenu_more.setFocusable(false);

        menu_outGroup.setText("Rời nhóm");
        menu_outGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_outGroupActionPerformed(evt);
            }
        });
        popupMenu_more.add(menu_outGroup);

        menu_lsMember.setText("Thành viên");
        popupMenu_more.add(menu_lsMember);

        menu_uy_quyen.setText("Ủy quyền");
        popupMenu_more.add(menu_uy_quyen);

        menu_add_member.setText("Thêm thành viên");
        menu_add_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_add_memberActionPerformed(evt);
            }
        });
        popupMenu_more.add(menu_add_member);

        menu_remove_member.setText("Xóa thành viên");
        popupMenu_more.add(menu_remove_member);

        dialog_addMember.setTitle("Thêm thành viên");

        text_input_addMember.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        text_input_addMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_input_addMemberActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Nhập ID, UserName hoặc Gmail:");

        button_add_member.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_add_member.setText("Thêm");
        button_add_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_memberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_addMemberLayout = new javax.swing.GroupLayout(dialog_addMember.getContentPane());
        dialog_addMember.getContentPane().setLayout(dialog_addMemberLayout);
        dialog_addMemberLayout.setHorizontalGroup(
            dialog_addMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_addMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialog_addMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_input_addMember)
                    .addGroup(dialog_addMemberLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_addMemberLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_add_member)
                .addGap(88, 88, 88))
        );
        dialog_addMemberLayout.setVerticalGroup(
            dialog_addMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_addMemberLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_input_addMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(button_add_member)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 605));
        setResizable(false);

        label_name_group.setFont(new java.awt.Font("Segoe Script", 0, 26)); // NOI18N
        label_name_group.setForeground(new java.awt.Color(0, 255, 255));
        label_name_group.setText("Tên gia đình");

        table_chi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_chi.setModel(new javax.swing.table.DefaultTableModel(
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
        table_chi.setToolTipText("");
        table_chi.setGridColor(new java.awt.Color(255, 255, 51));
        table_chi.setRowHeight(45);
        table_chi.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jScrollPane1.setViewportView(table_chi);

        label_sum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_sum.setText("0");

        button_tongket.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_tongket.setText("Tổng kết");
        button_tongket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tongketActionPerformed(evt);
            }
        });

        table_tongket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_tongket);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tổng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_tongket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(82, 82, 82)
                .addComponent(label_sum)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_sum)
                    .addComponent(button_tongket)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        button_add.setBackground(new java.awt.Color(0, 255, 255));
        button_add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Thêm");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 0, 51));
        button_delete.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_delete.setForeground(new java.awt.Color(255, 255, 255));
        button_delete.setText("Xóa");

        button_update.setBackground(new java.awt.Color(51, 255, 0));
        button_update.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Sửa");

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 24));

        label_date.setBackground(new java.awt.Color(0, 255, 204));
        label_date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_date, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(label_date))
        );

        button_pre.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_pre.setPreferredSize(new java.awt.Dimension(24, 24));
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });

        button_next.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_next.setPreferredSize(new java.awt.Dimension(24, 24));
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });

        button_more.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_more.setPreferredSize(new java.awt.Dimension(28, 28));
        button_more.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_moreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 199, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_more, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_name_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_name_group)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_more, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_add)
                        .addComponent(button_update)
                        .addComponent(button_delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        AddLogGroup addLogGroup =  new AddLogGroup(id_user,Family.this);
        addLogGroup.setVisible(true);
    }//GEN-LAST:event_button_addActionPerformed

    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_preActionPerformed
        Calendar c = getPreviousMonth();
        setTextLabelDate(c);
        fillTable(c);
        sum_price_per_month();
        initTablePrice();
    }//GEN-LAST:event_button_preActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        Calendar c = getNextMonth();
        setTextLabelDate(c);
        fillTable(c);
        sum_price_per_month();
        initTablePrice();
    }//GEN-LAST:event_button_nextActionPerformed

    private void button_moreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_moreActionPerformed
        popupMenu_more.show(mainBoard, WIDTH + 910, WIDTH+120);
    }//GEN-LAST:event_button_moreActionPerformed

    private void menu_outGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_outGroupActionPerformed
        int is_outGroup = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn rời khỏi nhóm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(is_outGroup == JOptionPane.YES_OPTION){
            familyController.setOutGroup(id_user);
            mainBoard.appear_panel_none_family();
        }
    }//GEN-LAST:event_menu_outGroupActionPerformed

    private void menu_add_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_add_memberActionPerformed
        dialog_addMember.setSize(280,150);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog_addMember.setLocation(dim.width/2-dialog_addMember.getSize().width/2, dim.height/2-dialog_addMember.getSize().height/2-50);
        dialog_addMember.setVisible(true);
    }//GEN-LAST:event_menu_add_memberActionPerformed

    private void text_input_addMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_input_addMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_input_addMemberActionPerformed

    private void button_add_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_memberActionPerformed
        String input = text_input_addMember.getText();
        int check = familyController.add_member_group(input, familyController.getID_Group(id_user));
        switch (check) {
            case 0 -> JOptionPane.showMessageDialog(this, "Người này không tồn tại!", "Thông báo", JOptionPane.OK_OPTION);
            case -1 -> JOptionPane.showMessageDialog(this, "Người này đã có nhóm!", "Thông báo", JOptionPane.OK_OPTION);
            default -> {
                JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.OK_OPTION);
                dialog_addMember.setVisible(false);
                mainBoard.appear_panel_family();
            }
        }
    }//GEN-LAST:event_button_add_memberActionPerformed

    private void button_tongketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tongketActionPerformed
        fillTablePrice(getMonthYear());
        
    }//GEN-LAST:event_button_tongketActionPerformed

    public void sum_price_per_month(){
        Calendar calendar = getMonthYear();
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        double price = 0;
        List<LogO> LogsGroup = logController.getLogGroup(familyController.getID_Group(id_user), month, year);
        for(LogO log: LogsGroup){
            price += log.getPrice();
        }
        label_sum.setText(String.valueOf(price));
    }
    
    public void getLsNguoiChi(List<List<String>> UserChoce){
        this.UserChoce = UserChoce;
    }
    
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Family(13).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_add_member;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_more;
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JButton button_tongket;
    private javax.swing.JButton button_update;
    private javax.swing.JDialog dialog_addMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_name_group;
    private javax.swing.JLabel label_sum;
    private javax.swing.JMenuItem menu_add_member;
    private javax.swing.JMenu menu_lsMember;
    private javax.swing.JMenuItem menu_outGroup;
    private javax.swing.JMenu menu_remove_member;
    private javax.swing.JMenu menu_uy_quyen;
    private javax.swing.JPopupMenu popupMenu_more;
    private javax.swing.JTable table_chi;
    private javax.swing.JTable table_tongket;
    private javax.swing.JTextField text_input_addMember;
    // End of variables declaration//GEN-END:variables
}
