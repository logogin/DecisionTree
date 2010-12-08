package com.logogin.decisiontree.model.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

/**
 * $Id$
 *
 * @created Sep 6, 2010
 * @author Pavel Danchenko
 */
public class LogicalExpression {

    private List<LogicalTerm> terms = new ArrayList<LogicalTerm>();

    public LogicalExpression() {
    }

    public LogicalExpression(LogicalTerm term) {
        addTerm(term);
    }

    public LogicalExpression and(LogicalTerm term) {
        addTerm(term);
        return this;
    }

    private void addTerm(LogicalTerm term) {
        boolean added = false;
        ListIterator<LogicalTerm> iter = terms.listIterator();
        while (iter.hasNext()) {
            LogicalTerm original = iter.next();
            if ( original.isApplicable(term) ) {
                if ( original.apply(term) ) {
                    iter.remove();
                    if ( !added ) {
                        iter.add(term);
                        added = true;
                    }
                } else {
                    added = true;
                    break;
                }
            }
        }
        if ( !added ) {
            terms.add(term);
        }
    }

    public boolean match(final LogicalExpression filter) {
        boolean result = false;
        for ( LogicalTerm filterTerm : filter.terms ) {
            for ( LogicalTerm term : terms ) {
                if ( !term.isApplicable(filterTerm) ) {
                    continue;
                }
                if ( !term.apply(filterTerm) ) {
                    //only 'and' expression -> fast return in case false
                    return false;
                }
                result = true;
            }
        }
        return result;
    }

    public LogicalExpression clone() {
        LogicalExpression expr = new LogicalExpression();
        expr.terms.addAll(terms);
        return expr;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        int index = 0;
        for ( LogicalTerm term : terms ) {
            index++;
            buf.append(term);
            if ( index < terms.size() ) {
                buf.append(" and ");
            }
        }
        return buf.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((terms == null) ? 0 : terms.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LogicalExpression other = (LogicalExpression) obj;
        if (terms == null) {
            if (other.terms != null)
                return false;
        } else if (!new HashSet<LogicalTerm>(terms).equals(new HashSet<LogicalTerm>(other.terms)))
            return false;
        return true;
    }

    public boolean equalsIgnoreTerms(LogicalExpression expr, Collection<String> varNames) {
        for ( LogicalTerm term : terms ) {
            if ( !varNames.contains(term.getVariable()) ) {
                if ( !expr.terms.contains(term) ) {
                    return false;
                }
            }
        }
        for ( LogicalTerm term : expr.terms ) {
            if ( !varNames.contains(term.getVariable()) ) {
                if ( !terms.contains(term) ) {
                    return false;
                }
            }
        }
        return true;
    }

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

        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.le("B", 9));
        System.out.println("expr: A=x and B>=5 and B<=9 -> " + expr);
        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.ge("B", 9));
        System.out.println("expr: A=x and B>=5 and B>=9 -> " + expr);
        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.ge("B", 3));
        System.out.println("expr: A=x and B>=5 and B>=3 -> " + expr);
        expr = new LogicalExpression(LogicalTerm.eq("A", "x")).and(LogicalTerm.ge("B", 5)).and(LogicalTerm.le("B", 9)).and(LogicalTerm.ge("B", 3)).and(LogicalTerm.le("B", 8));
        System.out.println("expr: A=x and B>=5 and B<=9 and B>=3 and B<=8 -> " + expr);

    }
}
