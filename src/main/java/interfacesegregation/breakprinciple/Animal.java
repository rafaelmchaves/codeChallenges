package interfacesegregation.breakprinciple;

import jdk.jshell.spi.ExecutionControl;

public interface Animal {

    void walk();

    void bark() throws ExecutionControl.NotImplementedException;

    void meow() throws ExecutionControl.NotImplementedException;
}
