package com.sdl.lc.pages;

public class ProjectsView {
	private final String projects = "//a[contains(@class, 'x-btn') and count(*//text()[.='Projects']) > 0]";
	private final String newProject = "//a[contains(@class, 'x-btn') and count(*//text()[.='New Project']) > 0]";
	private final String createdNotification = "//*[contains(text(),'Successfully created your project')]";
	private final String startedNotification = "//*[contains(text(),'Successfully started the workflow')]";
	private final String project = "[class='x-grid-item-container'] table:nth-child(1)>tbody>tr>td:nth-child(3) [class='action-link']";

	public String getProjects() {
		return projects;
	}

	public String getNewProject() {
		return newProject;
	}

	public String getCreatedNotification() {
		return createdNotification;
	}

	public String getStartedNotification() {
		return startedNotification;
	}

	public String getProject() {
		return project;
	}
}
