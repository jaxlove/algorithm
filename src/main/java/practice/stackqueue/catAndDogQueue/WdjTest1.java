package practice.stackqueue.catAndDogQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/23 15:22
 */
public class WdjTest1 {

    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();
        petQueue.add(new Cat());
        petQueue.add(new Cat());
        petQueue.add(new Dog());
        petQueue.add(new Cat());
        petQueue.add(new Dog());
        petQueue.add(new Cat());
    }

    static class PetQueue {

        private int curIndex = 0;

        private Queue<PetWrapper> catQueue;

        private Queue<PetWrapper> dogQueue;


        public PetQueue() {
            catQueue = new ArrayDeque<>();
            dogQueue = new ArrayDeque<>();
        }

        public void add(Pet pet) {
            if (pet instanceof Cat) {
                catQueue.add(new PetWrapper(pet, curIndex++));
            } else if (pet instanceof Dog) {
                dogQueue.add(new PetWrapper(pet, curIndex++));
            }
        }

        public void pollAll() {
            if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
                PetWrapper cat = catQueue.peek();
                PetWrapper dog = dogQueue.peek();
                if (cat.getIndex() < dog.getIndex()) {
                    catQueue.poll().getPet();
                } else {
                    dogQueue.poll().getPet();
                }
            } else if (!catQueue.isEmpty()) {
                catQueue.poll().getPet();
            } else if (!dogQueue.isEmpty()) {
                dogQueue.poll().getPet();
            }
        }

        public void pollCat() {
            if (!catQueue.isEmpty()) {
                PetWrapper poll = catQueue.poll();
                System.out.println(poll.getPet());
            }
        }

        public void pollDog() {
            if (!dogQueue.isEmpty()) {
                PetWrapper poll = dogQueue.poll();
                System.out.println(poll.getPet());
            }
        }

        public boolean isEmpty() {
            return dogQueue.isEmpty() && catQueue.isEmpty();
        }

        public boolean catEmpty() {
            return catQueue.isEmpty();
        }

        public boolean dogEmpty() {
            return dogQueue.isEmpty();
        }

    }


    static class Pet {
        private String type;


        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return type;
        }
    }

    static class Dog extends Pet {
        public Dog() {
            super("dog");
        }

        @Override
        public String toString() {
            return "Dog:" + getPetType();
        }
    }

    static class Cat extends Pet {
        public Cat() {
            super("cat");
        }

        @Override
        public String toString() {
            return "Cat:" + getPetType();
        }
    }

    static class PetWrapper {

        private Pet pet;

        private int index;

        public PetWrapper(Pet pet, int index) {
            this.pet = pet;
            this.index = index;
        }

        public String getPetType() {
            return pet.getPetType();
        }

        public int getIndex() {
            return index;
        }

        public Pet getPet() {
            return pet;
        }
    }


}
