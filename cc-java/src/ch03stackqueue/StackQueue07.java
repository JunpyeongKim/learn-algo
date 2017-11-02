package ch03stackqueue;

import java.util.LinkedList;

/**
 * 3.7 먼저 들어온 동물이 먼저 나가는 동물 쉽터(Animal Shelter)가 있다고 하자.
 *     이 쉽터는 개와 고양이만 수용할 수 있다.
 *     사람들은 쉽터의 동물들 가운데 들어온 지 가장 오래된 동물부터 입양할 수 있는데, 개와 고양이 중 어떤 동물을 데려갈지 선택할 수도 있다.
 *     특정한 동물을지정해 데려가는 것은 금지되어 있다.
 *     이 시스템을 자료구조로 구현하라.
 *     해당 자료구조는 enqueue, dequeueAny, dequeueDog, dequeueCat 의 연산들을 제공해야 한다.
 *     언어에 기본 탑재되어 있는 LinkedList(Java) 자료구조를 이용해도 된다.
 *
 * (6E)
 * 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 *                     People must adopt either the "oldest" (based on arrival time) of all animalShelter at the shelter,
 *                     or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 *                     They cannot select which specific animal they would like.
 *                     Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, 
 *                     dequeueDog, and dequeueCat.
 *                     You may use the built-in LinkedList data structure.
 *
 *                     Hints: #22, #56, #63
 */
public class StackQueue07 {

    private static abstract class Animal {
        protected String name;
        private int order;

        public Animal(String n) {
            name = n;
        }

        public abstract String name();

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    private static class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }

        @Override
        public String name() {
            return "Dog: " + name;
        }
    }

    private static class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }

        @Override
        public String name() {
            return "Cat: " + name;
        }
    }

    private static class AnimalShelter {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;  // timestamp

        public void enqueue(Animal a) {
            a.setOrder(order++);

            if (a instanceof Dog) {
                dogs.add((Dog) a);  // or addLast()
            } else if (a instanceof Cat) {
                cats.add((Cat) a);  // or addLast()
            }
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0) {
                return dequeueCat();
            } else if (cats.size() == 0) {
                return dequeueDog();
            }

            Dog dog = peekDog();
            Cat cat = peekCat();

            if (dog.isOlderThan(cat)) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }

        public Dog dequeueDog() {
            return dogs.poll();
        }

        public Cat dequeueCat() {
            return cats.poll();
        }

        public Animal peek() {
            if (dogs.size() == 0) {
                return peekCat();
            } else if (cats.size() == 0) {
                return peekDog();
            }

            Dog dog = peekDog();
            Cat cat = peekCat();
            if (dog.isOlderThan(cat)) {
                return dog;
            } else {
                return cat;
            }
        }

        public Dog peekDog() {
            return dogs.peek();
        }

        public Cat peekCat() {
            return cats.peek();
        }

        public int size() {
            return dogs.size() + cats.size();
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(new Cat("Callie"));
        animalShelter.enqueue(new Cat("Kiki"));
        animalShelter.enqueue(new Dog("Fido"));
        animalShelter.enqueue(new Dog("Dora"));
        animalShelter.enqueue(new Cat("Kari"));
        animalShelter.enqueue(new Dog("Dexter"));
        animalShelter.enqueue(new Dog("Dobo"));
        animalShelter.enqueue(new Cat("Copa"));
        System.out.println("enqueue: (Rear) Copa, Dobo, Dexter, Kari, Dora, Fido, Kiki, Callie (Front)");

        System.out.println("dequeueAny:");
        System.out.println("---> " + animalShelter.dequeueAny().name());  // Callie
        System.out.println("---> " + animalShelter.dequeueAny().name());  // Kiki
        System.out.println("---> " + animalShelter.dequeueAny().name());  // Fido

        System.out.println("dequeueDog:");
        System.out.println("---> " + animalShelter.dequeueDog().name());  // Dora
        System.out.println("dequeueCat:");
        System.out.println("---> " + animalShelter.dequeueCat().name());  // Kari

        animalShelter.enqueue(new Dog("Dapa"));
        animalShelter.enqueue(new Cat("Kilo"));
        System.out.println("enqueue: (Rear) Kilo, Dapa, Copa, Dobo, Dexter (Front)");

        while (animalShelter.size() != 0) {
            System.out.println("dequeueAny - " + animalShelter.dequeueAny().name());
        }
    }
}
