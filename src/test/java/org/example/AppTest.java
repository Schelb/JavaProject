package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void efficiencyEvaluationsTest() {
        EfficiencyEvaluations efficiencyEvaluations= EfficiencyEvaluations.getInstance();
        double actualPrecision =  efficiencyEvaluations.getPrecision(10,20);
        double actualRecall =  efficiencyEvaluations.getRecall(9,12);
        double actualF_Measure = efficiencyEvaluations.getF_Measure(0.8 , 0.2 );

        assertEquals(0.5 , actualPrecision , 0.001);
        assertEquals(0.75 , actualRecall, 0.001);
        assertEquals(0.32 , actualF_Measure, 0.001);
    }
}
