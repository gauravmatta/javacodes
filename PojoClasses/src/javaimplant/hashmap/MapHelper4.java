/**
 * 
 */
package javaimplant.hashmap;

import java.util.Map;

/**
 * @author Gaurav
 *
 */
public class MapHelper4 implements Runnable {
	
	Map<String,Integer> map;
	
	public MapHelper4(Map<String,Integer> map) {
		this.map=map;
		new Thread(this,"MapHelper").start();
	}

	@Override
	public void run() {
		map.put("four", 4);
		try {
			System.out.println("MapHelper4 sleeping");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
