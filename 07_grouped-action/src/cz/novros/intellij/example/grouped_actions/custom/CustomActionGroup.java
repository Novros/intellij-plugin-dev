package cz.novros.intellij.example.grouped_actions.custom;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Editor;

public class CustomActionGroup extends DefaultActionGroup {

	@Override
	public void update(final AnActionEvent event) {
		final Editor editor = event.getData(CommonDataKeys.EDITOR);
		event.getPresentation().setVisible(true);
		event.getPresentation().setEnabled(editor != null);
		event.getPresentation().setIcon(editor != null ? AllIcons.General.Information : AllIcons.General.Error);
	}
}
