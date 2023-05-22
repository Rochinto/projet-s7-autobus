package tec;

import java.lang.reflect.Method;

public class LancerTests {
	static private void lancer(Class<?> c) throws Exception {
		Method m[] = c.getMethods();
		int i = 0;
		for (Method method : m) {
			if (method.getName().startsWith("test")) {
				System.out.print('.');
				Object test = c.getDeclaredConstructor().newInstance();
				method.invoke(test);
				i++;
			}
		}
		System.out.println("(" + i + "):OK:" + c.getName() + "\n");
	}

	static public void main(String[] args) throws Exception {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;

		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}

		for (String arg : args) {
			Class c = Class.forName(arg);
			lancer(c);
		}
	}
}
