package org.robotframework.swing.context;

import org.netbeans.jemmy.ComponentChooser;
import org.robotframework.swing.operator.ComponentWrapper;

/**
 * @author Heikki Hulkko
 */
public class ContainerOperator extends org.netbeans.jemmy.operators.ContainerOperator implements ComponentWrapper {
    public ContainerOperator(ContainerOperator container, int index) {
        super(container, index);
    }

    public ContainerOperator(ContainerOperator container, ComponentChooser chooser) {
        super(container, chooser);
    }
}
