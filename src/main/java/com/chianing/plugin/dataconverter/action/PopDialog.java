package com.chianing.plugin.dataconverter.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.awt.event.InputEvent;

public class PopDialog extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // Using the event, create and show a dialog
        Project currentProject = e.getProject();
        InputEvent inputEvent = e.getInputEvent();
        inputEvent.consume();

        Messages.showMessageDialog(currentProject, "", "", Messages.getInformationIcon());

    }
}
