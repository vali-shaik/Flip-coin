# Java---Software-Development-2
Java program to implement a data structure from basic objects

Background
============
Balanced binary search trees can be tricky to code and expensive to maintain. However, we
don’t always need a perfectly balanced tree. We are often content with an approximation to
the tree or a heuristic structure that mimics the balanced binary tree.
In this assignment, you will implement a data structure that looks like a set of linked lists but
that mimics some behaviour of a balanced binary tree.

Problem
===========
Write a class called “ListHierarchy” that accepts data values and then lets you search the list to
see if a value is in the list. The key part of the class is in the data structure that it uses to store
the data.
The data structure will have a random behavior to it. For testing purposes, the constructor for
the class will accept an object of type “coin” to use for all the random parts. You will be
supplied with different implementations for the “coin” object: one implementation will use
randomness and the other will let you specify the coin flips yourself so that you can have
deterministic debugging.

Data structure
=================
The data structure is a hierarchy of sorted linked lists. Each higher level of the hierarchy
contains a subset of the values stored in the level directly below it. The lowest level of the
hierarchy contains all of the elements as a sorted linked list.
Figure 1 shows a structure with 8 values in it. These values are in the lowest linked list. Four of
the values (date, grape, orange, and tea) were randomly selected to appear in the next level up.
Of those four, two of them (date and orange) were randomly selected to appear in another
higher level, creating 3 levels.
Add: To add a value, we insert the value into the lowest list, keeping the sorted order. Once
inserted, we randomly choose whether or not the new item should go into the list above; call
the coin class to get back a random 0 or 1 value. 0 means we do not put the new value into the
upper list and 1 means that we do put it into the upper list. When we add the value to a higher
list, we keep a connection between the nodes with the value in the two lists.
If we add the value to the upper list then we get another random value to see if we add it to the
next higher list. This random selection process continues until you are in the topmost list or
until you have a choice to no longer promote the value to a higher list. In the topmost list, you
still get a random value about moving the value to a higher list; if you do move it up then you
add a new level to the hierarchy, add the value, and then stop.
Search: Given a value v to search for, we begin the search in the highest level (the one with 2
entries in Figure 1). Suppose that we are searching for “mango” in Figure 1. We would search
the top list for “mango”, find that it is not there, and find that it would go between the values
of “date” and “orange”. We would then follow the link from “date” to the next lower level and
continue the search in that next lower level, starting at the “date” node to find that “mango”
isn’t there, but it would appear between “grape” and “orange”. Again, follow the link from
“grape” in one level to the next lower level and continue the search starting at the “grape”
node. That continuation shows that “mango” is not there, but it would fit between “lettuce”
and “orange”. Since we are at the lowest level, we would conclude that “mango” is not in the
list.
Given the search description, it is useful for each level to have a sentinel node at the start of
each list so you always have some earlier node to reference.

Figure 1 Sample data structure with 8 values in it.

Methods for the ListHierarchy class:
====================================
- boolean ListHierarchy( Coin flip ) – constructor for the method that accepts an object of
type Coin to give random values (store “flip” as an attribute of the class for future use).
Return true if the object is ready to use at the end of the method call and false if there is
some error.
- boolean add( String key ) – add a key to the data structure. Return true if the key can be
found in the list at the end of the method (so return true if the key is already in the list
too). Return false if there was an error.
- boolean find( String key ) – search the data structure for the key value. Return true if
the key value is in the data structure. Return false if there is an error or if the key is not
in the data structure.
Inputs
All the inputs will be determined by the parameters used in calling your methods.

Assumptions
==============
You may assume that
- no string to store will be more than 15 characters.

Constraints
============
• You may not use any data structures from the Java Collection Framework, including
ArrayLists.
• If in doubt for testing, I will be running your program on bluenose.cs.dal.ca. Correct
operation of your program shouldn’t rely on any packages that aren’t available on that
system.

Notes
==========
- Implement a single sorted linked list; you won’t need any
random element for that. Get that working. Next, implement a single additional level
to the hierarchy and get that working. Only after you have done this should you think of
making the hierarchy grow dynamically.
- When it comes time to use levels of the hierarchy, start with a Coin object where you
control whether or not it returns a 0 or a 1. That control will make it easier for you to
test.
- Although Figure 1 shows arrows in one direction, you may find it more convenient to
have references go in both directions, so a doubly-linked list at each level.
