

# SwingLibrary 1.1.3 #
SwingLibrary 1.1.3 was released on thursday the 3rd of March 2011. Contains a couple of new keywords and improved performance of Select Menu keyword.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 185](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=185) | Defect   | High         | Performance improvement of Select From Menu keywords |
| [Issue 17](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=17) | Enhancement | Medium       | New Slider Keywords: Get/Set Slider Value, Slider Should (Not) Exist |
| [Issue 184](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=184) | Enhancement | Medium       | Click On Table Header -keyword |

# SwingLibrary 1.1.2 #
SwingLibrary 1.1.2 was released on thursday the 13th of January 2011. Contains a new keyword and a bug fix.

| [Issue 180](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=180) | Defect | Medium | Select From Menu keyword succeeds when menu item is disabled |
|:----------------------------------------------------------------------------------------|:-------|:-------|:-------------------------------------------------------------|
| [Issue 177](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=177) | Enhancement | Medium | "Get List Values" Keyword                                    |



# SwingLibrary 1.1.1 #

SwingLibrary 1.1.1 was released on tuesday the 17th of August 2010. It contains new keywords, improvements to old ones and bug fixes. This is very early release and some issues are still open.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 174](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=174) | Defect   | High         | Disabled components should not be editable |
| [Issue 172](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=172) | Enhancement | High         | "Table Cell Should (Not) Be Editable" keyword |
| [Issue 167](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=167) | Defect   | Medium       | "Get Current Context" keyword |
| [Issue 168](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=168) | Enhancement | Medium       | "Click On Table Cell" keyword |
| [Issue 166](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=166) | Enhancement | Medium       | "Set Spinner String/Number Value" keywords |
| [Issue 173](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=173) | Enhancement | Medium       | New keywords to manage JTextArea |


# SwingLibrary 1.1 #

SwingLibrary 1.1 was released on wednesday the 3rd of February 2010.

Release 1.1 contains new keywords, improvements to old ones and several bug fixes.

  * Combobox, Table, Tree and List keywords now returns the rendered value instead of the model value ([Issue 153](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=153) and [Issue 162](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=162)). This change might be backwards incompatible in case value in the model and the visible value are different.

  * Select dialog and window keywords accepts a regular expression identifier. ([Issue 160](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=160) and [Issue 161](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=161))

  * The Swing Library's 3rd party dependencies are repackaged to avoid collisions with the same ones in the SUT. ([Issue 163](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=163))

  * Java 1.4 (EOSL) isn't supported anymore. Please use older versions of SwingLibrary or try building from the sources, if updating Java is not an option.

For more details please click on the issue number.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 160](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=160) | Enhancement | High         | Dialog selection using regexps |
| [Issue 161](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=161) | Enhancement | High         | Window selection using regexps |
| [Issue 163](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=163) | Enhancement | High         | 3rd party libraries repackaged to avoid collisions with SUT libraries |
| [Issue 156](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=156) | Defect   | Medium       | Unable to Select a Tab Pane inside another Tab Pane |
| [Issue 126](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=126) | Defect   | Medium       | Optionally disable verification on "Select From Combo Box" keyword |
| [Issue 143](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=143) | Defect   | Medium       | Select Table Cell Area |
| [Issue 162](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=162) | Defect   | Medium       | "Get Selected Value From List" should return screen representation |
| [Issue 150](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=150) | Defect   | Medium       | 'Click on Tree Node' requires gnu/regexp/REException |
| [Issue 141](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=141) | Enhancement | Medium       | Get Table Cell Property keyword |
| [Issue 144](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=144) | Enhancement | Medium       | Select From Popup Menu On Selected Table Cells |
| [Issue 145](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=145) | Enhancement | Medium       | Find Table Row support for matching specific column |
| [Issue 148](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=148) | Enhancement | Medium       | Optional tab pane indentifier argument for "Select Tab" keyword |
| [Issue 151](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=151) | Enhancement | Medium       | "Select From List" fails without timeout |
| [Issue 153](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=153) | Enhancement | Medium       | "Get Table Cell Value",  "Get Selected Item From Combobox" and "Get Combo Box Values Value" keywords return visible string value |
| [Issue 155](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=155) | Enhancement | Medium       | Add Table Cell Selection |
| [Issue 157](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=157) | Enhancement | Medium       | "Select Tab As Context" keyword |
| [Issue 158](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=158) | Enhancement | Medium       | Return the old setting value from "Set Jemmy Timeout" keyword |
| [Issue 142](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=142) | Enhancement |              | Improve error message when context is null |

