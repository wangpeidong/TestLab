package org.testlab;

import static org.easymock.EasyMock.*;

import org.junit.*;

public class CarTest {

	@Test
	public void testStart() {
		final Engine mockEngine = createMock(Engine.class);
		expect(mockEngine.type()).andReturn("MockEngine").once();
		replay(mockEngine);
		new Car(mockEngine).start();
		verify(mockEngine);
	}

}
