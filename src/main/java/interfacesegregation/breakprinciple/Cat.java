package interfacesegregation.breakprinciple;

import jdk.jshell.spi.ExecutionControl;

public class Cat implements Animal {
    @Override
    public void walk() {

    }

    @Override
    public void bark() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }

    @Override
    public void meow() {

    }
}
