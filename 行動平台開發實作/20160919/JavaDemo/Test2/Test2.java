class Test2 {
	public static void main(String[] args){
		Dog d = new Dog();
		d.bark();
		for (int i = 0; i < 10; i++){
			if (i >= 5)
				System.out.println("Hello, World");
		}
	}
}

class Dog{
	private String name;
	public Dog(){
		name = "Bbbbb";
	}
	public void bark(){
		System.out.println("bark bark " + name);
	}
}