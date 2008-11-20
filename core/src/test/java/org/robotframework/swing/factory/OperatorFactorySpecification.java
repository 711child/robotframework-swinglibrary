package org.robotframework.swing.factory;

import java.awt.Component;
import java.awt.Container;

import org.jmock.Expectations;
import org.jmock.Sequence;
import org.netbeans.jemmy.ComponentChooser;
import org.netbeans.jemmy.JemmyProperties;
import org.netbeans.jemmy.drivers.KeyDriver;
import org.netbeans.jemmy.drivers.MouseDriver;
import org.robotframework.swing.context.Context;
import org.robotframework.swing.keyword.MockSupportSpecification;
import org.robotframework.swing.operator.IOperator;
import org.robotframework.swing.operator.context.DefaultContainerOperator;


public class OperatorFactorySpecification<T> extends MockSupportSpecification<T> {
    protected DefaultContainerOperator dummyContainerOperator;

    protected void mockFindsByName(final Component componentToFind) {
        setDummyContext();
        checking(new Expectations() {{
            allowing(dummyContainerOperator).waitSubComponent(with(any(ComponentChooser.class)), with(equal(0)));
            will(returnValue(componentToFind));
        }});

        stubRestOfDummyContainerOperator();
    }

    protected void mockFindsByIndex(final Component componentToBeFound) {
        setDummyContext();
        final Container container = mock(Container.class);

        checking(new Expectations() {{
            allowing(container).getComponents();
            will(returnValue(new Component[] { componentToBeFound }));

            allowing(dummyContainerOperator).getSource();
            will(returnValue(container));
        }});

        stubRestOfDummyContainerOperator();
    }

    protected void stubRestOfDummyContainerOperator() {
        final JemmyProperties properties = mock(JemmyProperties.class);
        final Sequence jemmyDriverManagerInvocationSequence = sequence("jemmyDriverManager");

        checking(new Expectations() {{
            one(properties).getProperty(with(any(String.class)));
            inSequence(jemmyDriverManagerInvocationSequence);
            will(returnValue(dummy(KeyDriver.class)));

            one(properties).getProperty(with(any(String.class)));
            inSequence(jemmyDriverManagerInvocationSequence);
            will(returnValue(dummy(MouseDriver.class)));

            allowing(dummyContainerOperator).getProperties(); will(returnValue(properties));

            allowing(properties).getProperty(with(any(String.class)));
            will(returnValue(null));

            ignoring(dummyContainerOperator);
        }});
    }

    private void setDummyContext() {
        dummyContainerOperator = mock(DefaultContainerOperator.class);
        Context.setContext(dummyContainerOperator);
    }

    public abstract class AnyIdentifierParsingOperatorFactory {
        private Component component;
        private OperatorFactory<? extends IOperator> operatorFactory;

        public void create() {
            operatorFactory =  createOperatorFactory();
            component = createComponent();
        }

        public void destroy() {
            Context.setContext(null);
        }

        public void findsComponentWithNameAndCreatesOperatorForIt() {
            mockFindsByName(component);

            IOperator operator = operatorFactory.createOperator("someComponent");
            specify(operator.getSource(), must.equal(component));
        }

        public void findsComponentWithIndexAndCreatesOperatorForIt() {
            mockFindsByIndex(component);

            IOperator operator = operatorFactory.createOperator("0");
            specify(operator.getSource(), must.equal(component));
        }

        protected abstract OperatorFactory<? extends IOperator> createOperatorFactory();
        protected abstract Component createComponent();
    }
}
