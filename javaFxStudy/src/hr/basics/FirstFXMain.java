package hr.basics;

import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;

public class FirstFXMain extends Application {

	public FirstFXMain() {
		System.out.println(Thread.currentThread().getName() + ": FirstFXMain() call.");

	}

	@Override
	public void init() throws Exception {
//		super.init();
		Parameters param = getParameters();
		Map<String, String> map = param.getNamed();
		Set<String> set = map.keySet();
		for (String str : set) {
			if (str != null)
				System.out.println("key: " + str + ", value: " + map.get(str));
		}
		System.out.println(Thread.currentThread().getName() + ": init() call.");
	}

	@Override
	public void stop() throws Exception {
//		super.stop();
		System.out.println(Thread.currentThread().getName() + ": stop() call.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() call.");
		primaryStage.show();
	}

	public static void main(String[] args) {
		try {
//			Application.launch((Class<FirstFXMain>) Class.forName("hr.basics.FirstFXMain"), "start");
//			FirstFXMain main = new FirstFXMain();
//			Application.launch(main.getClass(), args);
//			Application.launch(FirstFXMain.class, args);
			Application.launch(new FirstFXMain().getClass(), args);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
