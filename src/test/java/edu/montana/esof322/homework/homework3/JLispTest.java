package edu.montana.esof322.homework.homework3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JLispTest {

    /*====================================================================
    // Homework 3
    //
    // Included in this directory is a simple lisp implementation.  This
    // lisp implementation supports basic math, akin to what our reverse
    // polish notation calculator did.
    //
    // The intention with this lisp is to support simple, binary addition
    // in the form:
    //
    //  (+ 1 2)
    //
    //  or
    //
    //  (+ 1 (+ 2 3))
    //
    //
    // The `+` operator can take two and only two arguments, and must be
    // enclosed in parenthesis to be valid.
    //
    // This implementation is buggy.  Your assignment is to create four (4)
    // tests showing *different* bugs within the simple language.
    //
    //====================================================================*/

    @Test
    // This is a sample test to help you get started
    public void exampleTest() {
        assertEquals(1, 2);
        fail("test didn't pass");
        assertEquals("Foo", "Bar");
    }

    @Test
    // java convention is camel case (no points off)
    public void throws_illegal_argument_excpetion_with_null_input() {
        JLisp jlisp = new JLisp();
        try{
            jlisp.eval(null);
            fail("Didnt Throw");
        }catch(IllegalArgumentException illegalArgumentException) { }
    }

    @Test
    public void input_does_not_start_with_parentheses() {
        JLisp jlisp = new JLisp();
        try{
            jlisp.eval( "+ 1 2)");
            fail("Didnt Start With parentheses and didn't throw an IllegalArgumentException");
        }catch(IllegalArgumentException illegalArgumentException) { }

    }

    @Test
    public void does_JLisp_addition_work() {
        JLisp jlisp = new JLisp();
        Integer int_answer = jlisp.eval("(+ 1 (+2 3))");
        assertEquals(6, int_answer);
    }

    @Test
    public void input_has_to_many_arguments() {
        JLisp jlisp = new JLisp();
        try{
            jlisp.eval("(+ 1 2 3)");
            fail("Has More Than Two Arguments and didn't throw an IllegalArgumentException");
        }catch(IllegalArgumentException illegalArgumentException) { }
    }
}


