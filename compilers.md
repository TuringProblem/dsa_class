# Chapter 1: Introduction to Compilers

> ## 1.1 Compilers
>
> **_Compiler_**: A program that reads a program written in one language - the _source_ language - and translates it into an equivalent program in another language - the target language.
>
> ## 1.2

> **_Syntax-Directed Translation_**: refers to a method of Compiler implementation where the source language translation is completely driven by the parser.
>
> - A common method of syntax-directed translation is translating a string into a sequence of actions by attaching one such action to each rule of a grammar.

### Semantic Analysis

> The semantic analysis phase checks the source program for semantic errors and gathers type information for the subsequent code-generation phase. It uses the hierarchical structure determined by the syntax-analysis phase to identify the operators and operands of expressions and statements.
>
> An important component of semantic analysis is type checking.
