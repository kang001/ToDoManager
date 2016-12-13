package com.Kara;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stiri on 12/12/2016.
 */
public class ToDoGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField newToDoTextField;
    private JButton addToDoButton;
    private JList toDoList;
    private JButton newListButton;
    private JButton viewListsButton;
    private JButton viewCompletedItemsButton;

    private DefaultListModel<String> listModel;

    protected ToDoGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));

        listModel = new DefaultListModel<String>();

        toDoList.setModel(listModel);

        addListeners();

        pack();
        setVisible(true);


    }
    private void addListeners(){
        addToDoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String newToDo = newToDoTextField.getText();
                newToDo = newToDo.trim();

                if (newToDo.length() == 0){
                    return;
                }

                listModel.addElement(newToDo);
                newToDoTextField.setText("");
                }
            });

        toDoList.addListSelectionListener((new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1){
                    listModel.remove(selectedIndex);
                }
        }
    }));

}
}
