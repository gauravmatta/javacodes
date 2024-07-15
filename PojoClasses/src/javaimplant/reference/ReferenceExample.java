package javaimplant.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceExample {
	
	public static void strongReference() {
		NetworkConnection nc = new NetworkConnection();
		nc=null;
	}
	
	public static void weakReference() {
		System.out.println("Creating Weak Reference");
		NetworkConnection nc = new NetworkConnection();
		WeakReference<NetworkConnection> weakReference = new WeakReference<>(nc);
		System.out.println(weakReference.get());
		nc=null;
		System.gc();
		System.out.println(weakReference.get());
	}
	
	public static void softReference() {
		System.out.println("Creating Soft Reference");
		NetworkConnection nc = new NetworkConnection();
		SoftReference<NetworkConnection> softReference = new SoftReference<>(nc);
		System.out.println(softReference.get());
		nc=null;
		System.gc();
		System.out.println(softReference.get());
	}
	
	public static void phantomReference() {
		System.out.println("Creating Phantom Reference");
		NetworkConnection nc = new NetworkConnection();
		ReferenceQueue<NetworkConnection> referenceQueue = new ReferenceQueue<>();
		PhantomReference<NetworkConnection> phantomReference = new PhantomReference<>(nc,referenceQueue);
		System.out.println("Phantom Reference deleted");
		System.out.println(phantomReference.get());
	}
	
	public static void main(String[] args) {
		weakReference();
		softReference();
		phantomReference();
	}
}
