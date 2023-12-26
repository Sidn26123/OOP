/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.thu;

import Utils.Utils;
import controller.ActionStoreController;
import controller.LogsController;
import java.awt.CardLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.objects.ActionStore;
import model.objects.ActionStores;
import model.objects.LogO;
import model.objects.Logs;
import model.objects.LogsDB;

/**
 *
 * @author sidac
 */
public class TestD extends javax.swing.JFrame {

    /**
     * Creates new form TestD
     */
    public TestD() {
        initComponents();
        add();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curDate = new javax.swing.JLabel();
        nextDateBtn = new javax.swing.JButton();
        preDateBtn = new javax.swing.JButton();
        transactionTableWrapper = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        deleteAllBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nextActionBtn = new javax.swing.JToggleButton();
        backActionBtn = new javax.swing.JToggleButton();
        totalOfTypeInDay = new javax.swing.JLabel();
        totalOfTypeInDayValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalInDayValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        curDate.setText("jLabel2");

        nextDateBtn.setText("jButton5");

        preDateBtn.setText("jButton5");

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        transactionTableWrapper.setViewportView(transactionTable);

        deleteAllBtn.setText("jButton3");

        jButton4.setText("jButton4");

        nextActionBtn.setText("jToggleButton1");

        backActionBtn.setText("jToggleButton1");

        totalOfTypeInDay.setText("Tổng mục:");

        totalOfTypeInDayValue.setText("jLabel1");

        jLabel1.setText("Tổng: ");

        totalInDayValue.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transactionTableWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(curDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(preDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nextDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(totalOfTypeInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(totalOfTypeInDayValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteAllBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(totalInDayValue, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(curDate, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextDateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preDateBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalOfTypeInDay)
                        .addComponent(jLabel1)
                        .addComponent(totalInDayValue))
                    .addComponent(totalOfTypeInDayValue, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteAllBtn)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextActionBtn)
                        .addComponent(backActionBtn)))
                .addGap(18, 18, 18)
                .addComponent(transactionTableWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void add(){
        JFrame showDetailsLogsFrame = new JFrame();
        showDetailsLogsFrame.setType(JFrame.Type.UTILITY);
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Mục", "Số tiền","Ghi chú", "Thời gian", "Chọn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Ä�áº·t kiá»ƒu dá»¯ liá»‡u cá»§a cá»™t kiá»ƒu boolean lÃ  Boolean
                return columnIndex == 5 ? Boolean.class : super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                transactionTableMouseClicked(evt);
            }
        });
        
    }
        private void deleteAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllBtnActionPerformed
        //lap hang
        Vector<Integer> idList = new Vector<Integer>();
        int idex = this.actionStoreController.getActionStore().getSize();
        try{
            for (int i  =0; i < transactionTable.getRowCount(); i++){
                // Chá»�n cÃ¡c hÃ ng Ä‘Æ°á»£c chá»�n
                if (transactionTable.getValueAt(i, 5) != null && (boolean)transactionTable.getValueAt(i, 5) == true){
                    int id = (int)transactionTable.getValueAt(i, 0);
                    //Láº¥y index trong table
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
        // this.logsController.setLogs(logs.getData(this.curDate.getText(), this.curIdOfItemInCategory));
        this.fillTransactionTable();
    }
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
        private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        int row = transactionTable.getSelectedRow();
        int id = (int)model.getValueAt(row, 0);
        this.changeList.add(id);
        if (this.contextBeforeAction.size() == 0){
            this.contextBeforeAction.add(new Object[]{model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2), model.getValueAt(row, 3), model.getValueAt(row, 4), row});
        }
        else if ((int)this.contextBeforeAction.get(0)[0] == (int)model.getValueAt(row, 0)){
            int tmpRow = row;
            //Náº¿u 2 ptu khÃ¡c nhau:
            //Táº¡o 1 hÃ m check 2 ptu cÃ¹ng object type
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
        // for (Object[] item:this.actionStore){
        //     System.out.println("id: " + item[0] + " idOfItemInCategory: " + item[1] + " amount: " + item[2] + " note: " + item[3] + " action: " + item[4] + " index: " + item[5] + " cur: " + this.indexOfActionStore);
        // }
    }
         private void timeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTypeActionPerformed
        if (this.timeType.getSelectedItem() == "Ngày"){
            this.curTypeOfTime = "d";
        }
        else if (this.timeType.getSelectedItem() == "Tuần"){
            this.curTypeOfTime = "w";
        }
        else if (this.timeType.getSelectedItem() == "Tháng"){
            this.curTypeOfTime = "m";
        }
    }
             private void updateIncomSpent(){
        Object[] a = logsDB.getFirstItemInCateWithTypeSum(this.curDateValue, this.curIdOfMode);
        this.curIdOfItemInCategory = (int)a[1];
        this.totalInDayValue.setText("" + a[0]);
        // this.totalInDayValue.setText("" + logs.getSpecSum(this.curDate.getText(), this.curIdOfMode));
    }
    private void fillTransactionTable(){
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);
        Object[][] tableData = logsController.logDataToTable(rowLogTableStructure);
        for (Object[] item : tableData) {
            model.addRow(item);
        }
    }  
        private void addDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataBtnActionPerformed
        int amount = 0;
        try {
            // Chuyá»ƒn Ä‘á»•i chuá»—i thÃ nh sá»‘ nguyÃªn
            amount = Integer.parseInt(this.amountText.getText().trim());

            // In ra giÃ¡ trá»‹ sá»‘ nguyÃªn Ä‘Ã£ chuyá»ƒn Ä‘á»•i
        } catch (NumberFormatException e) {
            // Xá»­ lÃ½ náº¿u chuá»—i khÃ´ng thá»ƒ chuyá»ƒn Ä‘á»•i thÃ nh sá»‘ nguyÃªn
            System.out.println("Lá»—i chuyá»ƒn Ä‘á»•i: " + e.getMessage());
        }

        String note = this.noteText.getText();
        String date = this.curDateValue;
        int idOfItemInCategory = this.curIdOfItemInCategory;
        LogsDB log = new LogsDB();
        
        log.insertData(new Object[]{idOfItemInCategory, amount, note, date});
        
        // this.transactions.add(new Object[]{log.getLastId(), idOfItemInCategory, amount, note, date});
        this.logsController.addLog(new LogO(log.getLastId(), idOfItemInCategory, amount, note, date));
        
        this.totalInDayValue.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));

        this.logData = new LogO(log.getLastId(), this.curIdOfItemInCategory, amount, note, date);
        
        if (this.actionStore.getLastAction() == null){
            this.actionStoreItem = new ActionStore(this.logData, "add", 0, this.logsController.getLogs().getSize()-1);
        }
        else{
            this.actionStoreItem = new ActionStore(this.logData, "add", this.actionStore.getLastAction().getIndex()+1, this.logsController.getLogs().getSize()-1);
        }

        this.actionStoreController.addActionStore(actionStoreItem);
        showTransacsMouseClicked();
    }
    private void showTransacsMouseClicked() {//GEN-FIRST:event_showTransacsMouseClicked
//        CardLayout showTransactionLayout = (CardLayout) getDataPanel.getLayout();
//        showTransactionLayout.next(getDataPanel);
        // for (Object[] item: conditionsForFilter){
        //     System.out.println(item[0] + " " + item[1] + " " + item[2]);
        // }
        this.logsController.filter(conditionsForFilter, conditionsForSort);
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);
        Object[][] tableData = logsController.logDataToTable(rowLogTableStructure);
        for (Object[] item : tableData) {
            model.addRow(item);
        }
        // this.fill
    }
        private void initValue(){
        this.curIdOfMode = 0;
        this.curDateValue = Utils.getCurrentDateFormatted();
        this.curDate.setText(this.curDateValue);
        this.conditionsForFilter = new Vector<Object[]>();
        // this.conditionsForFilter.add(new Object[]{"date", "'2023-12-01'", "from"});
        // this.conditionsForFilter.add(new Object[]{"date", "'2023-12-02'", "to"});
        
        //ThÃªm Ä‘iá»�u kiá»‡n ngÃ y hÃ´m nay
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
        
        this.totalAmoutInDate.setText("" + log.getSpecSum(this.curDate.getText(), this.curIdOfMode));
        
        this.changeList = new Vector<Integer>();

        this.actionStore = new ActionStores();

        this.actionStoreController = new ActionStoreController(this.actionStore);
        // this.indexOfActionStore = -1;

        // this.conditionsForSort.add(new Object[]{"date", "ASC"});
        // this.conditionsForSort.add(new Object[]{"amount", "DESC"});

        this.contextBeforeAction = new Vector<Object[]>();
        // System.out.println(log.getFirstItemInCateWithTypeSum("1/12/2023", 1)[0]);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        }
        catch (Exception ex){
            ;
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton backActionBtn;
    private javax.swing.JLabel curDate;
    private javax.swing.JButton deleteAllBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton nextActionBtn;
    private javax.swing.JButton nextDateBtn;
    private javax.swing.JButton preDateBtn;
    private javax.swing.JLabel totalInDayValue;
    private javax.swing.JLabel totalOfTypeInDay;
    private javax.swing.JLabel totalOfTypeInDayValue;
    private javax.swing.JTable transactionTable;
    private javax.swing.JScrollPane transactionTableWrapper;
    // End of variables declaration//GEN-END:variables
        private javax.swing.JButton addDataBtn;
    private javax.swing.JPanel addTransactionPanel;
    private javax.swing.JTextField amountText;
    private javax.swing.JButton analyzeBtn;
    private javax.swing.JPanel analyzeWrapper;
    private javax.swing.JLabel appIcon;
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JLabel availableAmountLabel;
    private javax.swing.JLabel availableAmountValue;
    private javax.swing.JButton beforeDateBtn;
    private javax.swing.JPanel budgetAllocationWrapper;
    private javax.swing.JLabel byAmount;
    private javax.swing.JLabel byDate;
    private javax.swing.JButton calendarBtn;
    private javax.swing.JPanel calendarHeader;
    private javax.swing.JLabel calendarIconInHeader;
    private javax.swing.JPanel calendarWrapper;
    private javax.swing.JPopupMenu categoryPopupMenu;
    private javax.swing.JScrollPane categorySpace;
    private javax.swing.JMenuItem changeTheme;
    private javax.swing.JPanel colNamePanel1;
    private javax.swing.JLabel conditionLabel;
    private javax.swing.JLabel curDateLabel;
    private javax.swing.JLabel curMonthLabel;
    private javax.swing.JLabel dateConditionLabel;
    private javax.swing.JLabel dateInMonth;
    private javax.swing.JPanel dateSelectionPanel;
    private javax.swing.JPanel filterContainer;
    private javax.swing.JLabel fromAmountLabel;
    private javax.swing.JTextField fromAmountValueText;
    private javax.swing.JLabel fromDateLabel;
    private javax.swing.JTextField fromDateValueText;
    private javax.swing.JPanel getDataPanel;
    private javax.swing.JLabel incomeAmountInDate;
    private javax.swing.JPanel incomeAndSpentWrapper;
    private javax.swing.JButton incomeBtn;
    private javax.swing.JButton itemCategoryIcon;
    private javax.swing.JPanel itemCategoryWrapper;
    private javax.swing.JPanel itemInCategory;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel mainCardLayout;
    private javax.swing.JMenuItem modifyItemCategory;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton moreFunctionBtn;
    private javax.swing.JPopupMenu moreFunctionPopupMenu;
    private javax.swing.JPanel nameAppPanel;
    private javax.swing.JButton nextMonth;
    private javax.swing.JTextArea noteText;
    private javax.swing.JButton previousMonth;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel showCalendarSpace;
    private javax.swing.JButton showTransacs;
    private javax.swing.JPanel showTransactionPanel;
    private javax.swing.JButton smallCalendarIcon;
    private javax.swing.JLabel sortLabel;
    private javax.swing.JLabel spentAmountInDate;
    private javax.swing.JButton spentBtn;
    private javax.swing.JPanel testPanel1;
    private javax.swing.JPanel testPanel2;
    private javax.swing.JPanel testPanel3;
    private javax.swing.JComboBox<String> timeType;
    private javax.swing.JLabel toAmountLabel;
    private javax.swing.JTextField toAmountValueText;
    private javax.swing.JLabel toDateLabel;
    private javax.swing.JTextField toDateTextValue;
    private javax.swing.JLabel totalAmoutInDate;
    private javax.swing.JLabel totalInDayLabel;
    private javax.swing.JScrollPane transactionScrollPane;
    
    // End of variables declaration//GEN-END:variables
    private int curIdOfItemInCategory; //id cá»§a item trong category
    private int curIdOfMode; //Thu chi
    private String curDateValue; //NgÃ y hiÃªá»‡n táº¡i
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
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JPanel calendarItem;
    private javax.swing.JPanel calendarShowPanel;
    // private javax.swing.JPanel calendarWrapper;
    private javax.swing.JButton dateChooseBtn;
    private javax.swing.JLabel dateItemLabel;
    private javax.swing.JLabel incomeValueLabel;
    // private javax.swing.JPanel jPanel3;
    // private javax.swing.JPanel jPanel4;
    // private javax.swing.JPanel jPanel5;
    // private javax.swing.JPanel jPanel7;
    // private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField label_date;
    private javax.swing.JLabel spentValueLabel;
    private javax.swing.JLabel totalValueLabel;
}