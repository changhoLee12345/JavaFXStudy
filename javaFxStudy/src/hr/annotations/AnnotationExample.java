package hr.annotations;

class Annotations {
	@DefaultValueSet(defaultName = "Hong", defaultAge = 10)
	Annotations() {
		System.out.println();
	}

	@DefaultValueSet
	void getAnnotationValue() {
		System.out.println("annotation for reflection");
	}
}

public class AnnotationExample {
	public static void main(String[] args) {
		Annotations ann = new Annotations();
		ann.getAnnotationValue();
	}
}
