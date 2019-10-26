package com.xulk.designPattern.mashibing.visitor;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 15:32
 **/
public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        memory.accept(visitor);
        board.accept(visitor);
    }

    public static void main(String[] args) {

        PersonOneVisitor personOneVisitor = new PersonOneVisitor();
        new Computer().accept(personOneVisitor);
        System.out.println(personOneVisitor.totalPrice);

    }


}

abstract class ComputerPart {
    abstract void accept(Visitor visitor);

    abstract double getPrice();
}


class CPU extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 1000;
    }
}

abstract class Visitor {

    abstract void visitCPU(CPU cpu);

    abstract void visitMemory(Memory memory);

    abstract void visitBoard(Board board);

}

class PersonOneVisitor extends Visitor {
    double totalPrice = 0.0;

    @Override
    void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.9;
    }

    @Override
    void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.8;
    }


}


class CorpVisitor extends Visitor {
    double totalPrice = 0.0;

    @Override
    void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.9;
    }

    @Override
    void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.8;
    }


}