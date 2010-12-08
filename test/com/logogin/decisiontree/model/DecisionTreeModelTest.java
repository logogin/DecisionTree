package logogin.decisiontree.model;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.logogin.decisiontree.model.DecisionTreeModel;
import com.logogin.decisiontree.model.JAXBUtil;
import com.logogin.decisiontree.model.Rule;

/**
 * $Id$
 *
 * @created Dec 8, 2010
 * @author Pavel Danchenko
 */

public class DecisionTreeModelTest {

    @Test
    public void calculateRules() throws Exception {
        DecisionTreeModel treeModel = new DecisionTreeModel("d:/Temp/pmmls/spain100000.pmml"
                , "spain100000.pmml"
                , JAXBUtil.unmarshal(new File("d:/Temp/pmmls/spain100000.pmml"), true));
        Assert.assertEquals(67, treeModel.getRulesCount());
        Assert.assertEquals(40, treeModel.getRulesCountForScore("0"));
        Assert.assertEquals(27, treeModel.getRulesCountForScore("1"));
        Assert.assertEquals(7, treeModel.getFrequentRulesCountForScore("0", 100));
        Assert.assertEquals(0, treeModel.getFrequentRulesCountForScore("1", 100));
        Assert.assertEquals(5, treeModel.getRelativeRulesCountForScore("0", 0.9));
        Assert.assertEquals(27, treeModel.getRelativeRulesCountForScore("1", 0.9));

        Rule rule = treeModel.getRules().get(0);
        Assert.assertEquals("personality = True and aimSex = True", rule.getExpression().toString());
        Assert.assertEquals("1", rule.getScore());
        Assert.assertEquals(Double.valueOf(78.0), rule.getRecordCount());
        Assert.assertEquals(Double.valueOf(66.0), rule.getScoreRecordCount());

        System.out.println(treeModel.dumpWekaTree());
    }
}
