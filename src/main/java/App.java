import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

interface App {

	List<String> TEST_LIST = large();

	static List<String> large() {
		return IntStream.range(0, 10_000_000)
				.mapToObj(String::valueOf)
				.toList();
	}

	static String withStringJoin(List<String> list) {
		return String.join(",", list);
	}

	static String withJoining(List<String> list) {
		return list
				.stream()
				.collect(Collectors.joining(","));
	}

	static void main(String... args) {
		var now = Instant.now();
		var result = withJoining(TEST_LIST);
		var length = result.length();
		out.println("concatenated length: %d in %s"
				.formatted(length, Duration.between(now, Instant.now())));
	}
}
