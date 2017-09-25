package cz.novros.intellij.example.custom_action;

import com.intellij.openapi.actionSystem.AnActionEvent;

public class PopupMenuAction extends ShowFileInformationAction {

	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		tryShowFileInformationFromAction(anActionEvent);
	}
}
