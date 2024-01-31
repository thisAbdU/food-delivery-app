package frontend;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class TaskManage extends Restaurants {
    private static final List<Object[]> data = new ArrayList<>();
    private JScrollPane scrollPane;

    public TaskManage() {
        super();
        fetchDataFromDatabase(); // Fetch data (dummy for now)

        String[] columnNames = {"Food", "Quantity", "Restaurant", "Delivery Address", "Status", "Confirm Delivery"};

        Object[][] rowData = data.toArray(new Object[0][]);

        JTable table = new JTable(rowData, columnNames);
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
        scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void fetchDataFromDatabase() {
        // In a real application, connect to the database and fetch data.
        // For now, let's add some dummy data.
        addRow("Value11", "Value12", "Value13", null, null, null, null);
        // Add more data as needed
    }

    private void addRow(Object... rowData) {
        data.add(rowData);
    }

    public static void main(String[] args) {
        TaskManage taskManage = new TaskManage();
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Delivered");
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Perform action when button is pressed
                JOptionPane.showMessageDialog(null, "Task delivered!");
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
