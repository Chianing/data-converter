package com.chianing.plugin.dataconverter.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

public class PopDialog extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // Using the event, create and show a dialog
        Project currentProject = e.getProject();
        StringBuilder dlgMsg = new StringBuilder(e.getPresentation().getText() + " Selected!");
        String dlgTitle = e.getPresentation().getDescription();
        // If an element is selected in the editor, add info about it.
        Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
        if (nav != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", nav));
        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());

    }
}
