package pro.sky.java.course2.examinerservice2.constants;

import pro.sky.java.course2.examinerservice2.domain.Question;

import java.util.Collection;
import java.util.Set;

public class QuestionConstants {

    public static final String javaQuestion1 = "Что из себя представляет массив?";
    public static final String javaQuestion2= "Каким свойством обладает массив?";
    public static final String javaQuestion3 = "Что из себя представляет цикл?";
    public static final String javaQuestion4 = "Что из себя представляет пул строк?";
    public static final String javaQuestion5 = "Что из себя представляет метод?";
    public static final String javaQuestion6 = "Каких типов бывают методы?";
    public static final String javaQuestion7 = "Какие типы коллекций существуют?";
    public static final String javaQuestion8 = "Что из себя представляют списки (lists)?";
    public static final String javaQuestion9 = "Что из себя представляют множества (sets)?";
    public static final String javaQuestion10 = "Что из себя представляют словари (maps)?";


    public static final String javaAnswer1 = "Массив — это структура данных, которая позволяет хранить несколько значений " +
            "одного типа";
    public static final String javaAnswer2 = "Массив обладает свойством length, которое возвращает длину массива, " +
            "то есть количество элементов";
    public static final String javaAnswer3 = "Цикл — конструкция языка, которая позволяет выполнять один и тот же код " +
            "многократно в зависимости от условий";
    public static final String javaAnswer4 = "Пул строк — один из внутренних механизмов Java, благодаря которому в памяти " +
            "сохраняется только один экземпляр строки идентичного содержания";
    public static final String javaAnswer5 = "Метод - блок кода, который выполняет определенную функцию и позволяет " +
            "переиспользовать себя в нескольких местах без необходимости снова писать один и тот же код";
    public static final String javaAnswer6 = "Те, что принимают наш объект в виде параметра. Например, как было с методами " +
            "класса Arrays. Те, что объявлены напрямую в объекте и позволяют вызывать эти методы прямо из объекта. " +
            "Например, методы для работы со строками";
    public static final String javaAnswer7 = "Основными типами коллекций являются: списки (листы), множества (сеты) и словари" +
            " (карты, ассоциативные массивы, мапы)";
    public static final String javaAnswer8 = "Списки (lists) являются упорядоченными структурами. Списки наиболее близки к " +
            "массивам по функционалу, а самая популярная реализация списков ArrayList построена на базе массива";
    public static final String javaAnswer9 = "Множества (sets) являются в основном неупорядоченными структурами, особенность " +
            "их в том, что все элементы множеств являются абсолютно уникальными";
    public static final String javaAnswer10 = "Словари (maps), они же ассоциативные массивы, представляют собой более сложные " +
            "структуры данных. Если упрощенно, то это массив из пар «ключ-значение», где ключи должны быть уникальны " +
            "(как элементы множеств), а значения могут повторяться";

    public static final Question javaQuest1 = new Question(javaQuestion1, javaAnswer1);
    public static final Question javaQuest2 = new Question(javaQuestion2, javaAnswer2);
    public static final Question javaQuest3 = new Question(javaQuestion3, javaAnswer3);
    public static final Question javaQuest4 = new Question(javaQuestion4, javaAnswer4);
    public static final Question javaQuest5 = new Question(javaQuestion5, javaAnswer5);
    public static final Question javaQuest6 = new Question(javaQuestion6, javaAnswer6);
    public static final Question javaQuest7 = new Question(javaQuestion7, javaAnswer7);
    public static final Question javaQuest8 = new Question(javaQuestion8, javaAnswer8);
    public static final Question javaQuest9 = new Question(javaQuestion9, javaAnswer9);
    public static final Question javaQuest10 = new Question(javaQuestion10, javaAnswer10);

    public static final Collection<Question> ALL_JAVA_QUESTIONS = Set.of(
            javaQuest1,
            javaQuest2,
            javaQuest3,
            javaQuest4,
            javaQuest5,
            javaQuest6,
            javaQuest7,
            javaQuest8,
            javaQuest9,
            javaQuest10
    );

    public static final String mathQuestion1 = "Math question1";
    public static final String mathQuestion2 = "Math question2";
    public static final String mathQuestion3 = "Math question3";
    public static final String mathQuestion4 = "Math question4";
    public static final String mathQuestion5 = "Math question5";

    public static final String mathAnswer1 = "Math answer1";
    public static final String mathAnswer2 = "Math answer2";
    public static final String mathAnswer3 = "Math answer3";
    public static final String mathAnswer4 = "Math answer4";
    public static final String mathAnswer5 = "Math answer5";

    public static final Question mathQuest1 = new Question(mathQuestion1, mathAnswer1);
    public static final Question mathQuest2 = new Question(mathQuestion2, mathAnswer2);
    public static final Question mathQuest3 = new Question(mathQuestion3, mathAnswer3);
    public static final Question mathQuest4 = new Question(mathQuestion4, mathAnswer4);
    public static final Question mathQuest5 = new Question(mathQuestion5, mathAnswer5);

    public static final Set<Question> ALL_MATH_QUESTIONS = Set.of(
            mathQuest1,
            mathQuest2,
            mathQuest3,
            mathQuest4,
            mathQuest5
    );

}
