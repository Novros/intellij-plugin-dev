package cz.novros.intellij.example.custom_action;

import java.net.URL;

import javax.swing.*;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.JBColor;

import org.jetbrains.annotations.NotNull;

public abstract class ShowFileInformationAction extends AnAction {

	protected ShowFileInformationAction() {
		super(getIconFromResource());
	}

	protected void tryShowFileInformationFromAction(@NotNull final AnActionEvent event) {
		final Object navigable = event.getData(CommonDataKeys.VIRTUAL_FILE);
		if (navigable != null) {
			showFileInformation((VirtualFile) navigable);
		}
	}

	protected void showFileInformation(@NotNull final VirtualFile file) {
		final StringBuilder fileInfo = new StringBuilder();

		fileInfo.append("Name: ").append(file.getName()).append("\n");
		fileInfo.append("Path: ").append(file.getCanonicalPath()).append("\n");
		fileInfo.append("Url: ").append(file.getUrl()).append("\n");
		fileInfo.append("FileType: ").append(file.getFileType().getName()).append("\n");
		fileInfo.append("Charset: ").append(file.getCharset()).append("\n");
		fileInfo.append("Length: ").append(file.getLength()).append("\n");
		fileInfo.append("Timestamp: ").append(file.getTimeStamp()).append("\n");
		fileInfo.append("Presentable name: ").append(file.getPresentableName()).append("\n");
		fileInfo.append("Presentable url: ").append(file.getPresentableUrl()).append("\n");
		fileInfo.append("Modification count: ").append(file.getModificationCount()).append("\n");
		fileInfo.append("Modification stamp: ").append(file.getModificationStamp()).append("\n");

		Messages.showDialog(fileInfo.toString(), "File Info", new String[]{"OK"}, -1, null);
	}

	protected static Icon getIconFromResource() {
		final String iconName = JBColor.isBright() ? "icon_black.png" : "icon_white.png";
		final URL iconUrl = ShowFileInformationAction.class.getClassLoader().getResource(iconName);
		return iconUrl == null ? null : new ImageIcon(iconUrl);
	}
}
