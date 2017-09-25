package cz.novros.intellij.example;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.VetoableProjectManagerListener;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import org.jetbrains.annotations.NotNull;

public class HelloToolbar implements ApplicationComponent {

	@NotNull
	@Override
	public String getComponentName() {
		return "Hello toolbar";
	}

	@Override
	public void initComponent() {
		// Method to do some action (load, initialize gui and resources, and so on) before component is fully showed.
		ProjectManager.getInstance().addProjectManagerListener(new VetoableProjectManagerListener() {
			@Override
			public boolean canClose(@NotNull final Project project) {
				return true;
			}

			public void projectOpened(final Project project) {
				final ToolWindowManager twm = ToolWindowManager.getInstance(project);

				final Runnable laterTask = () -> {
					final ToolWindow toolWindow = twm.registerToolWindow("Hello toolbar window", true, ToolWindowAnchor.RIGHT);
					final ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
					final Content content = contentFactory.createContent(new View(), "", false);

					toolWindow.getContentManager().addContent(content);
				};
				twm.invokeLater(laterTask);
			}

			public void projectClosed(final Project project) {
			}
		});
	}

	@Override
	public void disposeComponent() {
		// Method to do some action (save, free resources, and so on) before component is removed.
	}
}
