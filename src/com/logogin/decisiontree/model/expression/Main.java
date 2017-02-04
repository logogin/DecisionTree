package com.logogin.decisiontree.model.expression;


/**
 * @created Sep 6, 2010
 * @author Pavel Danchenko
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //A = 'x' && B >= 5;
        LogicalExpression expr = new LogicalExpression(LogicalTerm.eq("A", "x"));
        expr.and(LogicalTerm.ge("B", 5));

        //B > 3
        LogicalExpression filter = new LogicalExpression(LogicalTerm.gt("B", 7));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));

        filter = new LogicalExpression(LogicalTerm.gt("B", 3));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));

        filter = new LogicalExpression(LogicalTerm.eq("A", "x"));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));

        filter = new LogicalExpression(LogicalTerm.gt("B", 5));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));

        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.le("B", 9));
        filter = new LogicalExpression(LogicalTerm.gt("B", 6)).and(LogicalTerm.lt("B", 8));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));

        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.le("B", 9));
        filter = new LogicalExpression(LogicalTerm.gt("B", 6)).and(LogicalTerm.lt("B", 10));
        System.out.println("expr: " + expr + " filter: " + filter + " match: " + expr.match(filter));
    }
}
