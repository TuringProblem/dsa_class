#!/bin/bash
# author { @Override }
case "$1" in
    "zaddy")
        echo "why tf isn't my string workgin";;
    "javatest")
        echo "Scanning for Java test files now..."
        javac NaturalMerge.java
        echo "Running Test file..."
        java NaturalMerge.java;; 
    "javarun")
        echo "Scanning for Java files now..."
        javac NaturalMerge.java
        echo "Scanning for Java files now..."
        java NaturalMerge.java;;

    *)
        echo "You didn't pass shit, you know the drill"
        echo ""
        echo "Here is the list of commands:"
        echo "════════════════════════════════════════" 
        echo "- javatest"
        echo "- javarun" 
        echo "- zaddy" 
        exit 1;;
esac

