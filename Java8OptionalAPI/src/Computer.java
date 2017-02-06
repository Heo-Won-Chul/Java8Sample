
public class Computer {
	private SoundCard soundCard;
	
	public SoundCard getSoundCard() {
		return soundCard;
	}
}

class SoundCard {
	private Usb usb;
	
	public Usb getUsb() {
		return usb;
	}
}

class Usb {
	private String version;

	public String getVersion() {
		return version;
	}
}
