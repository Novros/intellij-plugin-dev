package cz.novros.intellij.example.grouped_actions.dynamic;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DynamicActionGroup extends ActionGroup {

	@NotNull
	@Override
	public AnAction[] getChildren(@Nullable final AnActionEvent event) {
		if (event != null) {
			final Project project = event.getData(CommonDataKeys.PROJECT);

			if (project == null) {
				return defaultActions();
			}

			final Object navigable = event.getData(CommonDataKeys.EDITOR);
			if (navigable != null) {
				return new AnAction[]{new DynamicAction(), new NextDynamicAction()};
			}
		}

		return defaultActions();
	}

	public AnAction[] defaultActions() {
		return new AnAction[]{new DynamicAction()};
	}
}
