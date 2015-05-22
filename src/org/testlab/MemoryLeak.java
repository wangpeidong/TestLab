package org.testlab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MemoryLeak {

	/**
	 * Force a java heap space OutOfMemoryError
	 */
    public static void heapSpaceOOM() {

        Long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println(maxMemory);
        int[] matrix = new int[(int) (maxMemory + 1)];
        for(int i = 0; i < matrix.length; ++i)
            matrix[i] = i+1;
    }
    
    /**
     * Force a vm limit OutOfMemoryError
     */
    public static void vmLimitOOM() {
    	int[] matrix = new int[Integer.MAX_VALUE];
    	
    	for (int i = 0; i < matrix.length; i++)
			matrix[i] = i+1;
    }
    
    /**
     * 
     * @param args
     */
    public static void leakMem()  {
    	Random random = new Random();
    	Map<Integer, String> sampleMap = new HashMap<>();
    	
    	// Loop forever
    	for (int i=0;;i++) {
    		int randomValue = random.nextInt();
    		sampleMap.put(randomValue, String.valueOf(randomValue));
    		// Give GC time to catch up
    		try {
    			if (i % 10000 == 0) Thread.sleep(30 * 1000);
    		} catch (InterruptedException e) {
    			// Restore interrupted status
    			Thread.currentThread().interrupt();
    			break;
    		}
    		
    	}
    	
    }

    // Launcher
	public static void main(String[] args) {
		new Thread("heapSpaceOOM") {
			@Override
			public void run() {
				heapSpaceOOM();
			}
		}.start();
		
		new Thread("vmLimitOOM") {
			@Override
			public void run() {
				vmLimitOOM();
			}
		}.start();

		new Thread("LeakMem") {
			@Override
			public void run() {
				leakMem();
			}
		}.start();
	}
	

}
