package org.testlab;

import java.io.*;

/**
 * 
 * @author wangpeidong
 *
 */
public class ARMTest {

	private static class Resource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Auto Resource Management - Resource closed automatically");
		}

	}

	public static void main(final String[] args) {
		try (final Resource res = new Resource();
				final FileInputStream reader = new FileInputStream("input");
				final FileOutputStream writer = new FileOutputStream("output");
				final Resource resource = new Resource()) {
			int var;
			while ((var = reader.read()) != -1) {
				writer.write(var);
			}
		} catch (final IOException ex) {
			ex.printStackTrace();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
