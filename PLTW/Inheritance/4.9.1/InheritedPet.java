public class InheritedPet {
    public static void main(String[] args) {
        System.out.println("My cat");
        Cat myCat = new Cat();
        myCat.setName("Romeo");
        myCat.purr();
        myCat.eat();
        myCat.sleep();
        
        System.out.println("======================");
        
        System.out.println("My dog");
        Dog myDog = new Dog();
        myDog.setName("Juliette");
        myDog.walk();
        myDog.eat();
        myDog.sleep();
        
        System.out.println("======================");
        
        System.out.println("My parakeet");
        Parakeet myParakeet = new Parakeet();
        myParakeet.setName("Jack");
        myParakeet.fly();
        myParakeet.eat();
        myParakeet.talk();
        
        System.out.println("======================");

        System.out.println("My canary");
        Canary myCanary = new Canary();
        myCanary.setName("Jill");
        myCanary.fly();
        myCanary.eat();
        myCanary.sing();
    }
}
