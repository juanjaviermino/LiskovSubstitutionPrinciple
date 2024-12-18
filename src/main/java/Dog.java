class Dog extends Animal implements WalkingAnimal {

    public void walk() {
        System.out.println("Dog is walking.");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}
