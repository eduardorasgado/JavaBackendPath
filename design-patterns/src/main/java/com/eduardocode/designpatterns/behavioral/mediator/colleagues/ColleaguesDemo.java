package com.eduardocode.designpatterns.behavioral.mediator.colleagues;

public class ColleaguesDemo {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        //Colleague colleagueA = new ConcreteColleagueA(mediator);
        //Colleague colleagueB = new ConcreteColleagueB(mediator);
        //Colleague colleagueC = new ConcreteColleagueC(mediator);

        Colleague colleagueA = new ConcreteColleagueA();
        Colleague colleagueB = new ConcreteColleagueB();
        Colleague colleagueC = new ConcreteColleagueC();

        mediator.setColleague(colleagueA);
        mediator.setColleague(colleagueB);
        mediator.setColleague(colleagueC);

        colleagueA.send("Hi, I am A");
        colleagueB.send("Hi, I am B");
    }
}
