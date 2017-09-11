package cz.novros.intellij.example;

import javax.swing.*;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;

public class SaveAction extends AnAction {

	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		final Project project = anActionEvent.getProject();

		final SaveService saveService = project == null ?
				ServiceManager.getService(SaveService.class) :
				ServiceManager.getService(project, SaveService.class);
		
		final SaveState state = saveService.getCurrentState();
		final String newData = JOptionPane.showInputDialog("Current state is: \"" + state.data + "\".");
		
		if (newData != null) {
			state.data = newData;
		}
		
		saveService.setCurrentState(state);
	}
}
