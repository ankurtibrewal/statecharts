package org.yakindu.sct.generator.core.filesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class HeadlessFileSystemAccess extends AbstractFileSystemAccess implements ISCTFileSystemAccess {
	public static final String BASE_DIR = "filesystemAccess.absolute.baseDir";
	public static final String ENCODING = "filesystemAccess.encoding";

	@Inject
	@Named(ENCODING)
	protected String ENCODING_UTF_8;
	@Inject
	@Named(BASE_DIR)
	protected String absoluteBaseDir;

	@Override
	public void generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		// validate setup
		validateFileSystemAccess();

		OutputConfiguration outputConfig = getOutputConfig(outputConfigurationName);

		File outputDir = getOutputDir(outputConfig);

		String contentsAsString = doPostProcesses(fileName, outputConfigurationName, contents);

		File outputFile = new File(outputDir, fileName);
		if (outputFile.exists()) {
			if (outputConfig.isOverrideExistingResources()) {
				tryOverride(contentsAsString, outputFile);
			}
		} else {
			outputFile.getParentFile().mkdirs();
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			writeContent(contentsAsString, outputFile, ENCODING_UTF_8);
		}
	}

	protected void validateFileSystemAccess() {
		if (this.absoluteBaseDir == null || this.absoluteBaseDir.isEmpty())
			throw new IllegalStateException("the base dir must have been set");
	}

	protected void tryOverride(String contentsAsString, File outputFile) {
		String currentContent = getCurrentContent(outputFile);
		if (isSame(contentsAsString, currentContent)) {
			writeContent(contentsAsString, outputFile, ENCODING_UTF_8);
		} else {
			// ignore same content...
		}
	}

	/**
	 * Respects 'Pigeonhole_principle'.
	 * 
	 * @param newContent
	 * @param currentContent
	 * @return
	 */
	protected boolean isSame(String newContent, String currentContent) {
		return currentContent.hashCode() != newContent.hashCode() &&
				/* Pigeonhole_principle */currentContent.equals(newContent);
	}

	protected String getCurrentContent(File outputFile) {
		String currentContent = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(outputFile));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			currentContent = stringBuilder.toString();
		} catch (FileNotFoundException e1) {
			throw new RuntimeException("Error during load of current file", e1);
		} catch (IOException e) {
			throw new RuntimeException("Error during load of current file", e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// ignore
			}
		}
		return currentContent;
	}

	protected String doPostProcesses(String fileName, String outputConfigurationName, CharSequence contents) {
		CharSequence postProcessedContent = postProcess(fileName, outputConfigurationName, contents);
		String contentsAsString = postProcessedContent.toString();
		return contentsAsString;
	}

	protected File getOutputDir(OutputConfiguration outputConfig) {
		String fullPath = getFullPath(outputConfig);
		File outputDir = new File(fullPath);
		if (!outputDir.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				outputDir.mkdirs();
			} else {
				outputDir = null;
			}
		}
		return outputDir;
	}

	protected String getFullPath(OutputConfiguration outputConfig) {
		String outputDirectory = outputConfig.getOutputDirectory();
		String fullPath = absoluteBaseDir + File.separator
				+ getOutputConfig(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT).getOutputDirectory()
				+ File.separator + outputDirectory;
		return fullPath;
	}

	protected void writeContent(String contentsAsString, File outputFile, String encoding) {
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), encoding));
			out.write(contentsAsString);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				// ignore
			}

		}
	}

	@Override
	public URI getURI(String path, String outputConfiguration) {
		OutputConfiguration outputConfig = getOutputConfig(outputConfiguration);
		return URI.createFileURI(getFullPath(outputConfig) + File.separator + path);
	}

	@Override
	public IFileSystemAccess getIFileSystemAccess() {
		return this;
	}

	@Override
	public void afterGeneration() {
		// currently nothing
	}

}
