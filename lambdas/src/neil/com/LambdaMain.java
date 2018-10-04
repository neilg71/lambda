package neil.com;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaMain {
	
	private class MyThread implements Runnable{
		@Override
		public void run() {
			System.out.println("in traditional thread");
		}
	}
	
	public int someMethod(PredicateMine p) {
		return p.doSomething(5, 14);
	}
	
	public String add(String string, Function<String, String> fn) {
		return fn.apply(string);
	}
	
	private String passThisMethod() {
		return "passThisMethod";
	}

	public static void main(String[] args) {
		Runnable runnable = ()-> System.out.println("running something here");
		
		runnable.run();
		
		
		Runnable myThread = new LambdaMain().new MyThread();
		myThread.run();
		
		int i=5;
		PredicateMine p = (a, b)-> {int c= a * b;
										c=c%14;
										return c;
										};

		
		System.out.println(p.doSomething(10,20));
		
		System.out.println(new LambdaMain().someMethod((int a, int b)->a+b));
		
		Function<String, String> fn = parameter -> parameter + " from lambda";
		Function<Integer, Integer> fn2 = (Integer j) -> j + 4;
		Predicate<Integer> myPred = myValue -> myValue > 0;
		System.out.println(fn.apply("something here"));
		System.out.println(new LambdaMain().add("MyString", fn));
		System.out.println(fn2.apply(new Integer(17)));
		System.out.println(myPred.test(-100));
		
		Supplier<String> supplier = () -> new LambdaMain().passThisMethod();
		System.out.println(supplier.get());
		
		

	}

}
