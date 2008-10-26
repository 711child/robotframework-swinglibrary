package org.robotframework.swing.operator.list;

import org.netbeans.jemmy.ComponentChooser;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JListOperator;
import org.robotframework.swing.operator.IOperator;

/**
 * @author Heikki Hulkko
 */
public class MyListOperator extends JListOperator implements IOperator {
    public MyListOperator(ContainerOperator container, ComponentChooser chooser) {
        super(container, chooser);
    }

    public MyListOperator(ContainerOperator container, int index) {
        super(container, index);
    }
}
