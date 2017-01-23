package refresher.practice.misc.files;

import java.io.File;

import refresher.practice.helpers.LogIt;

public class ListMyFiles {

	private static LogIt logger = new LogIt(ListMyFiles.class.getName());

	/**
	 * Recursive function to return list of files/directories at current path.
	 * 
	 * @param root
	 *            The file path in which to descend.
	 * @return The list of files.
	 */
	private static File[] getFileList(String root) {

		File top = new File(root);
		File[] files = top.listFiles();

		for (File f : files) {
			if (f.isFile()) {
				logger.getLogger().info("Found: " + f);
				if (f.delete()) {
					logger.getLogger().info("Deleted: " + f);
				}
				;
			} else {
				if (f.isDirectory() && (f.listFiles().length != 0)) {
					files = getFileList(f.getAbsolutePath());
				}
			}
			if (f.isDirectory() && f.listFiles().length == 0)
				if (f.delete()) {
					logger.getLogger().info("Deleted: " + f);
				}
			;
		}
		return files;
	}

	public static void main(String[] args) {

		String rootName = args[0];
		logger.getLogger().info("Root Directory: " + rootName);
		getFileList(rootName);
	}

}
