package com.company;

import java.util.Scanner;
import java.util.Queue;
//Интерфейс описывает коллекции с предопределённым способом
//вставки и извлечения элементов, а именно — очереди FIFO (first-in-first-out).
//Помимо методов, определённых в интерфейсе Collection, определяет
//дополнительные методы для извлечения и добавления элементов в очередь.
import java.util.LinkedList;

public class Drunk {
    private Queue<Integer> firstCards = new LinkedList<Integer>();
    private Queue<Integer> secondCards = new LinkedList<Integer>();
    //LinkedList: Позволяет хранить любые данные,
    //включая null. Данная коллекция реализована на основе двунаправленного
    //связного списка (каждый элемент списка имеет ссылки на предыдущий и
    //следующий). Добавление и удаление элемента из середины, доступ по индексу,
    //значению происходит за линейное время O(n), а из начала и конца за константное время O(1).

    public void play() {
        fill_in();
        compare();
    }

    public void fill_in() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            this.firstCards.add(scan.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            this.secondCards.add(scan.nextInt());
        }
    }

    public void compare() {
        int n = 0;
        while (firstCards.peek() != null && secondCards.peek() != null && n < 106) { //peek() смотрит на первый элемент очереди
            n++;
            int firstCard = this.firstCards.poll();
            int secondCard = this.secondCards.poll();
            //poll(): Этот метод извлекает значение первого элемента очереди, удаляя его из очереди.
            // При каждом вызове он удаляет первый элемент списка, и если список уже пуст, он возвращает null, но не создает никаких исключений .
            if (firstCard == 0 && secondCard == 9) {
                firstCards.add(firstCard);
                firstCards.add(secondCard);
            }
            else if (firstCard == 9 && secondCard == 0) {
                secondCards.add(firstCard);
                secondCards.add(secondCard);
            }
            else if (firstCard > secondCard) {
                firstCards.add(firstCard);
                firstCards.add(secondCard);
            }
            else {
                secondCards.add(firstCard);
                secondCards.add(secondCard);
            }
        }
        if (firstCards.peek() == null) {
            System.out.println("second " + n);
        }
        else if (secondCards.peek() == null) {
            System.out.println("first " + n);
        }
        else {
            System.out.println("botva");
        }
    }
}
