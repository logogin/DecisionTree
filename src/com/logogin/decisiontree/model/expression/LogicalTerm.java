package com.logogin.decisiontree.model.expression;

/**
 * @created Sep 6, 2010
 * @author Pavel Danchenko
 */
public class LogicalTerm {

    public enum Operator {
        EQ("="),
        GT(">"),
        LT("<"),
        GE(">="),
        LE("<=");

        private String opString;
        Operator(String opString) {
            this.opString = opString;
        }

        @Override
        public String toString() {
            return opString;
        }

        public boolean isApplicable(Operator operator) {
            switch (this) {
            case EQ: return true;
            case LT:
            case LE: return LT == operator || LE == operator;
            case GT:
            case GE: return GT == operator || GE == operator;
            }
            return false;
        }

        public boolean test(Object left, Object right) {
            int compared = ((Comparable)left).compareTo(right);
            switch (this) {
            case EQ: return 0 == compared;
            case LT: return compared < 0;
            case GT: return compared > 0;
            case LE: return compared <= 0;
            case GE: return compared >= 0;
            }
            return false;
        }

        public static Operator fromValue(String opString) {
            for ( Operator op : values() ) {
                if ( op.opString.equals(opString) ) {
                    return op;
                }
            }
            throw new IllegalArgumentException(opString);
        }
    }

    private String variable;
    private Object value;
    private Operator operator;

    public LogicalTerm(String variable, Object value, String opString) {
        this(variable, value, Operator.fromValue(opString));
    }

    public LogicalTerm(String variable, Object value, Operator operator) {
        this.variable = variable;
        this.value = value;
        this.operator = operator;
    }

    public static LogicalTerm eq(String variable, Object value) {
        return new LogicalTerm(variable, value, Operator.EQ);
    }

    public static LogicalTerm ge(String variable, Object value) {
        return new LogicalTerm(variable, value, Operator.GE);
    }

    public static LogicalTerm gt(String variable, Object value) {
        return new LogicalTerm(variable, value, Operator.GT);
    }

    public static LogicalTerm le(String variable, Object value) {
        return new LogicalTerm(variable, value, Operator.LE);
    }

    public static LogicalTerm lt(String variable, Object value) {
        return new LogicalTerm(variable, value, Operator.LT);
    }

    public boolean isApplicable(LogicalTerm filterTerm) {
        return variable.equals(filterTerm.variable) && filterTerm.operator.isApplicable(operator);
    }

    public boolean apply(LogicalTerm filterTerm) {
        return operator.test(filterTerm.value, value);
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return variable + " " + operator + " " + value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((operator == null) ? 0 : operator.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result
                + ((variable == null) ? 0 : variable.hashCode());
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
        LogicalTerm other = (LogicalTerm) obj;
        if (operator != other.operator)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (variable == null) {
            if (other.variable != null)
                return false;
        } else if (!variable.equals(other.variable))
            return false;
        return true;
    }
}