package edu.itstep.example;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * Public
 * */
@Documented
@Inherited
@interface PublicAnnotate{}
/**
 * Private
 * */

@Documented
@interface PrivateAnnotate{}

/**
 * Parent
 * */
@PublicAnnotate
@PrivateAnnotate
public class ParentClass {
}

