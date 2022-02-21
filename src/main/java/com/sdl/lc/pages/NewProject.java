package com.sdl.lc.pages;

public class NewProject {
	private final String name = "name";
	private final String location = "location";
	private final String sourceLanguage = "projectSourceLanguage";
	private final String targetLanguage = "projectTargetLanguages";
	private final String fileTypeConfiguration = "configurationId";
	private final String browse = "//*[contains(@class, 'x-btn x-form-file-btn x-unselectable x-btn-link-medium') and count(*//text()[.='browse']) > 0]";
	private final String file = "[class='x-container x-box-item x-container-default'] [class='x-grid-item-container'] table:nth-child(1)>tbody>tr>td:nth-child(2)";
	private final String next = "//*[contains(text(),'Next')]";
	private final String translationEngine = "//input[@placeholder='Select a translation engine']";
	private final String pricingModel = "pricingModelId";
	private final String workflow = "workflowId";
	private final String createAndStart = "//*[contains(text(),'Create & Start')]";
	 
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public String getFileTypeConfiguration() {
		return fileTypeConfiguration;
	}

	public String getBrowse() {
		return browse;
	}
	
	public String getFile() {
		return file;
	}

	public String getNext() {
		return next;
	}

	public String getTranslationEngine() {
		return translationEngine;
	}

	public String getPricingModel() {
		return pricingModel;
	}

	public String getWorkflow() {
		return workflow;
	}

	public String getCreateAndStart() {
		return createAndStart;
	}
}
