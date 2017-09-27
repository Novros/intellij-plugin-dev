package cz.novros.intellij.example.grouped_actions.dynamic;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class DynamicAction extends AnAction {
	
	public DynamicAction() {
		super("Dynamic added action");
	}
	
	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		
	}
}
