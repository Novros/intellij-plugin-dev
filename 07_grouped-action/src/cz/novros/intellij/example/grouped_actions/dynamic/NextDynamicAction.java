package cz.novros.intellij.example.grouped_actions.dynamic;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class NextDynamicAction extends AnAction {
	
	public NextDynamicAction() {
		super("Next dynamic action - only in editor");
	}
	
	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
	}
}
