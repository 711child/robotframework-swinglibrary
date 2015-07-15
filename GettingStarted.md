

# Introduction #

SwingLibrary is a Swing GUI testing library for [Robot Framework](http://robotframework.org). It uses [Jemmy](http://java.net/projects/jemmy/) as a driver to manipulate the Swing components.

# Taking library into use #

First of all, to use the SwingLibrary, it needs to be included in the `CLASSPATH`.

To take the library into use in the test suite, simply specify it in the settings table:

```
*** Settings ***
Library    SwingLibrary
```

# Locating Components #

In order to interact with the Swing widgets, first a desired context must be selected by using for example `Select Window` or `Select Dialog` keyword. After that the Swing components can be located in the selected context using a desired keyword with an identifier.

Identifier can be:

  * The logical name of the component given by the developer. This is the recommended approach as such internal names are likely to be stable.

  * The index of the component in its own context, such as the 3rd button in the context. As usual in this trade, the component indexing starts from the 0 which is the index of the first component. Indexes change when components are added, removed or reordered so this is a relatively fragile approach.

  * Title, label or other visible text of the component. Also visible texts can change, especially if the application is translated, so this is also a fragile approach.

Example:

```
*** Test Case ***
Test Add Todo Item
    Select Window    Todo List
    Insert Into Text Field    description    buy milk
    Push Button    Add
    Select From List    todolist    0
    ${item}=    Get Selected Value From List    todolist
    Should Be Equal    ${item}    buy milk
```

The previous test:

  1. Selects a window titled "Todo List".
  1. Inserts text "buy milk" into text field with logical name "description" given by the developer.
  1. Pushes a button with a visible label "Add".
  1. Selects the first item (index 0) of the list with logical name "todolist".
  1. Gets the value of the selected item.
  1. Compares the value with the expected value "buy milk".

There are a couple of ways to find out what components there are in a given context. Keyword `List Components in Context` can be used in a Robot test as a debugging tool. It is also possible to use an external tool such as [JSpy](http://code.google.com/p/robotframework-javatools/wiki/JSpy) to inspect the component hierarchy of a Swing application.