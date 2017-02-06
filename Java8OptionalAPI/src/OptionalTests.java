import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.Test;


public class OptionalTests {

	@Test
	public void test_empty() {
		assertThat(Optional.empty()).isEmpty();
	}
	
	@Test
	public void test_of() {
		Optional<String> name = Optional.of("wonchul");
		
		assertThat(name.get()).isEqualTo("wonchul");
	}
	
	@Test
	public void test_ofNullable() {
		Optional<String> name = Optional.ofNullable(null);
		assertThat(name).isEmpty();
	}
	
	@Test
	public void test_orElse() {
		Optional<String> name         = Optional.of("wonchul");
		Optional<String> nameNullable = Optional.ofNullable(null);
		
//		... call defaultValue()
		System.out.println("orElse      => " + name.orElse(defaultValue()));
		System.out.println("orElseGet   => " + name.orElseGet(() -> defaultValue()));

//		... call defaultValue()
		System.out.println("orElse      => " + nameNullable.orElse(defaultValue()));
//		... call defaultValue()
		System.out.println("orElseGet   => " + nameNullable.orElseGet(() -> defaultValue()));

//		System.out.println("orElseThrow => " + name.orElseThrow(NullPointerException::new));
	}
	
	private String defaultValue() {
		System.out.println("call defaultValue()");
		return "default name : wonchul";
	}
	
	@Test
	public void test_isParent() {
//		Optional<String> name = Optional.of("wonchul");
		Optional<String> name = Optional.ofNullable(null);
		
		if(name.isPresent()) {
			assertThat(name).isPresent();
		} else {
			assertThat(name).isNotPresent();
		}
	}
	
	@Test
	public void test_ifParent() {
//		Optional<String> name = Optional.of("wonchul");
		Optional<String> name = Optional.ofNullable(null);
		
		name.ifPresent(System.out::println);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void test_basic() {
		Computer computer = null;
		
		String version = getDefaultVersion();
		if(computer != null) {
			if(computer.getSoundCard() != null) {
				if (computer.getSoundCard().getUsb() != null) {
					version = computer.getSoundCard().getUsb().getVersion();
				}
			}
		}
		
		assertThat(
				version
		).isEqualTo(getDefaultVersion());
	}
	
	@Test
	public void test_expansion() {
		Optional<OpComputer> opComputer = Optional.empty();
		
		assertThat(
				opComputer
					.flatMap(OpComputer::getSoundCard)
					.flatMap(OpSoundCard::getUsb)
					.flatMap(OpUsb::getVersion)
					.orElseGet(() -> getDefaultVersion())
		).isEqualTo(getDefaultVersion());
	}
	
	private final String getDefaultVersion() {
		return "UNKNOWN";
	}
}
