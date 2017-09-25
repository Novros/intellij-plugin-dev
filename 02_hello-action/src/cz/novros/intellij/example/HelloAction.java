package cz.novros.intellij.example;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * Show hello world from menu H"elp->Hello action".
 */
public class HelloAction extends AnAction {

	/**
	 * Show hello dialog from action menu.
	 *
	 * @param anActionEvent Event with some basic information.
	 */
	@Override
	public void actionPerformed(final AnActionEvent anActionEvent) {
		final Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
		final String projectName = project != null ? project.getName() : "<no-project>";

		Messages.showMessageDialog(project, "Hello world from \"" + projectName + "\" project!",
				"Hello Action", Messages.getInformationIcon());
	}
}
