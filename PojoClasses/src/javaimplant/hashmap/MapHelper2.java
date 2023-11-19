/**
 * 
 */
package javaimplant.hashmap;

import java.util.Map;

/**
 * @author Gaurav
 *
 */
public class MapHelper2 implements Runnable {
	
	Map<String,Integer> map;
	
	public MapHelper2(Map<String,Integer> map) {
		this.map=map;
		new Thread(this,"MapHelper").start();
	}

	@Override
	public void run() {
		map.put("two", 2);
		try {
			System.out.println("MapHelper2 sleeping");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
