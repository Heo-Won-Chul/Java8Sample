import java.util.Optional;


public class OpComputer {
	private Optional<OpSoundCard> soundCard;
	
	public Optional<OpSoundCard> getSoundCard() {
		return soundCard;
	}
}

class OpSoundCard {
	private Optional<OpUsb> usb;
	
	public Optional<OpUsb> getUsb() {
		return usb;
	}
}

class OpUsb {
	private Optional<String> version;

	public Optional<String> getVersion() {
		return version;
	}
}
