package interfacesegregation.compliant;

import jdk.jshell.spi.ExecutionControl;

public interface ICat {

    void meow() throws ExecutionControl.NotImplementedException;
}
