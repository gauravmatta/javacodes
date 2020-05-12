package javaimplant.inheritance;

public class Mamels {
	String voice;
	int legs;
	
	public void giveSound()
	{
		System.out.println("This Mamel gives sound "+voice);
	}
	
	public void giveLegCount()
	{
		System.out.println("This Mamel has leg count "+legs);
	}
	
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
}
