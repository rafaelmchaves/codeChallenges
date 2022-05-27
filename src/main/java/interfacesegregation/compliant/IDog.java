package interfacesegregation.compliant;

import jdk.jshell.spi.ExecutionControl;

public interface IDog {

    void bark() throws ExecutionControl.NotImplementedException;

}
