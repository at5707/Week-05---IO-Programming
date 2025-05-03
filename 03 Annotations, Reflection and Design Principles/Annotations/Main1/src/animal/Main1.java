package animal;
class Animal {
	void makeSound() {
		System.out.println("Some animal sound");
	}
}
class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Woof!");
	}
}
public class Main1 {

	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.makeSound();
	}
}