Altogether 18 issues.

# SwingLibrary 1.0 #

Release 1.0 contains new keywords and several bug fixes.

  * [Focus To Component](http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Focus%20To%20Component) helps in setting the focus without changing the [context](http://code.google.com/p/robotframework-swinglibrary/wiki/ExtendingSwingLibrary#Context) which is useful for example when simulating copy and paste actions by sending keyboard events to the component.

> An example on how to create a _fake_ drag and drop keyword by using _Focus To Component_ and _Send Keywobard Event_ keywords:

| **Keyword** | | | |
|:------------|:|:|:|
| dragAndDrop | `[`arguments`]` | ${from} | ${to} |
|             | copyToClipboard | ${from} | |
|             | pasteFromClipboard | ${to} | |

| copyToClipboard | `[`arguments`]` | ${target} | |
|             |   focusToComponent | ${target} | |
|             |   sendKeyboardEvent | VK\_C | CTRL\_MASK |

| pasteFromClipboard | `[`arguments`]` | ${target} | |
|             | focusToComponent | ${target} | |
|             | sendKeyboardEvent | VK\_V | CTRL\_MASK |

  * Selecting from a popup menu has been made possible for any kind of components with the new [Select From Popup Menu](http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Select%20From%20Popup%20Menu) keyword.

  * Values from comboboxes and table columns can be extracted with [Get Combobox Values](http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Get%20Combobox%20Values) and [Get Table Column Values](http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-1.0/doc/swinglibrary-1.0-doc.html#Get%20Table%20Column%20Values) keywords.

For more details please click on the issue number.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 135](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=135) | Enhancement | High         | Close All Dialogs keyword |
| [Issue 126](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=126) | Defect   | Medium       | Select From Combobox fails permanently with some comboxes |
| [Issue 136](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=136) | Defect   | Medium       | Fix tree keywords that operate on all nodes |
| [Issue 137](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=137) | Defect   | Medium       | Checkbox keywords should work with the internal name |
| [Issue 140](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=140) | Defect   | Medium       | Menu Keywords should find menuitems by exact match only |
| [Issue 138](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=138) | Enhancement | Medium       | Get Combobox Values keyword |
| [Issue 139](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=139) | Enhancement | Medium       | Get Table Column Values keyword |
| [Issue 124](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=124) | Enhancement | Medium       | Focus To Component keyword |
| [Issue 133](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=133) | Enhancement | Medium       | Select from popup menu keyword |
| [Issue 102](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=102) | Enhancement | Medium       | Document how to extend SwingLibrary |
| [Issue 123](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=123) | Defect   | Low          | Tree Node keywords should work with nodes other than javax.swing.tree.TreeNode |

# SwingLibrary 0.14 #

This release contains some new keywords and a fix to an old one.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 82](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=82) | Enhancement | Medium       | Get Table Headers keyword |
| [Issue 110](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=110) | Defect   | Medium       | Combobox keywords should support ListCellRenderers |
| [Issue 114](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=114) | Enhancement | Medium       | Get Tooltip Text Keyword |
| [Issue 117](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=117) | Enhancement | Medium       | Collapse All Tree Nodes keyword |
| [Issue 118](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=118) | Enhancement | Medium       | Expand All Tree Nodes keyword |
| [Issue 119](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=119) | Enhancement | Medium       | Radio Button Should Be Disabled keyword |
| [Issue 120](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=120) | Enhancement | Medium       | Radio Button Should Be Enabled keyword |


# SwingLibrary 0.13 #

Release 0.13 contains mainly new keywords but also few fixes to old ones. For example "Set Table Cell Value" keyword has been fixed to work with comboboxes also. This meant that keyboard events could no longer be used with this keyword. The old functionality has been preserved in a new keyword called "Type Into Table Cell".
A new keyword called "Run In Separate Thread" has been added. This keyword is useful when testing components that block the currently executing thread. It takes any keyword name as argument and executes it in a separate thread. More on this keyword [here](http://robotframework-swinglibrary.googlecode.com/svn/tags/swinglibrary-0.13/doc/swinglibrary-0.13-doc.html#Run%20Keyword%20In%20Separate%20Thread).

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 98](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=98) | Defect   | Medium       | Set Table Cell keyword should work with dropdown boxes |
| [Issue 99](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=99) | Defect   | Medium       | Type Into Textfield keyword fails when input characters are modified on the fly |
| [Issue 97](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=97) | Enhancement | Medium       | Table Cell Popup Menu Should Be Enabled / Disabled keywords |
| [Issue 100](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=100) | Enhancement | Medium       | Find Table Row keyword |
| [Issue 104](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=104) | Enhancement | Medium       | Main Menu Item Should Not Exist keyword |
| [Issue 105](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=105) | Enhancement | Medium       | Run In Separate Thread keyword |
| [Issue 106](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=106) | Enhancement | Medium       | Type Into Table Cell keyword |
| [Issue 108](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=108) | Enhancement | Medium       | Get Tree Node Child Names keyword |

