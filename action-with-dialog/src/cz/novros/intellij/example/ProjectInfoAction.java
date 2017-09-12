package cz.novros.intellij.example;

import javax.swing.*;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class ProjectInfoAction extends AnAction {

	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		final Project project = anActionEvent.getProject();

		if (project != null) {
			final ProjectInfoDialog projectInfoDialog = new ProjectInfoDialog(anActionEvent.getProject());
			projectInfoDialog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Project not found!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
