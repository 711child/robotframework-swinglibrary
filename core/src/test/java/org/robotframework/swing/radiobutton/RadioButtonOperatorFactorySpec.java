package org.robotframework.swing.radiobutton;

import java.awt.Component;

import javax.swing.JRadioButton;

import jdave.junit4.JDaveRunner;

import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.robotframework.swing.button.AbstractButtonOperator;
import org.robotframework.swing.context.IContextVerifier;
import org.robotframework.swing.contract.FieldIsNotNullContract;
import org.robotframework.swing.factory.OperatorFactory;
import org.robotframework.swing.factory.OperatorFactorySpecification;
import org.robotframework.swing.operator.IOperator;

@RunWith(JDaveRunner.class)
public class RadioButtonOperatorFactorySpec extends OperatorFactorySpecification<RadioButtonOperatorFactory> {
    public class Any extends AnyIdentifierParsingOperatorFactory {
        @Override
        protected Component createComponent() {
            return new JRadioButton() {
                public boolean isShowing() {
                    return true;
                }
            };
        }

        @Override
        protected OperatorFactory<? extends IOperator> createOperatorFactory() {
            RadioButtonOperatorFactory radioButtonOperatorFactory = new RadioButtonOperatorFactory();
            final IContextVerifier contextVerifier = injectMockTo(radioButtonOperatorFactory, IContextVerifier.class);
            checking(new Expectations() {{
                ignoring(contextVerifier);
            }});
            
            return radioButtonOperatorFactory;
        }
    }
    
    public class VerifyingContext {
        private AbstractButtonOperator operator = dummy(AbstractButtonOperator.class);
        
        public RadioButtonOperatorFactory create() {
            return new RadioButtonOperatorFactory() {
                public AbstractButtonOperator createOperatorByIndex(int index) {
                    return operator;
                }
                
                public AbstractButtonOperator createOperatorByName(String name) {
                    return operator;
                }
            };
        }

        public void hasContextVerifier() {
            specify(context, satisfies(new FieldIsNotNullContract("contextVerifier")));
        }
        
        public void verifiesContext() {
            final IContextVerifier contextVerifier = injectMockToContext(IContextVerifier.class);
            checking(new Expectations() {{
                one(contextVerifier).verifyContext();
            }});
            
            context.createOperator("someRadioButton");
        }
    }
}
