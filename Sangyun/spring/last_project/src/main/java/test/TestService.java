package test;

import java.util.List;

public interface TestService {
	public List<TestVO> test();
	public TestHotdogVO testhotdog(String email);
}
