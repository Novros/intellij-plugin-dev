package cz.novros.intellij.example.custom_action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;

/**
 * Action based on information from  <a href="https://www.jetbrains.org/intellij/sdk/docs/tutorials/action_system/working_with_custom_actions.html">Action tutorial</a>.
 */
public class EditorToolsMenuAction extends ShowFileInformationAction {

	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		tryShowFileInformationFromAction(anActionEvent);
	}

	/**
	 * Action is visible only if file user is in editor.
	 */
	@Override
	public void update(final AnActionEvent event) {
		final Project project = event.getData(CommonDataKeys.PROJECT);

		if (project == null) {
			return;
		}

		final Object navigable = event.getData(CommonDataKeys.EDITOR);
		event.getPresentation().setEnabledAndVisible(navigable != null);
	}
}
