package com.logogin.decisiontree.model;

import com.logogin.decisiontree.model.expression.LogicalExpression;

/**
 * $Id$
 *
 * @created Oct 19, 2010
 * @author Pavel Danchenko
 */
public class Rule {

    private LogicalExpression expr;
    private String score;
    private Double recordCount;
    private Double scoreRecordCount;

    public Rule(LogicalExpression expr, String score) {
        this.expr = expr;
        this.score = score;
    }

    public Rule(LogicalExpression expr, String score, Double recordCount, Double scoreRecordCount) {
        this(expr, score);
        this.recordCount = recordCount;
        this.scoreRecordCount = scoreRecordCount;
    }

    public LogicalExpression getExpression() {
        return expr;
    }

    public String getScore() {
        return score;
    }

    public Double getRecordCount() {
        return recordCount;
    }

    public Double getScoreRecordCount() {
        return scoreRecordCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((expr == null) ? 0 : expr.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
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
        Rule other = (Rule) obj;
        if (expr == null) {
            if (other.expr != null)
                return false;
        } else if (!expr.equals(other.expr))
            return false;
        return true;
    }
}
