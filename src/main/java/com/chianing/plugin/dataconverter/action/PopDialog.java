package com.chianing.plugin.dataconverter.action;

import com.chianing.plugin.dataconverter.ui.DataInputForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

public class PopDialog extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        JFrame frame = new JFrame("DataInputForm");
        DataInputForm dataInputForm = new DataInputForm(frame);
        frame.setContentPane(dataInputForm.getBackground());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
