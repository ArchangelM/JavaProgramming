package lesson2part2instrum;

/**
 * Delegation
 * override like Has-A Инкорпорирование?
 * Person должен переопределить все методы. иначе это будет не делегирование, а включение класса или композициея
 */
public class Person {
    private Instrument instrument;

    public Person() {
        instrument = new Flute();
    }
 //переопределиние с др именеи
    public void makeNoise() {
        instrument.sound();
    }
    //переопределиние с таким же именеи
    public void sound() {
        instrument.sound();
    }
}
