/**
 * 
 */
package javaimplant.hashmap;

import java.util.Map;

/**
 * @author Gaurav
 *
 */
public class MapHelper implements Runnable {
	
	Map<String,Integer> map;
	
	public MapHelper(Map<String,Integer> map) {
		this.map=map;
		new Thread(this,"MapHelper").start();
	}

	@Override
	public void run() {
		map.put("one", 1);
		try {
			System.out.println("MapHelper sleeping");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