# SwingLibrary 0.12 #

In this release, we made SwingLibrary easier to extend. It can now accept keyword patterns in the same way than [AnnotationLibrary](http://code.google.com/p/robotframework-javatools/wiki/AnnotationLibrary) so that you can add your own keywords to the keywords already contained in SwingLibrary.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 95](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=95) | Enhancement | High         | Label Text Should Be keyword |
| [Issue 96](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=96) | Enhancement | Medium       | SwingLibrary should be easier to extend |

# SwingLibrary 0.11 #

A small release that introduces two new keywords _Checkbox Should Be Enabled_ and _Checkbox Should Be Disabled_.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 92](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=92) | Enhancement | Medium       | Checkbox Should Be Disabled/Enabled keywords needed |

# SwingLibrary 0.10 #

A small release that focuses mostly on Tree keywords. Support for nodes without
any text and node access independent on node objects' toString method has been added.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 89](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=89) | Defect   | Medium       | Tree keywords should work also with unnamed nodes |
| [Issue 74](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=74) | Enhancement | Medium       | Tree keywords should support TreeCellRenderer |
| [Issue 90](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=90) | Enhancement | Medium       | Type Into Combobox keyword |

# SwingLibrary 0.9 #

Argument handling was fixed to support different datatypes.
Select From List keyword was modified to support selection of multiple items. Unfortunately the optional click count parameter we added in the previous release had to be dropped to enable this. A new keyword, called "Click On List Item", that takes the click count as a parameter was introduced to fix this.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 85](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=85) | Defect   | High         | SwingLibrary should accept argument of all relevant types |
| [Issue 28](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=28) | Enhancement | Medium       | Textfield Should Be Disabled/Enabled keywords |
| [Issue 81](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=81) | Enhancement | Medium       | Click On Tree Node keyword |
| [Issue 13](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=13) | Enhancement | Medium       | Select From List Keyword multiple item support |
| [Issue 83](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=83) | Enhancement | Medium       | Menu Item Should Be Checked |
| [Issue 84](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=84) | Enhancement | Medium       | Menu Item Should Not Be Checked |
| [Issue 87](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=87) | Enhancement | Medium       | Select All List Items keyword |
| [Issue 88](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=88) | Enhancement | Medium       | Click On List Item keyword |

# SwingLibrary 0.8 #

This release contains new keywords and bugfixes.
Some existing keywords have been enhanced:

"Select Tree Node" now accepts a list of nodes to select:

Before this release to select multiple nodes you had to do this:
| Select Tree Node | myTree | some|node |
|:-----------------|:-------|:----------|
| Select Tree Node | myTree | other|node |
| Select Tree Node | myTree | third|node |

Now you can do the following:
| Select Tree Node | myTree | some|node | other|node | third|node |
|:-----------------|:-------|:----------|:-----------|:-----------|


| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 14](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=14) | Defect   | Medium       | Select From List keyword should work with row numbers |
| [Issue 24](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=24) | Defect   | Medium       | Selecting from combobox should work with indexes |
| [Issue 22](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=22) | Enhancement | Medium       | Combobox Should Be Enabled/Disabled keywords |
| [Issue 53](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=53) | Enhancement | Medium       | Choose From File Chooser keyword |
| [Issue 62](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=62) | Enhancement | Medium       | "Select From Popup Menu On Selected Tree Nodes" keyword |
| [Issue 66](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=66) | Enhancement | Medium       | Get Tree Node Label |
| [Issue 70](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=70) | Enhancement | Medium       | Get Tree Node Index keyword |
| [Issue 71](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=71) | Enhancement | Medium       | Cancel File Chooser keyword |
| [Issue 72](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=72) | Enhancement | Medium       | Modify "Select Tree Node" keyword, so that it accepts multiple nodes as parameters |
| [Issue 73](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=73) | Enhancement | Medium       | Improve Select From List keyword to take click count as optional parameter |

# SwingLibrary 0.7 #

Release 0.7 introduces new keywords.
"Send Keyboard Event" sends real key strokes to the selected component.
This is useful if we want to test something that relies on real events being caught eg. tab navigation in a JTree.

| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 49](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=49) | Enhancement | Medium       | Send Keyboard Event keyword |
| [Issue 68](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=68) | Enhancement | Medium       | Push Toggle Button keyword |
| [Issue 69](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=69) | Enhancement | Medium       | Rename "Select Radio Button" to "Push Radio Button" |

# SwingLibrary 0.6 #

Release 0.6 adds few new keywords to the collection. **Set Table Cell Value** has
been modified so that it uses real keyboard events instead of setting the cell
value directly. This hopefully increases its compatibility with different table models.


| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 59](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=59) | Enhancement | Medium       | Select Radio Button keyword |
| [Issue 60](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=60) | Enhancement | Medium       | Radio Button Should Be Selected keyword |
| [Issue 61](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=61) | Enhancement | Medium       | Radio Button Should Not Be Selected keyword |
| [Issue 63](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=63) | Enhancement | Medium       | Toggle Button Should Be Selected keyword |
| [Issue 64](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=64) | Enhancement | Medium       | Toggle Button Should Not Be Selected keyword |
| [Issue 9](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=9) | Enhancement | Medium       | Select From Table Cell Popup Keyword |
| [Issue 10](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=10) | Enhancement | Medium       | Set Table Cell Keyword uses real key events. |
| [Issue 42](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=42) | Enhancement | Medium       | Start Application keyword should give better error message if main method is not found |


# SwingLibrary 0.5 #

Release 0.5 contains few bugfixes and new keywords.

Also some existing keywords have been changed:

All table and tree keywords have been changed so that they don't require separate selection of the
tree or table as context. Instead an additional parameter "identifier" (for finding the tree or
table) has been added to all of these keywords:

**Before:**
| Select Tree      | 0         |
|:-----------------|:----------|
| Expand Tree Node | some|node |

**Now:**
| Expand Tree Node | 0 | some|node |
|:-----------------|:--|:----------|

The reason for this change is that we have noticed that the context switching causes more pain
than the additional parameter.

Because of this modification keywords **Select Table** and **Select Tree** have been removed from
release 0.5 as unnecessary.


| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 4](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=4) | Defect   | Medium       | Close Internal Frame keyword |
| [Issue 37](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=37) | Defect   | Medium       | Tree Node Popup Menu keywords should accept only exact matches for menupaths |
| [Issue 41](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=41) | Defect   | Medium       | Select From List keyword should use only exact matches |
| [Issue 8](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=8) | Enhancement | Medium       | Get Tree Node Count Keyword |
| [Issue 43](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=43) | Enhancement | Medium       | Click On Component keywords |
| [Issue 58](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=58) | Enhancement | Medium       | Tree and Table keywords should use default context in order to reduce context switching |
| [Issue 5](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=5) | Enhancement | Medium       | Clear Table Cell Keyword |
| [Issue 54](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=54) | Enhancement | ----         | Internal Frame Should Exist keyword |
| [Issue 55](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=55) | Enhancement | ----         | Internal Frame Should Not Exist keyword |
| [Issue 56](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=56) | Enhancement | ----         | Internal Frame Should Be Open keyword |
| [Issue 57](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=57) | Enhancement | ----         | Internal Frame Should Not Be Open keyword |

# SwingLibrary 0.4 #

Release 0.4 contains bugfixes and few new keywords. A whole new group of keyword for using spinner buttons were created. These are: "Spinner Should Exist", "Spinner Should Not Exist", "Get Spinner Value", "Increase Spinner Value" and "Decrease Spinner Value".


| **ID** | **Type** | **Priority** | **Summary** |
|:-------|:---------|:-------------|:------------|
| [Issue 18](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=18) | Defect   | Medium       | DefaultContextVerifier should has have JInternalFrame as one of the expected classes |
| [Issue 20](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=20) | Defect   | Medium       | Select From Combobox keyword matches substrings |
| [Issue 35](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=35) | Defect   | Medium       | Get Selected Table Cell Value keyword should return its value as string |
| [Issue 1](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=1) | Enhancement | Medium       | Spinner Button Keywords. |
| [Issue 6](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=6) | Enhancement | Medium       | Get Table Column Count Keyword |
| [Issue 7](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=7) | Enhancement | Medium       | Get Table Row Count Keyword |
| [Issue 44](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=44) | Enhancement | Medium       | Add new timeout to "Set Jemmy Timeouts": ComponentOperator.WaitStateTimeout |
| [Issue 45](https://code.google.com/p/robotframework-swinglibrary/issues/detail?id=45) | Enhancement | ----         | Set Table Cell Value keyword |