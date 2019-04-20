# Flock_theory_simulator

##What is this?
A small Java Application that implements and visualizes Flock behaviour.

Flock theory is a fairly simple concept, "bird" of the system reacts to the other surrounding "birds" by adhering to 3 simple rules.
1. Cohesion: the "bird" will try to move to the center of the flock of "birds" in the vicinity.
2. Steering: the "bird" will try to change its direction to the one of the flock og "birds" in the vicinity.
3. Separation: the "bird" will try to move away from other "birds" that are too close.

The visualization consists in points that represent the "birds" that follow the 3 rules mentioned above, the window that represent the warped space where the "birds" are flying and a button that lets you enable and disable many species mode (more on that later).

##What am i seeing?
The visualization is showing a flock of 40 different "birds" that are all following the 3 rules with the same multipliers, if you click on the button at the top of the window the mode will change from "1 species" to "many species" and now the "birds" will behave accordingly to their type, they can be easily distinguished by their unique color, for example: the red "birds" value Separation much higher than the rest, as such they will tend to avoid creating a flock of "birds" bunched together.

##Contents
The project contains only 4 classes:
Airspace.java: contains the main method and the GUI.
Flock.java: contains the global values for the 3 rules, the update and draw methods for the visualization of its "birds".
Bird.java: contains birds' data and the methods for the 3 rules.
Species.java: contains birds' data if species are enabled.

##Easy tweaks
In Airspace you can edit:
-the value of 'width' and 'height' to change the dimensions for the window.
-the value of the third number in 'timer.scheduleAtFixedRate(task,0,33l);' to increase or decrease the tickrate.

In Flock you can edit:
-the number in 'private Bird[] birds = new Birds[20];' to increase or decrease the number of "birds" in the flock.
-the value of 'maxV' to increase or decrease the maximum velocity a "bird" can reach.
-the value of 'awareness' to increase or decrease the radius in which the "birds" interact with the others **for 1 species mode**.
-the values of 'cohesiveness', 'willtosteer' and 'divisiveness' to change the multipliers of the 3 rules **for 1 species mode**.

In Bird there is __close to nothing__ that can be edited without making adjustments elsewhere.

In Species you can edit:
-**any** value of the existing species to change the "birds" behaviour **for many species mode**.
-adding new cases in the 'switch' statement to create new types of "birds" **However** if you don't edit the number 6 to the new number of "bird" types in Bird.java here: 'type = new Species(ThreadLocalRandom.current().nextInt(0,6));' the new types **cannot show up**.

##Known bugs
The airspace is warped and should update the boundaries automatically when the window is resized, however it seems i'm unable to get this to work correctly.

##Last considerations
I wrote this simulator purely out of curiosity, you can take and improve it as i know it's not perfect, but i'm satisfacted with the result.

This project is under the MIT License, read the LICENSE file for details.

__WeLikeIke__
 