package org.robotframework.swing.keyword.label;

import java.awt.Component;

import javax.swing.JLabel;

import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;
import org.robotframework.swing.factory.OperatorFactory;
import org.robotframework.swing.factory.OperatorFactorySpecification;
import org.robotframework.swing.operator.label.DefaultLabelOperator;


@RunWith(JDaveRunner.class)
public class LabelOperatorFactorySpec extends OperatorFactorySpecification<LabelOperatorFactory> {
    public class Any extends AnyIdentifierParsingOperatorFactory {
        @Override
        protected Component createComponent() {
            return new JLabel() {
                public boolean isShowing() {
                    return true;
                }
            };
        }

        @Override
        protected OperatorFactory<DefaultLabelOperator> createOperatorFactory() {
            return new LabelOperatorFactory();
        }
    }
}
