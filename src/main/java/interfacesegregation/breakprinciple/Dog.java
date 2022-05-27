package interfacesegregation.breakprinciple;

import jdk.jshell.spi.ExecutionControl;

public class Dog implements Animal {

    @Override
    public void walk() {

    }

    @Override
    public void bark() {

    }

    @Override
    public void meow() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }
}
